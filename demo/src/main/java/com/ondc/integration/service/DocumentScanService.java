package com.ondc.integration.service;

import static com.ondc.integration.configuration.DocumentScanConfiguration.PENDING_OPSWAT_SCAN_QUEUE;
import static com.ondc.integration.utils.Utils.future;
import static java.time.Clock.systemUTC;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.HttpClientErrorException;


import com.ondc.integration.configuration.OndcHeaderConfiguration;
import com.ondc.integration.model.BinBase64;
import com.ondc.integration.model.ScanContextInfo;
import com.ondc.integration.model.ScanResult;
import com.ondc.integration.model.opswat.OpSwatUploadResponse;
import com.ondc.integration.model.opswat.PendingOpSwatScan;
import com.ondc.integration.utils.FailOnEx;
import com.ondc.integration.utils.RuntimeReportableException;
import com.ondc.integration.model.DocumentScanId;
import com.ondc.integration.model.DocumentScanRow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentScanService {
    @Value("${ondcIntegration.timeout}")
    private Duration timeout;

    @Value("${ondcIntegration.ondc.baseUrl}")
    private String baseUrl;
    
    //PSD-633 Private Scanning
    @Value("${ondcIntegration.ondc.privateProcessing}")
    private String privateProcessing;

    @SuppressWarnings("deprecation")
	@Autowired
    private AsyncRestTemplate restTemplate;

    @Autowired
    @Qualifier(PENDING_OPSWAT_SCAN_QUEUE)
    private BlockingQueue<PendingOpSwatScan> pendingQueue;


    @Autowired
    private OndcHeaderConfiguration opswatSecretConfiguration;

    @RequiredArgsConstructor
    private class OnSuccess implements SuccessCallback<ResponseEntity<OpSwatUploadResponse>> {
        final ScanContextInfo ctxInfo;
        final CompletableFuture<ScanResult> result;
        final byte[] rawContent;

        @Override
        public void onSuccess(ResponseEntity<OpSwatUploadResponse> ok) {
            final String dataId = ok.getBody().getDataId();
            log.info("OpSwat assigned data id [{}] to hash [{}] ({} bytes)",
                    dataId, "", rawContent.length);
            final PendingOpSwatScan scan = PendingOpSwatScan.builder()
                    .context(ctxInfo)
                    .contentHash("")
                    .vendorScanId(dataId)  //PSD-633 Changes Opswat Get File Results
                    .expiresAt(systemUTC().instant().plus(timeout))
                    .sink(result)
                    .build();
            if (pendingQueue.add(scan)) {
            	DocumentScanId scanId =  create(DocumentScanRow.create(dataId, scan));
            	   scan.getContext().setScanId(Optional.of(scanId));
                return;
            }
            setException(result, new RuntimeReportableException(
                    "pending queue is full"));
        }
    }
    
	    public DocumentScanId create(DocumentScanRow row) {
	      return DocumentScanId.valueOf(1234);
	    }

    @RequiredArgsConstructor
    private class OnFail implements FailureCallback {
        final CompletableFuture<ScanResult> result;

        @Override
        public void onFailure(Throwable e) {
            if (e instanceof HttpClientErrorException) {
                setException(result, e);
            } else {
                setException(result,
                        new RuntimeReportableException(
                                "opswat scan submission failed", e));
            }
        }
    }

    @Async
    public CompletableFuture<ScanResult> scanForMalware(
            ScanContextInfo ctxInfo, BinBase64 data) {
        final CompletableFuture<ScanResult> result = future();

        final MultiValueMap<String, String> headers = opswatSecretConfiguration.getHeaders();
       
        headers.add("Content-Type", APPLICATION_OCTET_STREAM_VALUE);
        headers.add("filename", ctxInfo.getDocumentName());
        //PSD-633 Private Scanning
        headers.add("privateprocessing",privateProcessing);
        // @todo check in db that content with this hash has been processed
        //       before uploading to opswat
        final byte[] rawContent = data.decode();
        restTemplate.postForEntity(
                baseUrl + "/file",
                new HttpEntity<Object>(rawContent, headers),
                OpSwatUploadResponse.class)
                .addCallback(
                        new FailOnEx<>(
                                new OnSuccess(ctxInfo, result, rawContent),
                                new OnFail(result)));
        return result;
    }

    private void setException(CompletableFuture<ScanResult> result, Throwable e) {
        result.completeExceptionally(e);
    }

   
}

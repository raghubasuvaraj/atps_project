package com.ondc.integration.service;


import static com.ondc.integration.model.OpSwatScanStatus.PENDING;
import static com.ondc.integration.model.MalwareScanStatus.OK;
import static com.ondc.integration.model.OpSwatScanStatus.CLEAN;
import static com.ondc.integration.model.OpSwatScanStatus.INFECTED;
import static java.time.Clock.systemUTC;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.ondc.integration.model.MalwareScanStatus;
import com.ondc.integration.model.OpSwatScanStatus;
import com.ondc.integration.model.ScanResult;
import com.ondc.integration.service.DocumentScanRepository;
import com.ondc.integration.configuration.OndcHeaderConfiguration;
import com.ondc.integration.model.opswat.OpSwatScanStateResponse;
import com.ondc.integration.model.opswat.PendingOpSwatScan;
import com.ondc.integration.model.opswat.ProcessInfo;
import com.ondc.integration.utils.FailOnEx;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
@Service
public class DocScanChecker {
    @Value("${ondcIntegration.checkInterval}")
    private Duration checkInterval;

    @Value("${ondcIntegration.ondc.baseUrl}")
    private String baseUrl;

    @SuppressWarnings("deprecation")
	@Autowired
    private AsyncRestTemplate restTemplate;

    @Autowired
    private TimerService timerService;
    
    @Autowired
    private DocumentScanRepository documentScanRepository;

    
    @Autowired
    private OndcHeaderConfiguration opswatSecretConfiguration;

    public void check(com.ondc.integration.model.opswat.PendingOpSwatScan scan) {

        restTemplate.exchange(
                baseUrl + "/file/" + scan.getVendorScanId(),  
                HttpMethod.GET,
                new HttpEntity<>(opswatSecretConfiguration.getHeaders()),
                OpSwatScanStateResponse.class)
                .addCallback(
                        new FailOnEx<>(
                                ok -> onSuccess(ok.getBody(), scan),
                                e -> onFailure(e, scan)));
    }

    private void onSuccess(OpSwatScanStateResponse body, PendingOpSwatScan scan) {
        ProcessInfo pInfo = body.getProcessInfo();
        if (pInfo != null && pInfo.getProgressPercentage() == 100) {
        	  set(scan, body.getScanResults().getScanResult() == 0
                      ? CLEAN
                      : INFECTED, OK);
        } else {
            schedule(scan);
        }
    }
    
    private void set(PendingOpSwatScan scan, OpSwatScanStatus status, MalwareScanStatus ok) {
        log.info("Hash [{}] classified as [{}]", scan.getContentHash(), status);
        scan.getContext().getScanId().ifPresent(
                scanId -> documentScanRepository.scanCompleted(ok, scanId, status));
        log.info("Hash [{}] classification persisted", scan.getContentHash());
        scan.getSink().complete(ScanResult.builder()
                .scan(scan)
                .status(status)
                .build());
    }

    private Optional<HttpStatus> badStatus(Throwable e) {
        if (e instanceof HttpClientErrorException) {
            return Optional.of(((HttpClientErrorException) e).getStatusCode());
        } else if (e instanceof HttpServerErrorException){
            return Optional.of(((HttpServerErrorException) e).getStatusCode());
        }
        return Optional.empty();
    }

    private void onFailure(Throwable e, PendingOpSwatScan scan) {
        Optional<HttpStatus> oStatus = badStatus(e);
        if (oStatus.isPresent()) {
            switch (oStatus.get()) {
                case SERVICE_UNAVAILABLE:
                case INTERNAL_SERVER_ERROR:
                    log.error("OpSwat check failed with recoverable error", e);
                    schedule(scan);
                    break;
                case NOT_FOUND:
                	System.out.printf("NOT_FOUND");
                    break;
                default:
                	System.out.printf("default");
                    break;
            }
        } else {
           
        }
    }

    public void schedule(PendingOpSwatScan scan) {
        log.info("Schedule recheck for [{}]", scan.getContentHash());
        timerService.timeout(checkInterval, () -> {
            if (scan.getExpiresAt().isBefore(systemUTC().instant())) {
            	 log.info("Active check for hash {} is suspended", scan.getContentHash());
                 set(scan, PENDING, MalwareScanStatus.PENDING);
                 return;
            }
            check(scan);
        });
    }
}

package com.ondc.integration.controller;


import static  com.ondc.integration.utils.Utils.future;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ondc.integration.model.ScanRequest;
import com.ondc.integration.service.DocumentScanService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/v1")
public class DocumentScannerController {
    @Autowired
    private DocumentScanService documentScanService;


    @SuppressWarnings("rawtypes")
	@PostMapping(
            value = "/scans/scan",
            consumes = "application/json",
            produces = "application/json")
    @Async
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ResponseEntity> handleScanRequest(
             @RequestBody ScanRequest scanRequest) {
        log.debug("Request to scan [{}] with volume {}",
                scanRequest.getData().getDocumentName(),
                scanRequest.getData().getFileContent().getData().length());
        final CompletableFuture<ResponseEntity> result = future();
        
        documentScanService.scanForMalware(
                scanRequest.getData().toContextInfo(),
                scanRequest.getData().getFileContent())
                .whenComplete(
                        (scanResult, e) -> {
                                if (scanResult == null) {
                                   
                                } else {
                                    scanResult.getStatus().handle(
                                            scanResult.getScan(),
                                            scanRequest.getData().getDocumentName(),
                                            result);
                                    log.info("Responded about scanning [{}/{}]",
                                            scanRequest.getData().getDocumentName(),
                                            scanResult.getScan().getContentHash());
                                }
                        });
        return result;
    }
}

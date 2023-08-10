package com.ondc.integration.model;

import com.google.common.collect.ImmutableMap;
import com.ondc.integration.model.opswat.PendingOpSwatScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.concurrent.CompletableFuture;

import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public enum OpSwatScanStatus {
    PENDING {
        @Override
        public void handle(PendingOpSwatScan scan, String documentName,
                           CompletableFuture<ResponseEntity> result) {
            result.complete(new ResponseEntity(new ScanStatusResponse(
                    201, "Document scan record created, but scan remains pending.",
                    documentName,
                    scan.getContext().getScanId(),
                    MalwareScanStatus.PENDING),
                    HEADERS,
                    HttpStatus.CREATED));
        }

        @Override
        public boolean toBool() {
            return false;
        }
    },
    CLEAN {
        @Override
        public void handle(PendingOpSwatScan scan, String documentName,
                           CompletableFuture<ResponseEntity> result) {
            result.complete(new ResponseEntity(new ScanStatusResponse(
                    200, "Document successfully passed scan.",
                    documentName,
                    scan.getContext().getScanId(),
                    MalwareScanStatus.OK),
                    HEADERS,
                    HttpStatus.OK));
        }

        @Override
        public boolean toBool() {
            return false;
        }
    },
    INFECTED {
        @Override
        public void handle(PendingOpSwatScan scan, String documentName,
                           CompletableFuture<ResponseEntity> result) {
            result.complete(new ResponseEntity(new ScanStatusResponse(
                    202, "Document is infected.",
                    documentName,
                    scan.getContext().getScanId(),
                    MalwareScanStatus.WARNING),
                    HEADERS,
                    HttpStatus.ACCEPTED));
        }

        @Override
        public boolean toBool() {
            return true;
        }
    };

    private static final MultiValueMap<String, String> HEADERS
            = new LinkedMultiValueMap<>(
            ImmutableMap.of("Content-Type",
                    singletonList(APPLICATION_JSON_VALUE)));

    public abstract void handle(
            PendingOpSwatScan scan,
            String documentName,
            CompletableFuture<ResponseEntity> result);

    public abstract boolean toBool();
}

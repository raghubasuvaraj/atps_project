package com.ondc.integration.model.opswat;

import com.ondc.integration.model.ScanContextInfo;
import com.ondc.integration.model.ScanResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@Builder
public class PendingOpSwatScan {
    private final ScanContextInfo context;
    private final Instant expiresAt;
    private final String contentHash;
    private final String vendorScanId; //PSD-633 Changes Opswat Get File Results
    private final CompletableFuture<ScanResult> sink;
}

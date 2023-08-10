package com.ondc.integration.model;

import com.ondc.integration.model.opswat.PendingOpSwatScan;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScanResult {
    private OpSwatScanStatus status;
    private PendingOpSwatScan scan;
}

package com.ondc.integration.model;

import com.ondc.integration.model.opswat.PendingOpSwatScan;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class DocumentScanRow {
    private String documentName;
    private String vendorScanId;
    private String documentHash;
    private MalwareScanStatus scanStatus;
    private OpSwatScanStatus isInfected;
    private String requestSourceName;
    private PortalUserId portalUserId;

    public static DocumentScanRow create(String vendorScanId, PendingOpSwatScan scan) {
        return DocumentScanRow.builder()
                .documentHash(scan.getContentHash())
                .requestSourceName(scan.getContext().getRequestSourceName())
                .documentName(scan.getContext().getDocumentName())
                .isInfected(OpSwatScanStatus.CLEAN)
                .scanStatus(MalwareScanStatus.PENDING)
                .portalUserId(scan.getContext().getPortalUserId())
                .vendorScanId(vendorScanId)
                .build();
    }
}

package com.ondc.integration.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Builder
public class ScanContextInfo {
    @Setter
    private Optional<DocumentScanId> scanId;
    private String documentName;
    private String requestSourceName;
    private PortalUserId portalUserId;

    public static class ScanContextInfoBuilder {
        Optional<DocumentScanId> scanId = Optional.empty();
    }
}

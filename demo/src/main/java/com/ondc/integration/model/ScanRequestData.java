package com.ondc.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanRequestData {

    private String documentName;

    private String requestSourceName;

    private PortalUserId portalUserId;

    @JsonProperty("uploadFile")
    private BinBase64 fileContent;

    public ScanContextInfo toContextInfo() {
        return ScanContextInfo.builder()
                .documentName(documentName)
                .portalUserId(portalUserId)
                .requestSourceName(requestSourceName)
                .build();
    }
}

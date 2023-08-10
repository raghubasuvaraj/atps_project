package com.ondc.integration.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "code",
        "message",
        "documentName",
        "documentScanId",
        "scanStatus"
})
public class ScanStatusResponse {

    @JsonProperty("code")
    private Integer httpStatusCode;


    @JsonProperty("message")
    private String humanReadableMessage;


    @JsonProperty("documentName")
    private String assignedDocumentName;

    @JsonProperty("documentScanId")
    private Optional<DocumentScanId> scanId;

    @JsonProperty("scanStatus")
    private MalwareScanStatus status;
}

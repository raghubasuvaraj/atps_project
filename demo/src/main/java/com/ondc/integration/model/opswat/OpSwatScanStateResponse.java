package com.ondc.integration.model.opswat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpSwatScanStateResponse {
    @JsonProperty("data_id")
    private String dataId;
    @JsonProperty("scan_results")
    private ScanResults scanResults;
    @JsonProperty("process_info")
    private ProcessInfo processInfo;
}

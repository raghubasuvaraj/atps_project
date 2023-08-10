package com.ondc.integration.model.error;

import lombok.Value;

@Value
public class ErrorItem {
    private final String reason;

    private final String message;
}

package com.ondc.integration.utils;

public class RuntimeReportableException extends RuntimeException {
    public RuntimeReportableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeReportableException(String message) {
        super(message);
    }
}

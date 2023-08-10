package com.ondc.integration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public class DocumentScanId {
    private final int data;

    @JsonCreator
    public DocumentScanId(int data) {
        this.data = data;
    }

    @JsonCreator
    public static DocumentScanId valueOf(int s) {
        return new DocumentScanId(s);
    }

    @JsonValue
    public int getData() {
        return data;
    }

    public String toString() {
        return String.valueOf(data);
    }
}

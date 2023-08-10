package com.ondc.integration.model;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public class BinBase64 {
    private final String data;

    @JsonCreator
    public BinBase64(String data) {
        this.data = data;
    }

    @JsonCreator
    public static BinBase64 valueOf(String s) {
        return new BinBase64(s);
    }

    @JsonValue
    public String getData() {
        return data;
    }

    public byte[] decode() {
        return Base64.decodeBase64(data);
    }

    public String toString() {
        return data;
    }
}

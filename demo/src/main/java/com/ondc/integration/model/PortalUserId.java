package com.ondc.integration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;




public class PortalUserId {
    private final Long data;

    @JsonCreator
    public PortalUserId(Long data) {
        this.data = data;
    }

    @JsonCreator
    public static PortalUserId valueOf(long s) {
        return new PortalUserId(s);
    }

    @JsonValue
    public Long getData() {
        return data;
    }

    public String toString() {
        return String.valueOf(data);
    }
}

package com.ondc.integration.model.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class BaseResponse {


    private Integer statusCode;

    private String statusMessage;

    private String tracerGuid;
}

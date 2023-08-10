package com.ondc.integration.model.error;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {

    private List<ErrorItem> errors;
}

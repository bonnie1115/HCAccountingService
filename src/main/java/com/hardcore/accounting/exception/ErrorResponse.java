package com.hardcore.accounting.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder //因为一会要用，所以写一个builder？
public class ErrorResponse {
    private String code;
    private ServiceException.ErrorType errorType;
    private String message;
    private int statusCode;


}

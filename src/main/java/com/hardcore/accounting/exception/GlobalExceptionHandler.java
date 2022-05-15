package com.hardcore.accounting.exception;

import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //参数非法异常
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<?> handleServiceExceptionn(ServiceException ex){
        val errorResponse = ErrorResponse.builder()
                .statusCode(ex.getStatusCode())
                .message(ex.getMessage())
                .code(ex.getErrorCode())
                .errorType(ex.getErrorType())
                .build();

        return ResponseEntity.status(ex.getStatusCode()!=0 ? ex.getStatusCode()
                        :HttpStatus.INTERNAL_SERVER_ERROR.value()) //判断下，如果getStatusCode为0则给500
                .body(errorResponse);
    }
}

package com.hardcore.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ServiceException{

    public ResourceNotFoundException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.setErrorType(ErrorType.Client);
        this.setErrorCode("USER_INFO_NOT_FOUND"); //这里注意，一般不会写得很详细，一般不会抛出，在外层抛
    }


}

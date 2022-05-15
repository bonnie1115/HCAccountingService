package com.hardcore.accounting.exception;

import lombok.Data;

@Data  //GET SET方法可以偷懒，用Lombok
public class ServiceException extends RuntimeException {
    private int statusCode;
    private String errorCode; //BIZ ERROR CODE
    private  ServiceException.ErrorType errorType; //SERVICE,CLIENT,UNKNOWN

    public enum ErrorType{
        Client,
        Service,
        Unknown

    }

    //构造器
    public ServiceException(String message){
        super(message);

    }
}

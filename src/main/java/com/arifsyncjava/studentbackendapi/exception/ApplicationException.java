package com.arifsyncjava.studentbackendapi.exception;

import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException{

    private final HttpStatus status ;

    public ApplicationException (HttpStatus status, ErrorMessage message) {
        super(message.toString()) ;
        this.status = status ;
    }


    public HttpStatus getStatus() {
        return status;
    }






}

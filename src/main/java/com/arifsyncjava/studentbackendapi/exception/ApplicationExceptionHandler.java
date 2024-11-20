package com.arifsyncjava.studentbackendapi.exception;

import com.arifsyncjava.studentbackendapi.payload.ApiError;
import com.arifsyncjava.studentbackendapi.payload.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler (ApplicationException.class)
    public ResponseEntity<ApiError> handleApplicationException (
            ApplicationException exception) {

        var error = new Error(exception.getStatus(), exception.getMessage()) ;
        var response = new ApiError(error) ;
        return ResponseEntity.status(exception.getStatus()).body(response) ;


    }









}

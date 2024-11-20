package com.arifsyncjava.studentbackendapi.payload;

import org.springframework.http.HttpStatus;

public record Error(
        int code ,
        String status ,
        String message
) {

    public Error (HttpStatus httpStatus,String message) {
           this (
                   httpStatus.value(),
                   httpStatus.getReasonPhrase(),
                   message
           );
    }


}

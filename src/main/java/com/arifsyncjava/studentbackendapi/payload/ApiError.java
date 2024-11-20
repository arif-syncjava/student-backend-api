package com.arifsyncjava.studentbackendapi.payload;

public record ApiError(
        String time,
        Error error
) {

    public ApiError (Error error) {
        this(ApiResponse.getTime(), error) ;

    }





}

package com.arifsyncjava.studentbackendapi.payload;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public record ApiResponse (
        String time ,
        Map<String,?> data
) {

    public ApiResponse (Map<String,?> data) {
        this (getTime(), data) ;
    }


    public static String getTime () {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss 'UTC' ")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now()) ;
    }



}




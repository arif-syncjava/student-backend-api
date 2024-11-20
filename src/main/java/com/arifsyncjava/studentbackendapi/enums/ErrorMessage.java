package com.arifsyncjava.studentbackendapi.enums;

public enum ErrorMessage {

    STUDENT_ID_NOT_FOUND ("Student ID not found"),
    DATABASE_OPERATION_FAILED ("Database operation failed");

    private final String message ;

    ErrorMessage(String message) {
        this.message = message ;
    }

    private String getMessage () {
        return message ;

    }



}

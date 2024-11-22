package com.arifsyncjava.studentbackendapi.enums;

public enum ErrorMessage {

    STUDENT_ID_NOT_FOUND ("Student ID not found"),
    DATABASE_OPERATION_FAILED ("Database operation failed"),
    NO_STUDENT_AVAILABLE ("No Student Available"),
    STUDENT_INFORMATION_DELETE_SUCCESSFULLY("Student information delete successfully");

    private final String message ;

    ErrorMessage(String message) {
        this.message = message ;
    }

    private String getMessage () {
        return message ;

    }



}

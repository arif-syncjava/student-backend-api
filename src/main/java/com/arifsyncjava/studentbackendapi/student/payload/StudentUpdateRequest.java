package com.arifsyncjava.studentbackendapi.student.payload;

public record StudentUpdateRequest (
        String studentId,
        StudentRequest request
) { }

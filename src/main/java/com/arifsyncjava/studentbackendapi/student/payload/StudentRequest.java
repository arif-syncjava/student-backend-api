package com.arifsyncjava.studentbackendapi.student.payload;

public record StudentRequest(
        String name,
        String email,
        String phoneNumber,
        String department
) {
}

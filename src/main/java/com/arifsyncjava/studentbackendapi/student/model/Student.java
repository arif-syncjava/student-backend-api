package com.arifsyncjava.studentbackendapi.student.model;

import com.arifsyncjava.studentbackendapi.student.payload.StudentRequest;

public record Student(
        String studentId,
        String name,
        String email,
        String department,
        String phoneNumber
) {


    public Student (String id, StudentRequest request) {
        this(
                id,
                request.name(),
                request.email(),
                request.department(),
                request.phoneNumber()
        );
    }




}

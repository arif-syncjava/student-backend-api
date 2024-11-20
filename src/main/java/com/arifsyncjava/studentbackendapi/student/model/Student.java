package com.arifsyncjava.studentbackendapi.student.model;

public record Student(
        int studentId,
        String name,
        String email,
        String department,
        String phoneNumber) { }

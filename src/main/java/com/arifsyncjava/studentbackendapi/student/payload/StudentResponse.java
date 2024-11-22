package com.arifsyncjava.studentbackendapi.student.payload;

import com.arifsyncjava.studentbackendapi.student.model.Student;

public record StudentResponse(
        String studentId,
        String name,
        String email,
        String department
) {

    public StudentResponse (Student student) {
        this(
                student.studentId(),
                student.name(),
                student.email(),
                student.department()

        );
    }

    public StudentResponse (StudentUpdateRequest student) {
        this(
                student.studentId(),
                student.request().name(),
                student.request().email(),
                student.request().department()

        );
    }






}

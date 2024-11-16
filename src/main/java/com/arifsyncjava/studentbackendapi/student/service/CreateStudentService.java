package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.model.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.model.StudentRequest;
import org.springframework.http.ResponseEntity;

public class CreateStudentService implements Service<StudentRequest, ApiResponse> {

    @Override
    public ResponseEntity<ApiResponse> execute(StudentRequest input) {
        return null;
    }



}

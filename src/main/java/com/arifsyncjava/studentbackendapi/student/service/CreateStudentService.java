package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import com.arifsyncjava.studentbackendapi.student.payload.StudentRequest;
import com.arifsyncjava.studentbackendapi.student.payload.StudentResponse;
import com.arifsyncjava.studentbackendapi.student.repository.CreateStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.SecureRandom;
import java.util.Map;

@org.springframework.stereotype.Service
public class CreateStudentService implements Service<StudentRequest, ApiResponse> {

    private final CreateStudentRepository repository ;

    public CreateStudentService(CreateStudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<ApiResponse> execute(StudentRequest  request) {
        String studentId = getStudentId() ;
        var student = new Student(studentId, request) ;

        var savedStudent = repository.execute(student) ;
        var body = new StudentResponse(savedStudent) ;
        var response = new ApiResponse(Map.of("created-student",body)) ;

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response) ;
    }







    private String getStudentId() {
        SecureRandom secureRandom = new SecureRandom() ;
        int random = secureRandom.nextInt((900_000_00) + 10_000_000) ;
        return String.valueOf(random) ;
    }


}

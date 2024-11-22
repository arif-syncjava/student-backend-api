package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import com.arifsyncjava.studentbackendapi.student.payload.StudentRequest;
import com.arifsyncjava.studentbackendapi.student.repository.CreateStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class CreateStudentService implements Service<StudentRequest, ApiResponse> {

    private final CreateStudentRepository repository ;

    public CreateStudentService(CreateStudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<ApiResponse> execute(StudentRequest  request) {
        var studentId = " 12849884" ;
        var student = new Student(studentId, request) ;












        throw new ApplicationException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ErrorMessage.STUDENT_ID_NOT_FOUND
        ) ;

    }



}

package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.payload.StudentResponse;
import com.arifsyncjava.studentbackendapi.student.repository.ReadAllStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ReadAllStudentService implements Service<Void, ApiResponse> {

    private final ReadAllStudentRepository repository ;

    public ReadAllStudentService(ReadAllStudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<ApiResponse> execute(Void input) {
        var studentList = repository.execute(input) ;
        if (studentList.isEmpty()) {
            throw new ApplicationException(
                    HttpStatus.NOT_FOUND,
                    ErrorMessage.NO_STUDENT_AVAILABLE
            ) ;
        }

        List<StudentResponse> body = studentList.stream()
                .map(StudentResponse::new).toList();

        var response = new ApiResponse(Map.of("list",body)) ;

        return ResponseEntity.ok(response) ;
    }


}

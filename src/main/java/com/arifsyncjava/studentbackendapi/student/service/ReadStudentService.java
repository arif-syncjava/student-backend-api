package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import com.arifsyncjava.studentbackendapi.student.payload.StudentResponse;
import com.arifsyncjava.studentbackendapi.student.repository.ReadStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ReadStudentService implements Service<String, ApiResponse> {

    private final ReadStudentRepository repository ;

    public ReadStudentService(ReadStudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<ApiResponse> execute(String studentId) {
        Optional<Student> student = repository.execute(studentId) ;
        if (!student.isPresent()) {
            throw new ApplicationException(
                    HttpStatus.NOT_FOUND,
                    ErrorMessage.STUDENT_ID_NOT_FOUND
            ) ;
        }

        var body = new StudentResponse(student.get()) ;
        var response = new ApiResponse(Map.of("student", body)) ;

        return ResponseEntity.ok(response) ;

    }


}

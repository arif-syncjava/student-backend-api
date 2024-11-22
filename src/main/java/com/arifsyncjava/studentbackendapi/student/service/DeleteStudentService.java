package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.repository.DeleteStudentRepository;
import com.arifsyncjava.studentbackendapi.student.repository.StudentIdCheckRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@org.springframework.stereotype.Service
public class DeleteStudentService implements Service<String, ApiResponse> {

    private final DeleteStudentRepository repository ;
    private final StudentIdCheckRepository checkRepository ;

    public DeleteStudentService(DeleteStudentRepository repository, StudentIdCheckRepository checkRepository) {
        this.repository = repository;
        this.checkRepository = checkRepository;
    }


    @Override
    public ResponseEntity<ApiResponse> execute(String studentId) {
        if (checkRepository.check(studentId)) {
            repository.execute(studentId) ;
        } else {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.STUDENT_ID_NOT_FOUND) ;
        }

        var response = new ApiResponse(Map.of("message",
                ErrorMessage.STUDENT_INFORMATION_DELETE_SUCCESSFULLY)) ;

        return ResponseEntity.ok(response);
    }

}

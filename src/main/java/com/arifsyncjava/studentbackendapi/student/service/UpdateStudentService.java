package com.arifsyncjava.studentbackendapi.student.service;

import com.arifsyncjava.studentbackendapi.Service;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.payload.StudentResponse;
import com.arifsyncjava.studentbackendapi.student.payload.StudentUpdateRequest;
import com.arifsyncjava.studentbackendapi.student.repository.StudentIdCheckRepository;
import com.arifsyncjava.studentbackendapi.student.repository.UpdateStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@org.springframework.stereotype.Service
public class UpdateStudentService implements Service<StudentUpdateRequest, ApiResponse> {

    private final UpdateStudentRepository updateRepository ;
    private final StudentIdCheckRepository checkRepository ;

    public UpdateStudentService(UpdateStudentRepository updateRepository,
                                StudentIdCheckRepository checkRepository) {
        this.updateRepository = updateRepository;
        this.checkRepository = checkRepository;

    }


    @Override
    public ResponseEntity<ApiResponse> execute(StudentUpdateRequest updateRequest) {
        String studentId = updateRequest.studentId();
        if (!checkRepository.check(studentId)) {
            throw new ApplicationException(
                    HttpStatus.NOT_FOUND,
                    ErrorMessage.STUDENT_ID_NOT_FOUND);
        }
        var  updatedStudent = updateRepository.execute(updateRequest) ;
        var body = new StudentResponse(updatedStudent) ;
        var response = new ApiResponse(Map.of("updated-student",body)) ;

        return ResponseEntity.ok(response) ;
    }
}

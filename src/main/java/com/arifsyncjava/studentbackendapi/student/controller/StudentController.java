package com.arifsyncjava.studentbackendapi.student.controller;

import com.arifsyncjava.studentbackendapi.model.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.model.StudentRequest;
import com.arifsyncjava.studentbackendapi.student.model.StudentResponse;
import com.arifsyncjava.studentbackendapi.student.service.CreateStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping (path = "/student")
public class StudentController {

    private final CreateStudentService createStudentService ;

    @PostMapping(path = "/save")
    public ResponseEntity<ApiResponse> create (StudentRequest request) {
        return createStudentService.execute(request) ;
    }













}

package com.arifsyncjava.studentbackendapi.student.controller;

import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.payload.StudentRequest;
import com.arifsyncjava.studentbackendapi.student.service.CreateStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping (path = "/student")
public class StudentController {

    private final CreateStudentService createStudentService ;

    public StudentController(CreateStudentService createStudentService) {
        this.createStudentService = createStudentService;
    }


    @GetMapping(path = "/save")
    public ResponseEntity<ApiResponse> create (StudentRequest request) {
        return createStudentService.execute(request) ;
    }













}

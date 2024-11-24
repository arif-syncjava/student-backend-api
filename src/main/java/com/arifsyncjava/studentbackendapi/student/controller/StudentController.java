package com.arifsyncjava.studentbackendapi.student.controller;

import com.arifsyncjava.studentbackendapi.payload.ApiResponse;
import com.arifsyncjava.studentbackendapi.student.payload.StudentRequest;
import com.arifsyncjava.studentbackendapi.student.payload.StudentUpdateRequest;
import com.arifsyncjava.studentbackendapi.student.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping (path = "/student")
public class StudentController {

    private final CreateStudentService createStudentService ;
    private final ReadStudentService readStudentService ;
    private final ReadAllStudentService readAllStudentService ;
    private final UpdateStudentService updateStudentService ;
    private final DeleteStudentService deleteStudentService ;

    public StudentController(CreateStudentService createStudentService,
                             ReadStudentService readStudentService,
                             ReadAllStudentService readAllStudentService,
                             UpdateStudentService updateStudentService,
                             DeleteStudentService deleteStudentService) {
        this.createStudentService = createStudentService;
        this.readStudentService = readStudentService;
        this.readAllStudentService = readAllStudentService;
        this.updateStudentService = updateStudentService;
        this.deleteStudentService = deleteStudentService;
    }


    @PostMapping (path = "/save")
    public ResponseEntity<ApiResponse> create (@RequestBody StudentRequest request) {
        return createStudentService.execute(request) ;
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<ApiResponse> read (@PathVariable("studentId") String studentId) {
        return readStudentService.execute(studentId) ;
    }

    @GetMapping(path = "/list")
    public ResponseEntity<ApiResponse> readAll () {
        return readAllStudentService.execute(null) ;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ApiResponse> update (
            @RequestBody StudentUpdateRequest request) {
        return updateStudentService.execute(request);
    }

    @DeleteMapping(path = "/delete/{studentId}")
    public ResponseEntity<ApiResponse> delete (@PathVariable String studentId) {
        return deleteStudentService.execute(studentId) ;
    }



}

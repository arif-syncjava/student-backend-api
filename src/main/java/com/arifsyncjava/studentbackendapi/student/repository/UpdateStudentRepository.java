package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import com.arifsyncjava.studentbackendapi.student.payload.StudentUpdateRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

@org.springframework.stereotype.Repository
public class UpdateStudentRepository implements Repository
        <StudentUpdateRequest,StudentUpdateRequest> {

    private final JdbcClient jdbc ;

    public UpdateStudentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public StudentUpdateRequest execute(StudentUpdateRequest updatedStudent) {
        try {
            jdbc.sql("UPDATE Students name = :name, email = :email, phone_number = :phoneNumber, department=:department WHERE student_id = :studentId")
                    .param("name",updatedStudent.request().name())
                    .param("email",updatedStudent.request().email())
                    .param("phone_number",updatedStudent.request().phoneNumber())
                    .param("department",updatedStudent.request().department())
                    .update() ;
        } catch (DataAccessException exception) {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.DATABASE_OPERATION_FAILED) ;
        }
        return updatedStudent;
    }










}

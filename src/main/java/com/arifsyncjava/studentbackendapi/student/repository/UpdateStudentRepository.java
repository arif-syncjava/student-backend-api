package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

@org.springframework.stereotype.Repository
public class UpdateStudentRepository implements Repository<Student,Student> {

    private final JdbcClient jdbc ;

    public UpdateStudentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Student execute(Student updatedStudent) {
        try {
            jdbc.sql("UPDATE Students name = :name, email = :email, phone_number = :phoneNumber, department=:department WHERE student_id = :studentId")
                    .param("name",updatedStudent.name())
                    .param("email",updatedStudent.email())
                    .param("phone_number",updatedStudent.phoneNumber())
                    .param("department",updatedStudent.department())
                    .update() ;
        } catch (DataAccessException exception) {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.DATABASE_OPERATION_FAILED) ;
        }
        return updatedStudent;
    }










}

package com.arifsyncjava.studentbackendapi.student.repository;


import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.*;

@org.springframework.stereotype.Repository
public class ReadAllStudentRepository implements Repository<Void, List<Student>> {

    private final JdbcClient jdbc ;

    public ReadAllStudentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public List<Student> execute(Void input) {
        var studentList;
        try {
            studentList = jdbc.sql("SELECT student_id,name,email,phoneNumber,department FROM Students")
                    .query(Student.class)
                    .list();

        } catch (DataAccessException exception) {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.DATABASE_OPERATION_FAILED);
        }


        return studentList;
    }


}

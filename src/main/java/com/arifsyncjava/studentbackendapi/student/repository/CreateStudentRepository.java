package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

@org.springframework.stereotype.Repository
public class CreateStudentRepository implements Repository<Student,Student> {

    private final JdbcClient jdbc ;

    public CreateStudentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Student execute(Student student) {
        try {
            jdbc.sql("INSERT INTO Students(student_id,name,email,phone_number,department) VALUES (:studentId,:name,:email,:phoneNumber,:department)")
                    .param("studentId", student.studentId())
                    .param("name", student.name())
                    .param("email", student.email())
                    .param("phoneNumber", student.phoneNumber())
                    .param("department", student.department())
                    .update() ;
        } catch (DataAccessException exception) {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.STUDENT_ID_NOT_FOUND
            ) ;
        }
        return student;
    }

}

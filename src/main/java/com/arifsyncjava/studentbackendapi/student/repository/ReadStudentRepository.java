package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;

@org.springframework.stereotype.Repository
public class ReadStudentRepository implements Repository<String, Optional<Student>> {

    private final JdbcClient jdbc ;
    public ReadStudentRepository (JdbcClient jdbcClient) {
        this.jdbc = jdbcClient ;
    }


    @Override
    public Optional<Student> execute(String studentId) {
      return   jdbc.sql("SELECT student_id,name,email,phoneNumber,department FROM Students WHERE student_id = :studentId")
                .param("studentId",studentId)
                .query(Student.class)
                .optional() ;

    }
}

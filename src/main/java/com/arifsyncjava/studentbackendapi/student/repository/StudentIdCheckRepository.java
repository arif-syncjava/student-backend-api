package com.arifsyncjava.studentbackendapi.student.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class StudentIdCheckRepository {

    private  final JdbcClient jdbc ;

    public StudentIdCheckRepository(JdbcClient jdbcClient) {
        this.jdbc = jdbcClient;
    }

    public  boolean check (String studentId) {
        var row = jdbc.sql("SELECT student_id FROM Students WHERE student_id = :studentId")
                .param("studentId", studentId)
                .update() ;
        if ( row == 0 ) {
            return false ;
        } else
            return true ;

    }








}

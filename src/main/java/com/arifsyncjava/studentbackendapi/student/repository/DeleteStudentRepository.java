package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.enums.ErrorMessage;
import com.arifsyncjava.studentbackendapi.exception.ApplicationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

@org.springframework.stereotype.Repository
public class DeleteStudentRepository implements Repository<String,Void> {

    private final JdbcClient jdbc ;

    public DeleteStudentRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Void execute(String studentId) {
        try {
            jdbc.sql("DELETE student_id,name,email,phone_number,department FROM Students WHERE student_id = :studentId")
                    .param("studentId",studentId)
                    .update();
        } catch (DataAccessException exception) {
            throw new ApplicationException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorMessage.DATABASE_OPERATION_FAILED) ;
        }

        return null;
    }




}

package com.arifsyncjava.studentbackendapi.student.repository;

import com.arifsyncjava.studentbackendapi.Repository;
import com.arifsyncjava.studentbackendapi.student.model.Student;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class ReadStudentRepository implements Repository<String, Optional<Student>> {

    private final JdbcClient jdbc ;
    public ReadStudentRepository (JdbcClient jdbcClient) {
        this.jdbc = jdbcClient ;
    }


    @Override
    public Optional<Student> execute(String studentId) {
      return   jdbc.sql("SELECT student_id,name,email,department,phone_number FROM Students WHERE student_id = :studentId")
                .param("studentId",studentId)
                .query((ResultSet rs, int rn)->mapToStudent(rs))
                .optional() ;

    }

    private Student mapToStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("department"),
                rs.getString("phone_number")
        ) ;
    }
}

package com.arifsyncjava.studentbackendapi;

import org.springframework.http.ResponseEntity;

public interface Service <I,O>{
    ResponseEntity<O> execute ( I input) ;
}

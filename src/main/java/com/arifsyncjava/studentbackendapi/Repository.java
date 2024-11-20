package com.arifsyncjava.studentbackendapi;

public interface Repository <I,O>{
    O execute (I input) ;
}

package com.azarov.springboot.springboot.exceptionhadling;

public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}

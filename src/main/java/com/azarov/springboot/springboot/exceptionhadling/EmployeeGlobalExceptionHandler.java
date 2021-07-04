package com.azarov.springboot.springboot.exceptionhadling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectInput> handleExceptions(NoSuchEmployeeException e) {
        EmployeeIncorrectInput employeeIncorrectInput = new EmployeeIncorrectInput();
        employeeIncorrectInput.setInfo(e.getLocalizedMessage());
        return new ResponseEntity<EmployeeIncorrectInput>(employeeIncorrectInput, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectInput> handleExceptions(Exception e) {
        EmployeeIncorrectInput employeeIncorrectInput = new EmployeeIncorrectInput();
        employeeIncorrectInput.setInfo(e.getLocalizedMessage());
        return new ResponseEntity<EmployeeIncorrectInput>(employeeIncorrectInput, HttpStatus.BAD_REQUEST);
    }
}

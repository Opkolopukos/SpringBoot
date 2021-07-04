package com.azarov.springboot.springboot.exceptionhadling;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeIncorrectInput {
    private String info;

    public EmployeeIncorrectInput() {
    }
}

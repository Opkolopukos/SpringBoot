package com.azarov.springboot.springboot.controller;


import com.azarov.springboot.springboot.entity.Employee;
import com.azarov.springboot.springboot.exceptionhadling.NoSuchEmployeeException;
import com.azarov.springboot.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id: " + id + " in db");
        }
        return employee;
    }

    @PostMapping("/ChangeEmployees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/ChangeEmployees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeService.getEmployee(id) == null) {
            throw new NoSuchEmployeeException("There is no employee with id =" + id + " in db");
        }
        employeeService.deleteEmployee(id);
        String info = "Employee with id = " + id + " was deleted";
        return info;
    }
}

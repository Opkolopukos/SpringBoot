package com.azarov.springboot.springboot.dao;


import com.azarov.springboot.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    void save(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}

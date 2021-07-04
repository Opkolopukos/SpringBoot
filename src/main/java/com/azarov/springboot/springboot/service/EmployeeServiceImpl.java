package com.azarov.springboot.springboot.service;


import com.azarov.springboot.springboot.dao.EmployeeDAO;
import com.azarov.springboot.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public Employee getEmployee(int id){
        return employeeDAO.getEmployee(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}

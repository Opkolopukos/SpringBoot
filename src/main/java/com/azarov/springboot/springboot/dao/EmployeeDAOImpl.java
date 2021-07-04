package com.azarov.springboot.springboot.dao;


import com.azarov.springboot.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings({})
    @Override
    public List<Employee> findAll() {
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("From Employee").getResultList();
        Query query = entityManager.createQuery("From Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public void save(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        session.createQuery("delete From Employee " + "where id =: employeeId")
//                .setParameter("employeeId", id)
//                .executeUpdate();

        Query query = entityManager.createQuery("delete From Employee " + "where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}

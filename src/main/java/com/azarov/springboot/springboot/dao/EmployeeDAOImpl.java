package com.azarov.springboot.springboot.dao;


import com.azarov.springboot.springboot.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("From Employee").getResultList();
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete From Employee " + "where id =: employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }
}

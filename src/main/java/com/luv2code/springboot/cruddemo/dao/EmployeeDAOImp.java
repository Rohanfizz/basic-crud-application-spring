package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = entityManager.createQuery("from Employee",Employee.class).getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class,theId);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee where lastName=:lastName",Employee.class);
        List<Employee> employees = theQuery.setParameter("lastName",lastName).getResultList();
        return employees;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //merge does save or update
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }

    @Override
    public int deleteAll() {
        int numRows = entityManager.createQuery("delete from Employee").executeUpdate();
        return numRows;
    }
}

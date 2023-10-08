package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAOImp;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAOImp employeeDAOImp;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOImp employeeDAOImp) {
        this.employeeDAOImp = employeeDAOImp;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAOImp.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAOImp.findById(id);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeDAOImp.findByLastName(lastName);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAOImp.save(theEmployee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAOImp.delete(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return employeeDAOImp.deleteAll();
    }
}

package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findByLastName(String lastName);
    Employee save(Employee theEmployee);
    void delete(int id);
    int deleteAll();
}

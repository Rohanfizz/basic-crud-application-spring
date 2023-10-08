package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.hibernate.sql.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmp(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee id not found "+id);
        }
        return employee;
    }

    @GetMapping("/employees/lastNameIs/{lastName}")
    public List<Employee> findByLastName(@PathVariable String lastName){
        List<Employee> employees = employeeService.findByLastName(lastName);
        if(employees == null){
            throw new RuntimeException("Employee lastName not found "+lastName);
        }
        return employees;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable int id){
        employeeService.delete(id);
    }

    @DeleteMapping("/employees/")
    public int deleteAll(){
        return employeeService.deleteAll();
    }
}

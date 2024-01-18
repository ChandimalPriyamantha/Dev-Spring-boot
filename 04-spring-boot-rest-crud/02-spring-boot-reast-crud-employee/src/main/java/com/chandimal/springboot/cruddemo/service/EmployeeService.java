package com.chandimal.springboot.cruddemo.service;

import com.chandimal.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

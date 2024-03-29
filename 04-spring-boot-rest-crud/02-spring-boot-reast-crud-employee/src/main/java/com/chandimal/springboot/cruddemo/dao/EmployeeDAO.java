package com.chandimal.springboot.cruddemo.dao;

import com.chandimal.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

package com.chandimal.springboot.cruddemo.dao;

import com.chandimal.springboot.cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}

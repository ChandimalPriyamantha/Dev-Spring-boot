package com.chandimal.springboot.cruddemo.dao;

import com.chandimal.springboot.cruddemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

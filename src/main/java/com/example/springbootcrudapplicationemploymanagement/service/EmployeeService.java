package com.example.springbootcrudapplicationemploymanagement.service;

import com.example.springbootcrudapplicationemploymanagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee e);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}

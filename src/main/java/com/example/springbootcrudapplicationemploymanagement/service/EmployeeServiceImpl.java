package com.example.springbootcrudapplicationemploymanagement.service;

import com.example.springbootcrudapplicationemploymanagement.exception.EmployeeNotFoundException;
import com.example.springbootcrudapplicationemploymanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee saveEmployee(Employee e) {
        if(e.getEmpId().isEmpty() || e.getEmpId() == null) {
            e.setEmpId(UUID.randomUUID().toString());
        }
        employees.add(e);
        return e;
    }

    @Override
    public String deleteEmployeeById(String id) {
        int n = employees.size();
        for(int i=0; i< n; i++) {
            Employee currEmployee = employees.get(i);
            if (!currEmployee.getEmpId().equals(id)) {
                continue;
            }
            employees.remove(currEmployee);
        }
        return "Employee Has been removed with the id= "+id;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream().filter(e -> e.getEmpId().equals(id)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee not found with the id: "+id));
    }
}

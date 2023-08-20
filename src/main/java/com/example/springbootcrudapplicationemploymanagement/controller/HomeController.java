package com.example.springbootcrudapplicationemploymanagement.controller;


import com.example.springbootcrudapplicationemploymanagement.model.Employee;
import com.example.springbootcrudapplicationemploymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    private Employee save(@RequestBody Employee e) {
        return employeeService.saveEmployee(e);
    }

    @GetMapping
    private List<Employee> fetch() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable String id ) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    private String deleteEmployeeById(@PathVariable String id) {
        return employeeService.deleteEmployeeById(id);
    }
}

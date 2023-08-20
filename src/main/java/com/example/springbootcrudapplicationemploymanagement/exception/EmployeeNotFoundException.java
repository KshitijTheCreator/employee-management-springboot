package com.example.springbootcrudapplicationemploymanagement.exception;

//This class is used to handle the custom exception if employee id is not found
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}

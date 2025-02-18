package com.practice.HRAnalytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.HRAnalytics.model.Employee;
import com.practice.HRAnalytics.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getMethodName() {
        return new String("Yo");
    }
    
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.save(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public Page<Employee> getEmployee(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "0")int size) {
        
        PageRequest pageable = PageRequest.of(page, size);
        return employeeService.getEmployee(pageable);
        
    }

    @PutMapping("employee/{id}")
    public String putEmployee(@PathVariable Long id, @RequestBody Employee new_employee) {
        //TODO: process PUT request
        String result = employeeService.updateEmployee(id, new_employee);
        return result;
        
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        String result = employeeService.deleteEmployee(id);
        return result;
    }
    
}

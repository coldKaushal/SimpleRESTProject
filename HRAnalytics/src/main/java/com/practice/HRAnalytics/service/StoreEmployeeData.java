package com.practice.HRAnalytics.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.HRAnalytics.model.Employee;

@Service
public class StoreEmployeeData {

    @Autowired
    private CSVReaderService csvReaderService;
    @Autowired
    private EmployeeService employeeService;

    public void storeData(){
        try {
            List<Employee> employee = csvReaderService.readEmployeesFromCSV();
            employeeService.addAllEmployees(employee);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}

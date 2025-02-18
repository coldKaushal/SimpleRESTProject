package com.practice.HRAnalytics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.practice.HRAnalytics.model.Employee;
import com.practice.HRAnalytics.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void addAllEmployees(List<Employee> employee){
        employeeRepository.saveAll(employee);
        System.out.println("Added all employees");
    }

    public Employee save(Employee employee) {
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee;
    }

    public Page<Employee> getEmployee(PageRequest pageable) {
        return employeeRepository.findAll(pageable);
    }

    public String updateEmployee(Long id, Employee employee) {
        // TODO Auto-generated method stub
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if(existingEmployee==null){
            return "Can not find employee with id: "+id;
        }
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEducation(employee.getEducation());
        existingEmployee.setEmployeeCount(employee.getEmployeeCount());
        
        employeeRepository.save(existingEmployee);
        return "New data saved";
    }

    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee==null){
            return "Can not find this employee";
        }
        employeeRepository.deleteById(id);
        return "Employee deleted";

    }
}

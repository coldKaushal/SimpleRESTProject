package com.practice.HRAnalytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.HRAnalytics.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        
}
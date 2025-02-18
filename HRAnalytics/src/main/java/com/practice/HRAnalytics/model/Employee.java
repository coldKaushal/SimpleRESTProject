package com.practice.HRAnalytics.model;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "Education")
    private String education;

    @CsvBindByName(column = "Age")
    private String age;

    @CsvBindByName(column = "EmployeeCount")
    private Double employeeCount;

    @CsvBindByName(column = "Department")
    private String department;

}

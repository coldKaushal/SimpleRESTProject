package com.practice.HRAnalytics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.practice.HRAnalytics.model.Employee;
import com.practice.HRAnalytics.service.CSVReaderService;

public class CSVReaderServiceTest {

    private CSVReaderService csvReaderService = new CSVReaderService();

    @Test
    void testReadEmployeesFromCSV() throws FileNotFoundException, IOException {
        List<Employee> employees = csvReaderService.readEmployeesFromCSV();
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        System.out.println(employees.get(1));
    }
}

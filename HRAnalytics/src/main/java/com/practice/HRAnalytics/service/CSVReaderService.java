package com.practice.HRAnalytics.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.practice.HRAnalytics.model.Employee;


@Service
public class CSVReaderService {

    public List<Employee> readEmployeesFromCSV() throws FileNotFoundException, IOException{
        Reader reader = new FileReader("HRAnalytics\\src\\main\\java\\com\\practice\\HRAnalytics\\service\\HR_Analytics.csv");
        CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader).withType(Employee.class).withIgnoreLeadingWhiteSpace(true).build();
        return csvToBean.parse();
    }
}

package com.practice.HRAnalytics;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties.Store;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.HRAnalytics.model.Employee;
import com.practice.HRAnalytics.service.CSVReaderService;
import com.practice.HRAnalytics.service.StoreEmployeeData;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HrAnalyticsApplication {

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = SpringApplication.run(HrAnalyticsApplication.class, args);
		SpringApplication.run(HrAnalyticsApplication.class, args);
		// StoreEmployeeData storeEmployeeData = context.getBean(StoreEmployeeData.class);
		// try {
		// 	storeEmployeeData.storeData();
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
	}

}

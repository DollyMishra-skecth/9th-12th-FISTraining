package com.fisglobal.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.employeemanagement.model.Employee;
import com.fisglobal.employeemanagement.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeemanagementApplication.class, args);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		
		Employee employee1 = new Employee("e001","Itachi","Uchiha",1000.0f);
		
		employeeRepository.save(employee1);
		
		context.close();
	}

}

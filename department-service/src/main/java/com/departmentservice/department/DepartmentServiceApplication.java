package com.departmentservice.department;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.departmentservice.department.model.Department;
import com.departmentservice.department.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(DepartmentServiceApplication.class, args);
		
		
		/*
		 * DepartmentRepository departmentRepository =
		 * context.getBean(DepartmentRepository.class); Department department = new
		 * Department("D01", "Accounts", "Bengaluru","abc@def.com",2500.0f); Department
		 * department2 = new Department("D02", "Security",
		 * "Mumbai","xyz@gsah.cun",8523.25f); Department department3 = new
		 * Department("D03", "Consultancy", "Chennai","jdah@hsl.njh",6588.25f);
		 * Department department4 = new Department("D04", "Developer",
		 * "Delhi","sbhsj@sh.co",9965.78f);
		 * 
		 * departmentRepository.save(department);
		 * departmentRepository.save(department2);
		 * departmentRepository.save(department3);
		 * departmentRepository.save(department4);
		 * 
		 * List<Department> departments = departmentRepository.findAll();
		 * 
		 * 
		 * departments.forEach(System.out::println);
		 * 
		 * context.close();
		 */
		 
		 
	
	}

}

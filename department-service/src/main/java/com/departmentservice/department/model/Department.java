package com.departmentservice.department.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "dept")
public class Department {
	
	@Id
	private String deptId;
	@Size(min = 2,max = 12,message = "Department name shd not exceed 12 characters")
	private String deptName;
	@Size(min = 2,max = 15,message = "Location shd not exceed 15 characters")
	private String deptLoc;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Positive
	@Min(value = 0, message = "Salary can't be negative")
	private float DeptSalary;

}



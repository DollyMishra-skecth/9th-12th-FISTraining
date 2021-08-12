package com.departmentservice.department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.department.exception.ResourceNotFound;
import com.departmentservice.department.model.Department;
import com.departmentservice.department.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List<Department> departments = departmentRepository.findAll();
		if(departments.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(departments);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws ResourceNotFound
	{
		Department department = departmentRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFound("No record exists for Department having dID= " +id));
		
		return ResponseEntity.ok().body(department);
		
//		Optional<Department> optional= departmentRepository.findById(id);
//		
//		if(optional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record exists for Department having dID= " +id);
//		}
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<?> createDepartment(@RequestBody Department newDepartment)
	{
		if(departmentRepository.existsById(newDepartment.getDeptId())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Record Exists");
		}
		Department tempdepartment = departmentRepository.save(newDepartment);
		
		System.out.println(tempdepartment);
		if(tempdepartment!=null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(tempdepartment);
		}
		else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(tempdepartment);
		}
	}
}

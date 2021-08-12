package com.fisglobal.organizationservice.controller;
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

import com.fisglobal.organizationservice.exception.ResourceNotFound;
import com.fisglobal.organizationservice.model.Organization;
import com.fisglobal.organizationservice.model.Organization;
import com.fisglobal.organizationservice.repository.OrgRepo;

@RestController
@RequestMapping("/api/organization")
public class OrgController {
	@Autowired
	private OrgRepo orgRepository;
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List<Organization> orgs = orgRepository.findAll();
		if(orgs.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(orgs);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data found");
		}
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws ResourceNotFound
	{
		Organization org = orgRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFound("No record exists for Organization having OrgID= " +id));
		
		return ResponseEntity.ok().body(org);
		
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

	@PostMapping("/addOrg")
	public ResponseEntity<?> createDepartment(@RequestBody Organization newOrganization)
	{
		if(orgRepository.existsById(newOrganization.getOrgId())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Record Exists");
		}
		Organization temporganization = orgRepository.save(newOrganization);
		
		System.out.println(temporganization);
		if(temporganization!=null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(temporganization);
		}
		else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(temporganization);
		}
	}
	
}

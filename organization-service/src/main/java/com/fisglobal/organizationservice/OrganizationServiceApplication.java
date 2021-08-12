package com.fisglobal.organizationservice;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.organizationservice.model.Organization;
import com.fisglobal.organizationservice.repository.OrgRepo;

import java.util.*;
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(OrganizationServiceApplication.class, args);
		/*OrgRepo orgRepo =context.getBean(OrgRepo.class);
		Organization or1 = new Organization("o101","Space","Mumbai");
		Organization or2 = new Organization("o102","Shape","Bangalore");
		Organization or3 = new Organization("o103","Soap","Chennai");
		
				 
		orgRepo.save(or1);
		orgRepo.save(or2);
		orgRepo.save(or3);
				 
				 
				 List<Organization> orgs = orgRepo.findAll();
				 
				 
				 orgs.forEach(System.out::println);
				
				 context.close();*/
	}

}

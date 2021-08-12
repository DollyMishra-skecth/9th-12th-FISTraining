package com.fisglobal.organizationservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Organization")
public class Organization {

	@Id
	private String orgId;
	@Size(min = 2,max = 12,message = "Department name shd not exceed 12 characters")
	private String orgName;
	@Size(min = 2,max = 15,message = "Location shd not exceed 15 characters")
	private String orgLoc;
}

package com.fisglobal.organizationservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.organizationservice.model.Organization;

@Repository
public interface OrgRepo extends JpaRepository<Organization, String>{

}

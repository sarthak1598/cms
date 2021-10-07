package com.cmsservices.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmsservices.cms.cmsentity.Customermodel;

// An interface inheriting the methods of jparepository interface for jpa based crud operations

public interface CustomerDb extends JpaRepository<Customermodel , Long> {
	
}

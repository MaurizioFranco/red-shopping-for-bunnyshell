package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.price.low.entity.Department;

/**
 * Provides a repository for the DepartmentRecord entity
 * 
 * Provides data for department info
 * 
 * @author maurizio.franco@ymail.com
 */
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

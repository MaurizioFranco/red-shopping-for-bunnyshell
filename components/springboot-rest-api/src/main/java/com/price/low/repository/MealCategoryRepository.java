package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.price.low.entity.MealCategory;

/**
 * Provides a repository for the MealCategory entity
 * 
 * Provides data for MealCategory info
 * 
 * @author maurizio.franco@ymail.com
 */
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MealCategoryRepository extends JpaRepository<MealCategory, Long> {

}

package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.price.low.entity.MealSubCategory;

/**
 * Provides a repository for the MealSubCategory entity
 * 
 * Provides data for MealSubCategory info
 * 
 * @author maurizio.franco@ymail.com
 */
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MealSubCategoryRepository extends JpaRepository<MealSubCategory, Long> {

}

package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.price.low.entity.Meal;

/**
 * Provides a repository for the Meal entity
 * 
 * Provides data for Meal info
 * 
 * @author maurizio.franco@ymail.com
 */
@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MealRepository extends JpaRepository<Meal, Long> {

}

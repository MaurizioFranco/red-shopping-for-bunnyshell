/**
 * 
 */
package com.price.low.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.low.entity.MealCategory;
import com.price.low.service.MealCategoryService;



/**
 * 
 * Provides rest api for meal category entity mapping methods
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/mealcategory")
@CrossOrigin(origins = "*")
public class MealCategoryController {
	public static final Logger logger = LoggerFactory.getLogger(MealCategoryController.class);
	
	@Autowired
	private MealCategoryService mealCategoryService ;

	@GetMapping("/")
	public ResponseEntity<List<MealCategory>> getItems() {
		List<MealCategory> items = mealCategoryService.getAll();
		
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
}

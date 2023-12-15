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

import com.price.low.entity.Meal;
import com.price.low.service.MealService;



/**
 * 
 * Provides rest api for meal entity mapping methods
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/meal")
@CrossOrigin(origins = "*")
public class MealController {
	public static final Logger logger = LoggerFactory.getLogger(MealController.class);
	
	@Autowired
	private MealService mealService ;

	@GetMapping("/")
	public ResponseEntity<List<Meal>> getItems() {
		List<Meal> items = mealService.getAll();
		
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
}

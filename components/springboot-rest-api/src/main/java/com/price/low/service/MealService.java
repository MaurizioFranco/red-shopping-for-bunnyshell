package com.price.low.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.low.entity.Meal;
import com.price.low.repository.MealRepository;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class MealService {

	public static final Logger logger = LoggerFactory.getLogger(MealService.class);

	@Autowired
	private MealRepository mealRepository;

	/**
	 * Provides list of meals entities from repository
	 * 
	 * @return List<Meals>, list of Meals entity objects
	 */
	public List<Meal> getAll() {
		logger.info("getAll - START");
		List<Meal> items = mealRepository.findAll();
		logger.info("getAll - END - returning " + items.size() + " meals.");
		return items;
	}

}

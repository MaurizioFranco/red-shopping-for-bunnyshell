package com.price.low.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.low.entity.MealCategory;
import com.price.low.repository.MealCategoryRepository;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class MealCategoryService {

	public static final Logger logger = LoggerFactory.getLogger(MealCategoryService.class);

	@Autowired
	private MealCategoryRepository mealCategoryRepository;

	/**
	 * Provides list of meals entities from repository
	 * 
	 * @return List<Meals>, list of Meals entity objects
	 */
	public List<MealCategory> getAll() {
		logger.info("getAll - START");
		List<MealCategory> items = mealCategoryRepository.findAll();
		logger.info("getAll - END - returning " + items.size() + " meal categories.");
		return items;
	}

}

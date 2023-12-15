/**
 * 
 */
package com.price.low.configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.price.low.entity.Department;
import com.price.low.entity.Meal;
import com.price.low.entity.MealCategory;
import com.price.low.entity.MealSubCategory;
import com.price.low.entity.UnitOfMeasure;

/**
 * To expose id where it's needed.
 * Spring data rest default hide id for returned instances
 */
@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Department.class);
		config.exposeIdsFor(Meal.class);
		config.exposeIdsFor(MealCategory.class);
		config.exposeIdsFor(MealSubCategory.class);
		config.exposeIdsFor(UnitOfMeasure.class);
//		config.exposeIdsFor(Store.class);
	}
}
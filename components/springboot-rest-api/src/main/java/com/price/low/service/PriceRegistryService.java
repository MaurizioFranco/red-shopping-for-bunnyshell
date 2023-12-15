package com.price.low.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.low.entity.PriceRegistry;
import com.price.low.repository.PriceRegistryRepository;
import com.price.low.request.model.PriceCustomRequest;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class PriceRegistryService {

	public static final Logger logger = LoggerFactory.getLogger(PriceRegistryService.class);

	@Autowired
	private PriceRegistryRepository priceRegistryRepository ;
	
	/**
	 * Provides to insert new selling price for item
	 * 
	 * @param PriceRegistry
	 * @return
	 */
	public PriceRegistry insertPriceRegistryEntity (PriceRegistry entity) {
		logger.info("insert - START - with PriceRegistry {}", entity);
		return priceRegistryRepository.saveAndFlush(entity);
	}
	
	/**
	 * Provides to insert new selling price for item
	 * 
	 * @param PriceRegistry
	 * @return
	 */
	public PriceRegistry insertPriceCustomRequest (PriceCustomRequest request) {
		logger.info("insert - START - with PriceCustomRequest {}", request);
		LocalDateTime ldt = null ;
		PriceRegistry entityToInsert = new PriceRegistry (request.getProduct_id(), request.getSelling_prize(), request.getList_prize(), ldt, request.getStore_id()) ;
		return priceRegistryRepository.saveAndFlush(entityToInsert);
	}

}

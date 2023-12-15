package com.price.low.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.low.repository.custom.StoreRecordRepository;
import com.price.low.response.model.StoreRecord;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class StoreRegistryService {

	public static final Logger logger = LoggerFactory.getLogger(StoreRegistryService.class);

	@Autowired
	private StoreRecordRepository storeRecordRepository;

	/**
	 * Provides list of pointOfSale from repository
	 * 
	 * @return List<StoreRecord>
	 */
	public List<StoreRecord> getAll() {
		logger.info("getAll - START");
		List<StoreRecord> items = storeRecordRepository.findAllStores();
		logger.info("getAll - END - returning " + items.size() + " stores(StoreRecord).");
		return items;
	}

}

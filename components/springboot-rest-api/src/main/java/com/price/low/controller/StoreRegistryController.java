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

import com.price.low.response.model.StoreRecord;
import com.price.low.service.StoreRegistryService;



/**
 * 
 * Provides rest api for StoreRecord response data
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/stores")
@CrossOrigin(origins = "*")
public class StoreRegistryController {
	public static final Logger logger = LoggerFactory.getLogger(StoreRegistryController.class);
	
	@Autowired
	private StoreRegistryService storeRegistryService ;

	@GetMapping("/")
	public ResponseEntity<List<StoreRecord>> getItems() {
		List<StoreRecord> items = storeRegistryService.getAll();
		
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
}

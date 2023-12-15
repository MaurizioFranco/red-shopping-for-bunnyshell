/**
 * 
 */
package com.price.low.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.low.response.model.ProductRecord;
import com.price.low.service.FullProductRegistryService;



/**
 * 
 * Provides rest api for Product Record response data
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/barcode")
@CrossOrigin(origins = "*")
public class BarcodeController {
	public static final Logger logger = LoggerFactory.getLogger(BarcodeController.class);
	
	@Autowired
	private FullProductRegistryService fullProductRegistryService ;

	/*
	 * retrieve product info per given barcode 
	 * @arg 
	 */
	@GetMapping("/{barcode}")
	public ResponseEntity<ProductRecord> getProductInfoPerBarcode(@PathVariable("barcode") final String barcode) {

			Optional<ProductRecord> optionalItem = fullProductRegistryService.getByBarcode(barcode);
			if (optionalItem.isPresent()) {
				logger.info("getProductInfoPerBarcode - DEBUG - research for barcode: {}, found:{}", barcode, optionalItem.get());
				return new ResponseEntity<>(optionalItem.get(), HttpStatus.OK);
			} else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
}

/**
 * 
 */
package com.price.low.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.low.controller.validator.CustomErrorType;
import com.price.low.entity.PriceRegistry;
import com.price.low.request.model.PriceCustomRequest;
import com.price.low.service.PriceRegistryService;



/**
 * 
 * Provides rest api for new price registration for an already registered(so already in db) product
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/price/new")
public class PriceRegistryController {
	public static final Logger logger = LoggerFactory.getLogger(PriceRegistryController.class);
	
	@Autowired
	private PriceRegistryService priceRegistryService ;

	
	
	@Transactional
	@PostMapping(value = "/")
	public ResponseEntity<?> insert(PriceCustomRequest request) {
		logger.info("insert : {}", request);
//		PriceRegistry responseObj = priceRegistryService.insertPriceCustomRequest(request);
		PriceRegistry responseObj = null ;
		try {
			return new ResponseEntity<PriceRegistry>(responseObj, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("ERROR in inserting new PriceCustomRequest: ", e);
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to insert new PriceCustomRequest: " + request)  , HttpStatus.BAD_REQUEST);
		}
	}	
	
//	@Transactional
//	@PostMapping(value = "/")
//	public ResponseEntity<?> insert(@ModelAttribute ProductRecord requestProduct) {
//		logger.info("insert : {}", requestProduct);
//		ProductRecord objToReturn = null ;
//		try {
////			objToReturn = candidateService.createNewCandidate(requestCandidateCustom);
//			return new ResponseEntity<ProductRecord>(objToReturn, HttpStatus.CREATED);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			logger.error("ERROR in inserting new candidate: ", e);
//			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to insert new product: " + requestProduct)  , HttpStatus.BAD_REQUEST);
//		}
//	}	
	
}

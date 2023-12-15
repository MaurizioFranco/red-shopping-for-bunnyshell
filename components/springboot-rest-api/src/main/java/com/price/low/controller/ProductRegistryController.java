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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.low.controller.validator.CustomErrorType;
import com.price.low.entity.Product;
import com.price.low.request.model.ProductCustomRequest;
import com.price.low.response.model.ProductRecord;
import com.price.low.service.FullProductRegistryService;



/**
 * 
 * Provides rest api for Product Record response data
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/products")
public class ProductRegistryController {
	public static final Logger logger = LoggerFactory.getLogger(ProductRegistryController.class);
	
	@Autowired
	private FullProductRegistryService fullProductRegistryService ;

	@CrossOrigin
	@GetMapping("/")
	public ResponseEntity<List<ProductRecord>> getItems() {
		List<ProductRecord> items = fullProductRegistryService.getAll();
		
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value = "/")
	public ResponseEntity<?> insert(@ModelAttribute ProductCustomRequest requestProduct) {
		logger.info("insert : {}", requestProduct);
		Product objToReturn = fullProductRegistryService.insert(requestProduct);
		try {
//			objToReturn = candidateService.createNewCandidate(requestCandidateCustom);
			return new ResponseEntity<Product>(objToReturn, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("ERROR in inserting new ProductCustomRequest: ", e);
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to insert new ProductCustomRequest: " + requestProduct)  , HttpStatus.BAD_REQUEST);
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

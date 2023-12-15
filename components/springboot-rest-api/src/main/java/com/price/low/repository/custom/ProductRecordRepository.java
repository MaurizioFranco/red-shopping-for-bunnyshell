package com.price.low.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.price.low.response.model.ProductRecord;
/**
 * ProductRecordRepository
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public interface ProductRecordRepository {
	
	List<ProductRecord> findAllProducts();
	
	ProductRecord findByBarcode(String barcode);
	
}

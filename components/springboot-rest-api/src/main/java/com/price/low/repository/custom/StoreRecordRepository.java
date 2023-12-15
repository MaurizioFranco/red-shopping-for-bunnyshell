package com.price.low.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.price.low.response.model.StoreRecord;
/**
 * StoreRecordRepository
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public interface StoreRecordRepository {
	
	List<StoreRecord> findAllStores();
	
}

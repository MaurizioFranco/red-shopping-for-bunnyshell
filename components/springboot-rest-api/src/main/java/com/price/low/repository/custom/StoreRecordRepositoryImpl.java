package com.price.low.repository.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.price.low.response.model.StoreRecord;
/**
 * StoreRecordRepository
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class StoreRecordRepositoryImpl implements StoreRecordRepository {
	
	private final JdbcTemplate jdbcTemplate;

    public StoreRecordRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    select * from store p
//    JOIN brand br ON p.brand_id = br.brand_id
//    order by p.store_id
    public List<StoreRecord> findAllStores() {
        return jdbcTemplate.query(
        		"select * from store p\r\n"
        		+ "     JOIN brand br ON p.brand_id = br.brand_id\r\n"
        		+ "     order by p.store_id", (rs, rowNum) -> new StoreRecord(
        				rs.getLong("store_id"),
        				rs.getLong("brand_id"),
        				rs.getString("store_full_business_name"),
        		        rs.getString("store_city"),
        		        rs.getString("store_address"),
        		        rs.getString("store_province"),
		                rs.getTimestamp("store_insert_datetime"),
		                rs.getString("brand_name"),
		                rs.getString("brand_full_business_name")
		        ));
    }
	
}

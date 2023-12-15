/**
 * 
 */
package com.price.low.response.model;

import java.sql.Timestamp;

/**
 * Provides data for store full info to list into frontend
 * 
 * @author maurizio.franco@ymail.com
 */
public record StoreRecord(
		Long store_id,
		Long brand_id,
	    String store_full_business_name,
	    String store_city,
	    String store_address,
	    String store_province,
	    Timestamp store_insert_datetime,
	    String brand_name,
	    String brand_full_business_name
		) {

}

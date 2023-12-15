/**
 * 
 */
package com.price.low.response.model;

import java.sql.Timestamp;

/**
 * Provides data for product full info to list into frontend
 * 
 * @author maurizio.franco@ymail.com
 */
public record ProductRecord(
		Long id                  ,
		Long barcode_number      ,
	    String product_name      ,
	    String product_description       ,
	    Long unit_of_measure     ,
	    String unit_of_measure_label,
	    Double measure             ,
	    Long department_id       ,
	    Long meal_id       ,
	    Long meal_category_id    ,
	    Long meal_sub_category_id,
	    String manufacturer_name ,
	    String image_file_name,
	    String full_path_image_file_name,
	    Long store_id,
	    Double list_prize,
	    Double selling_prize,
	    Timestamp prize_registry_insert_datetime,
	    Long prize_registry_point_of_sale_id,
	    //brand
	    String brand_name,
	    String logo_image_file_name
		) {

}

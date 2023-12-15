package com.price.low.repository.custom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.price.low.response.model.ProductRecord;
/**
 * ProductRecordRepository
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class ProductRecordRepositoryImpl implements ProductRecordRepository {
	
	@Value("${product.img.relative.path}")
	private String product_img_relative_path ;
	
	private final JdbcTemplate jdbcTemplate;

    public ProductRecordRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    select * from products p
//    JOIN price_registry pr ON p.id = pr.product_id
//     JOIN store pos ON pr.store_id = pos.store_id
//     JOIN brand br ON pos.brand_id = br.brand_id
//     JOIN unit_of_measure uom ON uom.id = p.unit_of_measure

    public List<ProductRecord> findAllProducts() {
        return jdbcTemplate.query(
        		"select * from products p\r\n"
        		+ "JOIN price_registry pr ON p.id = pr.product_id\r\n"
        		+ "JOIN store pos ON pr.store_id = pos.store_id\r\n"
        		+ "JOIN brand br ON pos.brand_id = br.brand_id\r\n"
        		+ "JOIN unit_of_measure uom ON uom.id = p.unit_of_measure\r\n"
        		+ "ORDER BY p.id", (rs, rowNum) -> new ProductRecord(
        				rs.getLong("id"),
        				rs.getLong("barcode_number"),
        				rs.getString("product_name"),
        		        rs.getString("description"),
        		        rs.getLong("unit_of_measure"),
        		        rs.getString("unit_of_measure_label"),
        		        rs.getDouble("measure"),
        		        rs.getLong("department_id"),
        		        rs.getLong("meal_id"),
        		        rs.getLong("meal_category_id"),
        		        rs.getLong("meal_sub_category_id"),
        		        rs.getString("manufacturer_name"),
		                rs.getString("image_file_name"),
		                product_img_relative_path + rs.getString("image_file_name"),
		                rs.getLong("product_id"),
		                rs.getDouble("selling_prize"),
		                rs.getDouble("list_prize"),
		                rs.getTimestamp("insert_datetime"),
		                rs.getLong("store_id"),
		                rs.getString("brand_name"),
		                rs.getString("brand_logo_image_file_name")
		        ));
    }
    
//    select * from products p
//    JOIN price_registry pr ON p.id = pr.product_id
//    JOIN store pos ON pr.store_id = pos.store_id
//    JOIN brand br ON pos.brand_id = br.brand_id
//    JOIN unit_of_measure uom ON uom.id = p.unit_of_measure
//    WHERE p.barcode_number=???;

  public ProductRecord findByBarcode(String barcode) {
      return jdbcTemplate.queryForObject(
      		"select * from products p\r\n"
      		+ "JOIN price_registry pr ON p.id = pr.product_id\r\n"
      		+ "JOIN store pos ON pr.store_id = pos.store_id\r\n"
      		+ "JOIN brand br ON pos.brand_id = br.brand_id\r\n"
        	+ "JOIN unit_of_measure uom ON uom.id = p.unit_of_measure\r\n"
      		+ "WHERE p.barcode_number=" + barcode, (rs, rowNum) -> new ProductRecord(
      				rs.getLong("id"),
      				rs.getLong("barcode_number"),
      				rs.getString("product_name"),
      		        rs.getString("description"),
      		        rs.getLong("unit_of_measure"),
      		        rs.getString("unit_of_measure_label"),
      		        rs.getDouble("measure"),
      		        rs.getLong("department_id"),
    		        rs.getLong("meal_id"),
      		        rs.getLong("meal_category_id"),
      		        rs.getLong("meal_sub_category_id"),
      		        rs.getString("manufacturer_name"),
	                rs.getString("image_file_name"),
	                product_img_relative_path + rs.getString("image_file_name"),
	                rs.getLong("product_id"),
	                rs.getDouble("selling_prize"),
	                rs.getDouble("list_prize"),
	                rs.getTimestamp("insert_datetime"),
	                rs.getLong("store_id"),
	                rs.getString("brand_name"),
	                rs.getString("brand_logo_image_file_name")
		        ));
  }
	
}

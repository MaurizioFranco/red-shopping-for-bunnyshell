/**
 * 
 */
package com.price.low.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long barcode_number;
    private String product_name;
    private String description;
    private Long unit_of_measure;
    private Long measure;
    private Long department_id;
    private Long meal_category_id;
    private Long meal_sub_category_id;
    private String manufacturer_name;
    private String image_file_name;
}

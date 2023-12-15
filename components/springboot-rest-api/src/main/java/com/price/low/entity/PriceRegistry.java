/**
 * 
 */
package com.price.low.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
 * @author maurizio.franco@ymail.com
 */
@Entity
@Table(name = "price_registry")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PriceRegistry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long product_id;
    private Double selling_prize;
    private Double list_prize;
    private LocalDateTime insert_datetime;
    private Long store_id;
    
    public PriceRegistry (Long product_id, Double selling_prize, Double list_prize, LocalDateTime insert_datetime, Long store_id) {
    	this.product_id=product_id;
    	this.selling_prize=selling_prize;
    	this.list_prize=list_prize;
    	this.insert_datetime=insert_datetime;
    	this.store_id=store_id;
    }
}

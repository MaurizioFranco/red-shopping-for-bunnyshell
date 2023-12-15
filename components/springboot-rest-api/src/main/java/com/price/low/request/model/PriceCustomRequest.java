/**
 * 
 */
package com.price.low.request.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author maurizio.franco@ymail.com
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PriceCustomRequest {

	protected long product_id;
	protected Long store_id;
	protected Double selling_prize;
	protected Double list_prize ;
	protected String product_insert_datetime ;

}

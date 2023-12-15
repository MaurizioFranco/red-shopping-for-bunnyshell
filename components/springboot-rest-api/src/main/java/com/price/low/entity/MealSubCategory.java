/**
 * 
 */
package com.price.low.entity;

import jakarta.persistence.Column;
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
@Table(name = "meal_sub_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MealSubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    @Column(name = "meal")
    private long meal_id;
    @Column(name = "meal_category")
    private long meal_category_id;
    private long level;
}

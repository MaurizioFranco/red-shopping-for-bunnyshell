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
@Table(name = "meals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private String description;
    private long department_id;
    private long level;
}

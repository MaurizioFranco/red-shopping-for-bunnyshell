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
@Table(name = "unit_of_measure")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UnitOfMeasure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String unit_of_measure_label;
    private String description;
    private long level;
}

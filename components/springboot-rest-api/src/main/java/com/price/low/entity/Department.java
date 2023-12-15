/**
 * 
 */
package com.price.low.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

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
@Table(name = "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private String description;
    private int level;
//    @CreatedBy
//    private User user;
//    @CreatedDate
//    private Instant createdDate;
}

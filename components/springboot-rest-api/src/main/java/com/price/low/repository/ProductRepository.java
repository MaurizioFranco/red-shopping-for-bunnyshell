package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.price.low.entity.Product;

/**
 * Provides a repository for the Product entity
 * 
 * Provides data for Product info
 * 
 * @author maurizio.franco@ymail.com
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}

package com.price.low.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.price.low.entity.PriceRegistry;

/**
 * Provides a repository for the PriceRegistry entity
 * 
 * Provides data for PriceRegistry info
 * 
 * @author maurizio.franco@ymail.com
 */
public interface PriceRegistryRepository extends JpaRepository<PriceRegistry, Long> {

}

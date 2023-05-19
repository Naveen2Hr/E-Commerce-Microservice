package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Product;

/**
 * 
 * @author sagar.hr
 * 
 *         Interface for the Product Repository with extending CrudRepository
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

}

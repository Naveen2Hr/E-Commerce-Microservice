package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.ProductType;

/**
 * 
 * @author sagar.hr
 * 
 *         Interface for the ProductType Repository with extending
 *         CrudRepository
 */
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {

}

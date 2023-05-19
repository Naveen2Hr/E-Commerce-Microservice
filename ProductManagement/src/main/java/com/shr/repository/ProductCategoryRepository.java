package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.ProductCategory;

/**
 * 
 * @author sagar.hr
 * 
 *         Interface for the ProductCategory Repository with extending
 *         CrudRepository
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer>{

}

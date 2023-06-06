package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author ashik.k
 * 
 *  		Interface for the OrderedProduct Repository with extending
 *         		CrudRepository
 *         
 */

import com.shr.entity.OrderedProduct;

public interface OrderedProductRepository extends CrudRepository<OrderedProduct, Integer> {

}

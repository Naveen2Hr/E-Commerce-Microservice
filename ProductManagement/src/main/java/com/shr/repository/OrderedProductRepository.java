package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.OrderedProduct;

public interface OrderedProductRepository extends CrudRepository<OrderedProduct, Integer> {

}

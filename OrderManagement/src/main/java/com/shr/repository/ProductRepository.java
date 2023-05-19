package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}

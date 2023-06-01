package com.shr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer> {

}

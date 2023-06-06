package com.shr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Product;

/**
 * 
 * @author m.rakesh
 *
 *@apiNote Repository Interface extends JpaRepository and CrudRepository with Product as Type and
 *          ID as Integer
 */
public interface ProductRepository extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer> {

}

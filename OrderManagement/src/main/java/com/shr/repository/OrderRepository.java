package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Order;

/**
 * 
 * @author m.rakesh
 * 
 * @apiNote Repository Interface extends CrudRepository with Order as Type and
 *          ID as Integer
 *
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {

}

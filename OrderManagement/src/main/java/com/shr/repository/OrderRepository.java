package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}

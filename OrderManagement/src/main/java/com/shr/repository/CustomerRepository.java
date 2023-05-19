package com.shr.repository;

import org.springframework.data.repository.CrudRepository;

import com.shr.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}

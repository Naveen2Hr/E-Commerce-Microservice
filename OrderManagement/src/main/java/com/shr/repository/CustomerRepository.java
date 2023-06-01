package com.shr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shr.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}

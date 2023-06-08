package com.shr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shr.entity.Customer;

/**
 * 
 * @author m.rakesh
 * 
 * @apiNote Repository Interface extends JpaRepository with Customer as Type and
 *          ID as String
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

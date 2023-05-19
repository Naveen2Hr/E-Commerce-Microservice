package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Customer;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Repository Interface extends JpaRepository with Customer as Type and
 *          ID as String
 */
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}

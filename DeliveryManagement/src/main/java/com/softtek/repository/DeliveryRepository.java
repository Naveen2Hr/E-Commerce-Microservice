package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Delivery;

/**
 * 
 * @author nandish.c
 *
 * @apiNote DeliveryRepository Interface for CRUD operation
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}

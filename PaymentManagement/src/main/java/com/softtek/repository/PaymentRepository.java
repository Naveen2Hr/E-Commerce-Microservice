package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Payment;


/**
 * 
 * @author shreelakshmi.ms
 *
 * @apiNote PaymentRepository Interface extends JpaRepository with Payment as Type and
 *          ID as Long
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Payment findByOrderId(long orderId);

}

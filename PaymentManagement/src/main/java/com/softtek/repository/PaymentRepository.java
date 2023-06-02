package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Payment findByOrderId(long orderId);

}

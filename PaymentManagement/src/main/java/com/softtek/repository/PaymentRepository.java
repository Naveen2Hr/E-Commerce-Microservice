package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Payment findByOrderId(long orderId);

}

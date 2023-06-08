package com.softtek.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.softtek.model.Payment;

@FeignClient("Payment-Service")
public interface PaymentClient {

	@GetMapping("/payment/all")
	public ResponseEntity<List<Payment>> getAllPaymentDetails();
}

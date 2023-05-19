package com.softtek.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.entity.Payment;
import com.softtek.service.IPaymentService;
import com.softtek.service.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class CommerceController {
	@Autowired
	private IPaymentService paymentService;
	
	@Autowired
	private PaymentServiceImpl service;
	
	@PostMapping("/save")
	public void createPayment(@RequestBody Payment payment) {
		//set payment date and time
		payment.setDateAndTime(LocalDateTime.now());
		paymentService.savePaymentDetails(payment);
	}
	
	@GetMapping("/payment/{orderId}")
	public ResponseEntity<Payment> getPaymentDetailsByOrderId(@PathVariable long orderId){
		Payment payment = paymentService.getPaymentDetailsByOrderId(orderId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	
}

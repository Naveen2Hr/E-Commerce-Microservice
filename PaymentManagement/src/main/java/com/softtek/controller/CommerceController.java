package com.softtek.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.client.OrderClient;
import com.softtek.entity.Payment;
import com.softtek.model.Order;
import com.softtek.service.IPaymentService;
import com.softtek.service.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class CommerceController {
	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private PaymentServiceImpl service;

	@Autowired
	private OrderClient client;

	@PostMapping("/save")
	public void createPayment(@RequestBody Payment payment) {
		// set payment date and time
		payment.setDateAndTime(LocalDateTime.now());
		paymentService.savePaymentDetails(payment);
	}

	@GetMapping("/payment/{orderId}")
	public ResponseEntity<Payment> getPaymentDetailsByOrderId(@PathVariable long orderId) {
		Payment payment = paymentService.getPaymentDetailsByOrderId(orderId);
		if (payment != null) {
			return ResponseEntity.ok(payment);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/getPayment")
	public ResponseEntity<String> generatePayment() {
		try {
			Payment payment = new Payment();
			Order order = client.getOrderRecord().getBody();
			payment.setOrderId(100L);
			payment.setDateAndTime(LocalDateTime.now());
			payment.setOrderId(order.getOrderId());
			payment.setPaymentStatus(false);
			payment.setTotalAmount(order.getTotalPrice());
			payment.setPaymentMode("COD");
			String message = service.savePaymentDetails(payment);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something gone Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
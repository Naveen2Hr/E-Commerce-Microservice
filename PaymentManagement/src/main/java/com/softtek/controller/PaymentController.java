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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.client.OrderClient;
import com.softtek.entity.Payment;
import com.softtek.model.Order;
import com.softtek.service.IPaymentService;
import com.softtek.service.impl.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class PaymentController {
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
	public ResponseEntity<String> generatePayment(@RequestParam(defaultValue = "1") Integer orderId) {
		try {
			Order order = client.getOrderRecord(orderId).getBody();
			System.out.println(order);
			Payment payment = service.generatePayment(order);
			String message = service.savePaymentDetails(payment);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something gone Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
package com.shr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shr.entity.Order;
import com.shr.service.OrderServiceInterface;

@RestController
@RequestMapping("/providerApi")
public class ProviderController {

	@Autowired
	private OrderServiceInterface service;

	@GetMapping("/order/record")
	public ResponseEntity<Order> getOrderRecord() {
		Order order = service.orderProvider();
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}

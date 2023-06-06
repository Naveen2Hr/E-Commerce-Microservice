package com.shr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shr.entity.Order;
import com.shr.service.OrderServiceInterface;

/**
 * 
 * @author m.rakesh
 * 
 * @apiNote This Controller is the  provider server Api
 *
 */
@RestController
@RequestMapping("/providerApi/order")
public class ProviderController {

	@Autowired
	private OrderServiceInterface service;

	/**
	 * Fetching the OrderIds
	 * @param orderId
	 * @return
	 */
	@GetMapping("/record")
	public ResponseEntity<Order> getOrderRecord(@RequestParam Integer orderId) {
		Order order = service.orderProvider(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}

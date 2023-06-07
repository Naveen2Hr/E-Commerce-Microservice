package com.softtek.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softtek.model.Order;

@FeignClient("Payment-Service")
public interface PaymentClient {

	@GetMapping("/providerApi/order/record")
	public ResponseEntity<Order> getOrderRecord(@RequestParam Integer orderId);
}

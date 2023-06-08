package com.softtek.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softtek.model.Order;

@FeignClient("Order-Service")
public interface OrderClient {
	
	@GetMapping("/providerApi/order/record")
	public ResponseEntity<Order> getOrderRecord(@RequestParam Integer orderId);
}

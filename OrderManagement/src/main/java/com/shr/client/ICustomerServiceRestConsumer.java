package com.shr.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shr.entity.Customer;

/**
 * 
 * @author m.rakesh
 * 
 *
 */
@FeignClient("Customer-Service")
public interface ICustomerServiceRestConsumer {

	@GetMapping("/providerApi/customer/details")
	public ResponseEntity<Customer> getCustomerDetails(@RequestParam(name = "custId") String custId);
}

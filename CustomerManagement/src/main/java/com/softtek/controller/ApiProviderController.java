package com.softtek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.entity.Customer;
import com.softtek.service.ICustomerService;
/**
 * 
 * @author sagar.hr
 *
 * @apiNote This Controller is the provider Service API
 *
 */
@RestController
@RequestMapping("/providerApi")
public class ApiProviderController {

	private ICustomerService service;
	/**
	 * This API is used to fetch Customer details for the Order service.
	 * 
	 * @return Customer entity
	 */
	public ResponseEntity<?> customerDetails(@PathVariable String empId) {
		try {
			Customer customerRecord = service.getCustomerRecord(empId);
			return new ResponseEntity<Customer>(customerRecord, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

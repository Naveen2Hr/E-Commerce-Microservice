package com.softtek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.entity.Customer;
import com.softtek.service.ICustomerService;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Rest Controller for the API Handler Methods.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService custService;

	/**
	 * This API is used to fetch Customer details using the Customer ID.
	 * 
	 * @param customerId.
	 * @return Customer entity
	 */
	@GetMapping("/getCustomer")
	public ResponseEntity<?> getCustomer(@RequestParam(name = "custId") Integer custId) {
		try {
			Customer customerRecord = custService.getCustomerRecord(custId);
			return new ResponseEntity<Customer>(customerRecord, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This API is used to fetch Customer details using customer object.
	 * 
	 * @param Customer customer
	 * @return Response String
	 */
	@PostMapping("/insertCustomer")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {
		try {
			String insertCustomerRecord = custService.insertCustomerRecord(customer);
			return new ResponseEntity<String>(insertCustomerRecord, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This API is used to fetch Customer details..
	 * 
	 * @return List of Customer entity
	 */
	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> getAllCustomer() {
		try {
			List<Customer> allCustomerRecords = custService.getAllCustomerRecords();
			return new ResponseEntity<List<Customer>>(allCustomerRecords, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 *   fetch Customer details for the Order service.
	 * 
	 * @param String Customer ID.
	 * @return Response delete message.
	 */
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<?> deleteCustomer(@RequestParam(name = "custId") Integer custId) {
		try {
			String deleteCustomerRecord = custService.deleteCustomerRecord(custId);
			return new ResponseEntity<String>(deleteCustomerRecord, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

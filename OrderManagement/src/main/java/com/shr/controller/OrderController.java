package com.shr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shr.client.ICustomerServiceRestConsumer;
import com.shr.client.IProductServiceRestConsumer;
import com.shr.entity.Customer;
import com.shr.entity.Order;
import com.shr.entity.Product;
import com.shr.service.IEmailDispactherOrder;
import com.shr.service.OrderServiceInterface;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author m.rakesh
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderServiceInterface service;

	@Autowired
	private IProductServiceRestConsumer pClient;

	@Autowired
	private ICustomerServiceRestConsumer cClient;
	
	@Autowired
	private IEmailDispactherOrder email;

	private Integer custId = 1;

	/**
	 * 
	 * @param custId
	 * @param productIds
	 * @return
	 */
	@PostMapping("/insertorder")
	public ResponseEntity<?> insertOrderRecord(@RequestBody List<Integer> productIds) {
		try {
			setCustId(custId++);
			Order insertOrder = service.insertOrder(1, productIds);
			
			// send e-mail to customer for confirmation of a order
			String orderConfirmation = email.orderConfirmation(insertOrder);
			
			return new ResponseEntity<Order>(insertOrder, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/display-order")
	public ResponseEntity<?> displayOrderRecord(@RequestParam Integer orderId) {
		try {
			Order order = service.getOrderById(orderId);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/status-update")
	public ResponseEntity<?> updateOrderRecord(@RequestParam Integer orderId, @RequestParam Boolean status) {
		try {
			String message = service.updateOrderDeliveryStatus(orderId, status);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getProductList")
	public ResponseEntity<?> getProductList(@RequestParam List<Integer> ids) {
		try {
			List<Product> productList = pClient.getListOfProduct(ids).getBody();
			productList.stream().forEach(System.out::println);
			String message = service.insertProductRecords(productList);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getCustomer")
	public ResponseEntity<?> getCustomerRecord(@RequestParam String custId) {
		try {
			Customer customer = cClient.getCustomerDetails(custId).getBody();
			String message = service.insertCustomerRecord(customer);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

}

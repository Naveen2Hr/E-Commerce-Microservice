package com.shr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shr.entity.OrderedProduct;
import com.shr.entity.Product;
import com.shr.service.ProductServiceInterface;

@RestController
@RequestMapping("/providerApi/product")
public class ProviderController {

	@Autowired
	private ProductServiceInterface service;

	@GetMapping("/details")
	public ResponseEntity<?> productDetails() {
		try {
			return new ResponseEntity<List<OrderedProduct>>(service.getOrderedProductRecords(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong Please try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/selection")
	public ResponseEntity<?> productSelection(@RequestParam List<Integer> productIds) {
		try {
			List<Product> productRetrival = service.productRetrival(productIds);
			System.out.println(productRetrival);

			String selectedProducts = service.selectedProducts(productRetrival);
			return new ResponseEntity<String>(selectedProducts, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong Please try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list_of_produts")
	public ResponseEntity<List<Product>> getListOfProduct(@RequestParam List<Integer> productIds) {
		try {
			List<Product> productRetrival = service.productRetrival(productIds);
			return new ResponseEntity<List<Product>>(productRetrival, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Product>>( new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

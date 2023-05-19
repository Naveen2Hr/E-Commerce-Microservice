package com.shr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("/selection")
	public ResponseEntity<?> productSelection(@RequestBody List<Integer> productIds) {

		try {
			List<Product> productRetrival = service.productRetrival(productIds);
			String selectedProducts = service.selectedProducts(productRetrival);
			return new ResponseEntity<String>(selectedProducts, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong Please try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

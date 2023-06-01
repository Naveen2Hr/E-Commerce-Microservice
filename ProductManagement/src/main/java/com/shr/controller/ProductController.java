package com.shr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shr.entity.Product;
import com.shr.service.ProductServiceInterface;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Rest Controller class for the Handler mapping for the Product.
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface service;

	/**
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 * 
	 *         This the Handler Method for inserting the Product Record.
	 * 
	 */
	@PostMapping("/insert")
	public ResponseEntity<?> insertProductRecord(@RequestBody Product product) {
		try {
			String message = service.insertProduct(product);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 * 
	 *         This the Handler Method for displaying the Product Record.
	 * 
	 */
	@GetMapping("/get/Product")
	public ResponseEntity<?> displayProductRecord(@RequestParam(defaultValue = "0") Integer productId) {
		try {
			Product product = service.getProductById(productId);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 * 
	 *         This the Handler Method for Deleting the Product Record.
	 * 
	 */
	@DeleteMapping("/delete/product")
	public ResponseEntity<?> deletedProductRecord(@RequestParam Integer productId) {
		try {
			String message = service.deleteProduct(productId);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 * 
	 *         This the Handler Method for Updating Status of the Product Record.
	 * 
	 */
	@PatchMapping("/update/product_status")
	public ResponseEntity<?> updateProductStatusRecord(@RequestParam Integer productId, @RequestParam String status) {
		try {
			String message = service.productStatusUpdate(productId, status);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			String expMessage = "Something went wrong please try again";
			e.printStackTrace();
			return new ResponseEntity<String>(expMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

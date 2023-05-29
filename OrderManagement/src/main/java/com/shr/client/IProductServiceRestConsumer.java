package com.shr.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shr.entity.Product;

@FeignClient("Product-Service")
public interface IProductServiceRestConsumer {

	@GetMapping("/providerApi/product/list_of_produts")
	public ResponseEntity<List<Product>> getListOfProduct(@RequestParam List<Integer> productIds);
}

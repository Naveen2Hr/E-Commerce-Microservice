package com.softtek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.softtek.entity.Product;

@Controller
public class Controller_MVC {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/productList")
	public String myPage(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:9905/api/product/get/productList",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> products = response.getBody();
		products.stream().forEach(System.out::println);

		map.put("proList", products);

		return "product_list";
	}

}

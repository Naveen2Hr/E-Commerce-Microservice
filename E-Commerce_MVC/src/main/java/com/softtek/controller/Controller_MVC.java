package com.softtek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.softtek.entity.Product;

@Controller
public class Controller_MVC {

	@GetMapping("/")
	public String showHome() {
		return "index";
	}

	@GetMapping("/add")
	public String addProductToCart(HttpServletRequest req) {
		Integer productId = Integer.parseInt(req.getParameter("productId"));
		System.out.println(productId);


		// creating RestTemplate Instance.
		RestTemplate restTemplate = new RestTemplate();

		// Mention the Url path for the API end points.
		String apiUrl = "http://localhost:9905/api/product/add";


		// Create HttpHeaders Object. and setting the content type as Application_JSOn.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);


		// Creating an Integer HTTPEntity
		HttpEntity<Integer> requestEntity = new HttpEntity<Integer>(productId, headers);


		// using Rest Template we are hitting the API end points and getting the
		// Response Entity
		try {
			String postForObject = restTemplate.postForObject(apiUrl, requestEntity, String.class);
			System.out.println(postForObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/productList")
	public String myPage(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Product>> response = restTemplate.exchange(
				"http://localhost:9905/api/product/get/productList", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> products = response.getBody();
		products.stream().forEach(System.out::println);
		map.put("proList", products);
		return "product_list";
	}

}

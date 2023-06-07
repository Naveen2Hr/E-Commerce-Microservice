package com.softtek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.softtek.entity.Product;

@Controller
public class Controller_MVC {

	@GetMapping("/")
	public String showHome(Map<String, Object> map) {
		String videoPath1 = "/E-Commerce_MVC/src/main/webapp/WEB-INF/pages/videos/shopping.mp4";
		map.put("videoPath1", videoPath1);
		String videoPath2 = "/E-Commerce_MVC/src/main/webapp/WEB-INF/pages/videos/clothes.mp4";
		map.put("videoPath2", videoPath2);
		String videoPath3 = "/E-Commerce_MVC/src/main/webapp/WEB-INF/pages/videos/unboxing.mp4";
		map.put("videoPath3", videoPath3);
		String videoPath4 = "/E-Commerce_MVC/src/main/webapp/WEB-INF/pages/videos/happy.mp4";
		map.put("videoPath4", videoPath4);
		String videoPath5 = "/E-Commerce_MVC/src/main/webapp/WEB-INF/pages/videos/shopgo.mp4";
		map.put("videoPath5", videoPath5);
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

		return "product_list";
	}

}

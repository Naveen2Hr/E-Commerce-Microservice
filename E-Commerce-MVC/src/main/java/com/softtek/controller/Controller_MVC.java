package com.softtek.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.softtek.entity.Address;
import com.softtek.entity.Customer;
import com.softtek.entity.Order;
import com.softtek.entity.OrderedProduct;
import com.softtek.entity.Product;
import com.softtek.model.AccountType;
import com.softtek.model.ProductCategory;
import com.softtek.model.ProductType;
import com.softtek.service.ServiceInterface;

@Controller
@RequestMapping("/shop")
public class Controller_MVC {

	public List<Product> productlist = new ArrayList<Product>();

	@Autowired
	public ServiceInterface service;

	@GetMapping("/")
	public String showHome() {
		return "index";
	}

	@GetMapping("/home")
	public String showHome1() {
		return "index";
	}

	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}

	@GetMapping("/showRegister")
	public String showRegisterPage() {
		return "customerRegistration";
	}

	@GetMapping("/add")
	public String addProductToCart(@RequestParam("id") int id, Model model) {
		// Integer productId = Integer.parseInt(id);
		System.out.println(id);

		// creating RestTemplate Instance.
		RestTemplate restTemplate = new RestTemplate();

		// Mention the Url path for the API end points.
		String apiUrl = "http://localhost:9905/api/product/add";

		// Create HttpHeaders Object. and setting the content type as Application_JSOn.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Creating an Integer HTTPEntity
		HttpEntity<Integer> requestEntity = new HttpEntity<Integer>(id, headers);

		// using Rest Template we are hitting the API end points and getting the
		// Response Entity
		try {
			String postForObject = restTemplate.postForObject(apiUrl, requestEntity, String.class);
			System.out.println(postForObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RestTemplate restTemplate1 = new RestTemplate();
		ResponseEntity<List<Product>> response = restTemplate1.exchange(
				"http://localhost:9905/api/product/get/productList", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> products = response.getBody();

		products.stream().forEach(System.out::println);
		model.addAttribute("proList", products);
		return "product_list";
	}

	@PostMapping("/register")
	public String customerRegistration(HttpServletRequest req) {
		Customer customer = new Customer();
		customer.setCustomerName(req.getParameter("customerName"));
		customer.setCustomerContact(Long.parseLong(req.getParameter("customerContact")));
		customer.setCustomerEmail(req.getParameter("customerEmail"));
		customer.setCustomerGender(req.getParameter("customerGender"));
		AccountType accountType = new AccountType();
		accountType.setTypeId(2);
		customer.setCustomerType(accountType);
		Address address = new Address();
		address.setHouseDetails(req.getParameter("houseDetails"));
		address.setCity(req.getParameter("city"));
		address.setState(req.getParameter("state"));
		address.setPincode(Long.parseLong(req.getParameter("pincode")));
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		customer.setCustomerAddress(addresses);

		RestTemplate restTemplate = new RestTemplate();

		String apiUrl = "http://localhost:9901/customer/insertCustomer";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer, headers);

		try {
			String postForObject = restTemplate.postForObject(apiUrl, requestEntity, String.class);
			System.out.println(postForObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/showProductRegister")
	public String showProductRegisterPage() {
		return "productRegistration";
	}

	@PostMapping("/productRegister")
	public String productRegistration(HttpServletRequest req) {

		Product product = new Product();
		product.setProductName(req.getParameter("productName"));

		// Get the Category type
		String parameter1 = req.getParameter("productCategory");
		ProductCategory category = service.getProductCategory(parameter1);
		product.setProductCategory(category);

		// Get the Product Type
		String parameter2 = req.getParameter("ProductType");
		ProductType type = service.getProductType(parameter2);
		product.setProductType(type);

		// Set the Price
		Double price = Double.parseDouble(req.getParameter("price"));
		product.setProductPrice(price);

		// Set the Description
		String desc = req.getParameter("description");
		product.setProductDespcription(desc);

		// Set the Count
		Integer count = Integer.parseInt(req.getParameter("count"));
		product.setProductCount(count);

		// Set the Status
		product.setProductStatus(req.getParameter("ProductStatus"));

		// Set the image Location
		product.setImageLoc(req.getParameter("image"));

		RestTemplate restTemplate = new RestTemplate();

		String apiUrl = "http://localhost:9905/api/product/insert";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);

		try {
			String postForObject = restTemplate.postForObject(apiUrl, requestEntity, String.class);
			System.out.println(postForObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/order")
	public String orderDetails(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<OrderedProduct>> response = restTemplate.exchange(
				"http://localhost:9905/api/product/getOrderedProducts", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<OrderedProduct>>() {
				});

		List<OrderedProduct> orderedProductList = response.getBody();

		List<Integer> pIds = new ArrayList<Integer>();

		for (OrderedProduct op : orderedProductList) {
			pIds.add(op.getProductId());
		}

		pIds.stream().forEach(System.out::println);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<List<Integer>> requestEntity = new HttpEntity<List<Integer>>(pIds, headers);

		String apiUrl = "http://localhost:9903/api/order/insertorder";
		try {
			ResponseEntity<Order> postForEntity = restTemplate.postForEntity(apiUrl, requestEntity, Order.class);
			Order order = postForEntity.getBody();
			map.put("opl", orderedProductList);
			map.put("order", order);
			Double totalPrice = order.getTotalPrice();
			map.put("totalPrice", (totalPrice + 500 - 100));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payment";
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
		for (Product product : products) {
			System.out.println(product.getProductId());
		}
		map.put("proList", products);
		return "product_list";
	}

	@GetMapping("/contact")
	public String showContact() {
		return "contact";
	}

	@GetMapping("/denied")
	public String viewErrorPage() {
		return "authorization_failed";
	}

}

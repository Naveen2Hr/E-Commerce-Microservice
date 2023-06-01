package com.shr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shr.entity.Customer;
import com.shr.entity.Order;
import com.shr.entity.Product;

@Service
public interface OrderServiceInterface {

	public String insertOrder(String custId, List<Integer> productIds);

	public Order getOrderById(Integer orderId);

	public String updateOrderByObject(Order order);

	public String updateOrderDeliveryStatus(Integer orderId, Boolean status);

	public Order orderProvider();
	
	public String insertProductRecords(List<Product> productList);
	
	public String insertCustomerRecord(Customer customer);
}

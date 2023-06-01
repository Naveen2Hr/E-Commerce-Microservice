package com.shr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shr.entity.Order;

@Service
public interface OrderServiceInterface {

	public String insertOrder(String custId, List<Integer> productIds);

	public Order getOrderById(Integer orderId);

	public String updateOrderByObject(Order order);

	public String updateOrderDeliveryStatus(Integer orderId, Boolean status);

	public Order orderProvider();
}

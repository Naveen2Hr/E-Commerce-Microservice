package com.shr.service;

import java.util.List;

import com.shr.entity.Order;

public interface OrderServiceInterface {

	public String insertOrder(String custId, List<Integer> productIds);

	public Order getOrderById(Integer orderId);

	public String updateOrderByObject(Order order);

	public String updateOrderDeliveryStatus(Integer orderId, Boolean status);
}

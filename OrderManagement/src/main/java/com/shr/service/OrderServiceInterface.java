package com.shr.service;

import com.shr.entity.Order;

public interface OrderServiceInterface {

	public String insertOrder(Order order);

	public Order getOrderById(Integer orderId);

	public String updateOrderByObject(Order order);

	public String updateOrderDeliveryStatus(Integer orderId, String status);
}

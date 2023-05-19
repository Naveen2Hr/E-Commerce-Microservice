package com.shr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.shr.entity.Order;
import com.shr.repository.CustomerRepository;
import com.shr.repository.OrderRepository;
import com.shr.repository.ProductRepository;
import com.shr.service.OrderServiceInterface;

public class OrderServiceImpl implements OrderServiceInterface {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private ProductRepository productRepo;

	@Override
	public String insertOrder(Order order) {
		Order save = orderRepo.save(order);
		return save != null ? "Order Has been placed with order-ID :: " + save.getOrderId()
				: "Something went wrong try again";
	}

	@Override
	public Order getOrderById(Integer orderId) {
		Order order = orderRepo.findById(orderId).get();
		return order;
	}

	@Override
	public String updateOrderByObject(Order order) {
		Order save = orderRepo.save(order);
		return save != null ? "Order Has been updated with order-ID :: " + save.getOrderId()
				: "Something went wrong try again";
	}

	@Override
	public String updateOrderDeliveryStatus(Integer orderId, String status) {
		Order order = orderRepo.findById(orderId).get();
		if (status.equalsIgnoreCase("Delivered") || status.equalsIgnoreCase("Pending")) {
			order.setDeliveryStatus(status);
			return "Order status is updated for order-ID :: '" + order.getOrderId() + "' to '" + status + "'.";
		} else {
			return "Please select a correct status update option to change";
		}
	}

}

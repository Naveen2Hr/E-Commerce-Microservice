package com.shr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.client.ICustomerServiceRestConsumer;
import com.shr.client.IProductServiceRestConsumer;
import com.shr.entity.Customer;
import com.shr.entity.Order;
import com.shr.entity.Product;
import com.shr.repository.OrderRepository;
import com.shr.service.OrderServiceInterface;

@Service
public class OrderServiceImpl implements OrderServiceInterface {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ICustomerServiceRestConsumer custClient;

	@Autowired
	private IProductServiceRestConsumer prodClient;

	@Override
	public String insertOrder(String custId, List<Integer> productIds) {
		Order order = new Order();

		Customer cust = (Customer) custClient.getCustomerDetails(custId).getBody();
		List<Product> listOfProduct = prodClient.getListOfProduct(productIds).getBody();
		Double totalPrice = 0.0;
		for (Product product : listOfProduct) {
			totalPrice += product.getProductPrice();
		}

		order.setCustomer(cust);
		order.setProducts(listOfProduct);
		order.setDeliveryStatus(false);
		order.setOrderDate("20/05/2023");
		order.setTotalPrice(totalPrice);

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
	public String updateOrderDeliveryStatus(Integer orderId, Boolean status) {
		Order order = orderRepo.findById(orderId).get();
		if (status == true) {
			order.setDeliveryStatus(status);
			return "Order status is updated for order-ID :: '" + order.getOrderId() + "' to '" + status + "'.";
		} else {
			return "Please select a correct status update option to change";
		}
	}

}

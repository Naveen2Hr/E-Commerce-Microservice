package com.shr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.entity.Customer;
import com.shr.entity.Order;
import com.shr.entity.Product;
import com.shr.repository.CustomerRepository;
import com.shr.repository.OrderRepository;
import com.shr.repository.ProductRepository;
import com.shr.service.OrderServiceInterface;

/**
 * 
 * @author m.rakesh
 *
 */
@Service
public class OrderServiceImpl implements OrderServiceInterface {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CustomerRepository custRepo;
	
	/**
	 * Creating the orders 
	 */
	@Override
	public String insertOrder(Integer custId, List<Integer> productIds) {
		Order order = new Order();

		Double totalPrice = 0.0;
		List<Product> prodList = new ArrayList<Product>();

		for (Integer i : productIds) {
			prodList.add(productRepo.findById(i).get());
		}

		for (Product product : prodList) {
			totalPrice += product.getProductPrice();
		}

		order.setCustomer(custRepo.findById(custId).get());
		order.setDeliveryStatus(false);
		order.setOrderDate(new Date());
		order.setTotalPrice(totalPrice);

		Order save = orderRepo.save(order);
		return save != null ? "Order Has been placed with order-ID :: " + save.getOrderId()
				: "Something went wrong try again";
	}
	/**
	 * Fetching the Orders by orderIds
	 */
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

	@Override
	public Order orderProvider(Integer orderId) {
		Order order = orderRepo.findById(orderId).get();
		return order;
	}

	@Override
	public String insertProductRecords(List<Product> productList) {
		List<Product> saveAll = productRepo.saveAll(productList);
		return saveAll.size() >= 1 ? "Product List retrived" : "Check the list of Ids";
	}

	@Override
	public String insertCustomerRecord(Customer customer) {
		Customer save = custRepo.save(customer);
		return save != null ? save.getCustomerId() + " :: Customer Record is saved." : "Issue With Record Try Again.";
	}

}

package com.shr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.client.IProductServiceRestConsumer;
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

	@Autowired
	private IProductServiceRestConsumer pClient;

	/**
	 * Creating the orders
	 */
	@Override
	public Order insertOrder(Integer custId, List<Integer> productIds) {
		Order order = new Order();

		Double totalPrice = 0.0;
		List<Product> prodList = new ArrayList<Product>();

		prodList = pClient.getListOfProduct(productIds).getBody();
		prodList.forEach(prod -> {
			productRepo.save(prod);
		});

//		for (Integer i : productIds) {
//			System.out.println("Product id is ::" + i);
//			prodList.add(productRepo.getReferenceById(i));
//
//		}

		for (Product product : prodList) {
			System.out.println("product price from service :: " + product.getProductPrice());
			totalPrice += product.getProductPrice();
		}

		order.setCustomer(custRepo.findById(custId).get());
		order.setDeliveryStatus(false);
		order.setOrderDate(new Date());
		order.setTotalPrice(totalPrice);

		Order save = orderRepo.save(order);
		return save;
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

	@Override
	public String insertCustomerList(List<Customer> custList) {
		List<Customer> saveAll = custRepo.saveAll(custList);
		return "List Updated";
	}

	@Override
	public String insertProduct(Product product) {
		Product save = productRepo.save(product);
		return save != null ? "product Inserted" : "Something gone wrong";
	}

}

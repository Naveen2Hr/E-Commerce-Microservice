package com.softtek.service;

import java.util.List;

import com.softtek.entity.Payment;
import com.softtek.model.Order;

public interface IPaymentService {
	
	public String savePaymentDetails(Payment payment);

	public Payment getPaymentDetailsByOrderId(long orderId);
	
	//updating payment status after the payment
	public String updatePaymentStatus(Payment payment);
	
	public List<Payment> getAllPaymentDetails();
	
	//to update OrderStatus column
	public String updateOrderStatus(Order order);
		 


}

package com.softtek.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Payment;
import com.softtek.model.Order;
import com.softtek.repository.PaymentRepository;
import com.softtek.service.IPaymentService;

/**
 * 
 * @author shreelakshmi.ms
 *
 *@apiNote An Implementation Class that implements IPaymentService providing
 *          implementation for the abstract methods by Overriding.
 */

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	/**
	 * This Method is used to save the Payment Details
	 * 
	 * @param Payment payment
	 * @return String message
	 * 
	 */
	public String savePaymentDetails(Payment payment) {
		Payment save = paymentRepo.save(payment);
		return save != null ? "Saved Succesfully with id : " + payment.getPaymentId() : "Check The payment Object";
	}

	/**
	 * This method is used to get payment details as per OrderId
	 * 
	 * @return 
	 */
	@Override
	public Payment getPaymentDetailsByOrderId(long orderId) {
		return paymentRepo.findByOrderId(orderId);
	}

	/**
	 * This method is used to update the Payment status 
	 * 
	 * @param Payment payment
	 * @return message of Updated of Payment Status
	 */
	@Override
	public String updatePaymentStatus(Payment payment) {
		Payment save = paymentRepo.save(payment);
		return save != null ? "Payment status updated Successfully :: Payment Id :: " + payment.getPaymentId()
				: "Check The payment Object";
	}
	
	/**
	 * This method is used to get all payment Details
	 * 
	 * @return list of Payments
	 */
	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> findAll = paymentRepo.findAll();
		return findAll;
	}

	/**
	 * This method is used to create a payment
	 * 
	 * @param Order order
	 * @return payment object
	 */
	@Override
	public Payment generatePayment(Order order) {
		Payment payment = new Payment();
		payment.setOrderId(order.getOrderId());
		payment.setDateAndTime(LocalDateTime.now());
		payment.setPaymentStatus(false);
		payment.setTotalAmount(order.getTotalPrice());
		payment.setPaymentMode("COD");
		return payment;
	}
	
	@Override
	public String updateOrderStatus(Order order) {
		return null;
	}
}

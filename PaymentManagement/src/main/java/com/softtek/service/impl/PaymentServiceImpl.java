package com.softtek.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Payment;
import com.softtek.model.Order;
import com.softtek.repository.PaymentRepository;
import com.softtek.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	// Methods to handle payment operations
	public String savePaymentDetails(Payment payment) {
		Payment save = paymentRepo.save(payment);
		return save != null ? "Saved Succesfully with id : " + payment.getPaymentId() : "Check The payment Object";
	}

	@Override
	public Payment getPaymentDetailsByOrderId(long orderId) {
		return paymentRepo.findByOrderId(orderId);
	}

	@Override
	public String updatePaymentStatus(Payment payment) {
		Payment save = paymentRepo.save(payment);
		return save != null ? "Payment status updated Successfully :: Payment Id :: " + payment.getPaymentId()
				: "Check The payment Object";
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> findAll = paymentRepo.findAll();
		return findAll;
	}

	@Override
	public String updateOrderStatus(Order order) {
		
		return null;
	}

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
}

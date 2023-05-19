package com.softtek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Payment;
import com.softtek.model.Order;
import com.softtek.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	// Methods to handle payment operations
	public String savePaymentDetails(Payment payment) {
		paymentRepo.save(payment);
		return "Saved Succesfully with id : "+payment.getPid() ;
	}
	
	@Override
	public Payment getPaymentDetailsByOrderId(long orderId) {
		return paymentRepo.findByOrderId(orderId);
	}
	
	@Override
	public String updatePaymentStatus(Payment payment) {
		return "Payment status updated Successfully";
		//return payment.getPMode();
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrderStatus(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	

//	public String getOrderDetails1(Long oid, Double totalAmount) {
//		Order order = orderRepo.getTotalPrice(oid);
//		if (order != null) {
//			Double totalPrice = order.getTotalPrice();
//			Payment payment = new Payment();
//			payment.setOid(order.getOrderId());
//			payment.setTotalAmount(order.getTotalPrice());
////	    		payment.setPayType(payType2);
//			paymentRepo.save(payment);
//		}
//		return null;
//	}

	

}

//public void savePayment(Payment payment) {
//	paymentRepo.save(payment);
//	System.out.println();
//}

//@Override
//public String addOrderDetails(Order order) {
//	// saving the Order Status details in DB
//	double id = orderRepo.save(order).getTotalPrice();
//	return  orderService.getTotalOrderAmount() + " Order is inserted with the id :: " + orderService.getOrderId();
//}
//@Override
//public String getOrderDetails(Long oid, Double totalAmount) {
//	Optional<Payment> optional=paymentRepo.findById(oid);
//	if(optional.isPresent()) {
//		paymentRepo.getById(oid);
//	return "Oder id"+oid+"Total Amount"+totalAmount;
//	}
//	else {
//		System.out.println("Not Found");;
//        }
//	return "";
//}
package com.softtek.model;


import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private Integer orderId;

	private Customer customer;

	private Double totalPrice;

	private Boolean deliveryStatus;
	
	private Address deliveryAddress;

	private Date orderDate;
}

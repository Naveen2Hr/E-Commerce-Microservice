package com.softtek.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private Integer orderId;

	private Customer customer;

	private Double totalPrice;

	private Boolean deliveryStatus;

	private Date orderDate;

}

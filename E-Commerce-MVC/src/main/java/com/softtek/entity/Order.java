package com.softtek.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author ashik.k
 * 
 * @apiNote Order Entity Objects
 *
 */
@Getter
@Setter
public class Order {

	private Integer orderId;

	private Customer customer;

	private Double totalPrice;

	private Boolean deliveryStatus;

	private Date orderDate;

}

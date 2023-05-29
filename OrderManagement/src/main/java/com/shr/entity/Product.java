package com.shr.entity;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Product {

	private Integer productId;

	private String productName;

	private Double productPrice;

	@JsonIgnore
//	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	@Transient
	private Order order;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

}

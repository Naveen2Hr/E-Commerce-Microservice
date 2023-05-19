package com.shr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTS_Pool")
@Getter
@Setter
public class ProductsPool {

	private Integer productPoolId;

	private String productName;

	private Double productPrice;

	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Order order;

	// Cascading is if one table is saved then save the Parent table data also.
	@Override
	public String toString() {
		return "ProductsPool [productPoolId=" + productPoolId + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}
}

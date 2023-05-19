package com.shr.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER")
@Getter
@Setter
public class Order {

	@Id
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name = "customer", referencedColumnName = "customerId")
	private Customer customer;

	@Column
	private Double totalPrice;

	@Column(length = 30)
	private String deliveryStatus;

	@Column
	private Date orderDate;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "productPoolId", referencedColumnName = "productPoolId")
	private List<ProductsPool> products;

	/**
	 * Parameterized Order Constructor
	 * 
	 * @param orderId
	 * @param productList
	 * @param customer
	 * @param deliveryStatus
	 */
	public Order(Integer orderId, List<Product> productList, Customer customer, String deliveryStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.deliveryStatus = deliveryStatus;
		this.orderDate = new Date();
	}

	/**
	 * All Arguments Order Contructor
	 * 
	 * @param orderId
	 * @param productList
	 * @param customer
	 * @param totalPrice
	 * @param deliveryStatus
	 * @param orderDate
	 */
	public Order(Integer orderId, List<Product> productList, Customer customer, Double totalPrice,
			String deliveryStatus, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.deliveryStatus = deliveryStatus;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", totalPrice=" + totalPrice
				+ ", deliveryStatus=" + deliveryStatus + ", orderDate=" + orderDate + "]";
	}
	
	

}

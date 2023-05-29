package com.shr.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer")
	@Transient
	private Customer customer;

	private Double totalPrice;

	private Boolean deliveryStatus;

	private String orderDate;

//	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	@Transient
	private List<Product> products;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", deliveryStatus=" + deliveryStatus
				+ ", orderDate=" + orderDate + "]";
	}

}

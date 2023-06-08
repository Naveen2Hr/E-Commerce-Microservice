package com.shr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author m.rakesh
 * 
 * @apiNote Entity class of the Order , Achieving the Many to One
 * 			relationship with Customer entity 
 *
 */
@Entity
@Table(name = "ORDER_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name = "custId", referencedColumnName = "customerId")
	private Customer customer;

	@Column
	private Double totalPrice;

	@Column
	private Boolean deliveryStatus;
	
	@Column
	private Boolean deliveryAddress;

	@Column
	private Date orderDate;

}

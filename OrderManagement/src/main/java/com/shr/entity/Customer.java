package com.shr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author m.rakesh
 * 
 * @apiNote Customer entity table
 *
 */
@Entity
@Table(name = "Customer_Order_Table")
@Data
public class Customer {

	@Id
	private String customerId;

	@Column(length = 20)
	private String customerName;

}

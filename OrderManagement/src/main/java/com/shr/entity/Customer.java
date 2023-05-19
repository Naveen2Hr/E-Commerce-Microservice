package com.shr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_REFERENCE_CUSTOMER")
public class Customer {

	@Id
	private Integer customerId;

	@Column(length = 20)
	private String customerName;

}

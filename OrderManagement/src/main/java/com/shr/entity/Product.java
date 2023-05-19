package com.shr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ORDER_REFERENCE_PRODUCT")
@Data
public class Product {

	@Id
	private Integer productId;
	
	@Column(length = 20)
	private String productName;
	
	@Column
	private Double productPrice;
}

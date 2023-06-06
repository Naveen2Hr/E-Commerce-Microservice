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
 * @apiNote Entity class of the Product 
 *
 */
@Data
@Entity
@Table(name = "Product_Order_Table")
public class Product {

	@Id
	private Integer productId;

	@Column
	private String productName;

	@Column
	private Double productPrice;
	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

}

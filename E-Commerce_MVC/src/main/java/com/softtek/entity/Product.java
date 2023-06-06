package com.softtek.entity;

import com.softtek.model.ProductCategory;
import com.softtek.model.ProductType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Integer productId;

	private String productName;

	private ProductCategory productCategory;

	private String productStatus;

	private Integer productCount;

	private ProductType productType;

	private Double productPrice;

	private String productDespcription;
}

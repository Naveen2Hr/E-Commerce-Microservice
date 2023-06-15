package com.softtek.service;

import com.softtek.model.ProductCategory;
import com.softtek.model.ProductType;

public interface ServiceInterface {
	public ProductCategory getProductCategory(String parameter);

	public ProductType getProductType(String parameter);
	
	
}

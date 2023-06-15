package com.softtek.service.impl;

import org.springframework.stereotype.Service;

import com.softtek.model.ProductCategory;
import com.softtek.model.ProductType;
import com.softtek.service.ServiceInterface;

@Service
public class ServiceImpl implements ServiceInterface {

	@Override
	public ProductCategory getProductCategory(String parameter1) {
		ProductCategory category = new ProductCategory();

		if (parameter1.equalsIgnoreCase("Mobile")) {
			category.setCatId(1001);
		} else if (parameter1.equalsIgnoreCase("Laptop")) {
			category.setCatId(1002);
		} else if (parameter1.equalsIgnoreCase("Kadai")) {
			category.setCatId(1003);
		} else if (parameter1.equalsIgnoreCase("Pan")) {
			category.setCatId(1004);
		} else if (parameter1.equalsIgnoreCase("Clothes")) {
			category.setCatId(1005);
		} else if (parameter1.equalsIgnoreCase("Shoes")) {
			category.setCatId(1006);
		} else if (parameter1.equalsIgnoreCase("MakeUp")) {
			category.setCatId(1007);
		} else if (parameter1.equalsIgnoreCase("FaceWash")) {
			category.setCatId(1008);
		}
		return category;
	}

	@Override
	public ProductType getProductType(String parameter) {
		ProductType type = new ProductType();
		if (parameter.equalsIgnoreCase("Electronics")) {
			type.setTypeId(101);
		} else if (parameter.equalsIgnoreCase("Utensils")) {
			type.setTypeId(102);
		} else if (parameter.equalsIgnoreCase("Fashion")) {
			type.setTypeId(103);
		} else if (parameter.equalsIgnoreCase("Beauty")) {
			type.setTypeId(104);
		} else if (parameter.equalsIgnoreCase("Applainces")) {
			type.setTypeId(105);
		}
		return type;
	}

}

package com.shr.service;

import java.util.List;

import com.shr.entity.OrderedProduct;
import com.shr.entity.Product;

public interface ProductServiceInterface {

	public String insertProduct(Product product);

	public String updateProductByObject(Product product);

	public Product getProductById(Integer productId);

	public String deleteProduct(Integer productId);

	public String productStatusUpdate(Integer productId, String status);

	public String productCountUpdate(Integer productId, Integer count);
	
	public List<Product> productRetrival(List<Integer> productIds);
	
	public String selectedProducts(List<Product> productLists);
	
	public List<OrderedProduct> getOrderedProductRecords();
	
}

package com.shr.service;

import com.shr.entity.Product;

public interface ProductServiceInterface {

	public String insertProduct(Product product);

	public String updateProductByObject(Product product);

	public Product getProductById(Integer productId);

	public String deleteProduct(Integer productId);

	public String productStatusUpadte(Integer productId, String status);

	public String productCountUpdate(Integer productId, Integer count);
}

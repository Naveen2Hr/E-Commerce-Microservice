package com.shr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.entity.Product;
import com.shr.repository.ProductCategoryRepository;
import com.shr.repository.ProductRepository;
import com.shr.repository.ProductTypeRepository;
import com.shr.service.ProductServiceInterface;

/**
 * 
 * @author sagar.hr
 * 
 *         The Service Inplementation class
 * @implNote All the Service methods for the Product.
 */

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepo;
	private ProductCategoryRepository catRepo;
	private ProductTypeRepository typeRepo;

	@Override
	public String insertProduct(Product product) {
		product.setProductCategory(catRepo.findById(product.getProductCategory().getCatId()).get());
		product.setProductType(typeRepo.findById(product.getProductType().getTypeId()).get());
		Product save = productRepo.save(product);
		return save != null ? "New Product inserted with Product-ID :: " + save.getProductId()
				: "Something Went wrong please check and Try again";
	}

	@Override
	public String updateProductByObject(Product product) {
		Product save = productRepo.save(product);
		return save != null ? "Product Updated with Product-ID :: " + save.getProductId()
				: "Something Went wrong please check and Try again";
	}

	@Override
	public Product getProductById(Integer productId) {
		Product product = productRepo.findById(productId).get();
		return product;
	}

	@Override
	public String deleteProduct(Integer productId) {
		productRepo.deleteById(productId);
		return "Product with Product-ID :: " + productId + " has been deleted";
	}

	@Override
	public String productStatusUpadte(Integer productId, String status) {
		productRepo.findById(productId).get().setProductStatus(status);
		return "Product Status of the Product with Product-ID :: '" + productId + "' to '" + status + "'.";
	}

	@Override
	public String productCountUpdate(Integer productId, Integer count) {
		productRepo.findById(productId).get().setProductCount(count);
		return "Product Count is Upadte for the Product-ID :: '" + productId + "'.";
	}

}

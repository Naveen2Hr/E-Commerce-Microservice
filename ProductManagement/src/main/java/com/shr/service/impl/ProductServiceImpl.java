package com.shr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shr.entity.OrderedProduct;
import com.shr.entity.Product;
import com.shr.repository.OrderedProductRepository;
import com.shr.repository.ProductCategoryRepository;
import com.shr.repository.ProductRepository;
import com.shr.repository.ProductTypeRepository;
import com.shr.service.ProductServiceInterface;

/**
 * 
 * @author sagar.hr
 * 
 *         The Service Implementation class
 * @implNote All the Service methods for the Product.
 */

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductCategoryRepository catRepo;
	@Autowired
	private ProductTypeRepository typeRepo;
	@Autowired
	private OrderedProductRepository opRepo;

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

	@Override
	public List<Product> productRetrival(List<Integer> productIds) {
		List<Product> productList = new ArrayList<Product>();
		for (Integer id : productIds) {
			Product product = productRepo.findById(id).get();
			productList.add(product);
		}
		return productList;
	}

	@Override
	public String selectedProducts(List<Product> productLists) {
		for (Product pl : productLists) {
			OrderedProduct op = new OrderedProduct();
			op.setProductId(pl.getProductId());
			op.setProductName(pl.getProductName());
			op.setProductCategory(pl.getProductCategory());
			op.setProductStatus(pl.getProductStatus());
			op.setProductCount(pl.getProductCount());
			op.setProductType(pl.getProductType());
			op.setProductPrice(pl.getProductPrice());
			op.setProductDespcription(pl.getProductDespcription());
			opRepo.save(op);
		}
		return "Product have been added to cart proceed with your Order";
	}

	@Override
	public List<OrderedProduct> getOrderedProductRecords() {

		List<OrderedProduct> list = (List<OrderedProduct>) opRepo.findAll();
		opRepo.deleteAll();
		return list;
	}

}

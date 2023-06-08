package com.softtek.service;

import java.util.List;

import com.softtek.entity.Customer;

/**
 * 
 * @author sagar.hr
 * 
 * @apiNote An Interface for all the Service over Customer Abstract methods.
 *
 */
public interface ICustomerService {
	public String insertCustomerRecord(Customer customer);

	public Customer getCustomerRecord(Integer custId);

	public List<Customer> getAllCustomerRecords();

	public String updateCustomerRecord(Customer customer);

	public String deleteCustomerRecord(Integer custId);
}

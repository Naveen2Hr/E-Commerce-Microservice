package com.softtek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Customer;
import com.softtek.repository.ICustomerRepository;
import com.softtek.service.ICustomerService;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote An Implementation Class that implements ICustomerService providing
 *          implementation for the abstract methods by Overriding.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository custRepo;

	/**
	 * this method is used to insert Customer details
	 * 
	 * @param Customer customer
	 * @return String message
	 * 
	 */
	@Override
	public String insertCustomerRecord(Customer customer) {
		if (customer != null) {
			Customer insertedRecord = custRepo.save(customer);
			return insertedRecord != null
					? insertedRecord.getCustomerName() + " record is inserted with the Customer ID :: "
							+ insertedRecord.getCustomerId()
					: "Customer Record is not inserted please try again";
		} else {
			return "Customer record is not valid please check and try again";
		}
	}

	/**
	 * this method is used to get Customer details
	 * 
	 * @param Customer ID.
	 * @return Customer Object.
	 * 
	 */
	@Override
	public Customer getCustomerRecord(Integer custId) {
		Customer customer = custRepo.findById(custId).get();
		return customer != null ? customer : null;
	}

	/**
	 * this method is used to get all Customer details
	 * 
	 * @return List of Customer.
	 * 
	 */
	@Override
	public List<Customer> getAllCustomerRecords() {
		List<Customer> customerList = custRepo.findAll();
		return customerList.isEmpty() ? null : customerList;
	}

	/**
	 * this method is used to update Customer details
	 * 
	 * @param Customer customer.
	 * @return String update message.
	 */
	@Override
	public String updateCustomerRecord(Customer customer) {
		Customer record = custRepo.findById(customer.getCustomerId()).get();
		record.setCustomerName(customer.getCustomerName());
		record.setCustomerContact(customer.getCustomerContact());
		record.setCustomerAddress(customer.getCustomerAddress());
		record.setCustomerEmail(customer.getCustomerEmail());
		Customer insertedRecord = custRepo.save(record);
		return insertedRecord != null ? "Customer with ID :: " + insertedRecord.getCustomerId() + " is Updated"
				: "Customer record problem, please try again";
	}

	/**
	 * this method is used to delete Customer details
	 * 
	 * @param Customer ID.
	 * @return String delete message
	 */
	@Override
	public String deleteCustomerRecord(Integer custId) {
		custRepo.deleteById(custId);
		return "Customer ID :: " + custId + " is deleted.";
	}

}

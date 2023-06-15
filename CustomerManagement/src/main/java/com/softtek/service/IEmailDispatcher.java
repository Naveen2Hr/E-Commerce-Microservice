package com.softtek.service;

import com.softtek.entity.Customer;

/**
 * 
 * @author sagar.hr
 *
 */
public interface IEmailDispatcher {
	public String customerMailGenerator(Customer customer)throws Exception;

}

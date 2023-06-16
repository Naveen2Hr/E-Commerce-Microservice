package com.shr.service;

import com.shr.entity.Order;
/**
 * 
 * @author m.rakesh
 *
 */
public interface IEmailDispactherOrder {
	
	public String orderConfirmation(Order order)throws Exception; 
}

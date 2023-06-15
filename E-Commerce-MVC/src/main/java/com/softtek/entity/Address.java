package com.softtek.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author ashik.k
 * 
 * @apiNote Address Entity Object for the Customer
 *
 */
@Getter
@Setter
public class Address {

	private Integer addressId;

	private String houseDetails;

	private String city;

	private String state;

	private Long pincode;

	private Customer customerId;

}

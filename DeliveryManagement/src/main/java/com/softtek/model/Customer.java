package com.softtek.model;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	private String customerId;

	private String customerName;

	private Long customerContact;

	private String customerEmail;

	private String customerGender;

	private AccountType customerType;

	private List<Address> customerAddress;
}

package com.softtek.entity;

import java.util.List;

import com.softtek.model.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

	private String customerId;

	private String customerName;

	private Long customerContact;

	private String customerEmail;

	private String customerGender;

	private AccountType customerType;

	private List<Address> customerAddress;
}

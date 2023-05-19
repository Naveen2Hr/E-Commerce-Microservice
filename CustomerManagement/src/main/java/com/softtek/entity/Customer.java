package com.softtek.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Customer Entity and Table Details.
 */
@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {
	@Id
	@Column(name = "CUST_ID")
	private String customerId;

	@Column(name = "CUST_NAME")
	private String customerName;

	@Column(name = "CUST_MOBILE")
	private Long customerContact;

	@Column(name = "CUST_EMAIL")
	private String customerEmail;

	@Column(name = "CUST_GENDER")
	private String customerGender;

	@ManyToOne
	@JoinColumn(name = "CUST_TYPE", referencedColumnName = "TYPEID")
	private AccountType customerType;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
	private List<Address> customerAddress;
}

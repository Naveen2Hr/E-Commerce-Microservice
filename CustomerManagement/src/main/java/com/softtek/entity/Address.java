package com.softtek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Address Entity for the Customer multiple Address. Achieving one to
 *          many from the Customer Entity end.
 *
 */

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@Column(name = "HOUSE_DETAILS", length = 100)
	private String houseDetails;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "PINCODE", length = 6)
	private Long pincode;

	@JsonIgnore
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
	private Customer customerId;

	@Override
	public String toString() {
		return "Addresses [addr_id=" + addressId + ", houseNoDeatils=" + houseDetails + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}
}

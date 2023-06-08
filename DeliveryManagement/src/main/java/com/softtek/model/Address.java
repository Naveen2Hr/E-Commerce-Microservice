package com.softtek.model;

import lombok.Data;

@Data
public class Address {

	private Integer addressId;

	private String houseDetails;

	private String city;

	private String state;

	private Long pincode;

	private Customer customerId;

	@Override
	public String toString() {
		return "Addresses [addr_id=" + addressId + ", houseNoDeatils=" + houseDetails + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}
}

package com.softtek.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author nandish.c
 *
 * @apiNote DeliveryPartner Entity and Table Details.
 */
@Entity
@Data
@Table(name = "DELIVERY_PARTNER_DETAILS")
public class DeliveryPartner {
	@Id
	@Column(name = "DP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dpId;

	@Column(name = "PHONE")
	private Long dpPhone;

	@Column(name = "CAPACITY")
	private Integer dpCapacity;

	@Column(name = "VEHICLE")
	private String dpVehicle;

	@JsonIgnore
	@OneToMany(targetEntity = Delivery.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_ID", referencedColumnName = "DELIVERY_ID")
	private List<Delivery> deliveryList;

	@Override
	public String toString() {
		return "DeliveryPartner [dpId=" + dpId + ", dpPhone=" + dpPhone + ", dpCapacity=" + dpCapacity + ", dpVehicle="
				+ dpVehicle + "]";
	}
}
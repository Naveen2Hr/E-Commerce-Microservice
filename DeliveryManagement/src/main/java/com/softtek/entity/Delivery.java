package com.softtek.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author nandish.c
 *
 * @apiNote Delivery Entity and Table Details.
 */
@Entity
@Data
@Table(name = "DELIVERY_DETAILS")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;

	@Column(name = "DELIVERY_STATUS")
	private String deliveryStatus;

	@Column(name = "DELIVERY_DATE_TIME")
	private LocalDate date;

	@Column(name = "PACKAGE_WEIGHT")
	private Float packageWeight;

	@ManyToOne(targetEntity = Warehouse.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "WAREHOUSE_ID")
	private Warehouse warehouse;

	@ManyToOne(targetEntity = DeliveryPartner.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "DP_ID", referencedColumnName = "DP_ID")
	private DeliveryPartner deliveryPartner;

	@Column(name = "PAYMENT_ID")
	private Integer paymentId;
}

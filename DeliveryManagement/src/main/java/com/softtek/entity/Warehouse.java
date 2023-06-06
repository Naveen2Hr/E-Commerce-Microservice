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
 * @apiNote Warehouse Entity and Table Details.
 */
@Entity
@Data
@Table(name = "WAREHOUSE_DETAILS")
public class Warehouse {

	@Id
	@Column(name = "WAREHOUSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warehouseId;

	@Column(name = "WAREHOUSE_NAME")
	private String warehouseName;

	@Column(name = "WAREHOUSE_CAPACITY")
	private String warehouseCapacity;

	@Column(name = "WAREHOUSE_PINCODE")
	private String warehousePincode;

	@JsonIgnore
	@OneToMany(targetEntity = Delivery.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_ID", referencedColumnName = "DELIVERY_ID")
	private List<Delivery> deliveryList;

	@Override
	public String toString() {
		return "Warehouse [warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", warehouseCapacity="
				+ warehouseCapacity + ", warehousePincode=" + warehousePincode + "]";
	}

}

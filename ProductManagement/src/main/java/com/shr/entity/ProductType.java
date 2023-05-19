package com.shr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author sagar.hr
 *
 *         Entity Class for the Product Type Object. With the independent Table
 *         creation
 * 
 */

@Data
@Entity
@Table(name = "PRODUCTTYPE")
public class ProductType {
	@Id
	private Integer typeId;

	@Column(length = 20)
	private String typeName;

	@Column(length = 50)
	private String typeDescription;
}

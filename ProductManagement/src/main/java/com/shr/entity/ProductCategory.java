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
 *         Entity Class for the Product Category Object. With the independent
 *         Table creation
 * 
 */

@Data
@Entity
@Table(name = "PRODUCTCATEGORY")
public class ProductCategory {

	@Id
	private Integer catId;

	@Column(length = 20)
	private String catName;

	@Column(length = 50)
	private String catDescription;

}

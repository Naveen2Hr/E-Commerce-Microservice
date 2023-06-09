package com.shr.entity;

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
 * @author ashik.k
 * 
 *         Entity Class for the Ordered Product Object. With the Table creation
 *
 */
@Data
@Entity
@Table(name = "ORDEREDPRODUCT")
public class OrderedProduct {
	@Id
	private Integer productId;

	@Column(length = 20)
	private String productName;

	@ManyToOne
	@JoinColumn(name = "productCategory", referencedColumnName = "catId")
	private ProductCategory productCategory;

	@Column(length = 20)
	private String productStatus;

	@Column
	private Integer productCount;

	@ManyToOne
	@JoinColumn(name = "productType", referencedColumnName = "typeId")
	private ProductType productType;

	@Column
	private Double productPrice;

	@Column(length = 100)
	private String productDespcription;

	@Column(length = 1000)
	private String imageLoc;
}

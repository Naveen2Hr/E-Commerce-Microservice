package com.softtek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sagar.hr
 *
 * @apiNote Entity Class for the type of account for the customer. Achieving the
 *          one to many relationship from the customer entity end.
 * 
 */

@Entity
@Table(name = "ACCOUNT_TYPE")
@Getter
@Setter
public class AccountType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeId;

	@Column(name = "TYPENAME")
	private String typeName;

	@Column(name = "CATEGORY", length = 20)
	private String category;

	@Column(name = "PRIZE")
	private Double prize;

	@Column(name = "TYPEDESCRIPTION", length = 200)
	private String typeDescription;

}

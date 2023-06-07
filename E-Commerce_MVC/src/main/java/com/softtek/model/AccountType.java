package com.softtek.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author ashik.k
 *
 * @apiNote AccountType Model Objects
 *
 */
@Getter
@Setter
public class AccountType {

	private Integer typeId;

	private String typeName;

	private String category;

	private Double prize;

	private String typeDescription;

}

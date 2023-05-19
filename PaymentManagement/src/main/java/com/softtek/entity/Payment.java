package com.softtek.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="PAYMENT_DETAILS")
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    
    @Column(name = "PAYMENT_MODE")
    private String pMode;
    
    @Column(name = "PAYMENT_STATUS",columnDefinition = "boolean default false")
    private Boolean pStatus;
    
    @Column(name="PAYMENT_DATE_TIME")
    private LocalDateTime dateAndTime;
    
    @Column(name = "ORDER_ID")
    private Long oid;
    
    @Column(name = "AMOUNT")
    private Double totalAmount;
    

}

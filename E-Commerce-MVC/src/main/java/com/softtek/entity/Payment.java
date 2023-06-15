package com.softtek.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author ashik.k
 *
 * @apiNote Payment Entity Objects
 *
 */
@Getter
@Setter
public class Payment {
	
    private Integer paymentId;
    
    private String paymentMode;
    
    private Boolean paymentStatus;
    
    private LocalDateTime dateAndTime;
    
    private Integer orderId;
    
    private Double totalAmount;
    

}

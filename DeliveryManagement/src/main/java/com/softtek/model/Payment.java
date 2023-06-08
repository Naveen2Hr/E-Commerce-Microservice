package com.softtek.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Payment {
	private Integer paymentId;

	private String paymentMode;

	private Boolean paymentStatus;

	private LocalDateTime dateAndTime;

	private Integer orderId;

	private Double totalAmount;
}

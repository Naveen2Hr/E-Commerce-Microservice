package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.service.IDeliveryService;

/**
 * 
 * @author nandish.c
 *
 * @apiNote Rest Controller for the Delivery API Handler Methods.
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private IDeliveryService service;

	
}
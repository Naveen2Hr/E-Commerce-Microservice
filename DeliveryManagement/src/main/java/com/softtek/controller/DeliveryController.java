package com.softtek.controller;

import java.util.List;

import org.hibernate.mapping.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softtek.entity.DeliveryPartner;
import com.softtek.entity.Warehouse;
import com.softtek.service.IDeliveryService;

/**
 * 
 * @author nandish.c
 *
 * @apiNote Controller for the Delivery API Handler Methods.
 */
@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private IDeliveryService service;

	@GetMapping("/welcome")
	public String showWelcome() {
		return "welcome";
	}

	@GetMapping("/registerDeliveryPartner")
	public String showDeliveryPartnerRegistrationPage(Model map) {
		// form baking object
		map.addAttribute("deliveryPartner", new DeliveryPartner());
		map.addAttribute("mode", "deliveryPartnerAdd");
		return "register";
	}
	
	@GetMapping("/registerWarehouse")
	public String showWarehouseRegistrationPage(Model map) {
		// form baking object
		map.addAttribute("warehouse", new Warehouse());
		map.addAttribute("mode", "warehouseAdd");
		return "register";
	}

	@PostMapping("/save")
	public String saveDeliveryPartner(DeliveryPartner deliveryPartner, Model map) {
		map.addAttribute("msg", service.saveDeliveryPartnerDetails(deliveryPartner));

		// clear form baking object
		map.addAttribute("deliveryPartner", new DeliveryPartner());
		return "register";
	}

	@PostMapping("/create")
	public String saveWarehouse(Warehouse warehouse, Model map) {
		map.addAttribute("msg", service.saveWarehouseDetails(warehouse));

		// clear form baking object
		map.addAttribute("warehouse", new Warehouse());
		return "register";
	}
	
	@GetMapping("/allDeliveryPartners")
	public String showAllDeliveryPartners(Model map) {
		List<DeliveryPartner> list = service.getAllPartnerDetails();
		map.addAttribute("list", list);
		map.addAttribute("mode", "allDeliveryPartners");
		return "data";
	}
	
	@GetMapping("/allWarehouses")
	public String showAllWarehouses(Model map) {
		List<Warehouse> list = service.getAllWarehouseDetails();
		map.addAttribute("list", list);
		map.addAttribute("mode", "allWarehouses");
		return "data";
	}

}
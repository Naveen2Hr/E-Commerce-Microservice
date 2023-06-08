package com.softtek.service;

import java.util.List;

import com.softtek.entity.Delivery;
import com.softtek.entity.DeliveryPartner;
import com.softtek.entity.Warehouse;

public interface IDeliveryService {

	// ****************Delivery Service****************

	public String saveDeliveryDetails(Delivery delivery);

	public Delivery getDeliveryDetailsByDeliveryId(Integer deliveryId);

	public List<Delivery> getAllDeliveryDetails();

	//public String updateDeliveryStatusByDeliveryId(Integer deliveryId);

	// ****************Delivery Partner Service****************

	public String saveDeliveryPartnerDetails(DeliveryPartner deliveryPartner);

	public DeliveryPartner getDeliveryPartnerDetailsByPartnerId(Integer deviveryPartnerId);

	public List<DeliveryPartner> getAllPartnerDetails();

	public String updateDeliveryPartnerDetails(DeliveryPartner deliveryPartner);

	// ****************Warehouse Service****************

	public String saveWarehouseDetails(Warehouse warehouse);

	public Warehouse getWarehouseDetailsByWarehouseId(Integer warehouseId);

	public List<Warehouse> getAllWarehouseDetails();

	public String updateWarehouseDetails(Warehouse warehouse);

	public String updateDeliveryDetailsTable();
}

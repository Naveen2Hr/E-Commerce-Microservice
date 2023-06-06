package com.softtek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.entity.Delivery;
import com.softtek.entity.DeliveryPartner;
import com.softtek.entity.Warehouse;
import com.softtek.repository.DeliveryPartnerRepository;
import com.softtek.repository.DeliveryRepository;
import com.softtek.repository.WarehouseRepository;

/**
 * 
 * @author nandish.c
 *
 * @apiNote Implementation Class of IDeliveryService
 */

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepo;

	@Autowired
	private DeliveryPartnerRepository deliveryPartnerRepo;

	@Autowired
	private WarehouseRepository warehouseRepo;

	// ****************Delivery Service Impl****************

	/**
	 * This Method is used to save the Delivery Details
	 * 
	 * @param Delivery delivery
	 * @return String message
	 * 
	 */
	public String saveDeliveryDetails(Delivery delivery) {
		return "Saved Succesfully with id : " + deliveryRepo.save(delivery).getDeliveryId();
	}

	/**
	 * This method is used to get Delivery details by delivery ID
	 * 
	 * @return Delivery
	 */
	@Override
	public Delivery getDeliveryDetailsByDeliveryId(Integer deliveryId) {
		return deliveryRepo.getReferenceById(deliveryId);
	}

	/**
	 * This method is used to get all payment Details
	 * 
	 * @return list of Payments
	 */
	@Override
	public List<Delivery> getAllDeliveryDetails() {
		return deliveryRepo.findAll();
	}

	/**
	 * This method is used to update the Delivery Status
	 * 
	 */
	@Override
	public String updateDeliveryStatusByDeliveryId(Integer deliveryId) {
		Delivery delivery = deliveryRepo.getReferenceById(deliveryId);
		delivery.setDeliveryStatus(true);
		return "Delivery status successfully Changed !!" + deliveryRepo.save(delivery).getDeliveryId();
	}

	// ****************Delivery Partner Service Impl****************

	/**
	 * This Method is used to save the DeliveryPartner Details
	 * 
	 * @param DeliveryPartner deliveryPartner
	 * @return String message
	 * 
	 */
	@Override
	public String saveDeliveryPartnerDetails(DeliveryPartner deliveryPartner) {
		DeliveryPartner save = deliveryPartnerRepo.save(deliveryPartner);
		return save != null ? "Saved Succesfully with id : " + save.getDpId() : "Check The partner details";
	}

	@Override
	public DeliveryPartner getDeliveryPartnerDetailsByPartnerId(Integer deviveryPartnerId) {
		return deliveryPartnerRepo.getReferenceById(deviveryPartnerId);
	}

	@Override
	public List<DeliveryPartner> getAllPartnerDetails() {
		return deliveryPartnerRepo.findAll();
	}

	@Override
	public String updateDeliveryPartnerDetails(DeliveryPartner deliveryPartner) {
		DeliveryPartner save = deliveryPartnerRepo.save(deliveryPartner);
		return save != null ? "Partner Details Updated Successfully" : "Check The partner details";
	}

	// ****************Warehouse Service Impl****************

	@Override
	public String saveWarehouseDetails(Warehouse warehouse) {
		Warehouse save = warehouseRepo.save(warehouse);
		return save != null ? "Warehouse Details saved with Id :" + save.getWarehouseId()
				: "Check The warehouse details";
	}

	@Override
	public Warehouse getWarehouseDetailsByWarehouseId(Integer warehouseId) {
		return warehouseRepo.getReferenceById(warehouseId);
	}

	@Override
	public List<Warehouse> getAllWarehouseDetails() {
		return warehouseRepo.findAll();
	}

	@Override
	public String updateWarehouseDetails(Warehouse warehouse) {
		Warehouse save = warehouseRepo.save(warehouse);
		return save != null ? "Warehouse Details updated successfully" : "Check The warehouse details";
	}

}

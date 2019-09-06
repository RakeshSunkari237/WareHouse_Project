package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {
	
	
	public ShipmentType getOneShipmentType(Integer shipmentTypeId);
	public List<ShipmentType> getAllShipmentTypes();
		public Integer saveShipmentType(ShipmentType shipmentType);
	public void updateShipmentType(ShipmentType shipmentType);
	public void deleteShipmentType(Integer shipmentTypeId);

	public List<Object[]> getShipmentTypeModeCount();


}

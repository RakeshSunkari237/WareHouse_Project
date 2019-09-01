package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl  implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveShipmentType(ShipmentType shipmentType) {
		return (Integer) ht.save(shipmentType);
	}


	public void updateShipmentType(ShipmentType shipmentType) {
		ht.update(shipmentType);
		}

	public void deleteShipmentType(Integer shipmentTypeId) {
		ht.delete(new ShipmentType(shipmentTypeId));
	}

	public ShipmentType getOneShipmentType(Integer shipmentTypeId) {
		return ht.get(ShipmentType.class, shipmentTypeId);
	}

	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}


	@SuppressWarnings("unchecked")
	public List<Object[]> getShipmentTypeModeCount() {

		String hql =   " select shipmentTypeMode,count(shipmentTypeMode) from "
				     + ShipmentType.class.getName()
				     + " group by shipmentTypeMode";
		@SuppressWarnings({ "deprecation" })
		List<Object[]> shipmentTypes = (List<Object[]>) ht.find(hql);
		for(Object[] ob:shipmentTypes) {
			System.out.println(ob[0]+" ,"+ob[1]);
		}
		
		return shipmentTypes;
	}




}

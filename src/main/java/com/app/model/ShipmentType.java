package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmentType_table")
public class ShipmentType {
	
	@Id
	@GeneratedValue
	@Column(name="shipment_id")
	private Integer shipmentTypeId;
	@Column(name="shipment_mode")
	private String shipmentTypeMode;
	@Column(name="shipment_code")
	private String shipmentTypeCode;
	@Column(name="enableShipment")
	private String enableShipment;
	@Column(name="shipment_Grade")
	private String shipmentTypeGrade;
	@Column(name="Descrpition")
	private String descrpition;
	
	public ShipmentType() {
		super();
	}
	
	

	public ShipmentType(Integer shipmentTypeId) {
		super();
		this.shipmentTypeId = shipmentTypeId;
	}



	public ShipmentType(Integer shipmentTypeId, String shipmentTypeMode, String shipmentTypeCode, String enableShipment,
			String shipmentTypeGrade, String descrpition) {
		super();
		this.shipmentTypeId = shipmentTypeId;
		this.shipmentTypeMode = shipmentTypeMode;
		this.shipmentTypeCode = shipmentTypeCode;
		this.enableShipment = enableShipment;
		this.shipmentTypeGrade = shipmentTypeGrade;
		this.descrpition = descrpition;
	}



	public Integer getShipmentTypeId() {
		return shipmentTypeId;
	}



	public void setShipmentTypeId(Integer shipmentTypeId) {
		this.shipmentTypeId = shipmentTypeId;
	}



	public String getShipmentTypeMode() {
		return shipmentTypeMode;
	}



	public void setShipmentTypeMode(String shipmentTypeMode) {
		this.shipmentTypeMode = shipmentTypeMode;
	}



	public String getShipmentTypeCode() {
		return shipmentTypeCode;
	}



	public void setShipmentTypeCode(String shipmentTypeCode) {
		this.shipmentTypeCode = shipmentTypeCode;
	}



	public String getEnableShipment() {
		return enableShipment;
	}



	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}



	public String getShipmentTypeGrade() {
		return shipmentTypeGrade;
	}



	public void setShipmentTypeGrade(String shipmentTypeGrade) {
		this.shipmentTypeGrade = shipmentTypeGrade;
	}



	public String getDescrpition() {
		return descrpition;
	}



	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}



	@Override
	public String toString() {
		return "ShipmentType [shipmentTypeId=" + shipmentTypeId + ", shipmentTypeMode=" + shipmentTypeMode
				+ ", shipmentTypeCode=" + shipmentTypeCode + ", enableShipment=" + enableShipment
				+ ", shipmentTypeGrade=" + shipmentTypeGrade + ", descrpition=" + descrpition + "]";
	}



}

package com.app.model;

public class ShipmentType {

	private Integer shipmentTypeId;
	private String shipmentMode;
	private String shipmentCode;
	private String enableShipment;
	private String shipmentGrade;
	private String descrpition;
	
	public ShipmentType() {
		super();
	}
	
	

	public ShipmentType(Integer shipmentTypeId) {
		super();
		this.shipmentTypeId = shipmentTypeId;
	}



	public ShipmentType(Integer shipmentTypeId, String shipmentMode, String shipmentCode, String enableShipment,
			String shipmentGrade, String descrpition) {
		super();
		this.shipmentTypeId = shipmentTypeId;
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.enableShipment = enableShipment;
		this.shipmentGrade = shipmentGrade;
		this.descrpition = descrpition;
	}



	public Integer getShipmentTypeId() {
		return shipmentTypeId;
	}



	public void setShipmentTypeId(Integer shipmentTypeId) {
		this.shipmentTypeId = shipmentTypeId;
	}



	public String getShipmentMode() {
		return shipmentMode;
	}



	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}



	public String getShipmentCode() {
		return shipmentCode;
	}



	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}



	public String getEnableShipment() {
		return enableShipment;
	}



	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}



	public String getShipmentGrade() {
		return shipmentGrade;
	}



	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}



	public String getDescrpition() {
		return descrpition;
	}



	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}



	@Override
	public String toString() {
		return "ShipmentType [shipmentTypeId=" + shipmentTypeId + ", shipmentMode=" + shipmentMode + ", shipmentCode="
				+ shipmentCode + ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade
				+ ", descrpition=" + descrpition + "]";
	}



	
	
	
}

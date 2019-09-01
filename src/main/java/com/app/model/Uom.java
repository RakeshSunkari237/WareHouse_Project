package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uom")
public class Uom {

	@Id
	@GeneratedValue(generator="uom")
	@GenericGenerator(name="uom",strategy="increment")
	@Column(name="uom_Id")
	private Integer uomId;
	
	@Column(name="uom_type")
	private String uomType;
	
	@Column(name="uom_model")
	private String uomModel;
	
	@Column(name="uom_desc")
	private String uomDescrpition;
	
	public Uom() {
		super();
	}

	public Uom(Integer uomId, String uomType, String uomModel, String uomDescrpition) {
		super();
		this.uomId = uomId;
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.uomDescrpition = uomDescrpition;
	}

	public Integer getUomId() {
		return uomId;
	}
	
	

	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getUomDescrpition() {
		return uomDescrpition;
	}

	public void setUomDescrpition(String uomDescrpition) {
		this.uomDescrpition = uomDescrpition;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDescrpition="
				+ uomDescrpition + "]";
	}
	
	
	
	
}

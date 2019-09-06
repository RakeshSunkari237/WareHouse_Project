package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_method")
public class OrderMethod {

	@Id
	@GeneratedValue(generator="ordermethod")
	@GenericGenerator(name="ordermethod",strategy="increment")
	@Column(name="order_id")
	private Integer orderMethodId;
	
	@Column(name="order_mode")
	private String orderMethodMode;
	
	@Column(name="order_code")
	private String orderMethodCode;
	
	@Column(name="excute_type")
	private String excuteType;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="order_accept",joinColumns=@JoinColumn(name="order_id"))
	@OrderColumn(name="pos")
	@Column(name="order_accept")
	private List<String> orderMethodAccept;
	
	@Column(name="descrpiton")
	private String descrpition;
	
	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer orderMethodId) {
		super();
		this.orderMethodId = orderMethodId;
	}

	public OrderMethod(Integer orderMethodId, String orderMethodMode, String orderMethodCode, String excuteType,
			List<String> orderMethodAccept, String descrpition) {
		super();
		this.orderMethodId = orderMethodId;
		this.orderMethodMode = orderMethodMode;
		this.orderMethodCode = orderMethodCode;
		this.excuteType = excuteType;
		this.orderMethodAccept = orderMethodAccept;
		this.descrpition = descrpition;
	}

	public Integer getOrderMethodId() {
		return orderMethodId;
	}

	public void setOrderMethodId(Integer orderMethodId) {
		this.orderMethodId = orderMethodId;
	}

	public String getOrderMethodMode() {
		return orderMethodMode;
	}

	public void setOrderMethodMode(String orderMethodMode) {
		this.orderMethodMode = orderMethodMode;
	}

	public String getOrderMethodCode() {
		return orderMethodCode;
	}

	public void setOrderMethodCode(String orderMethodCode) {
		this.orderMethodCode = orderMethodCode;
	}

	public String getExcuteType() {
		return excuteType;
	}

	public void setExcuteType(String excuteType) {
		this.excuteType = excuteType;
	}

	public List<String> getOrderMethodAccept() {
		return orderMethodAccept;
	}

	public void setOrderMethodAccept(List<String> orderMethodAccept) {
		this.orderMethodAccept = orderMethodAccept;
	}

	public String getDescrpition() {
		return descrpition;
	}

	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderMethodId=" + orderMethodId + ", orderMethodMode=" + orderMethodMode
				+ ", orderMethodCode=" + orderMethodCode + ", excuteType=" + excuteType + ", orderMethodAccept="
				+ orderMethodAccept + ", descrpition=" + descrpition + "]";
	}
	
	
	
	
}

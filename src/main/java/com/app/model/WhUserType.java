package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="whuser_type")
public class WhUserType {

	@Id
	@GeneratedValue(generator="whuser")
	@GenericGenerator(name="whuser",strategy="increment")
	@Column(name="user_id")
	private Integer whUserTypeId;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_code")
	private String whUserCode;
	
	@Column(name="user_for")
	private String whUserFor;
	
	@Column(name="user_email")
	private String whUserEmail;
	
	@Column(name="contact")
	private String whUserContact;
	
	@Column(name="id_type")
	private String whUserIdType;
	
	@Column(name="id_number")
	private String whUserIdNumber;
	
	public WhUserType() {
		super();
	}

	public WhUserType(Integer whUserTypeId) {
		super();
		this.whUserTypeId = whUserTypeId;
	}

	public WhUserType(Integer whUserTypeId, String userType, String whUserCode, String whUserFor, String whUserEmail,
			String whUserContact, String whUserIdType, String whUserIdNumber) {
		super();
		this.whUserTypeId = whUserTypeId;
		this.userType = userType;
		this.whUserCode = whUserCode;
		this.whUserFor = whUserFor;
		this.whUserEmail = whUserEmail;
		this.whUserContact = whUserContact;
		this.whUserIdType = whUserIdType;
		this.whUserIdNumber = whUserIdNumber;
	}

	public Integer getWhUserTypeId() {
		return whUserTypeId;
	}

	public void setWhUserTypeId(Integer whUserTypeId) {
		this.whUserTypeId = whUserTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getWhUserCode() {
		return whUserCode;
	}

	public void setWhUserCode(String whUserCode) {
		this.whUserCode = whUserCode;
	}

	public String getWhUserFor() {
		return whUserFor;
	}

	public void setWhUserFor(String whUserFor) {
		this.whUserFor = whUserFor;
	}

	public String getWhUserEmail() {
		return whUserEmail;
	}

	public void setWhUserEmail(String whUserEmail) {
		this.whUserEmail = whUserEmail;
	}

	public String getWhUserContact() {
		return whUserContact;
	}

	public void setWhUserContact(String whUserContact) {
		this.whUserContact = whUserContact;
	}

	public String getWhUserIdType() {
		return whUserIdType;
	}

	public void setWhUserIdType(String whUserIdType) {
		this.whUserIdType = whUserIdType;
	}

	public String getWhUserIdNumber() {
		return whUserIdNumber;
	}

	public void setWhUserIdNumber(String whUserIdNumber) {
		this.whUserIdNumber = whUserIdNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [whUserTypeId=" + whUserTypeId + ", userType=" + userType + ", whUserCode=" + whUserCode
				+ ", whUserFor=" + whUserFor + ", whUserEmail=" + whUserEmail + ", whUserContact=" + whUserContact
				+ ", whUserIdType=" + whUserIdType + ", whUserIdNumber=" + whUserIdNumber + "]";
	}

	
	}

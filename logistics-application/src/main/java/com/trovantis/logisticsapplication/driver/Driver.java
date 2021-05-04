package com.trovantis.logisticsapplication.driver;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="driver")
public class Driver {
	
	public Driver() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DRIVER_ID")
	int id;
	
	@Column(name="GIVEN_NAME")
	String givenName;
		
	@Column(name="FAMILY_NAME")
	String familyName;

	@Column(name="PHONE_NO")
	String phoneNo;

	@Column(name="VEHICLE_NO")
	String vehicleNo;
	
	@Column(name="ID_PROOF")
	String idProof;	
	
	@Column(name="ID_DOCUMENT")
	@Lob
	byte[] data;
	
	@Column(name="ORDER_ID")
	int orderId;
	
	public Driver(int id, String givenName, String familyName, String phoneNo, String vehicleNo, String idProof, byte[] data, int orderId) {
		super();
		this.id = id;
		this.givenName = givenName;
		this.familyName = familyName;
		this.phoneNo = phoneNo;
		this.vehicleNo = vehicleNo;
		this.idProof = idProof;
		this.data = data;
		this.orderId = orderId;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result + id;
		result = prime * result + ((idProof == null) ? 0 : idProof.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((vehicleNo == null) ? 0 : vehicleNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (id != other.id)
			return false;
		if (idProof == null) {
			if (other.idProof != null)
				return false;
		} else if (!idProof.equals(other.idProof))
			return false;
		if (orderId != other.orderId)
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (vehicleNo == null) {
			if (other.vehicleNo != null)
				return false;
		} else if (!vehicleNo.equals(other.vehicleNo))
			return false;
		return true;
	}

			
}

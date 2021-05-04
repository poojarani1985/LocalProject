package com.trovantis.logisticsapplication.order;

import java.util.Date;

import com.trovantis.logisticsapplication.util.OrderStatus;

public class OrderCustomerResult {

	public OrderCustomerResult() {
	}
	
	Date dateOfOrder;
	
	String pickupRegion;
	
	String dropoffRegion;
	
	String travelAgencyName;
	
	String givenName;
	
	String familyName;
	
	double amount;
	
	OrderStatus status;
	
	int id;
		
	public OrderCustomerResult(Date dateOfOrder, String pickupRegion, String dropoffRegion, String travelAgencyName,
			String givenName, String familyName, int amount, OrderStatus status, int id) {
		super();
		this.dateOfOrder = dateOfOrder;
		this.pickupRegion = pickupRegion;
		this.dropoffRegion = dropoffRegion;
		this.travelAgencyName = travelAgencyName;
		this.givenName = givenName;
		this.familyName = familyName;
		this.amount = amount;
		this.status = status;
		this.id = id;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getPickupRegion() {
		return pickupRegion;
	}

	public void setPickupRegion(String pickupRegion) {
		this.pickupRegion = pickupRegion;
	}

	public String getDropoffRegion() {
		return dropoffRegion;
	}

	public void setDropoffRegion(String dropoffRegion) {
		this.dropoffRegion = dropoffRegion;
	}

	public String getTravelAgencyName() {
		return travelAgencyName;
	}

	public void setTravelAgencyName(String travelAgencyName) {
		this.travelAgencyName = travelAgencyName;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

package com.trovantis.logisticsapplication.order;

import java.util.Date;

import com.trovantis.logisticsapplication.util.OrderStatus;

public class OrderFleetOwnerResult {
	

	private int id;
	private Date dateOfOrder;
	private String name;
	private String pickupRegion;
	private OrderStatus status;
	

	public OrderFleetOwnerResult(int id, Date dateOfOrder, String name, String pickupRegion, OrderStatus status) {
		this.id = id;
		this.dateOfOrder = dateOfOrder;
		this.name = name;
		this.pickupRegion = pickupRegion;
		this.status = status;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateOfOrder() {
		return dateOfOrder;
	}


	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPickupRegion() {
		return pickupRegion;
	}


	public void setPickupRegion(String pickupRegion) {
		this.pickupRegion = pickupRegion;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	

}

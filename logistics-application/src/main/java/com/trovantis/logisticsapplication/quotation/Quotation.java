package com.trovantis.logisticsapplication.quotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Quotation")
public class Quotation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	int id;
	
	@Column(name="DELIVERY_COST")
	double deliveryCost;
	
	@Column(name="RETURN_DELIVERY_COST")
	double returnDeliveryCost;
	
	@Column(name="PACKAGING_COST")
	double packagingCost;
	
	@Column(name="ORDER_ID")
	int orderId;
	
	@Column(name="FLEET_OWNER_ID")
	int fleetOwnerId;	
	
	public Quotation(int id, double deliveryCost, double returnDeliveryCost, double packagingCost, int orderId,
			int fleetOwnerId) {
		super();
		this.id = id;
		this.deliveryCost = deliveryCost;
		this.returnDeliveryCost = returnDeliveryCost;
		this.packagingCost = packagingCost;
		this.orderId = orderId;
		this.fleetOwnerId = fleetOwnerId;
	}
	
	public Quotation() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getReturnDeliveryCost() {
		return returnDeliveryCost;
	}

	public void setReturnDeliveryCost(double returnDeliveryCost) {
		this.returnDeliveryCost = returnDeliveryCost;
	}

	public double getPackagingCost() {
		return packagingCost;
	}

	public void setPackagingCost(double packagingCost) {
		this.packagingCost = packagingCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFleetOwnerId() {
		return fleetOwnerId;
	}

	public void setFleetOwnerId(int fleetOwnerId) {
		this.fleetOwnerId = fleetOwnerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(deliveryCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + fleetOwnerId;
		result = prime * result + id;
		result = prime * result + orderId;
		temp = Double.doubleToLongBits(packagingCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(returnDeliveryCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Quotation other = (Quotation) obj;
		if (Double.doubleToLongBits(deliveryCost) != Double.doubleToLongBits(other.deliveryCost))
			return false;
		if (fleetOwnerId != other.fleetOwnerId)
			return false;
		if (id != other.id)
			return false;
		if (orderId != other.orderId)
			return false;
		if (Double.doubleToLongBits(packagingCost) != Double.doubleToLongBits(other.packagingCost))
			return false;
		if (Double.doubleToLongBits(returnDeliveryCost) != Double.doubleToLongBits(other.returnDeliveryCost))
			return false;
		return true;
	}
		
	

}

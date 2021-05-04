package com.trovantis.logisticsapplication.fleetowner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fleet_owner_order")

public class FleetOwnerOrder {
	
	public FleetOwnerOrder() {
		
	}

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FLEET_OWNER_ORDER_ID")
	int fleetOwnerOrderId;
	
	@Column(name="ORDER_ID")
	int orderId;
	
	@Column(name="FLEET_OWNER_ID")
	int fleetOwnerId;
	

	public FleetOwnerOrder(int fleetOwnerOrderId, int orderId, int fleetOwnerId) {
		super();
		this.fleetOwnerOrderId = fleetOwnerOrderId;
		this.orderId = orderId;
		this.fleetOwnerId = fleetOwnerId;
	}

	public int getFleetOwnerOrderId() {
		return fleetOwnerOrderId;
	}

	public void setFleetOwnerOrderId(int fleetOwnerOrderId) {
		this.fleetOwnerOrderId = fleetOwnerOrderId;
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
		result = prime * result + fleetOwnerId;
		result = prime * result + fleetOwnerOrderId;
		result = prime * result + orderId;
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
		FleetOwnerOrder other = (FleetOwnerOrder) obj;
		if (fleetOwnerId != other.fleetOwnerId)
			return false;
		if (fleetOwnerOrderId != other.fleetOwnerOrderId)
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	
	
 
	
	
	

}

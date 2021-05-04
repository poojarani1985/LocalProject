package com.trovantis.logisticsapplication.quotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Selected_Quotation")
public class SelectedQuotation {

	public SelectedQuotation() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	int id;
	
	@Column(name="ORDER_ID")
	int orderId;
	
	@Column(name="QUOTATION_ID")
	int quotationId;
	
	@Column(name="FLEET_OWNER_ID")
	int fleetOwnerId;
		
	public SelectedQuotation(int id, int orderId, int quotationId, int fleetOwnerId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.quotationId = quotationId;
		this.fleetOwnerId = fleetOwnerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}

	public int getFleetOwnerId() {
		return fleetOwnerId;
	}

	public void setFleetOwnerId(int fleetOwnerId) {
		this.fleetOwnerId = fleetOwnerId;
	}
	
	
		
	

}

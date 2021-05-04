package com.trovantis.logisticsapplication.quotation;

public class QuotationsResult {
	
	private int id;
	private double deliveryCost;
	private double returnDeliveryCost;
	private double packagingCost;
	private String travelAgencyName;
	

	public QuotationsResult(int id, double deliveryCost, double returnDeliveryCost, double packagingCost, String travelAgencyName) {
		this.id = id;
		this.deliveryCost = deliveryCost;
		this.returnDeliveryCost = returnDeliveryCost;
		this.packagingCost = packagingCost;
		this.travelAgencyName = travelAgencyName;
		
	}
	
	public QuotationsResult(int id, double deliveryCost, double returnDeliveryCost, double packagingCost) {
		this.id = id;
		this.deliveryCost = deliveryCost;
		this.returnDeliveryCost = returnDeliveryCost;
		this.packagingCost = packagingCost;
		
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


	public String getTravelAgencyName() {
		return travelAgencyName;
	}


	public void setTravelAgencyName(String travelAgencyName) {
		this.travelAgencyName = travelAgencyName;
	}
	
	
	

}

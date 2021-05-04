package com.trovantis.logisticsapplication.order;


import java.sql.Time;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trovantis.logisticsapplication.util.OrderStatus;

@Entity
@Table(name="orders")

public class Order {
	
	public Order() {		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	int id;
	
	@Column(name="NAME")
	String name;
		
	@Column(name="MOBILE")
	int mobile;

	@Column(name="EMAIL")
	@Email
	String email;

	@Column(name="REQUIREMENT")
	@NotNull
	String requirement;
	
	@Column(name="SERVICES")
	String services;
	
	@Column(name="WEIGHT")
	double weight;
	
	@Column(name="LENGTH")
	double length;
	
	@Column(name="WIDTH")
	double width;
	
	@Column(name="HEIGHT")
	double height;
	
	@Column(name="DETAILS")
	String details;
	
	@Column(name="DATE_OF_ORDER")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date dateOfOrder; 
	
	@Column(name="TIME_OF_ORDER")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	Time timeOfOrder; 
	
	@Column(name="AMOUNT")
	int amount;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	OrderStatus status;
	
	@Column(name="CUSTOMER_ID")
	int customerId;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "streetAddress", column = @Column(name = "PICKUP_STREETADDRESS")),
		  @AttributeOverride( name = "region", column = @Column(name = "PICKUP_REGION")),
		  @AttributeOverride( name = "locality", column = @Column(name = "PICKUP_LOCALITY")),
		  @AttributeOverride( name = "postalCode", column = @Column(name = "PICKUP_POSTALCODE"))

		})
	Address	pickupAddress;	
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "streetAddress", column = @Column(name = "DROPOFF_STREETADDRESS")),
		  @AttributeOverride( name = "region", column = @Column(name = "DROPOFF_REGION")),
		  @AttributeOverride( name = "locality", column = @Column(name = "DROPOFF_LOCALITY")),
		  @AttributeOverride( name = "postalCode", column = @Column(name = "DROPOFF_POSTALCODE"))

		})
	Address	dropoffAddress;	
	
	
	public Order(int id, String name, int mobile, @Email String email, @NotNull String requirement, String services,
			double weight, double length, double width, double height, String details, Date dateOfOrder,
			Time timeOfOrder, int amount, OrderStatus status, Address pickupAddress, Address dropoffAddress) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.requirement = requirement;
		this.services = services;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
		this.details = details;
		this.dateOfOrder = dateOfOrder;
		this.timeOfOrder = timeOfOrder;
		this.amount = amount;
		this.pickupAddress = pickupAddress;
		this.dropoffAddress = dropoffAddress;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Time getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(Time timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	public Address getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public Address getDropoffAddress() {
		return dropoffAddress;
	}

	public void setDropoffAddress(Address dropoffAddress) {
		this.dropoffAddress = dropoffAddress;
	}

	
}

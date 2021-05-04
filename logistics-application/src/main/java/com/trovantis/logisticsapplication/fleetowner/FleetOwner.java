package com.trovantis.logisticsapplication.fleetowner;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.trovantis.logisticsapplication.order.Address;

@Entity
@Component
@Table(name = "fleet_owner")
public class FleetOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	int id;

	@Column(name = "FIRST_NAME")
	String fName;

	@Column(name = "LAST_NAME")
	String lName;

	@Column(name = "PHONE")
	int phone;

	@Column(name = "TRAVEL_AGENCY_NAME")
	String travelAgencyName;

	@Column(name = "CITY")
	String city;

	@Column(name = "IS_ACTIVE")
	boolean isActive;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "streetAddress", column = @Column(name = "STREET_ADDRESS")),
		  @AttributeOverride( name = "region", column = @Column(name = "REGION")),
		  @AttributeOverride( name = "locality", column = @Column(name = "LOCALITY")),
		  @AttributeOverride( name = "postalCode", column = @Column(name = "POSTAL_CODE"))

		})
	Address	address;	


	public FleetOwner() {

	}

	public FleetOwner(int id, String fName, String lName, int phone, String travelAgencyName, String city,
			Address address, boolean isActive) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.travelAgencyName = travelAgencyName;
		this.city = city;
		this.address = address;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getTravelAgencyName() {
		return travelAgencyName;
	}

	public void setTravelAgencyName(String travelAgencyName) {
		this.travelAgencyName = travelAgencyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}

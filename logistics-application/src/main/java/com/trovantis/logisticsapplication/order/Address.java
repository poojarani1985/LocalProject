package com.trovantis.logisticsapplication.order;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Embeddable
public class Address {

	public Address() {

	}

	public Address(@NotNull String streetAddress, @NotNull String region, @NotNull String locality,
			@NotNull @Range(min = 100000, max = 999999, message = "Postal code should be 6 digits") int postalCode) {
		super();
		this.streetAddress = streetAddress;
		this.region = region;
		this.locality = locality;
		this.postalCode = postalCode;
	}
	
	@NotNull
	String streetAddress;
	
	@NotNull
	String region;
	
	@NotNull
	String locality;
	
	@NotNull
	@Range(min= 100000, max= 999999, message="Postal code should be 6 digits")
	int postalCode;

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
}

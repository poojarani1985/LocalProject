package com.trovantis.logisticsapplication.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trovantis.logisticsapplication.fleetowner.FleetOwner;
@Component
public class LogisticsUtil {
	
	@Autowired 
	FleetOwner fleetOwner;

	public LogisticsUtil() {
		// TODO Auto-generated constructor stub
	}
	
	//To change status of isActive for fleet owner
	
	void toggleIsActive(boolean isActive){
		fleetOwner.setIsActive(isActive);
	}

}

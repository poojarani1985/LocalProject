package com.trovantis.logisticsapplication.driver;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService{

	@Autowired
	private DriverRepository driverRepo;
	
	//for saving a new driver	
	public Driver saveDriver(Driver driver) throws IOException {      
		driver.setData(Base64.decodeBase64(driver.getData()));
		Driver driverResult = driverRepo.save(driver);
		return driverResult;
		
	}
	
	
	//for getting all drivers
	public List<Driver> getAllDrivers() {
		return driverRepo.findAll();
	}	
	
}

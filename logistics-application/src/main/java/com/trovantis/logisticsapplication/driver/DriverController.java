package com.trovantis.logisticsapplication.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Controller
public class DriverController {
	@Autowired
	private DriverService driverService;


	// For saving a new driver
	@PostMapping(value = "/add-driver", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addWithDriver(@RequestBody() Driver driver) throws IOException {
			driverService.saveDriver(driver);
		
	}

	// For getting all the drivers
	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> findAll() {
		return new ResponseEntity<List<Driver>>(driverService.getAllDrivers(), HttpStatus.OK);

	}

}
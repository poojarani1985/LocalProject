package com.trovantis.logisticsapplication.fleetowner;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FleetOwnerController {
	
	@Autowired
    private FleetOwnerService fleetOwnerService;
	
	
	 //For getting all the fleet owners
		
		@GetMapping("/fleet-owners")
	    public ResponseEntity<List<FleetOwner>> findAll(){
	        return new ResponseEntity<List<FleetOwner>>(fleetOwnerService.getAllFleetOwners(), HttpStatus.OK);

	    }
		
		@GetMapping("/fleet-owner-details")
		public ResponseEntity<FleetOwner> getFleetOwnerDetails(@RequestParam int id){
	        return new ResponseEntity<FleetOwner>(fleetOwnerService.getFleetOwnerDetails(id), HttpStatus.OK);

		}
		
		//For saving fleet owner
		@RequestMapping(value = "/add-fleet-owner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public void add(@Valid @RequestBody FleetOwner fleetOwner) {
			  fleetOwnerService.saveFleetOwner(fleetOwner);
		}
		  
		//For getting only active fleet owners		 
		  @GetMapping("/active-fleet-owners")
		  public ResponseEntity<List<FleetOwner>> findActiveFleetOwners(){	    
			   return new ResponseEntity<List<FleetOwner>>(
			    		 fleetOwnerService.findActiveFleetOwners(true), HttpStatus.OK);
			    }
		  
		  //For assigning order to multiple fleet owners	 
		  @RequestMapping(value = "/assign-order-to-fleetowners", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		  public void assignOrderToFleetOwner(@RequestBody List<Integer> fleetOwnerIdList, @RequestParam int orderId) {		   
			 
			  fleetOwnerService.assignOrderToFleetOwners(fleetOwnerIdList, orderId);
		}
		  
		  	  

		  
		
}

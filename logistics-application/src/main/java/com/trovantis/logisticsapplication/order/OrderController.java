package com.trovantis.logisticsapplication.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import javax.validation.Valid;

@RestController
@Controller
public class OrderController {
	@Autowired
    private OrderService orderService;
	
	 //For saving a new order
		@RequestMapping(value = "/new-order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void add(@Valid @RequestBody Order order) {
	        orderService.saveQuotation(order);
	    }
   
		//For getting all the orders
		@GetMapping("/orders")
		public ResponseEntity<Page<Order>> findAll(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "2") int pageSize, @RequestParam(defaultValue = "id") String sortBy){
			return new ResponseEntity<Page<Order>>(orderService.getAllOrders(pageNo, pageSize, sortBy), HttpStatus.OK);

		}
		
		//For getting order details
		@GetMapping("/order-details")
		public ResponseEntity<Order> findOrderDetails(@RequestParam int orderId){
			return new ResponseEntity<Order>(orderService.getOrderDetails(orderId), HttpStatus.OK);
			
		}
			
	 
		//For fetching orders for fleet owner
	  	@GetMapping("/fleet-owner-orders") 
	  	public ResponseEntity<Page<OrderFleetOwnerResult>> findAllOrders(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "2") int pageSize, @RequestParam(defaultValue = "id") String sortBy,@RequestParam int fleetOwnerId){
	  		return new ResponseEntity<Page<OrderFleetOwnerResult>>(orderService.getAllFleetOwnerOrders(pageNo, pageSize, sortBy,fleetOwnerId),
		  HttpStatus.OK);
		  
		  }
	  	
	  //For fetching orders for Customer
	  	@GetMapping("/customer-orders") 
	  	public ResponseEntity<List<OrderCustomerResult>> findAllCustomerOrders(@RequestParam int customerId){
	  		return new ResponseEntity<List<OrderCustomerResult>>(orderService.getAllCustomerOrders(customerId),
		  HttpStatus.OK);
		  
		  }	
		
		 
	 
	
  
	 


   
}
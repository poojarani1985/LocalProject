package com.trovantis.logisticsapplication.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.trovantis.logisticsapplication.order.OrderService;

import java.util.List;

import javax.validation.Valid;
@RestController
@Controller
public class QuotationController {
	
	@Autowired
	public QuotationService quotationService;
	
	@Autowired
	public OrderService orderService;
	
	 //For saving quotation by orderId and fleetOwnerId
		@RequestMapping(value = "/save-quotation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void add(@Valid @RequestBody Quotation quotation) {
	        quotationService.saveQuotation(quotation);
	    }   
		
	 //For getting all the quotations for an order from all the travel agencies		  
		@GetMapping("/quotations-for-an-order")
		public ResponseEntity<List<QuotationsResult>> findAll(@RequestParam int orderId){ 
		return new ResponseEntity<List<QuotationsResult>>(quotationService.getAllQuotationsForOrder(orderId), HttpStatus.OK);
		  
		  }
		
		//For saving selected quotation to table, from where customer will fetch the quotation associated to his order
		@RequestMapping(value = "/share-quotation-to-customer", method = RequestMethod.POST)
		public void add(@RequestParam int orderId, @RequestParam int quotationId, @RequestParam int fleetOwnerId) {
			SelectedQuotation selectedQuotation = new SelectedQuotation();
			selectedQuotation.setOrderId(orderId);
			selectedQuotation.setQuotationId(quotationId);
			selectedQuotation.setQuotationId(quotationId);
			selectedQuotation.setFleetOwnerId(fleetOwnerId);
			quotationService.shareQuotation(selectedQuotation);
		}   
		
		//For getting final quotation for his order by customer		  
		@GetMapping("/quotation-for-an-order")
		public ResponseEntity<QuotationsResult> findQuotationForOrder(@RequestParam int orderId){ 
			return new ResponseEntity<QuotationsResult>(quotationService.getQuotationForOrder(orderId), HttpStatus.OK);
				  
		 }
		
		
			
		 	
		  
}
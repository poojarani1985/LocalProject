/*
 * package com.trovantis.logisticsapplication.customer;
 * 
 * import java.util.List;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.trovantis.logisticsapplication.quotation.QuotationsResult;
 * 
 * public class CustomerController {
 * 
 * public CustomerController() { // TODO Auto-generated constructor stub }
 * 
 * // For getting all the quotations for an order
 * 
 * @GetMapping("/quotationforanorder") public
 * ResponseEntity<List<QuotationsResult>> findAll(@RequestParam int orderId) {
 * return new ResponseEntity<List<QuotationsResult>>(quotationService.
 * getAllQuotationsForOrder(orderId), HttpStatus.OK);
 * 
 * }
 * 
 * }
 */
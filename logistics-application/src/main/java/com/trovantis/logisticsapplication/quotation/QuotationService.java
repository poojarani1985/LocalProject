package com.trovantis.logisticsapplication.quotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trovantis.logisticsapplication.order.OrderService;
import com.trovantis.logisticsapplication.util.OrderStatus;

@Service
public class QuotationService{

	@Autowired
	private QuotationRepository quotationRepo;
	
	@Autowired
	private SelectedQuotationRepository selectedQuotationRepo;
	
	@Autowired
	private OrderService orderService;
	
	
	//for saving a quotation	
	public Quotation saveQuotation(Quotation quotation) {
		orderService.updateOrderStatus(quotation.getOrderId(), OrderStatus.PRICE_QUOTES);
		return quotationRepo.save(quotation);
	}
	
	//for getting all the quotations for an order
	public List<QuotationsResult> getAllQuotationsForOrder(int orderId){
		return quotationRepo.findQuotationsForOrder(orderId);

	}
	
	//for saving a selected quotation for an order
	public SelectedQuotation shareQuotation(SelectedQuotation selectedQuotation) {
		
		orderService.updateOrderStatus(selectedQuotation.getOrderId(), OrderStatus.QUOTATION_SENT);
		return selectedQuotationRepo.save(selectedQuotation);
	}
	
	//for getting quotation for an order
	public QuotationsResult getQuotationForOrder(int orderId) {
		return quotationRepo.findQuotationForAnOrder(orderId);
	}
	
		
}

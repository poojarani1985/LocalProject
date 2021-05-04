package com.trovantis.logisticsapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.order.OrderService;
import com.trovantis.logisticsapplication.quotation.Quotation;
import com.trovantis.logisticsapplication.quotation.QuotationRepository;
import com.trovantis.logisticsapplication.quotation.QuotationService;
import com.trovantis.logisticsapplication.quotation.QuotationsResult;
import com.trovantis.logisticsapplication.quotation.SelectedQuotation;
import com.trovantis.logisticsapplication.quotation.SelectedQuotationRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class QuotationServiceTest {

	@Mock
	QuotationRepository quotationRepo;
	
	@Mock
	SelectedQuotationRepository selectedQuotationRepo;		
	
	@Mock
	OrderService orderService;
	
	@InjectMocks
	QuotationService quotationService;	

	@Autowired	
	ObjectMapper mapper;	
    
	@Test
	public void post_add() throws Exception {
		
		Quotation quotation = new Quotation(1,1000, 500, 100, 1, 2);
		Mockito.when(quotationRepo.save(quotation)).thenReturn(quotation);		
		Quotation quotation1 = quotationService.saveQuotation(quotation);	
		assertEquals(quotation.getId(), quotation1.getId());
	}
	
	@Test
	public void get_allQuotationsForOrder() throws Exception {

		List<QuotationsResult> quotationResultList = new ArrayList<>();
		QuotationsResult quotationResult1 = new QuotationsResult(1, 1000, 500, 100, "Neeta Logistics");
		QuotationsResult quotationResult2 = new QuotationsResult(1, 1111, 555, 100, "Anil Logistics");
		quotationResultList.add(quotationResult1);
		quotationResultList.add(quotationResult2);
		Mockito.when(quotationRepo.findQuotationsForOrder(1)).thenReturn(quotationResultList);
		List<QuotationsResult> quotationResultList1 = quotationService.getAllQuotationsForOrder(1);		
		assertEquals(quotationResultList1.get(0).getTravelAgencyName(), quotationResultList.get(0).getTravelAgencyName());

	}
	
	@Test
	public void post_shareQuotation() throws Exception {

		SelectedQuotation selectedQuotation1 = new SelectedQuotation(1,1,1,1);		
		Mockito.when(selectedQuotationRepo.save(selectedQuotation1)).thenReturn(selectedQuotation1);
		SelectedQuotation selectedQuotation2 = quotationService.shareQuotation(selectedQuotation1);	
		assertEquals(selectedQuotation2.getId(), 1);
	}
	
	@Test
	public void get_quotationForAnOrder() throws Exception{
		
		QuotationsResult quotationResult = new QuotationsResult(1, 1000, 500, 100, "Neeta Logistics");		
		Mockito.when(quotationRepo.findQuotationForAnOrder(1)).thenReturn(quotationResult);
		QuotationsResult quotationResult1 = quotationRepo.findQuotationForAnOrder(1);		
		assertEquals(quotationResult1.getTravelAgencyName(), quotationResult.getTravelAgencyName());
	}
	


		
}

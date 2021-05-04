package com.trovantis.logisticsapplication;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.quotation.Quotation;
import com.trovantis.logisticsapplication.quotation.QuotationService;
import com.trovantis.logisticsapplication.quotation.QuotationsResult;

@SpringBootTest
@AutoConfigureMockMvc
public class QuotationControllerTest {

	@MockBean
	QuotationService quotationService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void post_add_returnsStatus201() throws Exception {
		Quotation quotation = new Quotation(1, 1000, 500, 100, 1, 2);
		Mockito.when(quotationService.saveQuotation(quotation)).thenReturn(quotation);
		mockMvc.perform(post("/save-quotation").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(quotation)))
				.andExpect(status().isOk());

	}

	@Test
	public void post_add_returnsStatus400() throws Exception {
		Quotation quotation = new Quotation(1, 1000, 500, 100, 1, 2);
		Mockito.when(quotationService.saveQuotation(quotation)).thenReturn(quotation);
		
		mockMvc.perform(post("/save-quotation").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void get_allQuotationsForOrder_returnsOkWithListOfOrders() throws Exception {

		List<QuotationsResult> quotationList = new ArrayList<>();
		QuotationsResult quotation1 = new QuotationsResult(1, 1000, 500, 100, "Neeta Logistics");
		QuotationsResult quotation2 = new QuotationsResult(1, 1111, 555, 100, "Anil Logistics");

		quotationList.add(quotation1);
		quotationList.add(quotation2);

		Mockito.when(quotationService.getAllQuotationsForOrder(1)).thenReturn(quotationList);

		mockMvc.perform(get("/quotations-for-an-order").param("orderId", "1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", is(2)))
				.andExpect(jsonPath("$[1].travelAgencyName", is("Anil Logistics")))
				.andExpect(jsonPath("$[0].travelAgencyName", is("Neeta Logistics")));

	}

	@Test
	public void get_allQuotationsForOrder_returnsStatus400() throws Exception {

		List<QuotationsResult> quotationList = new ArrayList<>();
		QuotationsResult quotation1 = new QuotationsResult(1, 1000, 500, 100, "Neeta Logistics");
		QuotationsResult quotation2 = new QuotationsResult(1, 1111, 555, 100, "Anil Logistics");

		quotationList.add(quotation1);
		quotationList.add(quotation2);

		Mockito.when(quotationService.getAllQuotationsForOrder(1)).thenReturn(quotationList);

		mockMvc.perform(get("/quotations-for-an-order")).andExpect(status().isBadRequest());

	}

	@Test
	public void post_shareQuotation_returnsStatus201() throws Exception {

		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("orderId", "1");
		params.add("quotationId", "1");
		params.add("fleetOwnerId", "1");

		mockMvc.perform(post("/share-quotation-to-customer").params(params)).andExpect(status().isOk());

	}

	@Test
	public void post_shareQuotation_returnsStatus400() throws Exception {

		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("orderId", "1");

		mockMvc.perform(post("/share-quotation-to-customer").params(params)).andExpect(status().isBadRequest());

	}

	@Test
	public void get_findQuotationForOrder_returnsStatus200() throws Exception {
		QuotationsResult quotationResult = new QuotationsResult(1, 1000, 500, 100, "Neeta Logistics");

		Mockito.when(quotationService.getQuotationForOrder(1)).thenReturn(quotationResult);

		mockMvc.perform(get("/quotation-for-an-order").param("orderId", "1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.travelAgencyName", is("Neeta Logistics")));

	}

}

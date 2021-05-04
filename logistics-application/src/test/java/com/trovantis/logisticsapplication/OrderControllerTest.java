
package com.trovantis.logisticsapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.order.Address;
import com.trovantis.logisticsapplication.order.Order;
import com.trovantis.logisticsapplication.order.OrderFleetOwnerResult;
import com.trovantis.logisticsapplication.order.OrderService;
import com.trovantis.logisticsapplication.util.OrderStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

@SpringBootTest

@AutoConfigureMockMvc

public class OrderControllerTest {

	@MockBean
	OrderService orderService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MockMvc mockMvc;
	
	Address pickupAddress = new Address("california", "torrance", "edfddsdf", 1236);
	
	Address dropoffAddress = new Address("124 Anza", "california", "torrance", 1236);


	@Test
	public void get_allOrders_returnsOkWithListOfOrders() throws Exception {

		List<Order> orderList = new ArrayList<Order>();		

		Order order1 = new Order(1, "Pooja", 12345, "pooja.rani@wipro.com", "personal", "packaging", 123, 12, 13, 11,
				"details about load", new Date(), new java.sql.Time(123456789999l), 14234, OrderStatus.NEW,
				pickupAddress, dropoffAddress);
		Order order2 = new Order(2, "Rani", 12345, "pooja.rani@wipro.com", "personal", "packaging", 123, 12, 13, 11,
				"details about load", new Date(), new java.sql.Time(123456789999l), 14234, OrderStatus.NEW,
				pickupAddress, dropoffAddress);

		orderList.add(order1);
		orderList.add(order2);

		Page<Order> pageList = new PageImpl<>(orderList);

		Mockito.when(orderService.getAllOrders(1, 1, "id")).thenReturn(pageList);

		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("pageNo", "1");
		params.add("pageSize", "1");
		params.add("sortBy", "id");

		mockMvc.perform(get("/orders").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.content[0].name", is(order1.getName())));

		assertThat(pageList.getNumberOfElements(), equalTo(2));
	}

	@Test
	public void get_fleetOwnerOrders_returnsOkWithListOfOrders() throws Exception {

		List<OrderFleetOwnerResult> orderList = new ArrayList<>();
		OrderFleetOwnerResult order1 = new OrderFleetOwnerResult(1, new Date(), "pooja", "california", OrderStatus.NEW);
		OrderFleetOwnerResult order2 = new OrderFleetOwnerResult(2, new Date(), "rani", "california", OrderStatus.NEW);

		orderList.add(order1);
		orderList.add(order2);

		Page<OrderFleetOwnerResult> pageList = new PageImpl<>(orderList);

		Mockito.when(orderService.getAllFleetOwnerOrders(1, 1, "id", 1)).thenReturn(pageList);

		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("pageNo", "1");
		params.add("pageSize", "1");
		params.add("sortBy", "id");
		params.add("fleetOwnerId", "1");

		mockMvc.perform(get("/fleet-owner-orders").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.content[0].name", is(order1.getName())));

		assertThat(pageList.getNumberOfElements(), equalTo(2));

	}

	@Test
	public void post_add_returnsStatus201() throws Exception {

		Order order = new Order(1, "Pooja", 12345, "pooja.rani@wipro.com", "personal", "packaging", 123, 12, 13, 11,
				"details about load", new Date(), new java.sql.Time(123456789999l), 123456, OrderStatus.NEW,
				pickupAddress,dropoffAddress);

		Mockito.when(orderService.saveQuotation(order)).thenReturn(order);

		mockMvc.perform(post("/new-order").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(order)))
				.andExpect(status().isOk());

	}

	@Test
	public void post_add_returnsStatus400() throws Exception {
		Order order = new Order(1, "Pooja", 12345, "pooja.raniwipro.com", "personal", "packaging", 123, 12, 13, 11,
				"details about load", new Date(), new java.sql.Time(123456789999l), 123456, OrderStatus.NEW,
				pickupAddress,dropoffAddress);
		
		
		Mockito.when(orderService.saveQuotation(order)).thenReturn(order);

		mockMvc.perform(post("/new-order").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(order)))
				.andExpect(status().isBadRequest());

	}

}

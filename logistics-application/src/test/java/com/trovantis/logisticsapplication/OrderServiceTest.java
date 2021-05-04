
package com.trovantis.logisticsapplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.order.Address;
import com.trovantis.logisticsapplication.order.Order;
import com.trovantis.logisticsapplication.order.OrderFleetOwnerResult;
import com.trovantis.logisticsapplication.order.OrderRepository;
import com.trovantis.logisticsapplication.order.OrderService;
import com.trovantis.logisticsapplication.util.OrderStatus;

@SpringBootTest

@AutoConfigureMockMvc
public class OrderServiceTest {

	@Mock
	OrderRepository orderRepo;

	@InjectMocks
	OrderService orderService;

	@Autowired
	ObjectMapper mapper;
	
	Address pickupAddress = new Address("california", "torrance", "edfddsdf", 1236);
	
	Address dropoffAddress = new Address("124 Anza", "california", "torrance", 1236);


	@Test
	public void post_save() throws Exception {
		Order order = new Order(1, "Pooja", 12345, "pooja.rani@wipro.com", "personal", "packaging", 123, 12, 13, 11,
				"details about load", new Date(), new java.sql.Time(123456789999l), 123456, OrderStatus.NEW,
				pickupAddress, dropoffAddress);
		Mockito.when(orderRepo.save(order)).thenReturn(order);
		Order order1 = orderService.saveQuotation(order);
		assertEquals(order1.getId(), order.getId());
	}

	@Test
	public void get_allOrders() throws Exception {

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

		Pageable paging = PageRequest.of(1, 1, Sort.by("id"));

		Mockito.when(orderRepo.findAll(Sort.by(Sort.Direction.DESC, "name"))).thenReturn(orderList);

		Mockito.when(orderRepo.findAll(paging)).thenReturn(pageList);

		Page<Order> pageList1 = orderService.getAllOrders(1, 1, "id");
		assertThat(pageList1.getNumberOfElements(), equalTo(2));

	}

	@Test
	public void get_fleetOwnerOrders() throws Exception {

		List<OrderFleetOwnerResult> orderList = new ArrayList<>();
		OrderFleetOwnerResult order1 = new OrderFleetOwnerResult(1, new Date(), "pooja", "california", OrderStatus.NEW);
		OrderFleetOwnerResult order2 = new OrderFleetOwnerResult(2, new Date(), "rani", "california", OrderStatus.NEW);

		orderList.add(order1);
		orderList.add(order2);

		Page<OrderFleetOwnerResult> pageList = new PageImpl<>(orderList);

		Pageable paging = PageRequest.of(1, 1, Sort.by("id"));

		Mockito.when(orderRepo.findOrdersByFleetOwnerId(1, paging)).thenReturn(pageList);

		Page<OrderFleetOwnerResult> pageList1 = orderService.getAllFleetOwnerOrders(1, 1, "id", 1);
		assertThat(pageList1.getNumberOfElements(), equalTo(2));

	}

}

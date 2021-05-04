package com.trovantis.logisticsapplication;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trovantis.logisticsapplication.fleetowner.FleetOwner;
import com.trovantis.logisticsapplication.fleetowner.FleetOwnerOrder;
import com.trovantis.logisticsapplication.fleetowner.FleetOwnerService;
import com.trovantis.logisticsapplication.order.Address;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FleetOwnerControllerTest {

	@MockBean
	FleetOwnerService fleetOwnerService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MockMvc mockMvc;
	
	Address address = new Address("california", "torrance", "edfddsdf", 1236);


	@Test
	public void get_allFleetOwners_returnsOkWithListOfFleetOwners() throws Exception {

		List<FleetOwner> fleetOwnerList = new ArrayList<>();
		FleetOwner fleetOwner1 = new FleetOwner(1, "Anil", "Ambani", 1234567890, "Anil Logistics", "LA", address, true);
		FleetOwner fleetOwner2 = new FleetOwner(2, "Neeta", "Ambani", 1234567890, "Anil Logistics", "LA", address, true);

		fleetOwnerList.add(fleetOwner1);
		fleetOwnerList.add(fleetOwner2);

		Mockito.when(fleetOwnerService.getAllFleetOwners()).thenReturn(fleetOwnerList);

		mockMvc.perform(get("/fleet-owners")).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)))
				.andExpect(jsonPath("$[1].fName", is("Neeta"))).andExpect(jsonPath("$[1].lName", is("Ambani")));

	}

	@Test
	public void post_add_returnsStatus201() throws Exception {
		FleetOwner fleetOwner = new FleetOwner(1, "Anil", "Ambani", 1234567890, "Anil Logistics", "LA", address, true);

		Mockito.when(fleetOwnerService.saveFleetOwner(fleetOwner)).thenReturn(fleetOwner);

		mockMvc.perform(post("/add-fleet-owner").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(fleetOwner)))
				.andExpect(status().isOk());

	}

	@Test
	public void post_assignOrderToFleetOwner_returnStatus201() throws Exception{
		List<Integer> fleetOwnerIdList = new ArrayList<Integer>();
		fleetOwnerIdList.add(1);
		fleetOwnerIdList.add(2);
		
		FleetOwnerOrder fleetOwnerOrder1 = new FleetOwnerOrder(1, 1, 1);
		FleetOwnerOrder fleetOwnerOrder2 = new FleetOwnerOrder(2, 1, 2);
		
		List<FleetOwnerOrder> fleetOwnerOrderList = new ArrayList<FleetOwnerOrder>();
		fleetOwnerOrderList.add(fleetOwnerOrder1);
		fleetOwnerOrderList.add(fleetOwnerOrder2);



		Mockito.when(fleetOwnerService.assignOrderToFleetOwners(fleetOwnerIdList,1)).thenReturn(fleetOwnerOrderList);

		
		mockMvc.perform(post("/assign-order-to-fleetowners").contentType(MediaType.APPLICATION_JSON).param("orderId", "1").accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsBytes(fleetOwnerIdList))).andExpect(status().isOk());	
		
	}

}

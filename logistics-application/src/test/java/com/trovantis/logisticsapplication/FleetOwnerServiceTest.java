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
import com.trovantis.logisticsapplication.fleetowner.FleetOwner;
import com.trovantis.logisticsapplication.fleetowner.FleetOwnerOrderRepository;
import com.trovantis.logisticsapplication.fleetowner.FleetOwnerRepository;
import com.trovantis.logisticsapplication.fleetowner.FleetOwnerService;
import com.trovantis.logisticsapplication.order.Address;
import com.trovantis.logisticsapplication.order.OrderService;

@SpringBootTest
@AutoConfigureMockMvc
public class FleetOwnerServiceTest {

	@Mock
	FleetOwnerRepository fleetOwnerRepo;
	
	@Mock
	OrderService orderService;
	
	@Mock
	FleetOwnerOrderRepository fleetOwnerOrderRepo;

	@InjectMocks
	FleetOwnerService fleetOwnerService;

	@Autowired
	ObjectMapper mapper;
	
	Address address = new Address("california", "torrance", "edfddsdf", 1236);


	@Test
	public void post_save() throws Exception {
		FleetOwner fleetOwner = new FleetOwner(1, "Anil", "Ambani", 1234567890, "Anil Logistics", "LA",address, true);
		Mockito.when(fleetOwnerRepo.save(fleetOwner)).thenReturn(fleetOwner);
		FleetOwner fleetOwner1 = fleetOwnerService.saveFleetOwner(fleetOwner);
		assertEquals(fleetOwner1.getId(), fleetOwner.getId());
	}

	@Test
	public void get_allFleetOwners() throws Exception {

		List<FleetOwner> fleetOwnerList = new ArrayList<>();
		FleetOwner fleetOwner1 = new FleetOwner(1, "Anil", "Ambani", 1234567890, "Anil Logistics", "LA", address, true);
		FleetOwner fleetOwner2 = new FleetOwner(2, "Neeta", "Ambani", 1234567890, "Anil Logistics", "LA", address, true);

		fleetOwnerList.add(fleetOwner1);
		fleetOwnerList.add(fleetOwner2);

		Mockito.when(fleetOwnerRepo.findAll()).thenReturn(fleetOwnerList);
		List<FleetOwner> fleetOwnerList1 = fleetOwnerService.getAllFleetOwners();
		assertEquals(fleetOwnerList1.get(0).getTravelAgencyName(), fleetOwnerList.get(0).getTravelAgencyName());

	}

	/*@Test
	public void post_assignOrderToFleetOwner() throws Exception {
		
		List<FleetOwnerOrder> fleetOwnerOrderList = new ArrayList<>();
		FleetOwnerOrder fleetOwnerOrder1 = new FleetOwnerOrder(1,1,1);
		FleetOwnerOrder fleetOwnerOrder2 = new FleetOwnerOrder(2,1,2);

		fleetOwnerOrderList.add(fleetOwnerOrder1);
		fleetOwnerOrderList.add(fleetOwnerOrder2);
		
		List<Integer> fleetOwnerIdList = new ArrayList<Integer>();
		fleetOwnerIdList.add(1);
		fleetOwnerIdList.add(2);



		Mockito.when(fleetOwnerOrderRepo.saveAll(fleetOwnerOrderList)).thenReturn(fleetOwnerOrderList);

		List<FleetOwnerOrder> fleetOwnerOrderList1 = fleetOwnerService.assignOrderToFleetOwners(fleetOwnerIdList,1);
		assertEquals(fleetOwnerOrderList.size(), fleetOwnerOrderList1.size());

	}*/

}

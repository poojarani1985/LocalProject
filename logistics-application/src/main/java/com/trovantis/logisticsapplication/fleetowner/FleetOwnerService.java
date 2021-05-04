package com.trovantis.logisticsapplication.fleetowner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trovantis.logisticsapplication.order.OrderService;
import com.trovantis.logisticsapplication.util.OrderStatus;

	@Service
	public class FleetOwnerService{

		@Autowired
		private FleetOwnerRepository fleetOwnerRepo;		
		
		@Autowired
		private FleetOwnerOrderRepository fleetOwnerOrderRepo;
		
		@Autowired 
		private OrderService  orderService;
			
		public FleetOwner saveFleetOwner(FleetOwner fleetOwner) {
			return fleetOwnerRepo.save(fleetOwner);
		}
		
		public List<FleetOwner> getAllFleetOwners() {
			return fleetOwnerRepo.findAll();
		}
		
		public FleetOwner getFleetOwnerDetails(int id) {
			return fleetOwnerRepo.findById(id);
		}

		
		public List<FleetOwner> findActiveFleetOwners(boolean isActive){
			return fleetOwnerRepo.findByIsActive(isActive);
		}
		
		public List<FleetOwnerOrder> assignOrderToFleetOwners(List<Integer> fleetOwnerIdList, int orderId) {
			
			//before assigning an order to fleet owner change its status to 2 i.e. 'Quotation'
			 orderService.updateOrderStatus(orderId, OrderStatus.QUOTATION);
			
			List<FleetOwnerOrder> fleetOwnerOrderList = new ArrayList<FleetOwnerOrder>();
			
			for(int fleetOwnerId : fleetOwnerIdList) {
				FleetOwnerOrder fleetOwnerOrder = new FleetOwnerOrder();
				fleetOwnerOrder.setFleetOwnerId(fleetOwnerId);
				fleetOwnerOrder.setOrderId(orderId);
				fleetOwnerOrderList.add(fleetOwnerOrder);
			}	
			
			fleetOwnerOrderRepo.saveAll(fleetOwnerOrderList);
			return fleetOwnerOrderRepo.saveAll(fleetOwnerOrderList);
		}	
		
	}



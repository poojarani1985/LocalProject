package com.trovantis.logisticsapplication.fleetowner;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetOwnerOrderRepository extends JpaRepository<FleetOwnerOrder, Integer>{  
	
	
 }
package com.trovantis.logisticsapplication.fleetowner;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trovantis.logisticsapplication.order.Order;


@Repository
public interface FleetOwnerRepository extends JpaRepository<FleetOwner, Integer>{
    List<FleetOwner> findByIsActive(boolean isActive);
    
    FleetOwner findById(@Param(value="id") int id);

    
    

}
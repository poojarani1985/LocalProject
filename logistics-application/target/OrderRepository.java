package com.trovantis.logisticsapplication.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByStatus(int status);
    
    @Modifying
    @Transactional
    @Query("update Order o set o.status = :status where o.id = :id")
    void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);
    
    
    @Query("select New com.trovantis.logisticsapplication.order.OrderFleetOwnerResult(o.id, o.dateOfOrder, o.name, o.pickupRegion, o.status) from Order o, FleetOwnerOrder fo where fo.orderId = o.id  AND fo.fleetOwnerId = :fleetOwnerId")
    List<OrderFleetOwnerResult> findOrdersByFleetOwnerId(@Param(value="fleetOwnerId") int fleetOwnerId);
  
    Order findById(@Param(value="orderId") int orderId);

}
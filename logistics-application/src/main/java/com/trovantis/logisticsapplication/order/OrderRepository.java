package com.trovantis.logisticsapplication.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trovantis.logisticsapplication.util.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByStatus(int status);
    
    @Modifying
    @Transactional
    @Query("update Order o set o.status = :status where o.id = :id")
    void updateStatus(@Param(value = "id") int id, @Param(value = "status") OrderStatus orderStatus);
    
    
    @Query("select New com.trovantis.logisticsapplication.order.OrderFleetOwnerResult(o.id, o.dateOfOrder, o.name, o.pickupAddress.region, o.status) from Order o, FleetOwnerOrder fo where fo.orderId = o.id  AND fo.fleetOwnerId = :fleetOwnerId")
    Page<OrderFleetOwnerResult> findOrdersByFleetOwnerId(@Param(value="fleetOwnerId") int fleetOwnerId, Pageable paging);
  
    Order findById(@Param(value="orderId") int orderId);
    
    @Query("select New com.trovantis.logisticsapplication.order.OrderCustomerResult(o.dateOfOrder, o.pickupAddress.region, o.dropoffAddress.region, fo.travelAgencyName, d.givenName, d.familyName, o.amount, o.status, o.id) from Order o LEFT JOIN SelectedQuotation sq ON sq.orderId = o.id LEFT JOIN Driver d ON d.orderId = o.id LEFT JOIN FleetOwner fo ON fo.id =sq.fleetOwnerId where o.customerId = :customerId")
    List<OrderCustomerResult> findOrdersByCustomerId(@Param(value ="customerId") int customerId);

}
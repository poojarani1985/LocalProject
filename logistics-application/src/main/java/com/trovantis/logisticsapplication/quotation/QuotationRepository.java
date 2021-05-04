package com.trovantis.logisticsapplication.quotation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Integer>{
	
    @Query("select New com.trovantis.logisticsapplication.quotation.QuotationsResult(q.id, q.deliveryCost, q.returnDeliveryCost, q.packagingCost, fo.travelAgencyName) from Quotation q, FleetOwner fo where q.orderId = :orderId AND fo.id = q.fleetOwnerId")
    List<QuotationsResult> findQuotationsForOrder(@Param(value="orderId") int orderId);
    
    @Query("select New com.trovantis.logisticsapplication.quotation.QuotationsResult(q.id, q.deliveryCost, q.returnDeliveryCost, q.packagingCost) from Quotation q, SelectedQuotation sq where q.orderId = :orderId AND q.id = sq.quotationId")
    QuotationsResult findQuotationForAnOrder(@Param(value="orderId") int orderId);

   
}
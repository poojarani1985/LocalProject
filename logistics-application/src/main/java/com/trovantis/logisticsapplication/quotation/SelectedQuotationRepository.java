package com.trovantis.logisticsapplication.quotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectedQuotationRepository extends JpaRepository<SelectedQuotation, Integer>{
   
}
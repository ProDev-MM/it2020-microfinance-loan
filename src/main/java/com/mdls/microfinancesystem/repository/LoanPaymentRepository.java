package com.mdls.microfinancesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdls.microfinancesystem.entity.LoanPayment;

@Repository
public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long>{
 
}

package com.mdls.microfinancesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdls.microfinancesystem.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}

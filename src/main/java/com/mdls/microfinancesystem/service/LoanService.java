package com.mdls.microfinancesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.Loan;
import com.mdls.microfinancesystem.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepository;

	public List<Loan> find(Loan loan) {
		// TODO Auto-generated method stub
		return loanRepository.findAll();
	}

	public Loan save(Loan loan) {
		Loan loans = new Loan();
		loans.setLoandedDate(loan.getLoandedDate());
		loans.setStaff(loan.getStaff());
		loans.setCustomer(loan.getCustomer());
		loans.setGuarantor(loan.getGuarantor());
		loans.setLoanPayment(loan.getLoanPayment());
		Loan saveloan = loanRepository.save(loans);
		return saveloan;

	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		loanRepository.deleteById(id);
	}

}

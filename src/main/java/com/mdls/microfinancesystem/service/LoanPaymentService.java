package com.mdls.microfinancesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.LoanPayment;
import com.mdls.microfinancesystem.repository.LoanPaymentRepository;

@Service("LoanPaymentInter")
public class LoanPaymentService {
	@Autowired
	LoanPaymentRepository loanPaymentRepository;

	public List<LoanPayment> find(LoanPayment loanPayment) {
		// TODO Auto-generated method stub
		return loanPaymentRepository.findAll();
	}

	public Double result(LoanPayment loanPayment) {
		Double loanAmount = loanPayment.getLoanAmount();
		Integer loanInterest = loanPayment.getLoanInterest();
		Integer months = loanPayment.getMonths();
		double result = ((loanAmount * loanInterest / 100) + loanAmount) / months;
		loanPayment.setMonthlyPayment(result);
		return result;

	}

	public LoanPayment saveLoan(LoanPayment loanPayment) {
		result(loanPayment);
		return loanPaymentRepository.save(loanPayment);
	}

}

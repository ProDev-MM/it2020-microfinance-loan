package com.mdls.microfinancesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.LoanPaymentPolicy;
import com.mdls.microfinancesystem.repository.LoanPaymentRepository;

@Service("LoanPaymentInter")
public class LoanPaymentService {
	@Autowired
	LoanPaymentRepository loanPaymentRepository;

	public List<LoanPaymentPolicy> find(LoanPaymentPolicy loanPaymentPolicy) {
		// TODO Auto-generated method stub
		return loanPaymentRepository.findAll();
	}

	public Double result(LoanPaymentPolicy loanPaymentPolicy) {
		Double loanAmount = loanPaymentPolicy.getLoanAmount();
		Integer loanInterest = loanPaymentPolicy.getLoanInterest();
		Integer months = loanPaymentPolicy.getMonths();
		double result = ((loanAmount * loanInterest / 100) + loanAmount) / months;
		loanPaymentPolicy.setMonthlyPayment(result);
		return result;

	}

	public LoanPaymentPolicy saveLoan(LoanPaymentPolicy loanPaymentPolicy) {
		result(loanPaymentPolicy);
		return loanPaymentRepository.save(loanPaymentPolicy);
	}

}

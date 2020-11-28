package com.mdls.microfinancesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mdls.microfinancesystem.entity.LoanPaymentPolicy;
import com.mdls.microfinancesystem.service.LoanPaymentService;

@RestController
public class LoanPaymentController {
@Autowired
LoanPaymentService loanPaymentService;

@GetMapping(name="/loanPayments")
public List<LoanPaymentPolicy> getLoanPayment(LoanPaymentPolicy loanPaymentPolicy){
	return loanPaymentService.find(loanPaymentPolicy);
}
@PostMapping(name="/loanPayment")
public LoanPaymentPolicy saveLoanPayment(@RequestBody LoanPaymentPolicy loanPaymentPolicy) {
	return loanPaymentService.saveLoan(loanPaymentPolicy);
	
}

}

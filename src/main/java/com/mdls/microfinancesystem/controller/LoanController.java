package com.mdls.microfinancesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mdls.microfinancesystem.entity.Loan;
import com.mdls.microfinancesystem.service.LoanService;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	
	@GetMapping(value="/loans")
	public List<Loan> getLoan(Loan loan){
		return loanService.find(loan);
	}
   
   @PostMapping (value = "/loan")
	public Loan saveLoan(@RequestBody Loan loan) {
		Loan loanResponse = loanService.save(loan);
		return loanResponse;
	}
   @DeleteMapping(value="/loan/{id}")
   public void deleteById(@PathVariable Long id) {
	    loanService.delete(id);
   }
   
   
   
   
   
}

package com.mdls.microfinancesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loanPayment")
public class LoanPaymentPolicy {
	@Id
	@GeneratedValue
	long id;
	@Column
	private double loanAmount;
	private int loanInterest;
	private int months;
	private double monthlyPayment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(int loanInterest) {
		this.loanInterest = loanInterest;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	@Override
	public String toString() {
		return "LoanPayment [id=" + id + ", loanAmount=" + loanAmount + ", loanInterest=" + loanInterest + ", months="
				+ months + ", monthlyPayment=" + monthlyPayment + "]";
	}

}

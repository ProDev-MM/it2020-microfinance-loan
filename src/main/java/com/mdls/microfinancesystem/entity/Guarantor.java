package com.mdls.microfinancesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guarantor")
public class Guarantor {
	@Id
	@GeneratedValue
	Long id;

	@Column
	private String guarantorName;
	@Column
	private String guarantorNRC;
	@Column
	private String guarantorAddress;
	@Column
	private String guarantorPhone;
	@Column
	private String guarantorOccupation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuarantorName() {
		return guarantorName;
	}

	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	public String getGuarantorNRC() {
		return guarantorNRC;
	}

	public void setGuarantorNRC(String guarantorNRC) {
		this.guarantorNRC = guarantorNRC;
	}

	public String getGuarantorAddress() {
		return guarantorAddress;
	}

	public void setGuarantorAddress(String guarantorAddress) {
		this.guarantorAddress = guarantorAddress;
	}

	public String getGuarantorPhone() {
		return guarantorPhone;
	}

	public void setGuarantorPhone(String guarantorPhone) {
		this.guarantorPhone = guarantorPhone;
	}

	public String getGuarantorOccupation() {
		return guarantorOccupation;
	}

	public void setGuarantorOccupation(String guarantorOccupation) {
		this.guarantorOccupation = guarantorOccupation;
	}

}

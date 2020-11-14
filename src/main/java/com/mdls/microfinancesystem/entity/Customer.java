package com.mdls.microfinancesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	Long id;

	@Column
	private String customerName;
	@Column
	private String customerNRC;
	@Column
	private String customerAddress;
	@Column
	private String customerPhone;
	@Column
	private String customerOccupation;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNRC() {
		return customerNRC;
	}

	public void setCustomerNRC(String customerNRC) {
		this.customerNRC = customerNRC;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerOccupation() {
		return customerOccupation;
	}

	public void setCustomerOccupation(String customerOccupation) {
		this.customerOccupation = customerOccupation;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerNRC=" + customerNRC
				+ ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", customerOccupation="
				+ customerOccupation + ", member=" + member + "]";
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}

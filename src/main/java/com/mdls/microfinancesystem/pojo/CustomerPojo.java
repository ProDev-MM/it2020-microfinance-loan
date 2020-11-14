package com.mdls.microfinancesystem.pojo;

public class CustomerPojo {
 Long id;
 String customerName;
 String customerNRCNo;
 String customerPhone;
 String customerAddress;
 String customerOccupation;
 Long member_id;

public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerNRCNo() {
	return customerNRCNo;
}
public void setCustomerNRCNo(String customerNRCNo) {
	this.customerNRCNo = customerNRCNo;
}
public String getCustomerPhone() {
	return customerPhone;
}
public void setCustomerPhone(String customerPhone) {
	this.customerPhone = customerPhone;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCustomerOccupation() {
	return customerOccupation;
}
public void setCustomerOccupation(String customerOccupation) {
	this.customerOccupation = customerOccupation;
}
public long getId() {
	// TODO Auto-generated method stub
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getMember_id() {
	return member_id;
}
public void setMember_id(Long member_id) {
	this.member_id = member_id;
}
 
 
}

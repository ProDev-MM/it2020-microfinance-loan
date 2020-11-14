package com.mdls.microfinancesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 Long id;
@Column
private String memberType;
@Column
private String memberGroupName;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMemberType() {
	return memberType;
}
public void setMemberType(String memberType) {
	this.memberType = memberType;
}
public String getMemberGroupName() {
	return memberGroupName;
}
public void setMemberGroupName(String memberGroupName) {
	this.memberGroupName = memberGroupName;
}
@Override
public String toString() {
	return "Member [id=" + id + ", memberType=" + memberType + ", memberGroupName=" + memberGroupName + "]";
}





}

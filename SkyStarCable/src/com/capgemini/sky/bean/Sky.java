//The entity class which acts as a POJO for all the getters and setters.This is the Entity class
package com.capgemini.sky.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@Table(name="SKYCUSTOMERS")
@NamedQuery(name="GetAllData",query="SELECT c FROM Sky c")
public class Sky {
@Id
@Column(name = "CUSTNUM")
private String customerNumber;
@Column(name = "BASEPACK")
private String basePack;
@Column(name = "OPTIONALPACK")
private String optionalPack;
public String getCustomerNumber() {
	return customerNumber;
}
public void setCustomerNumber(String customerNumber) {
	this.customerNumber = customerNumber;
}
public String getBasePack() {
	return basePack;
}
public void setBasePack(String basePack) {
	this.basePack = basePack;
}
public String getOptionalPack() {
	return optionalPack;
}
public void setOptionalPack(String optionalPack) {
	this.optionalPack = optionalPack;
}
public Sky() {
	super();
	// TODO Auto-generated constructor stub
}
public Sky(String customerNumber, String basePack, String optionalPack) {
	super();
	this.customerNumber = customerNumber;
	this.basePack = basePack;
	this.optionalPack = optionalPack;
}
@Override
public String toString() {
	return "Sky [customerNumber=" + customerNumber + ", basePack=" + basePack
			+ ", optionalPack=" + optionalPack + "]";
}
}

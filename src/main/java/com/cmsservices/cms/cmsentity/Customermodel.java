package com.cmsservices.cms.cmsentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customermodel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId ; 
	
	@Column(name = "name")
	private String name ; 
	
	@Column(name = "dob")
	private String dob ;
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public Customermodel() {
		
	}
	public Customermodel(int customerId, String name, String dob) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Customermodel [customerId=" + customerId + ", name=" + name + ", dob=" + dob + ", getCustomerId()="
				+ getCustomerId() + ", getName()=" + getName() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	} 
	
	
}

package com.hibernate.chapter06;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonDetails {

	
	private int persondetailid;
	private int income;
	private String desigination;
	
	@Id
	@GeneratedValue
	public int getPersondetailid() {
		return persondetailid;
	}
	public void setPersondetailid(int persondetailid) {
		this.persondetailid = persondetailid;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getDesigination() {
		return desigination;
	}
	public void setDesigination(String desigination) {
		this.desigination = desigination;
	}
	
	
	
}

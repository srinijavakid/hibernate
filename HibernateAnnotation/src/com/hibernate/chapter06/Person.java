package com.hibernate.chapter06;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Person {
	
	private int perid;
	private String pername;
	private PersonDetails perdet;
	
	@Id
	@GeneratedValue
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getPername() {
		return pername;
	}
	public void setPername(String pername) {
		this.pername = pername;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public PersonDetails getPerdet() {
		return perdet;
	}
	public void setPerdet(PersonDetails perdet) {
		this.perdet = perdet;
	}

}

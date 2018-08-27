package com.hibernate.chapter03;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class School {

	private int schoolId;
	private String schoolname;
	private Schooldetail schooldetails;
	
	
	@Embedded
	public Schooldetail getSchooldetails() {
		return schooldetails;
	}
	public void setSchooldetails(Schooldetail schooldetails) {
		this.schooldetails = schooldetails;
	}
	@Id
	@GeneratedValue
	
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	
	
	
	
}

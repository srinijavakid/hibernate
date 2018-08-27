package com.hibernate.chapter03;

import javax.persistence.Embeddable;


@Embeddable
public class Schooldetail {

private String schooladdress;
private boolean ispublicschool;
private int studentcount;


public String getSchooladdress() {
	return schooladdress;
}
public void setSchooladdress(String schooladdress) {
	this.schooladdress = schooladdress;
}
public boolean isIspublicschool() {
	return ispublicschool;
}
public void setIspublicschool(boolean ispublicschool) {
	this.ispublicschool = ispublicschool;
}
public int getStudentcount() {
	return studentcount;
}
public void setStudentcount(int studentcount) {
	this.studentcount = studentcount;
}



}

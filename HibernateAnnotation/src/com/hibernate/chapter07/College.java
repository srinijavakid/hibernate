package com.hibernate.chapter07;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class College {

	
	private int colid;
	private String colname;
	
	private List<Student> students;
	
	@OneToMany(targetEntity=Student.class,mappedBy="college",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Id
	@GeneratedValue
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	
	
}

package com.hibernate.chapter05;

import javax.persistence.Entity;


@Entity
public class Module extends Project{

	
	private String modulename;

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	
	
}

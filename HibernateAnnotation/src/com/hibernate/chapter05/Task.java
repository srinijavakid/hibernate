package com.hibernate.chapter05;

import javax.persistence.Entity;

@Entity
public class Task extends Module {

	
	private String taskname;

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	
}

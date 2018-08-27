package com.hibernate.chapter05;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project {

	@Id
	@TableGenerator(name="projectid",table="inher",pkColumnName="inher_Id",pkColumnValue="inher_id",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="projectid")
	private int projectid;
	private String projectname;
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
}

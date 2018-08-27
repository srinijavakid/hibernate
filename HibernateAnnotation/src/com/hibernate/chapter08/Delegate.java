package com.hibernate.chapter08;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Delegate {

	
	private int delegateid;
	private String delname;
	private List <Event> event=new ArrayList<Event>();
	
	@Id
	@GeneratedValue
	public int getDelegateid() {
		return delegateid;
	}
	public void setDelegateid(int delegateid) {
		this.delegateid = delegateid;
	}
	public String getDelname() {
		return delname;
	}
	public void setDelname(String delname) {
		this.delname = delname;
	}
	@ManyToMany
	@JoinTable(name="Join_delegate_event",
			joinColumns={@JoinColumn(name="delegateid")},
			inverseJoinColumns={@JoinColumn(name="eventid")})
	public List<Event> getEvent() {
		return event;
	}
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	
	
}

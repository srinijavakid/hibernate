package com.hibernate.chapter08;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Event {

	private int eventid;
	private String evnet;
	private List<Delegate> delegates = new ArrayList<Delegate>();

	@Id
	@GeneratedValue
	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEvnet() {
		return evnet;
	}

	public void setEvnet(String evnet) {
		this.evnet = evnet;
	}

	@ManyToMany
	@JoinTable(name="Join_delegate_event",
			joinColumns={@JoinColumn(name="eventid")},
			inverseJoinColumns={@JoinColumn(name="delegateid")})
	public List<Delegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

}

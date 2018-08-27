package com.hibernate.chapter04;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class CompoundKey implements Serializable {
	
	private int userid;
	private int accid;
	
	public CompoundKey(int userid,int accid){
		this.userid=userid;
		this.accid=accid;
		
	}
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}

}

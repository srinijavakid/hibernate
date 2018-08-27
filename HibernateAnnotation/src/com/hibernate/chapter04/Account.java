package com.hibernate.chapter04;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	private int accbalance;
	
	@Id
	@GeneratedValue
	private CompoundKey comkey;
	
	public int getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(int accbalance) {
		this.accbalance = accbalance;
	}
	public CompoundKey getComkey() {
		return comkey;
	}
	public void setComkey(CompoundKey comkey) {
		this.comkey = comkey;
	}
	
}

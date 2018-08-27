package com.hibernate.chapter01;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="Tutorial")


	public class Tutorial implements Serializable {


		private Integer id;
	    private String shortdesc;
	    private String longdesc;
	    private String pageurl;
	    private Date dateday;
	  
		public Tutorial(Integer id, String shortdesc, String longdesc, String pageurl) {
	        this.id = id;
	        this.shortdesc = shortdesc;
	        this.longdesc = longdesc;
	        this.pageurl = pageurl;
	    }
	    public Tutorial() {
	    }

		@Id
		@TableGenerator(name="ID",table="hibernatekey", pkColumnName="turorial_key",allocationSize=1,pkColumnValue="keyvalue")
		@GeneratedValue(strategy=GenerationType.TABLE,generator="ID")
	    public Integer getId() {
	        return this.id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
@Basic
	    public String getShortdesc() {
	        return this.shortdesc;
	    }

	    public void setShortdesc(String shortdesc) {
	        this.shortdesc = shortdesc;
	    }
@Transient
	    public String getLongdesc() {
	        return this.longdesc;
	    }

	    public void setLongdesc(String longdesc) {
	        this.longdesc = longdesc;
	    }

	    @Column(nullable=false,name="urlpage")
	    public String getPageurl() {
	        return this.pageurl;
	    }

	    public void setPageurl(String pageurl) {
	        this.pageurl = pageurl;
	    }
	    @Temporal(TemporalType.TIME)
	    public Date getDateday() {
			return dateday;
		}
		public void setDateday(Date dateday) {
			this.dateday = dateday;
		}
	}

	
	
	
	


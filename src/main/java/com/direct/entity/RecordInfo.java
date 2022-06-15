package com.direct.entity;

import java.util.Date;

public class RecordInfo {
	private int rid;
	private String information;
	private Date rdate;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public RecordInfo(String information, Date rdate) {
		super();
		this.information = information;
		this.rdate = rdate;
	}
	public RecordInfo() {
		super();
	}
	
}

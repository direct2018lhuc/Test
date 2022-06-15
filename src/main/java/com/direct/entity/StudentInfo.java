package com.direct.entity;

public class StudentInfo {
	private int sid;
	private String sname;
	private String sex;
	private int age;
	private String address;
	private int cid;
	private ClassInfo cinfo;//额外定义外键字段的一个对象属性(关联查询封装数据)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public ClassInfo getCinfo() {
		return cinfo;
	}
	public void setCinfo(ClassInfo cinfo) {
		this.cinfo = cinfo;
	}
	
}

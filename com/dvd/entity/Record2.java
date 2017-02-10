package com.dvd.entity;

public class Record2 {
	private int id;//记录id
	private int did;//DVD id
	private String uname;//用户名
	private String dname;//DVD名字
	private String lendTime;//借出时间
	private String returnTime;//归还时间
	public Record2(String uname, String dname, String lendTime,
			String returnTime) {
		super();
		this.uname = uname;
		this.dname = dname;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLendTime() {
		return lendTime;
	}
	public void setLendTime(String lendTime) {
		this.lendTime = lendTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
}

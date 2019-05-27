package com.orange.web.vo;

public class User {
	
	private int uid;
	private String uname;
	private String password;
	private int identity;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdentity() {
		return identity;
	}
	
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", identity=" + identity + "]";
	}
	
	
	

}

package com.orange.web.vo;

public class Address {
	
	private int uid;
	private String uname;
	private String phone;
	private String addp;
	private String addc;
	private String add;
	private String addd;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddp() {
		return addp;
	}
	public void setAddp(String addp) {
		this.addp = addp;
	}
	public String getAddc() {
		return addc;
	}
	public void setAddc(String addc) {
		this.addc = addc;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getAddd() {
		return addd;
	}
	public void setAddd(String addd) {
		this.addd = addd;
	}
	
	@Override
	public String toString() {
		return "Address [uid=" + uid + ", uname=" + uname + ", phone=" + phone + ", addp=" + addp + ", addc=" + addc
				+ ", add=" + add + ", addd=" + addd + "]";
	}
	
	

}

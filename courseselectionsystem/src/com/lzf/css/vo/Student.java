package com.lzf.css.vo;

public class Student {
	
	private String sid;
	private String skey;
	private String sname;
	private String ssex;
	private int sage;
	private double scredit;
	private String saddress;
	private String sphone;
	private String semail;
	private String sbrithday;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public double getScredit() {
		return scredit;
	}
	public void setScredit(double scredit) {
		this.scredit = scredit;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSbrithday() {
		return sbrithday;
	}
	public void setSbrithday(String sbrithday) {
		this.sbrithday = sbrithday;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", skey=" + skey + ", sname=" + sname + ", ssex=" + ssex + ", sage=" + sage
				+ ", scredit=" + scredit + ", saddress=" + saddress + ", sphone=" + sphone + ", semail=" + semail
				+ ", sbrithday=" + sbrithday + "]";
	}
	
}

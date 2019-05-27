package com.lzf.css.vo;

public class Teacher {

	private String tid;
	private String tkey;
	private String tname;
	private String tsex;
	private int tage;
	private String tphone;
	private String temail;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTkey() {
		return tkey;
	}
	public void setTkey(String tkey) {
		this.tkey = tkey;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tkey=" + tkey + ", tname=" + tname + ", tsex=" + tsex + ", tage=" + tage
				+ ", tphone=" + tphone + ", temail=" + temail + "]";
	}
	
}

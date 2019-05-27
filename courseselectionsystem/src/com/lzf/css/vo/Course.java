package com.lzf.css.vo;

import java.util.List;

public class Course {
	
	private int cid;
	private String tid;
	private String cname;
	private String ctype;
	private double ccredit;
	private int cmax;
	private String cnote;
	private int cprecid;
	private String ctime;
	private String croom;
	// course --> teacher 一对一(course为主表)
	private Teacher teac;
	// course --> elect 一对多(course为主表)  
	private List<Elect> elect;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public double getCcredit() {
		return ccredit;
	}
	public void setCcredit(double ccredit) {
		this.ccredit = ccredit;
	}
	public int getCmax() {
		return cmax;
	}
	public void setCmax(int cmax) {
		this.cmax = cmax;
	}
	public String getCnote() {
		return cnote;
	}
	public void setCnote(String cnote) {
		this.cnote = cnote;
	}
	public int getCprecid() {
		return cprecid;
	}
	public void setCprecid(int cprecid) {
		this.cprecid = cprecid;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCroom() {
		return croom;
	}
	public void setCroom(String croom) {
		this.croom = croom;
	}
	public Teacher getTeac() {
		return teac;
	}
	public void setTeac(Teacher teac) {
		this.teac = teac;
	}
	public List<Elect> getElect() {
		return elect;
	}
	public void setElect(List<Elect> elect) {
		this.elect = elect;
	}
	
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", tid=" + tid + ", cname=" + cname + ", ctype=" + ctype + ", ccredit=" + ccredit
				+ ", cmax=" + cmax + ", cnote=" + cnote + ", cprecid=" + cprecid + ", ctime=" + ctime + ", croom="
				+ croom + ", teac=" + teac + ", elect=" + elect + "]";
	}
	
	

}

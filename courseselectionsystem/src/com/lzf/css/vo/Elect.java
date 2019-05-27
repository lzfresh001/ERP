package com.lzf.css.vo;

public class Elect {
	
	private String sid;
	private int cid;
	private double score;
	private double credit;
	// elect --> course 一对一
	private Course cour;
	// elect --> student 一对一
	private Student stu;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Course getCour() {
		return cour;
	}
	public void setCour(Course cour) {
		this.cour = cour;
	}
	@Override
	public String toString() {
		return "Elect [sid=" + sid + ", cid=" + cid + ", score=" + score + ", credit=" + credit + ", cour=" + cour
				+ ", stu=" + stu + "]";
	}
	
	

}

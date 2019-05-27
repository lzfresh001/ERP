package com.lzf.css.vo;

public class QueryVo {
	
	private Academic acad;
	private Course cour;
	private Elect elect;
	private Student stu;
	private Teacher teac;
	
	public Academic getAcad() {
		return acad;
	}
	public void setAcad(Academic acad) {
		this.acad = acad;
	}
	public Course getCour() {
		return cour;
	}
	public void setCour(Course cour) {
		this.cour = cour;
	}
	public Elect getElect() {
		return elect;
	}
	public void setElect(Elect elect) {
		this.elect = elect;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Teacher getTeac() {
		return teac;
	}
	public void setTeac(Teacher teac) {
		this.teac = teac;
	}
	
	@Override
	public String toString() {
		return "QueryVo [acad=" + acad + ", cour=" + cour + ", elect=" + elect + ", stu=" + stu + ", teac=" + teac
				+ "]";
	}
	

}

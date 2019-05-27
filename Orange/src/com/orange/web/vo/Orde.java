package com.orange.web.vo;

public class Orde {
	
	private int uid;
	private int id;
	private String name;
	private String srcs;
	private double price;
	private int num;
	private String place;
	private String dno;
	private String date;
	private String state;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrcs() {
		return srcs;
	}
	public void setSrcs(String srcs) {
		this.srcs = srcs;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Orde [uid=" + uid + ", id=" + id + ", name=" + name + ", srcs=" + srcs + ", price=" + price + ", num="
				+ num + ", place=" + place + ", dno=" + dno + ", date=" + date + ", state=" + state + "]";
	}
	

}

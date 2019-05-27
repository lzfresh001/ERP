package com.orange.web.vo;

public class Shopcart {
	
	private int id;
	private String name;
	private String src;
	private String srcs;
	private String place;
	private double price;
	private int num;
	private int state;
	
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getSrcs() {
		return srcs;
	}
	public void setSrcs(String srcs) {
		this.srcs = srcs;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Shopcart [id=" + id + ", name=" + name + ", src=" + src + ", srcs=" + srcs + ", place=" + place
				+ ", price=" + price + ", num=" + num + ", state=" + state + "]";
	}
	
	
	
	
}

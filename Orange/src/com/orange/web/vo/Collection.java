package com.orange.web.vo;

public class Collection {
	
	private int uid;
	private int id;
	private String src;
	private String name;
	private String weight;
	private double price;
	
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Collection [uid=" + uid + ", id=" + id + ", src=" + src + ", name=" + name + ", weight=" + weight
				+ ", price=" + price + "]";
	}
	
	
	

}

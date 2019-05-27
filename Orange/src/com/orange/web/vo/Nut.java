package com.orange.web.vo;

public class Nut {
	
	private int id;
	private String name;
	private int count;
	private String srcs;
	private String src;
	private String srcc;
	private String srccc;
	private String srca;
	private String srcb;
	private String srcd;
	private String weight;
	private String plno;
	private String exdate;
	private String date;
	private double price;
	private String brand;
	private String place;
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSrcs() {
		return srcs;
	}
	public void setSrcs(String srcs) {
		this.srcs = srcs;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getSrcc() {
		return srcc;
	}
	public void setSrcc(String srcc) {
		this.srcc = srcc;
	}
	public String getSrccc() {
		return srccc;
	}
	public void setSrccc(String srccc) {
		this.srccc = srccc;
	}
	public String getSrca() {
		return srca;
	}
	public void setSrca(String srca) {
		this.srca = srca;
	}
	public String getSrcb() {
		return srcb;
	}
	public void setSrcb(String srcb) {
		this.srcb = srcb;
	}
	public String getSrcd() {
		return srcd;
	}
	public void setSrcd(String srcd) {
		this.srcd = srcd;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPlno() {
		return plno;
	}
	public void setPlno(String plno) {
		this.plno = plno;
	}
	public String getExdate() {
		return exdate;
	}
	public void setExdate(String exdate) {
		this.exdate = exdate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "Nut [id=" + id + ", name=" + name + ", count=" + count + ", srcs=" + srcs + ", src=" + src + ", srcc="
				+ srcc + ", srccc=" + srccc + ", srca=" + srca + ", srcb=" + srcb + ", srcd=" + srcd + ", weight="
				+ weight + ", plno=" + plno + ", exdate=" + exdate + ", date=" + date + ", price=" + price + ", brand="
				+ brand + ", place=" + place + "]";
	}
	
}

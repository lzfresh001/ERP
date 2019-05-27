package com.lzf.css.vo;

public class Academic {
	
	private String aid;
	private String akey;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAkey() {
		return akey;
	}
	public void setAkey(String akey) {
		this.akey = akey;
	}
	
	@Override
	public String toString() {
		return "Academic [aid=" + aid + ", akey=" + akey + "]";
	}
	

}

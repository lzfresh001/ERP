package com.lzf.erp.model;

import java.util.List;

/**
 * @comment 数据字典主表实体类
 * @filename WorkBook.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午9:23:21
 * @version 1.0
 */
public class WorkBook {
	
	private Integer wid;          // 数据字典主表id
	private String wname;         // 数据字典主表名称
	private Integer delflag;      // 数据字典主表删除标记  1 表示未删除   0 表示已删除
	private String remark;        // 数据字典主表备注
	private String currentTime;   // 数据字典主表创建时间
	private String updateTime;    // 数据字典主表更新时间
	private String optionPerson;  // 数据字典主表操作人
	
	private List<WorkBookDetail> workBookDetail; //数据字典明细表数据(一对多)
	
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getOptionPerson() {
		return optionPerson;
	}
	public void setOptionPerson(String optionPerson) {
		this.optionPerson = optionPerson;
	}
	public List<WorkBookDetail> getWorkBookDetail() {
		return workBookDetail;
	}
	public void setWorkBookDetail(List<WorkBookDetail> workBookDetail) {
		this.workBookDetail = workBookDetail;
	}
	@Override
	public String toString() {
		return "WorkBook [wid=" + wid + ", wname=" + wname + ", delflag=" + delflag + ", remark=" + remark
				+ ", currentTime=" + currentTime + ", updateTime=" + updateTime + ", optionPerson=" + optionPerson
				+ ", workBookDetail=" + workBookDetail + "]";
	}
	
}

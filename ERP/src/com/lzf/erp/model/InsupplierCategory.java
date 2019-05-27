package com.lzf.erp.model;

/**@文件名: Insuppliercategory.java
 * @类功能说明: 供应商类别实现类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月11日下午2:15:07
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月11日下午2:15:07</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InsupplierCategory {
	
	private Integer inscid;	//供应商类别id
	private String	insccode;	//供应商类别编码
	private String inscname;	//供应商类别名称
	private String remark;	//供应商类别备注
	private int state;	//供应商类别状态
	private int delflag;	//供应商类别删除标记
	private String optid;	// 操作人id
	private String optname;	//操作人姓名
	private int optdeptid;	//操作人部门id
	private int optorgid;	//操作人机构id
	private String currdate;	//业务发生时间
	
	public Integer getInscid() {
		return inscid;
	}
	public void setInscid(Integer inscid) {
		this.inscid = inscid;
	}
	public String getInsccode() {
		return insccode;
	}
	public void setInsccode(String insccode) {
		this.insccode = insccode;
	}
	public String getInscname() {
		return inscname;
	}
	public void setInscname(String inscname) {
		this.inscname = inscname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public String getOptid() {
		return optid;
	}
	public void setOptid(String optid) {
		this.optid = optid;
	}
	public String getOptname() {
		return optname;
	}
	public void setOptname(String optname) {
		this.optname = optname;
	}
	public int getOptdeptid() {
		return optdeptid;
	}
	public void setOptdeptid(int optdeptid) {
		this.optdeptid = optdeptid;
	}
	public int getOptorgid() {
		return optorgid;
	}
	public void setOptorgid(int optorgid) {
		this.optorgid = optorgid;
	}
	public String getCurrdate() {
		return currdate;
	}
	public void setCurrdate(String currdate) {
		this.currdate = currdate;
	}
	
	
}

package com.lzf.erp.model;

import java.util.List;

/**@文件名: Insupplierinfo.java
 * @类功能说明:  供应商实现类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月11日下午1:50:47
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月11日下午1:50:47</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InsupplierInfo {

	private Integer insiid; //供应商id
	private String insicode; //供应商编码
	private String insiname; //供应商名称
	private int inscid;	//供应商类型id
	private String inscname;//供应商类型名称
	private int inslid;	//供应商星际id
	private String inslname;//供应商星级名称
	private int insaid;	//供应商区域id
	private String insaname;//供应区域名
	private String insiaddress;	//供应商地址
	private String insiphone;	//供应商联系电话
	private String insilicense;	//供应商营业执照
	private String insipermitlicense;	//供应商经营许可证
	private String insilegalman;	//供应商法人
	private String insitaxnum;	//供应商序号
	private String insibank;	//供应商开户行
	private String insibankaccount;	//供应商开户行账号
	private String remark;	//备注
	private int state;	//状态
	private int delflag;	//删除标记
	private String optid;	//操作人id
	private String optname;	//操作人姓名
	private Integer optdeptid;	//操作人部门id
	private Integer optorgid;	//操作人机构id
	private String currdate;	//业务发生时间
	private List<InsupplierLinkMan> insupplierLinkmans; //管理供应商联系人字段
	
	
	
	public Integer getInsiid() {
		return insiid;
	}



	public void setInsiid(Integer insiid) {
		this.insiid = insiid;
	}



	public String getInsicode() {
		return insicode;
	}



	public void setInsicode(String insicode) {
		this.insicode = insicode;
	}



	public String getInsiname() {
		return insiname;
	}



	public void setInsiname(String insiname) {
		this.insiname = insiname;
	}



	public int getInscid() {
		return inscid;
	}



	public void setInscid(int inscid) {
		this.inscid = inscid;
	}



	public String getInscname() {
		return inscname;
	}



	public void setInscname(String inscname) {
		this.inscname = inscname;
	}



	public int getInslid() {
		return inslid;
	}



	public void setInslid(int inslid) {
		this.inslid = inslid;
	}



	public String getInslname() {
		return inslname;
	}



	public void setInslname(String inslname) {
		this.inslname = inslname;
	}



	public int getInsaid() {
		return insaid;
	}



	public void setInsaid(int insaid) {
		this.insaid = insaid;
	}



	public String getInsaname() {
		return insaname;
	}



	public void setInsaname(String insaname) {
		this.insaname = insaname;
	}



	public String getInsiaddress() {
		return insiaddress;
	}



	public void setInsiaddress(String insiaddress) {
		this.insiaddress = insiaddress;
	}



	public String getInsiphone() {
		return insiphone;
	}



	public void setInsiphone(String insiphone) {
		this.insiphone = insiphone;
	}



	public String getInsilicense() {
		return insilicense;
	}



	public void setInsilicense(String insilicense) {
		this.insilicense = insilicense;
	}



	public String getInsipermitlicense() {
		return insipermitlicense;
	}



	public void setInsipermitlicense(String insipermitlicense) {
		this.insipermitlicense = insipermitlicense;
	}



	public String getInsilegalman() {
		return insilegalman;
	}



	public void setInsilegalman(String insilegalman) {
		this.insilegalman = insilegalman;
	}



	public String getInsitaxnum() {
		return insitaxnum;
	}



	public void setInsitaxnum(String insitaxnum) {
		this.insitaxnum = insitaxnum;
	}



	public String getInsibank() {
		return insibank;
	}



	public void setInsibank(String insibank) {
		this.insibank = insibank;
	}



	public String getInsibankaccount() {
		return insibankaccount;
	}



	public void setInsibankaccount(String insibankaccount) {
		this.insibankaccount = insibankaccount;
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



	public Integer getOptdeptid() {
		return optdeptid;
	}



	public void setOptdeptid(Integer optdeptid) {
		this.optdeptid = optdeptid;
	}



	public Integer getOptorgid() {
		return optorgid;
	}



	public void setOptorgid(Integer optorgid) {
		this.optorgid = optorgid;
	}



	public String getCurrdate() {
		return currdate;
	}



	public void setCurrdate(String currdate) {
		this.currdate = currdate;
	}



	public List<InsupplierLinkMan> getInsupplierLinkmans() {
		return insupplierLinkmans;
	}



	public void setInsupplierLinkmans(List<InsupplierLinkMan> insupplierLinkmans) {
		this.insupplierLinkmans = insupplierLinkmans;
	}



	

	
	
	
	
	
	
	
}

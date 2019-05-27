package com.lzf.erp.model;

/**@文件名: Insupplierlinkman.java
 * @类功能说明: 供应商联系人实现类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月11日下午2:12:48
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月11日下午2:12:48</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InsupplierLinkMan {
	
	private Integer inslmid;	//供应商联系人id
	private String inslmcode;	//供应商联系人编码
	private Integer insiid;	//供应商id
	private String inslmname;	//供应商联系人姓名
	private String inslmphone;	//供应商联系人电话
	private String remark;	//备注
	private int state;	//状态
	private int delflag;	//删除标记
	public Integer getInslmid() {
		return inslmid;
	}
	public void setInslmid(Integer inslmid) {
		this.inslmid = inslmid;
	}
	public String getInslmcode() {
		return inslmcode;
	}
	public void setInslmcode(String inslmcode) {
		this.inslmcode = inslmcode;
	}
	public Integer getInsiid() {
		return insiid;
	}
	public void setInsiid(Integer insiid) {
		this.insiid = insiid;
	}
	public String getInslmname() {
		return inslmname;
	}
	public void setInslmname(String inslmname) {
		this.inslmname = inslmname;
	}
	public String getInslmphone() {
		return inslmphone;
	}
	public void setInslmphone(String inslmphone) {
		this.inslmphone = inslmphone;
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
	
	
}

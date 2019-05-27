package com.lzf.erp.model;

import java.util.List;

/**@文件名: InBuyContract.java
 * @类功能说明: 合同实体类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日上午9:28:43
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日上午9:28:43</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InBuyContract {

	private Integer inbcid;	//合同id
	private String inbccode;	//合同编码
	private String inbcname;	//合同名称
	private Integer insiid;	//供货商id
	private String insiname; //供应商名称 关联供应商表
	private Integer busiid;	//合同签订人id
	private String businame;	//合同签订人姓名
	private Integer busideptid;		//合同签订人部门
	private Integer busiorgid;	//合同签订人机构
	private String inbcdate;		//合同签订时间
	private String inbccontent;		//合同内容
	private Integer inbtid;		//采购类型id
	private String inbtname;	//采购名称 关联名称表
	private double inbctotalprice;	//采购合同总价
	private double inbcofferprice;	//采购合同优惠金额
	private double inbcactualprice;	//采购合同实价
	private double inbcadvancemoney;	//预付款金额
	private Integer intwid;	//采购合同运输方式id
	private String intwiname;	//运输方式名称
	private Integer indwid;	//采购合同交货方式id
	private String indwname;	//交货方式名称
	private String inbcdeliverydate;	//预计交货时间
	private String inbcdeliveryaddress;	//交货地点
	private Integer inbcstate;	//完成状态
	private Integer inbcpaystate;	//已付款
	private Integer inbcbillstate;	//已开票
	private String remark;	//备注
	private Integer wkexid;	//流程实例id
	private String approvalview;	//审批意见
	private Integer state;	//状态
	private Integer delflag;	//删除标记
	private Integer optid;		//操作人id
	private String optname;		//操作人姓名
	private Integer optdeptid;	//操作人部门id
	private Integer optorgid;	//操作人机构id
	private String currdate;	//业务发生时间
	private List<InBuyContractDetail> inBuyContractDetails; //合同明细表详情
	
	
	public String getIntwiname() {
		return intwiname;
	}
	public void setIntwiname(String intwiname) {
		this.intwiname = intwiname;
	}
	public String getIndwname() {
		return indwname;
	}
	public void setIndwname(String indwname) {
		this.indwname = indwname;
	}
	public String getInsiname() {
		return insiname;
	}
	public void setInsiname(String insiname) {
		this.insiname = insiname;
	}
	public String getInbtname() {
		return inbtname;
	}
	public void setInbtname(String inbtname) {
		this.inbtname = inbtname;
	}
	public Integer getInbcid() {
		return inbcid;
	}
	public void setInbcid(Integer inbcid) {
		this.inbcid = inbcid;
	}
	public String getInbccode() {
		return inbccode;
	}
	public void setInbccode(String inbccode) {
		this.inbccode = inbccode;
	}
	public String getInbcname() {
		return inbcname;
	}
	public void setInbcname(String inbcname) {
		this.inbcname = inbcname;
	}
	public Integer getInsiid() {
		return insiid;
	}
	public void setInsiid(Integer insiid) {
		this.insiid = insiid;
	}
	public Integer getBusiid() {
		return busiid;
	}
	public void setBusiid(Integer busiid) {
		this.busiid = busiid;
	}
	public String getBusiname() {
		return businame;
	}
	public void setBusiname(String businame) {
		this.businame = businame;
	}
	public Integer getBusideptid() {
		return busideptid;
	}
	public void setBusideptid(Integer busideptid) {
		this.busideptid = busideptid;
	}
	public Integer getBusiorgid() {
		return busiorgid;
	}
	public void setBusiorgid(Integer busiorgid) {
		this.busiorgid = busiorgid;
	}
	public String getInbcdate() {
		return inbcdate;
	}
	public void setInbcdate(String inbcdate) {
		this.inbcdate = inbcdate;
	}
	public String getInbccontent() {
		return inbccontent;
	}
	public void setInbccontent(String inbccontent) {
		this.inbccontent = inbccontent;
	}
	public Integer getInbtid() {
		return inbtid;
	}
	public void setInbtid(Integer inbtid) {
		this.inbtid = inbtid;
	}
	public double getInbctotalprice() {
		return inbctotalprice;
	}
	public void setInbctotalprice(double inbctotalprice) {
		this.inbctotalprice = inbctotalprice;
	}
	public double getInbcofferprice() {
		return inbcofferprice;
	}
	public void setInbcofferprice(double inbcofferprice) {
		this.inbcofferprice = inbcofferprice;
	}
	public double getInbcactualprice() {
		return inbcactualprice;
	}
	public void setInbcactualprice(double inbcactualprice) {
		this.inbcactualprice = inbcactualprice;
	}
	public double getInbcadvancemoney() {
		return inbcadvancemoney;
	}
	public void setInbcadvancemoney(double inbcadvancemoney) {
		this.inbcadvancemoney = inbcadvancemoney;
	}
	public Integer getIntwid() {
		return intwid;
	}
	public void setIntwid(Integer intwid) {
		this.intwid = intwid;
	}
	public Integer getIndwid() {
		return indwid;
	}
	public void setIndwid(Integer indwid) {
		this.indwid = indwid;
	}
	public String getInbcdeliverydate() {
		return inbcdeliverydate;
	}
	public void setInbcdeliverydate(String inbcdeliverydate) {
		this.inbcdeliverydate = inbcdeliverydate;
	}
	public String getInbcdeliveryaddress() {
		return inbcdeliveryaddress;
	}
	public void setInbcdeliveryaddress(String inbcdeliveryaddress) {
		this.inbcdeliveryaddress = inbcdeliveryaddress;
	}
	public Integer getInbcstate() {
		return inbcstate;
	}
	public void setInbcstate(Integer inbcstate) {
		this.inbcstate = inbcstate;
	}
	public Integer getInbcpaystate() {
		return inbcpaystate;
	}
	public void setInbcpaystate(Integer inbcpaystate) {
		this.inbcpaystate = inbcpaystate;
	}
	public Integer getInbcbillstate() {
		return inbcbillstate;
	}
	public void setInbcbillstate(Integer inbcbillstate) {
		this.inbcbillstate = inbcbillstate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getWkexid() {
		return wkexid;
	}
	public void setWkexid(Integer wkexid) {
		this.wkexid = wkexid;
	}
	public String getApprovalview() {
		return approvalview;
	}
	public void setApprovalview(String approvalview) {
		this.approvalview = approvalview;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	public Integer getOptid() {
		return optid;
	}
	public void setOptid(Integer optid) {
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
	public List<InBuyContractDetail> getInBuyContractDetails() {
		return inBuyContractDetails;
	}
	public void setInBuyContractDetails(List<InBuyContractDetail> inBuyContractDetails) {
		this.inBuyContractDetails = inBuyContractDetails;
	}
	
	
}

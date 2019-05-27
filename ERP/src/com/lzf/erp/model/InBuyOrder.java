package com.lzf.erp.model;

import java.util.List;

/**@文件名: InBuyOrder.java
 * @类功能说明: 订单实体类
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
public class InBuyOrder {

	private Integer inboid;	//订单id
	private String inbocode;	//订单编码
	private String inboname;	//订单名称
	private Integer insiid;	//供货商id
	private String insiname; //供应商名称 关联供应商表
	private Integer busiid;	//订单签订人id
	private String businame;	//订单签订人姓名
	private Integer busideptid;		//订单签订人部门
	private Integer busiorgid;	//订单签订人机构
	private String inbodate;		//订单签订时间
	private double inbototalprice;	//采购订单总价
	private double inboofferprice;	//采购订单优惠金额
	private double inboactualprice;	//采购订单实价
	private Integer intwid;	//采购订单运输方式id
	private String intwiname;	//运输方式名称
	private Integer indwid;	//采购订单交货方式id
	private String indwname;	//交货方式名称
	private String inbodeliverydate;	//预计交货时间
	private String inbodeliveryaddress;	//交货地点
	private Integer inbostate;	//完成状态
	private Integer inbopaystate;	//已付款
	private Integer inbobillstate;	//已开票
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
	private List<InBuyOrderDetail> inBuyOrderDetails; //订单明细表详情
	
	
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

	public Integer getInboid() {
		return inboid;
	}
	public void setInboid(Integer inboid) {
		this.inboid = inboid;
	}
	public String getInbocode() {
		return inbocode;
	}
	public void setInbocode(String inbocode) {
		this.inbocode = inbocode;
	}
	public String getInboname() {
		return inboname;
	}
	public void setInboname(String inboname) {
		this.inboname = inboname;
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
	public String getInbodate() {
		return inbodate;
	}
	public void setInbodate(String inbodate) {
		this.inbodate = inbodate;
	}
	
	public double getInbototalprice() {
		return inbototalprice;
	}
	public void setInbototalprice(double inbototalprice) {
		this.inbototalprice = inbototalprice;
	}
	public double getInboofferprice() {
		return inboofferprice;
	}
	public void setInboofferprice(double inboofferprice) {
		this.inboofferprice = inboofferprice;
	}
	public double getInboactualprice() {
		return inboactualprice;
	}
	public void setInboactualprice(double inboactualprice) {
		this.inboactualprice = inboactualprice;
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
	public String getInbodeliverydate() {
		return inbodeliverydate;
	}
	public void setInbodeliverydate(String inbodeliverydate) {
		this.inbodeliverydate = inbodeliverydate;
	}
	public String getInbodeliveryaddress() {
		return inbodeliveryaddress;
	}
	public void setInbodeliveryaddress(String inbodeliveryaddress) {
		this.inbodeliveryaddress = inbodeliveryaddress;
	}
	public Integer getInbostate() {
		return inbostate;
	}
	public void setInbostate(Integer inbostate) {
		this.inbostate = inbostate;
	}
	public Integer getInbopaystate() {
		return inbopaystate;
	}
	public void setInbopaystate(Integer inbopaystate) {
		this.inbopaystate = inbopaystate;
	}
	public Integer getInbobillstate() {
		return inbobillstate;
	}
	public void setInbobillstate(Integer inbobillstate) {
		this.inbobillstate = inbobillstate;
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
	public List<InBuyOrderDetail> getInBuyOrderDetails() {
		return inBuyOrderDetails;
	}
	public void setInBuyOrderDetails(List<InBuyOrderDetail> inBuyOrderDetails) {
		this.inBuyOrderDetails = inBuyOrderDetails;
	}
	
	
	
}

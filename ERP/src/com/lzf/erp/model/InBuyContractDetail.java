package com.lzf.erp.model;

/**@文件名: InBuyContractDetail.java
 * @类功能说明: 合同明细表实体类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日上午9:48:27
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日上午9:48:27</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InBuyContractDetail {
	
	private Integer inbcdid;	//合同明细id
	private Integer inbaid;		//采购申请id
	private Integer inbadid;	//采购申请明细id
	private Integer inbcid;		//采购合同id
	private Integer insiid;	//供货商id
	private Integer ingiid;	//物品id
	private String inginame;
	private double myprice;	//单价
	private Integer mycou;	//数量
	private double mymoney;	//总价
	private Integer usecou;	//引用数
	private double taxprice;	//含税单价
	private double taxmoney;	//含税金额
	private double invoicesmoney;	//开票金额
	private Integer paymoney;	//付款金额
	private String remark;	//备注
	private Integer state;	//状态
	private Integer delflag;	//删除标志
	private InGoodsInfo inGoodsInfo;//关联商品表
	
	
	public String getInginame() {
		return inginame;
	}
	public void setInginame(String inginame) {
		this.inginame = inginame;
	}
	public InGoodsInfo getInGoodsInfo() {
		return inGoodsInfo;
	}
	public void setInGoodsInfo(InGoodsInfo inGoodsInfo) {
		this.inGoodsInfo = inGoodsInfo;
	}
	public Integer getInbcdid() {
		return inbcdid;
	}
	public void setInbcdid(Integer inbcdid) {
		this.inbcdid = inbcdid;
	}
	public Integer getInbaid() {
		return inbaid;
	}
	public void setInbaid(Integer inbaid) {
		this.inbaid = inbaid;
	}
	public Integer getInbadid() {
		return inbadid;
	}
	public void setInbadid(Integer inbadid) {
		this.inbadid = inbadid;
	}
	public Integer getInbcid() {
		return inbcid;
	}
	public void setInbcid(Integer inbcid) {
		this.inbcid = inbcid;
	}
	public Integer getInsiid() {
		return insiid;
	}
	public void setInsiid(Integer insiid) {
		this.insiid = insiid;
	}
	public Integer getIngiid() {
		return ingiid;
	}
	public void setIngiid(Integer ingiid) {
		this.ingiid = ingiid;
	}
	public double getMyprice() {
		return myprice;
	}
	public void setMyprice(double myprice) {
		this.myprice = myprice;
	}
	public Integer getMycou() {
		return mycou;
	}
	public void setMycou(Integer mycou) {
		this.mycou = mycou;
	}
	public double getMymoney() {
		return mymoney;
	}
	public void setMymoney(double mymoney) {
		this.mymoney = mymoney;
	}
	public Integer getUsecou() {
		return usecou;
	}
	public void setUsecou(Integer usecou) {
		this.usecou = usecou;
	}
	public double getTaxprice() {
		return taxprice;
	}
	public void setTaxprice(double taxprice) {
		this.taxprice = taxprice;
	}
	public double getTaxmoney() {
		return taxmoney;
	}
	public void setTaxmoney(double taxmoney) {
		this.taxmoney = taxmoney;
	}
	public double getInvoicesmoney() {
		return invoicesmoney;
	}
	public void setInvoicesmoney(double invoicesmoney) {
		this.invoicesmoney = invoicesmoney;
	}
	public Integer getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(Integer paymoney) {
		this.paymoney = paymoney;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}

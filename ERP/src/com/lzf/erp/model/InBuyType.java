package com.lzf.erp.model;


/**@文件名: InBuyType.java
 * @类功能说明: 采购类型实体类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日上午10:56:44
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日上午10:56:44</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InBuyType {

	private Integer inbtid; // 采购类型id

    private String inbtcode; // 采购类型编码

    private String inbtname; // 采购类型名称

    private Integer inbthandleid; // 采购类型处理id

    private String remark; // 备注

    private Integer state; // 状态

    private Integer delflag; // 删除标记

    private Integer optid; // 操作人id

    private String optname; // 操作人姓名

    private Integer optdeptid; // 操作人部门id

    private Integer optorgid; // 操作人机构id

    private String currdate; // 业务发生时间

    public Integer getInbtid() {
        return inbtid;
    }

    public void setInbtid(Integer inbtid) {
        this.inbtid = inbtid;
    }

    public String getInbtcode() {
        return inbtcode;
    }

    public void setInbtcode(String inbtcode) {
        this.inbtcode = inbtcode == null ? null : inbtcode.trim();
    }

    public String getInbtname() {
        return inbtname;
    }

    public void setInbtname(String inbtname) {
        this.inbtname = inbtname == null ? null : inbtname.trim();
    }

    public Integer getInbthandleid() {
        return inbthandleid;
    }

    public void setInbthandleid(Integer inbthandleid) {
        this.inbthandleid = inbthandleid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        this.optname = optname == null ? null : optname.trim();
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

}

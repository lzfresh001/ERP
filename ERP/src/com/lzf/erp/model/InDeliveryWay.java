package com.lzf.erp.model;


/**@文件名: InDeliveryWay.java
 * @类功能说明: 交货方式实体类
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
public class InDeliveryWay {

	private Integer indwid; // 交货方式id

    private String indwname; // 交货方式编码

    private String indwcode; // 交货方式名称

    private String remark; // 备注

    private Integer state; // 状态

    private Integer delflag; // 删除标记

    private Integer optid; // 操作人id

    private String optname; // 操作人姓名

    private Integer optdeptid; // 操作人部门id

    private Integer optorgid; // 操作人机构id

    private String currdate; // 业务发生时间

   

    public Integer getIndwid() {
		return indwid;
	}

	public void setIndwid(Integer indwid) {
		this.indwid = indwid;
	}

	public String getIndwname() {
		return indwname;
	}

	public void setIndwname(String indwname) {
		this.indwname = indwname;
	}

	public String getIndwcode() {
		return indwcode;
	}

	public void setIndwcode(String indwcode) {
		this.indwcode = indwcode;
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

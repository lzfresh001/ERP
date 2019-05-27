package com.lzf.erp.model;

import java.util.Date;

/**@文件名: InGoodsCategory.java
 * @类功能说明: 商品类别实体类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午12:38:48
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午12:38:48</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InGoodsCategory {
	
	private Integer ingcid;  // 物品类别id

    private String ingccode;  // 物品类别编码

    private String ingcname; // 物品类别名称

    private String remark;  // 备注

    private Integer state;  // 状态

    private Integer delflag;  // 删除标志

    private Integer optid;  // 操作人id

    private String optname;  // 操作人姓名

    private Integer optdeptid;  // 操作人部门id
 
    private Integer optorgid;  // 操作人机构id

    private String currdate;  // 业务发生时间

    public Integer getIngcid() {
        return ingcid;
    }

    public void setIngcid(Integer ingcid) {
        this.ingcid = ingcid;
    }

    public String getIngccode() {
        return ingccode;
    }

    public void setIngccode(String ingccode) {
        this.ingccode = ingccode == null ? null : ingccode.trim();
    }

    public String getIngcname() {
        return ingcname;
    }

    public void setIngcname(String ingcname) {
        this.ingcname = ingcname == null ? null : ingcname.trim();
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

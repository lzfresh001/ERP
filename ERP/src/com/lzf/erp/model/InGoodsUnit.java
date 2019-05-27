package com.lzf.erp.model;

import java.util.Date;

/**@文件名: InGoodsUnit.java
 * @类功能说明: 商品单位实体类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午1:06:25
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午1:06:25</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class InGoodsUnit {
	
	private Integer inguid; // 物品单位id

    private String ingucode; // 物品单位编码

    private String inguname; // 物品单位名称

    private String optid; // 操作人id

    private Integer optdeptid; // 操作人部门id

    private Integer optorgid; // 操作人机构id

    private String optname; // 操作人姓名

    private Integer state; // 状态

    private Integer delflag; // 删除标志

    private String remark; // 备注

    private Date currdate; // 业务发生时间

    public Integer getInguid() {
        return inguid;
    }

    public void setInguid(Integer inguid) {
        this.inguid = inguid;
    }

    public String getIngucode() {
        return ingucode;
    }

    public void setIngucode(String ingucode) {
        this.ingucode = ingucode == null ? null : ingucode.trim();
    }

    public String getInguname() {
        return inguname;
    }

    public void setInguname(String inguname) {
        this.inguname = inguname == null ? null : inguname.trim();
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid == null ? null : optid.trim();
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

    public String getOptname() {
        return optname;
    }

    public void setOptname(String optname) {
        this.optname = optname == null ? null : optname.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCurrdate() {
        return currdate;
    }

    public void setCurrdate(Date currdate) {
        this.currdate = currdate;
    }

}

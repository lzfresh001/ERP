package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InBuyApply;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InBuyApplyService.java
 * @类功能说明: 采购申请主表Service接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日上午11:20:06
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日上午11:20:06</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InBuyApplyService {
	
	// 全查inbuyapply表 
	public JSONArray queryAllInBuyApply(Map<String,Object> map);
	
	// 查询inbuyapply表条数
	public Integer queryInBuyApplyCount(Map<String,Object> map);
	
	// 添加inbuyapply表及其对应子表
	public Integer addInBuyApply(InBuyApply inBuyApply,User user);
	
	// 逻辑删除inbuyapply表及其对应子表
	public Integer deleteInBuyApply(Integer inbaid);
	
	// 修改inbuyapply表及其对应子表
	public Integer updateInBuyApply(InBuyApply inBuyApply);
	
	// 修改wkexid为1
	public Integer updateWkexidForSubmit(Integer inbaid);
	
	// 查询已提交的inbuyapply表数据
	public JSONArray querySubmitedInBuyApply(Map<String,Object> map);
	
	// 申请驳回修改inbuyapply表数据
	public Integer updateInBuyApplyForRejected(InBuyApply inBuyApply);
	
	// 申请通过修改inbuyapply表数据
	public Integer updateInBuyApplyForThrough(InBuyApply inBuyApply);
	
	// 查询inbuyapply表数据申请统计用
	public JSONArray queryInBuyApplyForStatistical(Map<String,Object> map);
	
	// 查询inbuyapply表总条数申请统计用
	public Integer queryInBuyApplyCountForStatistical(Map<String,Object> map);
	
	// 查询通过审核、不是直接采购的申请信息
	public JSONArray queryInBuyApplyForContract();

}

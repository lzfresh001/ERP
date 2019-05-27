package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InBuyApply;

/**@文件名: InBuyApplyDao.java
 * @类功能说明: 采购申请主表Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日上午11:18:52
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日上午11:18:52</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InBuyApplyDao {
	
	// 全查inbuyapply表 
	public List<InBuyApply> queryAllInBuyApply(Map<String,Object> map);
	
	// 查询inbuyapply表条数
	public Integer queryInBuyApplyCount(Map<String,Object> map);
	
	// 添加inbuyapply表
	public Integer addInBuyApply(InBuyApply inBuyApply);
	
	// 获取inbaid最大值 
	public Integer getMaxInbaid();
	
	// 逻辑删除inbuyapply 
	public Integer deleteInBuyApply(Integer inbaid);
	
	// 修改inbuyapply
	public Integer updateInBuyApply(InBuyApply inBuyApply);
	
	// 修改wkexid为1
	public Integer updateWkexidForSubmit(Integer inbaid);
	
	// 查询已提交的inbuyapply表数据
	public List<InBuyApply> querySubmitedInBuyApply(Map<String,Object> map);
	
	// 申请驳回修改inbuyapply表数据
	public Integer updateInBuyApplyForRejected(InBuyApply inBuyApply);
	
	// 申请通过修改inbuyapply表数据
	public Integer updateInBuyApplyForThrough(InBuyApply inBuyApply);
	
	// 查询inbuyapply表数据申请统计用
	public List<InBuyApply> queryInBuyApplyForStatistical(Map<String,Object> map);
	
	// 查询inbuyapply表总条数申请统计用
	public Integer queryInBuyApplyCountForStatistical(Map<String,Object> map);
	
	// 查询通过审核、不是直接采购的申请信息
	public List<InBuyApply> queryInBuyApplyForContract();
	
	/**@方法名: findInBuyApplyById
	 * @方法说明: 根据id查找信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午6:01:05
	 * @param inbaid
	 * @return
	 * @return: InBuyApply
	 */
	public InBuyApply findInBuyApplyById(int inbaid);

	/**@方法名: updateWkexid
	 * @方法说明:  子表全部生成合同后 对数据流id更新
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午7:23:19
	 * @param inbaid
	 * @return: void
	 */
	public void updateWkexid(int inbaid);
}

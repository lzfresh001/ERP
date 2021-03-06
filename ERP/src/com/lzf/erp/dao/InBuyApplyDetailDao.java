package com.lzf.erp.dao;

import java.util.List;

import com.lzf.erp.model.InBuyApplyDetail;

/**@文件名: InBuyApplyDetailDao.java
 * @类功能说明: 采购申请子表Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日下午3:02:05
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日下午3:02:05</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InBuyApplyDetailDao {
	
	// 根据inbaid查询inbuyapplydetail表
	public List<InBuyApplyDetail> queryInBuyApplyDetailByInbaid(Integer inbaid);
	
	// 添加inbuyapplydetail表 
	public Integer addInBuyApplyDetail(InBuyApplyDetail inBuyApplyDetail);
	
	// 根据inbaid逻辑删除inbuyapplydetail
	public Integer deleteInBuyApplyDetailByInbaid(Integer inbaid);

	// 根据inbadid逻辑删除inbuyapplydetail
	public Integer deleteInBuyApplyDetailByInbadid(Integer inbadid);
	
	// 修改inbuyapplydetail
	public Integer updateInBuyApplyDetail(InBuyApplyDetail inBuyApplyDetail);
	
	//生成合同后对 申请表详细表进行修改
	public void updateState(Integer inbadid);

	/**@方法名: findNoContract
	 * @方法说明: 查询主表id查找 未生成合同的个数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午7:18:23
	 * @param inbadid
	 * @return
	 * @return: int
	 */
	public int findNoContract(Integer inbaid);
}

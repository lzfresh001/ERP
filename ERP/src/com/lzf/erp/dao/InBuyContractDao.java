package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InBuyContract;

public interface InBuyContractDao {

	/**@方法名: findAllInBuyContract
	 * @方法说明: 合同主表 明细表查询  分页查询+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午1:29:39
	 * @param map
	 * @return
	 * @return: List<InBuyContract>
	 */
	public List<InBuyContract> findAllInBuyContract(Map<String, Object> map);

	/**@方法名: findAllInBuyContractCount
	 * @方法说明: 合同主表+明细表 查询总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午1:30:16
	 * @return
	 * @return: int
	 */
	public int findAllInBuyContractCount();

	/**@方法名: updateWkexid
	 * @方法说明: 当合同下单时 改变状态 改为4 
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日上午11:37:18
	 * @param inbcid
	 * @return: void
	 */
	public int updateWkexid(int inbcid);

	/**@方法名: findInBuyContractById
	 * @方法说明: 根据id查找合同信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午12:09:52
	 * @param inbcid
	 * @return
	 * @return: InBuyContract
	 */
	public InBuyContract findInBuyContractById(int inbcid);
	
	// 查询inbuycontract表用于合同统计
	public List<InBuyContract> queryInBuyContractForStatistics(Map<String,Object> map);
	
	/**@方法名: addInBuyContract
	 * @方法说明: 添加合同主表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午6:04:42
	 * @param inBuyContract
	 * @return
	 * @return: int
	 */
	public int addInBuyContract(InBuyContract inBuyContract);

	/**@方法名: findMaxId
	 * @方法说明: 找出最大id
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午6:55:59
	 * @return
	 * @return: int
	 */
	public int findMaxId();
}

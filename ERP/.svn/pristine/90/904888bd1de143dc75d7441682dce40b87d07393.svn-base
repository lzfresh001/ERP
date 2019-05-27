package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InsupplierInfo;

public interface InsupplierInfoDao {

	/**@方法名: findAllinsupplierInfo
	 * @方法说明: 查询供应商详情表  +分页+模糊+子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午3:07:53
	 * @param map
	 * @return
	 * @return: List<InsupplierInfo>
	 */
	public List<InsupplierInfo> findAllinsupplierInfo(Map<String, Object> map);

	/**@方法名: findAllinsupplierInfoCount
	 * @方法说明: 查询供应商详情表总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午3:08:18
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllinsupplierInfoCount(Map<String, Object> map);

	/**@方法名: addInsupplierInfo
	 * @方法说明: 添加商品信息表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:31:53
	 * @param insupplierInfo
	 * @return
	 * @return: int
	 */
	public int addInsupplierInfo(InsupplierInfo insupplierInfo);

	/**@方法名: findMaxId
	 * @方法说明: 查询id最大值
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:35:48
	 * @return
	 * @return: int
	 */
	public int findMaxId();

	/**@方法名: updateInsupplierInfo
	 * @方法说明: 修改供应商信息表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:53:35
	 * @param insupplierInfo
	 * @return
	 * @return: int
	 */
	public int updateInsupplierInfo(InsupplierInfo insupplierInfo);

	/**@方法名: deleteInsupplierInfo
	 * @方法说明: 删除供应商信息表 
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午10:07:07
	 * @param insiid
	 * @return
	 * @return: int
	 */
	public int deleteInsupplierInfo(int insiid);
	
	/**@方法名: findNameById
	 * @方法说明: 根据供应商id查找供应商名字
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午1:46:47
	 * @param insiid
	 * @return
	 * @return: String
	 */
	public String findNameById(int insiid);

	/**@方法名: queryAllInBuygys
	 * @方法说明: 供应商下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午4:48:43
	 * @return
	 * @return: List<InsupplierInfo>
	 */
	public List<InsupplierInfo> queryAllInBuygys();

}

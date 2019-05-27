package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InDeliveryWay;


/**@文件名: InDeliverywayDao.java
 * @类功能说明: 交货类型Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日下午12:31:34
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日下午12:31:34</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InDeliveryWayDao {
	
	// 根据inbtid查InDeliveryway表
	public InDeliveryWay queryInDeliveryWayByIndwid(Integer indwid);
	
	// 全查InBuyType表
	public List<InDeliveryWay> queryAllInDeliveryWay();
	
	/**@方法名: findAllInDeliveryWay
	 * @方法说明: 查询交货类型 分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:51:50
	 * @param map
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InDeliveryWay> findAllInDeliveryWay(Map<String, Object> map);

	/**@方法名: findAllInDeliveryWayCount
	 * @方法说明: 查询交货类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:42
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllInDeliveryWayCount(Map<String, Object> map);

	/**@方法名: addInDeliveryWay
	 * @方法说明: 添加交货类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:10
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int addInDeliveryWay(InDeliveryWay itw);

	/**@方法名: updateInDeliveryWay
	 * @方法说明: 修改交货类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:33
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int updateInDeliveryWay(InDeliveryWay ibt);

	/**@方法名: deleteInDeliveryWayById
	 * @方法说明: 删除交货类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:56
	 * @param id
	 * @return: void
	 */
	public void deleteInDeliveryWayById(String id);

	/**@方法名: findInDeliveryWayByCode
	 * @方法说明: 根据编码查询交货类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:04:55
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInDeliveryWayByCode(String code);

	/**@方法名: findInDeliveryWayByName
	 * @方法说明: 根据名称查询交货类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:20
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInDeliveryWayByName(String name);

	/**@方法名: findAllInDeliveryWayList
	 * @方法说明: 交货类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:06:09
	 * @return
	 * @return: List<InDeliveryWay>
	 */
	public List<InDeliveryWay> findInDeliveryWayList();
	
	/**@方法名: findNameById
	 * @方法说明: 根据id找交货类型名字
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:15:34
	 * @param inbtid
	 * @return
	 * @return: String
	 */
	public String findNameById(int inbtid);

}

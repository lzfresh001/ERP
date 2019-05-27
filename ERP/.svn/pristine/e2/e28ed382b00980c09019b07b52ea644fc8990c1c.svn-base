package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;


import com.lzf.erp.model.InTransportWay;

/**@文件名: InTransportWayDao.java
 * @类功能说明: 采购类型Dao接口
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
public interface InTransportWayDao {
	
	// 根据inbtid查InTransportWay表
	public InTransportWay queryInTransportWayByIntwid(Integer intwid);
	
	// 全查InBuyType表
	public List<InTransportWay> queryAllInTransportWay();
	
	/**@方法名: findAllInTransportWay
	 * @方法说明: 查询采购类型 分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:51:50
	 * @param map
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InTransportWay> findAllInTransportWay(Map<String, Object> map);

	/**@方法名: findAllInTransportWayCount
	 * @方法说明: 查询采购类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:42
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllInTransportWayCount(Map<String, Object> map);

	/**@方法名: addInTransportWay
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:10
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int addInTransportWay(InTransportWay itw);

	/**@方法名: updateInTransportWay
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:33
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int updateInTransportWay(InTransportWay ibt);

	/**@方法名: deleteInTransportWayById
	 * @方法说明: 删除采购类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:56
	 * @param id
	 * @return: void
	 */
	public void deleteInTransportWayById(String id);

	/**@方法名: findInTransportWayByCode
	 * @方法说明: 根据编码查询采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:04:55
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInTransportWayByCode(String code);

	/**@方法名: findInTransportWayByName
	 * @方法说明: 根据名称查询采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:20
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInTransportWayByName(String name);

	/**@方法名: findAllInTransportWayList
	 * @方法说明: 采购类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:06:09
	 * @return
	 * @return: List<InTransportWay>
	 */
	public List<InTransportWay> findInTransportWayList();
	
	/**@方法名: findNameById
	 * @方法说明: 根据id找采购类型名字
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:15:34
	 * @param inbtid
	 * @return
	 * @return: String
	 */
	public String findNameById(int inbtid);

}

package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InTransportWay;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InTransportWay.java
 * @类功能说明: 采购类型Service接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日下午1:50:15
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日下午1:50:15</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InTransportWayService {
	
	// 全查InTransportWay表
	public JSONArray queryAllInTransportWay();
	
	/**@方法名: findAllInTransportWay
	 * @方法说明: 查询采购类型  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:07:04
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllInTransportWay(Map<String, Object> map);

	/**@方法名: findAllInTransportWayCount
	 * @方法说明: 查询总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:07:18
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllInTransportWayCount(Map<String, Object> map);

	/**@方法名: addInTransportWay
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:04
	 * @param ibt
	 * @param user
	 * @return
	 * @return: int
	 */
	public int addInTransportWay(InTransportWay ibt, User user);

	/**@方法名: updateInTransportWay
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:21
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int updateInTransportWay(InTransportWay ibt);

	/**@方法名: deleteInTransportWayById
	 * @方法说明: 删除采购类型 -逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:35
	 * @param delIds
	 * @return
	 * @return: int
	 */
	public int deleteInTransportWayById(String delIds);

	/**@方法名: findInTransportWayByCode
	 * @方法说明: 根据编码查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:58
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInTransportWayeByCode(String code);

	/**@方法名: findInTransportWayByName
	 * @方法说明: 根据名称查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:21:15
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInTransportWayByName(String name);

	/**@方法名: findAllInTransportWayList
	 * @方法说明: 查询所有的采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:21:44
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllInTransportWayList();

}

package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InBuyOrder;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InBuyOrderService.java
 * @类功能说明: 订单service 接口层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日下午6:24:31
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日下午6:24:31</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InBuyOrderService {

	/**@方法名: findAllInBuyOrder
	 * @方法说明: 查询订单 分页+模糊
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午6:25:01
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	JSONArray findAllInBuyOrder(Map<String, Object> map);

	/**@方法名: findAllInBuyOrderCount
	 * @方法说明: 查询订单总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午6:25:24
	 * @param map
	 * @return
	 * @return: int
	 */
	int findAllInBuyOrderCount(Map<String, Object> map);

	/**@方法名: addInBuyOrder
	 * @方法说明: 添加订单表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日上午10:24:09
	 * @param inBuyOrder
	 * @param user
	 * @return
	 * @return: int
	 */
	public int addInBuyOrder(InBuyOrder inBuyOrder, User user);

	/**@方法名: updateInBuyOrder
	 * @方法说明: 修改订单主表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午1:55:27
	 * @param inBuyOrder
	 * @return
	 * @return: int
	 */
	public int updateInBuyOrder(InBuyOrder inBuyOrder);

	/**@方法名: deleteInBuyOrder
	 * @方法说明: 删除订单表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午2:16:55
	 * @param inbodid
	 * @return
	 * @return: int
	 */
	public int deleteInBuyOrder(int inboid);
	
	// 查询inbuyorder用于订单统计
	public JSONArray queryInBuyOrderForStatistics(Map<String, Object> map);
	
}

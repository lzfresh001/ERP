package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InBuyType;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InBuyTypeService.java
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
public interface InBuyTypeService {
	
	// 全查inbuytype表
	public JSONArray queryAllInBuyType();
	
	/**@方法名: findAllInBuyType
	 * @方法说明: 查询采购类型  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:07:04
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllInBuyType(Map<String, Object> map);

	/**@方法名: findAllInBuyTypeCount
	 * @方法说明: 查询总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:07:18
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllInBuyTypeCount(Map<String, Object> map);

	/**@方法名: addInBuyType
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:04
	 * @param ibt
	 * @param user
	 * @return
	 * @return: int
	 */
	public int addInBuyType(InBuyType ibt, User user);

	/**@方法名: updateInBuyType
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:21
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int updateInBuyType(InBuyType ibt);

	/**@方法名: deleteInBuyTypeById
	 * @方法说明: 删除采购类型 -逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:35
	 * @param delIds
	 * @return
	 * @return: int
	 */
	public int deleteInBuyTypeById(String delIds);

	/**@方法名: findInBuyTypeByCode
	 * @方法说明: 根据编码查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:20:58
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInBuyTypeByCode(String code);

	/**@方法名: findInBuyTypeByName
	 * @方法说明: 根据名称查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:21:15
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInBuyTypeByName(String name);

	/**@方法名: findAllInBuyTypeList
	 * @方法说明: 查询所有的采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:21:44
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllInBuyTypeList();

}

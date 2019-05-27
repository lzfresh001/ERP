package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InBuyType;

/**@文件名: InBuyTypeDao.java
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
public interface InBuyTypeDao {
	
	// 根据inbtid查inbuytype表
	public InBuyType queryInBuyTypeByInbtid(Integer inbtid);
	
	// 全查inbuytype表
	public List<InBuyType> queryAllInBuyType();
	
	/**@方法名: findAllInBuyType
	 * @方法说明: 查询采购类型 分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:51:50
	 * @param map
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InBuyType> findAllInBuyType(Map<String, Object> map);

	/**@方法名: findAllInBuyTypeCount
	 * @方法说明: 查询采购类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:42
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllInBuyTypeCount(Map<String, Object> map);

	/**@方法名: addInBuyType
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:10
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int addInBuyType(InBuyType ibt);

	/**@方法名: updateInBuyType
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:33
	 * @param ibt
	 * @return
	 * @return: int
	 */
	public int updateInBuyType(InBuyType ibt);

	/**@方法名: deleteInBuyTypeById
	 * @方法说明: 删除采购类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:56
	 * @param id
	 * @return: void
	 */
	public void deleteInBuyTypeById(String id);

	/**@方法名: findInBuyTypeByCode
	 * @方法说明: 根据编码查询采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:04:55
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInBuyTypeByCode(String code);

	/**@方法名: findInBuyTypeByName
	 * @方法说明: 根据名称查询采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:20
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInBuyTypeByName(String name);

	/**@方法名: findAllInBuyTypeList
	 * @方法说明: 采购类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:06:09
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InBuyType> findAllInBuyTypeList();
	
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

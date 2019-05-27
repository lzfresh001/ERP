package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InsupplierCategory;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InsupplierCategoryService.java
 * @类功能说明:  供应商类别表 service 接口层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月11日下午3:07:38
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月11日下午3:07:38</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InsupplierCategoryService {

	/**@方法名: findAllICategory
	 * @方法说明: 查询供应商类别说明  分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:44:31
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllICategory(Map<String, Object> map);

	/**@方法名: findAllICategoryCount
	 * @方法说明: 查询供应商类别总条数  +模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:44:56
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllICategoryCount(Map<String, Object> map);

	/**@方法名: addCs
	 * @方法说明: 添加供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:45:13
	 * @param ic
	 * @param user
	 * @return
	 * @return: int
	 */
	public int addCs(InsupplierCategory ic, User user);

	/**@方法名: updateCs
	 * @方法说明: 修改供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:45:22
	 * @param ic
	 * @param user
	 * @return
	 * @return: int
	 */
	public int updateCs(InsupplierCategory ic);

	/**@param delIds 
	 * @方法名: deleteCsById
	 * @方法说明: 删除供应商类别 -逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:45:32
	 * @param ic
	 * @param user
	 * @return
	 * @return: int
	 */
	public int deleteCsById(String delIds);

	/**@方法名: findInsupplierCategoryByCode
	 * @方法说明: 验证编码唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:06:44
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInsupplierCategoryByCode(String code);

	/**@方法名: findInsupplierCategoryByName
	 * @方法说明: 验证供应商类别名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:06:55
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInsupplierCategoryByName(String name);

	/**@方法名: findAllICategoryList
	 * @方法说明: 供应商类别下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午4:39:53
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllICategoryList();

}

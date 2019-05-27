package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InsupplierCategory;

/**@文件名: InsupplierCategoryDao.java
 * @类功能说明: 供应商类别dao层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月13日上午8:28:01
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月13日上午8:28:01</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InsupplierCategoryDao {

	/**@方法名: findAllICategory
	 * @方法说明:  查询所有的供应商类别+分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午8:28:22
	 * @param map
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InsupplierCategory> findAllICategory(Map<String, Object> map);

	/**@方法名: findAllICategoryCount
	 * @方法说明: 查询总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午8:33:08
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllICategoryCount(Map<String, Object> map);

	/**@方法名: addCs
	 * @方法说明: 添加供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:02:07
	 * @param ic
	 * @return
	 * @return: int
	 */
	public int addCs(InsupplierCategory ic);

	/**@方法名: updateCs
	 * @方法说明: 修改供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:02:26
	 * @param ic
	 * @return
	 * @return: int
	 */
	public int updateCs(InsupplierCategory ic);

	/**@方法名: deleteCsById
	 * @方法说明: 删除供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:02:43
	 * @param id
	 * @return: void
	 */
	public void deleteCsById(String id);

	/**@方法名: findInsupplierCategoryByCode
	 * @方法说明: 验证供应商类别编码唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:10:13
	 * @param code
	 * @return
	 * @return: int
	 */
	public int findInsupplierCategoryByCode(String code);

	/**@方法名: findInsupplierCategoryByName
	 * @方法说明: 验证供应商类别名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:10:27
	 * @param name
	 * @return
	 * @return: int
	 */
	public int findInsupplierCategoryByName(String name);

	/**@方法名: findNameById
	 * @方法说明: 根据id 查找 供应商类别名称
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:59:53
	 * @param inscid
	 * @return
	 * @return: String
	 */
	public String findNameById(int inscid);

	/**@方法名: findAllICategoryList
	 * @方法说明: 提供供应商类别下拉框数据
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午4:45:03
	 * @return
	 * @return: List<InsupplierCategory>
	 */
	public List<InsupplierCategory> findAllICategoryList();

}

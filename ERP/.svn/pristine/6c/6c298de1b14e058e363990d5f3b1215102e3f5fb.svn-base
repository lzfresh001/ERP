package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InsupplierInfo;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InsupplierInfoService.java
 * @类功能说明: 供应商列表 service 接口层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月13日下午2:16:32
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月13日下午2:16:32</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InsupplierInfoService {

	/**@方法名: findAllinsupplierInfo
	 * @方法说明: 查询供应商列表  分页+模糊+联系人
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:16:53
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray findAllinsupplierInfo(Map<String, Object> map);

	/**@方法名: findAllinsupplierInfoCount
	 * @方法说明:  查询供应商列表总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:17:18
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllinsupplierInfoCount(Map<String, Object> map);

	/**@方法名: addInsupplierInfo
	 * @方法说明: 添加供应商详情表 +子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:04:59
	 * @param user
	 * @param insupplierInfo
	 * @return
	 * @return: int
	 */
	public int addInsupplierInfo(User user, InsupplierInfo insupplierInfo);

	/**@方法名: updateInsupplierInfo
	 * @方法说明: 修改供应商详情表 +子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:05:31
	 * @param insupplierInfo
	 * @return
	 * @return: int
	 */
	public int updateInsupplierInfo(User user,InsupplierInfo insupplierInfo);

	/**@方法名: deleteInsupplierInfo
	 * @方法说明: 删除供应商详情表 +子表-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:06:01
	 * @param insiid
	 * @return
	 * @return: int
	 */
	public int deleteInsupplierInfo(int insiid);

	/**@方法名: queryAllInBuygys
	 * @方法说明: 供应商下拉框数据
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午4:23:34
	 * @return
	 * @return: JSONArray
	 */
	public JSONArray queryAllInBuygys();

}

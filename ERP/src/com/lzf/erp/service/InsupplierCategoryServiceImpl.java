package com.lzf.erp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InsupplierCategoryDao;
import com.lzf.erp.model.InsupplierCategory;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InsupplierCategoryService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class InsupplierCategoryServiceImpl implements InsupplierCategoryService {

	@Autowired
	private InsupplierCategoryDao insupplierCategoryDao;

	/**@方法名: findAllICategory
	 * @方法说明: 查询供应商类别表  分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月11日下午3:20:31
	 * @param map	存储分页和模糊搜索字段
	 * @return
	 * @return:
	 */
	public JSONArray findAllICategory(Map<String, Object> map) {
		List<InsupplierCategory> insupplierCategorys=insupplierCategoryDao.findAllICategory(map);
		JSONArray jsonArray=new JSONArray();
		for(InsupplierCategory insupplierCategory:insupplierCategorys) {
			JSONObject json=new JSONObject();
			json.put("inscid", insupplierCategory.getInscid());
			json.put("insccode", insupplierCategory.getInsccode());
			json.put("inscname", insupplierCategory.getInscname());
			json.put("remark", insupplierCategory.getRemark());
			json.put("state", insupplierCategory.getState());
			json.put("optid", insupplierCategory.getOptid());
			json.put("optname", insupplierCategory.getOptname());
			json.put("optdeptid", insupplierCategory.getOptdeptid());
			json.put("currdate", insupplierCategory.getCurrdate());
			jsonArray.add(json);
			
		}
		return jsonArray;
	}

	/**@方法名: findAllICategoryCount
	 * @方法说明: 查找商品类别表 模糊搜索 总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月11日下午3:21:17
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public int findAllICategoryCount(Map<String, Object> map) {
		return insupplierCategoryDao.findAllICategoryCount(map);
	}

	/**@方法名: addCs
	 * @方法说明: 添加供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:03:08
	 * @param ic
	 * @param user
	 * @return
	 * @return:
	 */
	@Override
	public int addCs(InsupplierCategory ic, User user) {
		//ic.setOptid(user.getUid());
		ic.setOptname(user.getUname());
		ic.setOptdeptid(user.getRoleId());
		return insupplierCategoryDao.addCs(ic);
	}

	/**@方法名: updateCs
	 * @方法说明: 修改供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:03:19
	 * @param ic
	 * @return
	 * @return:
	 */
	@Override
	public int updateCs(InsupplierCategory ic) {
		// TODO Auto-generated method stub
		return insupplierCategoryDao.updateCs(ic);
	}

	/**@方法名: deleteCsById
	 * @方法说明: 删除供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午10:03:29
	 * @param delIds 删除多个供应商类别 id字符串 ，分隔
	 * @return
	 * @return:
	 */
	@Override
	public int deleteCsById(String delIds) {
		String[] ids=delIds.split(",");
		int  count=0;
		for(String id:ids) {
			insupplierCategoryDao.deleteCsById(id);
			count++;
		}
		return count;
	}

	/**@方法名: findInsupplierCategoryByCode
	 * @方法说明: 验证供应商类别编码唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:08:04
	 * @param code
	 * @return
	 * @return:
	 */
	@Override
	public int findInsupplierCategoryByCode(String code) {
		// TODO Auto-generated method stub
		return insupplierCategoryDao.findInsupplierCategoryByCode(code);
	}

	/**@方法名: findInsupplierCategoryByName
	 * @方法说明: 验证 供应商 类别名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:08:23
	 * @param code
	 * @return
	 * @return:
	 */
	@Override
	public int findInsupplierCategoryByName(String name) {
		// TODO Auto-generated method stub
		return insupplierCategoryDao.findInsupplierCategoryByName(name);
	}

	/**@方法名: findAllICategoryList
	 * @方法说明: 供应商类别下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午4:44:48
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllICategoryList() {
		List<InsupplierCategory> insupplierCategorys=insupplierCategoryDao.findAllICategoryList();
		JSONArray jsonArray=new JSONArray();
		for(InsupplierCategory insupplierCategory:insupplierCategorys) {
			JSONObject json=new JSONObject();
			json.put("inscid", insupplierCategory.getInscid());
			json.put("inscname", insupplierCategory.getInscname());
			jsonArray.add(json);
		}
		return jsonArray;
	}

}

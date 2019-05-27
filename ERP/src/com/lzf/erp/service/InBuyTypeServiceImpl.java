package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.model.User;
import com.lzf.erp.dao.InBuyTypeDao;
import com.lzf.erp.model.InBuyType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyTypeServiceImpl.java
 * @类功能说明: 采购类型Service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日下午1:51:12
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日下午1:51:12</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InBuyTypeServiceImpl implements InBuyTypeService {

	@Autowired
	private InBuyTypeDao inBuyTypeDao;
	
	// 全查inbuytype表
	@Override
	public JSONArray queryAllInBuyType() {
		JSONArray jsonArray = new JSONArray();
		List<InBuyType> IBTList = inBuyTypeDao.queryAllInBuyType();
		JSONObject JsonObject = new JSONObject();
		JsonObject.put("inbtid", "");
		JsonObject.put("inbtname", "全部");
		jsonArray.add(JsonObject);
		for(InBuyType ibtList: IBTList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("inbtid", ibtList.getInbtid());
			jsonObject.put("inbtcode", ibtList.getInbtcode());
			jsonObject.put("inbtname", ibtList.getInbtname());
			jsonObject.put("inbthandleid", ibtList.getInbthandleid());
			jsonObject.put("remark", ibtList.getRemark());
			jsonObject.put("state", ibtList.getState());
			jsonObject.put("delflag", ibtList.getDelflag());
			jsonObject.put("optid", ibtList.getOptid());
			jsonObject.put("optname", ibtList.getOptname());
			jsonObject.put("optdeptid", ibtList.getOptdeptid());
			jsonObject.put("optorgid", ibtList.getOptorgid());
			jsonObject.put("currdate", ibtList.getCurrdate());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	@Override
	public JSONArray findAllInBuyType(Map<String, Object> map) {
		List<InBuyType> inBuyTypes=inBuyTypeDao.findAllInBuyType(map);
		JSONArray jsonArray=new JSONArray();
		for(InBuyType inBuyType:inBuyTypes) {
			JSONObject json=new JSONObject();
			json.put("inbtid", inBuyType.getInbtid());
			json.put("inbtcode", inBuyType.getInbtcode());
			json.put("inbtname", inBuyType.getInbtname());
			json.put("remark", inBuyType.getRemark());
			json.put("state", inBuyType.getState());
			json.put("optid", inBuyType.getOptid());
			json.put("optname", inBuyType.getOptname());
			json.put("optdeptid", inBuyType.getOptdeptid());
			json.put("currdate", inBuyType.getCurrdate());
			jsonArray.add(json);
			
		}
		return jsonArray;
	}

	/**@方法名: findAllInBuyTypeCount
	 * @方法说明: 查询采购类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:27
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public int findAllInBuyTypeCount(Map<String, Object> map) {
		return inBuyTypeDao.findAllInBuyTypeCount(map) ;
	}

	/**@方法名: addInBuyType
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:57
	 * @param ibt
	 * @param user
	 * @return
	 * @return:
	 */
	@Override
	public int addInBuyType(InBuyType ibt, User user) {
		ibt.setOptid(user.getUid());
		ibt.setOptname(user.getUname());
		ibt.setOptdeptid(user.getRoleId());
		return inBuyTypeDao.addInBuyType(ibt);
	}

	/**@方法名: updateInBuyType
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:20
	 * @param ibt
	 * @return
	 * @return:
	 */
	@Override
	public int updateInBuyType(InBuyType ibt) {
		return inBuyTypeDao.updateInBuyType(ibt);
	}

	/**@方法名: deleteInBuyTypeById
	 * @方法说明: 删除采购类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:43
	 * @param delIds
	 * @return
	 * @return:
	 */
	@Override
	public int deleteInBuyTypeById(String delIds) {
		String[] ids=delIds.split(",");
		int  count=0;
		for(String id:ids) {
			inBuyTypeDao.deleteInBuyTypeById(id);
			count++;
		}
		return count;
	}

	/**@方法名: findInBuyTypeByCode
	 * @方法说明: 根据编码查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:54:11
	 * @param code
	 * @return
	 * @return:
	 */
	@Override
	public int findInBuyTypeByCode(String code) {
		// TODO Auto-generated method stub
		return inBuyTypeDao.findInBuyTypeByCode(code);
	}

	@Override
	public int findInBuyTypeByName(String name) {
		// TODO Auto-generated method stub
		return inBuyTypeDao.findInBuyTypeByName(name);
	}

	/**@方法名: findAllInBuyTypeList
	 * @方法说明: 采购类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:36
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllInBuyTypeList() {
		List<InBuyType> inBuyTypes=inBuyTypeDao.findAllInBuyTypeList();
		JSONArray jsonArray=new JSONArray();
		for(InBuyType inBuyType:inBuyTypes) {
			JSONObject json=new JSONObject();
			json.put("inbtid", inBuyType.getInbtid());
			json.put("inbtname", inBuyType.getInbtname());
			jsonArray.add(json);
		}
		return jsonArray;
	}

	
}

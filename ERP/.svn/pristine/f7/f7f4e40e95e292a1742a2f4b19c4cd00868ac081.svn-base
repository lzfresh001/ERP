package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.model.User;
import com.lzf.erp.dao.InDeliveryWayDao;
import com.lzf.erp.model.InDeliveryWay;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InDeliveryWayServiceImpl.java
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
public class InDeliveryWayServiceImpl implements InDeliveryWayService {

	@Autowired
	private InDeliveryWayDao inDeliveryWayDao;
	
	// 全查InTransportWay表
	@Override
	public JSONArray queryAllInDeliveryWay() {
		JSONArray jsonArray = new JSONArray();
		List<InDeliveryWay> IBTList = inDeliveryWayDao.queryAllInDeliveryWay();
		JSONObject JsonObject = new JSONObject();
		JsonObject.put("inbtid", "");
		JsonObject.put("inbtname", "全部");
		jsonArray.add(JsonObject);
		for(InDeliveryWay ibtList: IBTList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("indwid", ibtList.getIndwid());
			jsonObject.put("indwname", ibtList.getIndwname());
			jsonObject.put("indwcode", ibtList.getIndwcode());
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
	public JSONArray findAllInDeliveryWay(Map<String, Object> map) {
		List<InDeliveryWay> inDeliveryWays=inDeliveryWayDao.findAllInDeliveryWay(map);
		JSONArray jsonArray=new JSONArray();
		for(InDeliveryWay inDeliveryWay:inDeliveryWays) {
			JSONObject json=new JSONObject();
			json.put("indwid", inDeliveryWay.getIndwid());
			json.put("indwname", inDeliveryWay.getIndwname());
			json.put("indwcode", inDeliveryWay.getIndwcode());
			json.put("remark", inDeliveryWay.getRemark());
			json.put("state", inDeliveryWay.getState());
			json.put("optid", inDeliveryWay.getOptid());
			json.put("optname", inDeliveryWay.getOptname());
			json.put("optdeptid", inDeliveryWay.getOptdeptid());
			json.put("currdate", inDeliveryWay.getCurrdate());
			jsonArray.add(json);
			
		}
		return jsonArray;
	}

	/**@方法名: findAllInDeliveryWayCount
	 * @方法说明: 查询采购类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:27
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public int findAllInDeliveryWayCount(Map<String, Object> map) {
		return inDeliveryWayDao.findAllInDeliveryWayCount(map) ;
	}

	/**@方法名: addInDeliveryWay
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
	public int addInDeliveryWay(InDeliveryWay ibt, User user) {
		ibt.setOptid(user.getUid());
		ibt.setOptname(user.getUname());
		ibt.setOptdeptid(user.getRoleId());
		return inDeliveryWayDao.addInDeliveryWay(ibt);
	}

	/**@方法名: updateInDeliveryWay
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:20
	 * @param ibt
	 * @return
	 * @return:
	 */
	@Override
	public int updateInDeliveryWay(InDeliveryWay ibt) {
		return inDeliveryWayDao.updateInDeliveryWay(ibt);
	}

	/**@方法名: deleteInDeliveryWayById
	 * @方法说明: 删除采购类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:43
	 * @param delIds
	 * @return
	 * @return:
	 */
	@Override
	public int deleteInDeliveryWayById(String delIds) {
		String[] ids=delIds.split(",");
		int  count=0;
		for(String id:ids) {
			inDeliveryWayDao.deleteInDeliveryWayById(id);
			count++;
		}
		return count;
	}

	/**@方法名: findInDeliveryWayByCode
	 * @方法说明: 根据编码查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:54:11
	 * @param code
	 * @return
	 * @return:
	 */
	@Override
	public int findInDeliveryWayeByCode(String code) {
		// TODO Auto-generated method stub
		return inDeliveryWayDao.findInDeliveryWayByCode(code);
	}

	@Override
	public int findInDeliveryWayByName(String name) {
		// TODO Auto-generated method stub
		return inDeliveryWayDao.findInDeliveryWayByName(name);
	}

	/**@方法名: findAllInDeliveryWayList
	 * @方法说明: 采购类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:36
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllInDeliveryWayList() {
		List<InDeliveryWay> inDeliveryWays=inDeliveryWayDao.findInDeliveryWayList();
		JSONArray jsonArray=new JSONArray();
		for(InDeliveryWay inDeliveryWay:inDeliveryWays) {
			JSONObject json=new JSONObject();
			json.put("indwid", inDeliveryWay.getIndwid());
			json.put("indwname", inDeliveryWay.getIndwname());
			jsonArray.add(json);
		}
		return jsonArray;
	}

	
}

package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.model.User;
import com.lzf.erp.dao.InBuyTypeDao;
import com.lzf.erp.dao.InTransportWayDao;
import com.lzf.erp.model.InBuyType;
import com.lzf.erp.model.InTransportWay;

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
public class InTransportServiceImpl implements InTransportWayService {

	@Autowired
	private InTransportWayDao inTransportWayDao;
	
	// 全查InTransportWay表
	@Override
	public JSONArray queryAllInTransportWay() {
		JSONArray jsonArray = new JSONArray();
		List<InTransportWay> IBTList = inTransportWayDao.queryAllInTransportWay();
		JSONObject JsonObject = new JSONObject();
		JsonObject.put("inbtid", "");
		JsonObject.put("inbtname", "全部");
		jsonArray.add(JsonObject);
		for(InTransportWay ibtList: IBTList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("intwid", ibtList.getIntwid());
			jsonObject.put("intwname", ibtList.getIntwname());
			jsonObject.put("intwcode", ibtList.getIntwcode());
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
	public JSONArray findAllInTransportWay(Map<String, Object> map) {
		List<InTransportWay> inTransportWays=inTransportWayDao.findAllInTransportWay(map);
		JSONArray jsonArray=new JSONArray();
		for(InTransportWay inTransportWay:inTransportWays) {
			JSONObject json=new JSONObject();
			json.put("intwid", inTransportWay.getIntwid());
			json.put("intwname", inTransportWay.getIntwname());
			json.put("intwcode", inTransportWay.getIntwcode());
			json.put("remark", inTransportWay.getRemark());
			json.put("state", inTransportWay.getState());
			json.put("optid", inTransportWay.getOptid());
			json.put("optname", inTransportWay.getOptname());
			json.put("optdeptid", inTransportWay.getOptdeptid());
			json.put("currdate", inTransportWay.getCurrdate());
			jsonArray.add(json);
			
		}
		return jsonArray;
	}

	/**@方法名: findAllInTransportWayCount
	 * @方法说明: 查询采购类型总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:52:27
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public int findAllInTransportWayCount(Map<String, Object> map) {
		return inTransportWayDao.findAllInTransportWayCount(map) ;
	}

	/**@方法名: addInTransportWay
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
	public int addInTransportWay(InTransportWay ibt, User user) {
		ibt.setOptid(user.getUid());
		ibt.setOptname(user.getUname());
		ibt.setOptdeptid(user.getRoleId());
		return inTransportWayDao.addInTransportWay(ibt);
	}

	/**@方法名: updateInTransportWay
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:20
	 * @param ibt
	 * @return
	 * @return:
	 */
	@Override
	public int updateInTransportWay(InTransportWay ibt) {
		return inTransportWayDao.updateInTransportWay(ibt);
	}

	/**@方法名: deleteInTransportWayById
	 * @方法说明: 删除采购类型-逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:53:43
	 * @param delIds
	 * @return
	 * @return:
	 */
	@Override
	public int deleteInTransportWayById(String delIds) {
		String[] ids=delIds.split(",");
		int  count=0;
		for(String id:ids) {
			inTransportWayDao.deleteInTransportWayById(id);
			count++;
		}
		return count;
	}

	/**@方法名: findInTransportWayByCode
	 * @方法说明: 根据编码查找采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:54:11
	 * @param code
	 * @return
	 * @return:
	 */
	@Override
	public int findInTransportWayeByCode(String code) {
		// TODO Auto-generated method stub
		return inTransportWayDao.findInTransportWayByCode(code);
	}

	@Override
	public int findInTransportWayByName(String name) {
		// TODO Auto-generated method stub
		return inTransportWayDao.findInTransportWayByName(name);
	}

	/**@方法名: findAllInTransportWayList
	 * @方法说明: 采购类型下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午11:05:36
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllInTransportWayList() {
		List<InTransportWay> inTransportWays=inTransportWayDao.findInTransportWayList();
		JSONArray jsonArray=new JSONArray();
		for(InTransportWay inTransportWay:inTransportWays) {
			JSONObject json=new JSONObject();
			json.put("intwid", inTransportWay.getIntwid());
			json.put("intwname", inTransportWay.getIntwname());
			jsonArray.add(json);
		}
		return jsonArray;
	}

	
}

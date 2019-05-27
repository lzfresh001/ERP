package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InGoodsTypeDao;
import com.lzf.erp.model.InGoodsType;
import com.lzf.erp.model.User;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsTypeServiceImpl.java
 * @类功能说明:  商品类型Service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午11:25:29
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午11:25:29</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InGoodsTypeServiceImpl implements InGoodsTypeService {

	@Autowired
	private InGoodsTypeDao inGoodsTypeDao;
	
	// 全查ingoodstype表
	@Override
	public JSONArray queryAllInGoodsType(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InGoodsType> IGTList = inGoodsTypeDao.queryAllInGoodsType(map);
		for(InGoodsType igtList: IGTList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ingtid", igtList.getIngtid());
			jsonObject.put("ingtcode", igtList.getIngtcode());
			jsonObject.put("ingtname", igtList.getIngtname());
			jsonObject.put("remark", igtList.getRemark());
			jsonObject.put("state", igtList.getState());
			jsonObject.put("delflag", igtList.getDelflag());
			jsonObject.put("optid", igtList.getOptid());
			jsonObject.put("optname", igtList.getOptname());
			jsonObject.put("optdeptid", igtList.getOptdeptid());
			jsonObject.put("optorgid", igtList.getOptorgid());
			jsonObject.put("currdate", igtList.getCurrdate());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询ingoodstype表条数
	@Override
	public Integer queryInGoodsTypeCount(Map<String, Object> map) {
		return inGoodsTypeDao.queryInGoodsTypeCount(map);
	}

	// 根据ingtcode查ingoodstype表 
	@Override
	public InGoodsType queryAllInGoodsTypeByIngtcode(String ingtcode) {
		return inGoodsTypeDao.queryAllInGoodsTypeByIngtcode(ingtcode);
	}

	// 根据ingtname查ingoodstype表
	@Override
	public InGoodsType queryAllInGoodsTypeByIngtname(String ingtname) {
		return inGoodsTypeDao.queryAllInGoodsTypeByIngtname(ingtname);
	}

	// 添加ingoodstype表
	@Override
	public Integer addInGoodsType(InGoodsType inGoodsType, User user) {
		inGoodsType.setState(1);
		inGoodsType.setDelflag(1);
		inGoodsType.setOptid(user.getUid());
		inGoodsType.setOptname(user.getUname());
		inGoodsType.setOptdeptid(user.getRoleId());
		inGoodsType.setOptorgid(1);
		inGoodsType.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return inGoodsTypeDao.addInGoodsType(inGoodsType);
	}

	// 修改ingoodstype表
	@Override
	public Integer updateInGoodsType(InGoodsType inGoodsType) {
		return inGoodsTypeDao.updateInGoodsType(inGoodsType);
	}

	// 逻辑删除ingoodstype表
	@Override
	public Integer deleteInGoodsType(String ingtids) {
		String[] ingtidss = ingtids.split(",");
		Integer delRow = 0;
		for(String ingtid: ingtidss) {
			delRow += inGoodsTypeDao.deleteInGoodsType(Integer.parseInt(ingtid));
		}
		return delRow;
	}

}

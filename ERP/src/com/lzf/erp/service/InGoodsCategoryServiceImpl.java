package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InGoodsCategoryDao;
import com.lzf.erp.model.InGoodsCategory;
import com.lzf.erp.model.User;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsCategoryServiceImpl.java
 * @类功能说明: 商品类别Service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午8:45:07
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午8:45:07</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InGoodsCategoryServiceImpl implements InGoodsCategoryService {
	
	@Autowired
	private InGoodsCategoryDao inGoodsCategoryDao;

	// 全查ingoodscategory表
	@Override
	public JSONArray queryAllInGoodsCategory(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InGoodsCategory> IGCList = inGoodsCategoryDao.queryAllInGoodsCategory(map);
		for(InGoodsCategory igcList: IGCList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ingcid", igcList.getIngcid());
			jsonObject.put("ingccode", igcList.getIngccode());
			jsonObject.put("ingcname", igcList.getIngcname());
			jsonObject.put("remark", igcList.getRemark());
			jsonObject.put("state", igcList.getState());
			jsonObject.put("delflag", igcList.getDelflag());
			jsonObject.put("optid", igcList.getOptid());
			jsonObject.put("optname", igcList.getOptname());
			jsonObject.put("optdeptid", igcList.getOptdeptid());
			jsonObject.put("optorgid", igcList.getOptorgid());
			jsonObject.put("currdate", igcList.getCurrdate());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询ingoodscategory表的条数
	@Override
	public Integer queryInGoodsCategoryCount(Map<String, Object> map) {
		return inGoodsCategoryDao.queryInGoodsCategoryCount(map);
	}

	// 根据ingccode查ingoodscategory表
	@Override
	public InGoodsCategory queryInGoodsCategoryByIngccode(String ingccode) {
		return inGoodsCategoryDao.queryInGoodsCategoryByIngccode(ingccode);
	}

	// 根据ingcname查ingoodscategory表
	@Override
	public InGoodsCategory queryInGoodsCategoryByIngcname(String ingcname) {
		return inGoodsCategoryDao.queryInGoodsCategoryByIngcname(ingcname);
	}

	// 添加ingoodscategory表
	@Override
	public Integer addInGoodsCategory(InGoodsCategory inGoodsCategory, User user) {
		inGoodsCategory.setState(1);
		inGoodsCategory.setDelflag(1);
		inGoodsCategory.setOptid(user.getUid());
		inGoodsCategory.setOptname(user.getUname());
		inGoodsCategory.setOptdeptid(user.getRoleId());
		inGoodsCategory.setOptorgid(1);
		inGoodsCategory.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return inGoodsCategoryDao.addInGoodsCategory(inGoodsCategory);
	}

	// 修改ingoodscategory表
	@Override
	public Integer updateInGoodsCategory(InGoodsCategory inGoodsCategory) {
		return inGoodsCategoryDao.updateInGoodsCategory(inGoodsCategory);
	}

	// 逻辑删除ingoodscategory表
	@Override
	public Integer deleteInGoodsCategory(String ingcids) {
		String[] ingcidss = ingcids.split(",");
		Integer delRow = 0;
		for(String ingcid: ingcidss) {
			delRow += inGoodsCategoryDao.deleteInGoodsCategory(Integer.parseInt(ingcid));
		}
		return delRow;
	}

}

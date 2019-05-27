package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InGoodsInfoDao;
import com.lzf.erp.model.InGoodsCategory;
import com.lzf.erp.model.InGoodsInfo;
import com.lzf.erp.model.InGoodsProducer;
import com.lzf.erp.model.InGoodsType;
import com.lzf.erp.model.User;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsInfoServiceImpl.java
 * @类功能说明: 商品信息service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午2:01:50
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午2:01:50</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InGoodsInfoServiceImpl implements InGoodsInfoService {
	
	@Autowired
	private InGoodsInfoDao inGoodsInfoDao;

	// 全查ingoodsinfo表
	@Override
	public JSONArray queryAllInGoodsInfo(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InGoodsInfo> giList = inGoodsInfoDao.queryAllInGoodsInfo(map);
		for(InGoodsInfo inGoodsInfo: giList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ingiid", inGoodsInfo.getIngiid());
			jsonObject.put("ingicode", inGoodsInfo.getIngicode());
			jsonObject.put("inginame", inGoodsInfo.getInginame());
			jsonObject.put("ingcid", inGoodsInfo.getIngcid());
			jsonObject.put("ingtid", inGoodsInfo.getIngtid());
			jsonObject.put("ingpid", inGoodsInfo.getIngpid());
			jsonObject.put("ingiformat", inGoodsInfo.getIngiformat());
			jsonObject.put("ingimodel", inGoodsInfo.getIngimodel());
			jsonObject.put("ingilicensenum", inGoodsInfo.getIngilicensenum());
			jsonObject.put("ingishelflife", inGoodsInfo.getIngishelflife());
			jsonObject.put("ingideptidexclusive", inGoodsInfo.getIngideptidexclusive());
			jsonObject.put("ingiexplosive", inGoodsInfo.getIngiexplosive());
			jsonObject.put("ingitoxic", inGoodsInfo.getIngitoxic());
			jsonObject.put("ingicorrosion", inGoodsInfo.getIngicorrosion());
			jsonObject.put("ingifragile", inGoodsInfo.getIngifragile());
			jsonObject.put("ingustockid", inGoodsInfo.getIngustockid());
			jsonObject.put("ingusaleid", inGoodsInfo.getIngusaleid());
			jsonObject.put("ingusplitid", inGoodsInfo.getIngusaleid());
			jsonObject.put("ingisalescale", inGoodsInfo.getIngisalescale());
			jsonObject.put("ingisplitcale", inGoodsInfo.getIngisplitcale());
			jsonObject.put("ingiishandle", inGoodsInfo.getIngiishandle());
			jsonObject.put("ingibarcodecategory", inGoodsInfo.getIngibarcodecategory());
			jsonObject.put("remark", inGoodsInfo.getRemark());
			jsonObject.put("state", inGoodsInfo.getState());
			jsonObject.put("delflag", inGoodsInfo.getDelflag());
			jsonObject.put("stopflag", inGoodsInfo.getStopflag());
			jsonObject.put("optid", inGoodsInfo.getOptid());
			jsonObject.put("optname", inGoodsInfo.getOptname());
			jsonObject.put("optdeptid", inGoodsInfo.getOptdeptid());
			jsonObject.put("optorgid", inGoodsInfo.getOptorgid());
			jsonObject.put("currdate", inGoodsInfo.getCurrdate());
			InGoodsCategory inGoodsCategory = inGoodsInfo.getInGoodsCategory();
			InGoodsType inGoodsType = inGoodsInfo.getInGoodsType();
			InGoodsProducer inGoodsProducer =inGoodsInfo.getInGoodsProducer();
			jsonObject.put("ingcname", inGoodsCategory.getIngcname());
			jsonObject.put("ingtname", inGoodsType.getIngtname());
			jsonObject.put("ingpname", inGoodsProducer.getIngpname());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询ingoodsinfo的总条数
	@Override
	public Integer queryAllInGoodsInfoCount(Map<String, Object> map) {
		return inGoodsInfoDao.queryAllInGoodsInfoCount(map);
	}

	// 根据ingicode查ingoodsinfo表
	@Override
	public InGoodsInfo queryInGoodsInfoByIngicode(String ingicode) {
		return inGoodsInfoDao.queryInGoodsInfoByIngicode(ingicode);
	}

	// 根据inginame查ingoodsinfo表 
	@Override
	public InGoodsInfo queryInGoodsInfoByInginame(String inginame) {
		return inGoodsInfoDao.queryInGoodsInfoByInginame(inginame);
	}

	// 添加ingoodsinfo表
	@Override
	public Integer addInGoodsInfo(InGoodsInfo inGoodsInfo, User user) {
		inGoodsInfo.setDelflag(1);
		inGoodsInfo.setOptid(user.getUid());
		inGoodsInfo.setOptname(user.getUname());
		inGoodsInfo.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return inGoodsInfoDao.addInGoodsInfo(inGoodsInfo);
	}

	// 修改ingoodsinfo表
	@Override
	public Integer updateInGoodsInfo(InGoodsInfo inGoodsInfo) {
		return inGoodsInfoDao.updateInGoodsInfo(inGoodsInfo);
	}

	// 逻辑删除商品信息
	@Override
	public Integer deleteInGoodsInfo(String ingiids) {
		String[] ingiidss = ingiids.split(",");
		Integer delRow = 0;
		for(String ingiid: ingiidss) {
			delRow += inGoodsInfoDao.deleteInGoodsInfo(Integer.parseInt(ingiid));
		}
		return delRow;
	}

	// 查询ingoodsinfo表给IBAD
	@Override
	public JSONArray queryInGoodsInfoForIBAD() {
		JSONArray jsonArray = new JSONArray();
		List<InGoodsInfo> IGIList = inGoodsInfoDao.queryInGoodsInfoForIBAD();
		for(InGoodsInfo inGoodsInfo: IGIList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ingiid", inGoodsInfo.getIngiid());
			jsonObject.put("ingicode", inGoodsInfo.getIngicode());
			jsonObject.put("inginame", inGoodsInfo.getInginame());
			jsonObject.put("ingcid", inGoodsInfo.getIngcid());
			jsonObject.put("ingtid", inGoodsInfo.getIngtid());
			jsonObject.put("ingpid", inGoodsInfo.getIngpid());
			jsonObject.put("ingiformat", inGoodsInfo.getIngiformat());
			jsonObject.put("ingimodel", inGoodsInfo.getIngimodel());
			jsonObject.put("ingilicensenum", inGoodsInfo.getIngilicensenum());
			jsonObject.put("ingishelflife", inGoodsInfo.getIngishelflife());
			jsonObject.put("ingideptidexclusive", inGoodsInfo.getIngideptidexclusive());
			jsonObject.put("ingiexplosive", inGoodsInfo.getIngiexplosive());
			jsonObject.put("ingitoxic", inGoodsInfo.getIngitoxic());
			jsonObject.put("ingicorrosion", inGoodsInfo.getIngicorrosion());
			jsonObject.put("ingifragile", inGoodsInfo.getIngifragile());
			jsonObject.put("ingustockid", inGoodsInfo.getIngustockid());
			jsonObject.put("ingusaleid", inGoodsInfo.getIngusaleid());
			jsonObject.put("ingusplitid", inGoodsInfo.getIngusaleid());
			jsonObject.put("ingisalescale", inGoodsInfo.getIngisalescale());
			jsonObject.put("ingisplitcale", inGoodsInfo.getIngisplitcale());
			jsonObject.put("ingiishandle", inGoodsInfo.getIngiishandle());
			jsonObject.put("ingibarcodecategory", inGoodsInfo.getIngibarcodecategory());
			jsonObject.put("remark", inGoodsInfo.getRemark());
			jsonObject.put("state", inGoodsInfo.getState());
			jsonObject.put("delflag", inGoodsInfo.getDelflag());
			jsonObject.put("stopflag", inGoodsInfo.getStopflag());
			jsonObject.put("optid", inGoodsInfo.getOptid());
			jsonObject.put("optname", inGoodsInfo.getOptname());
			jsonObject.put("optdeptid", inGoodsInfo.getOptdeptid());
			jsonObject.put("optorgid", inGoodsInfo.getOptorgid());
			jsonObject.put("currdate", inGoodsInfo.getCurrdate());
			InGoodsCategory inGoodsCategory = inGoodsInfo.getInGoodsCategory();
			InGoodsType inGoodsType = inGoodsInfo.getInGoodsType();
			InGoodsProducer inGoodsProducer =inGoodsInfo.getInGoodsProducer();
			jsonObject.put("ingcname", inGoodsCategory.getIngcname());
			jsonObject.put("ingtname", inGoodsType.getIngtname());
			jsonObject.put("ingpname", inGoodsProducer.getIngpname());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

}

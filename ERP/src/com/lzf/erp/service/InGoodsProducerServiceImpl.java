package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InGoodsProducerDao;
import com.lzf.erp.model.InGoodsProducer;
import com.lzf.erp.model.User;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsProducerServiceImpl.java
 * @类功能说明: 商品生产厂家Service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日下午2:36:31
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日下午2:36:31</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InGoodsProducerServiceImpl implements InGoodsProducerService {
	
	@Autowired
	private InGoodsProducerDao inGoodsProducerDao;

	// 全查ingoodsproducer表
	@Override
	public JSONArray queryAllInGoodsProducer(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InGoodsProducer> IGPList = inGoodsProducerDao.queryAllInGoodsProducer(map);
		for(InGoodsProducer igpList: IGPList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("ingpid", igpList.getIngpid());
			jsonObject.put("ingpcode", igpList.getIngpcode());
			jsonObject.put("ingpname", igpList.getIngpname());
			jsonObject.put("ingplinkman", igpList.getIngplinkman());
			jsonObject.put("ingpphone", igpList.getIngpphone());
			jsonObject.put("ingpaddress", igpList.getIngpaddress());
			jsonObject.put("remark", igpList.getRemark());
			jsonObject.put("delflag", igpList.getDelflag());
			jsonObject.put("state", igpList.getState());
			jsonObject.put("optid", igpList.getOptid());
			jsonObject.put("optname", igpList.getOptname());
			jsonObject.put("optdeptid", igpList.getOptdeptid());
			jsonObject.put("optorgid", igpList.getOptorgid());
			jsonObject.put("currdate", igpList.getCurrdate());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询ingoodsproducer表条数
	@Override
	public Integer queryInGoodsProducerCount(Map<String, Object> map) {
		return inGoodsProducerDao.queryInGoodsProducerCount(map);
	}

	// 根据ingpcode查ingoodsproducer表
	@Override
	public InGoodsProducer queryAllInGoodsProducerByIngpcode(String ingpcode) {
		return inGoodsProducerDao.queryAllInGoodsProducerByIngpcode(ingpcode);
	}

	// 根据ingpname查ingoodsproducer表
	@Override
	public InGoodsProducer queryAllInGoodsProducerByIngpname(String ingpname) {
		return inGoodsProducerDao.queryAllInGoodsProducerByIngpname(ingpname);
	}

	// 根据ingpphone查ingoodsproducer表
	@Override
	public InGoodsProducer queryAllInGoodsProducerByIngpphone(String ingpphone) {
		return inGoodsProducerDao.queryAllInGoodsProducerByIngpphone(ingpphone);
	}

	// 添加ingoodsproducer表
	@Override
	public Integer addInGoodsProducer(InGoodsProducer inGoodsProducer, User user) {
		inGoodsProducer.setDelflag(1);
		inGoodsProducer.setState(1);
		inGoodsProducer.setOptid(user.getUid());
		inGoodsProducer.setOptname(user.getUname());
		inGoodsProducer.setOptdeptid(user.getRoleId());
		inGoodsProducer.setOptorgid(1);
		inGoodsProducer.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return inGoodsProducerDao.addInGoodsProducer(inGoodsProducer);
	}

	// 修改ingoodsproducer表
	@Override
	public Integer updateInGoodsProducer(InGoodsProducer inGoodsProducer) {
		return inGoodsProducerDao.updateInGoodsProducer(inGoodsProducer);
	}

	// 逻辑删除ingoodsproducer表
	@Override
	public Integer deleteInGoodsProducer(String ingpids) {
		String[] ingpidss = ingpids.split(",");
		Integer delRow = 0;
		for(String ingpid: ingpidss) {
			delRow += inGoodsProducerDao.deleteInGoodsProducer(Integer.parseInt(ingpid));
		}
		return delRow;
	}

}

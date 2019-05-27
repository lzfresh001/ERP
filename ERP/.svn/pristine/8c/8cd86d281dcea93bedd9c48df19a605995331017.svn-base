package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InBuyApplyDao;
import com.lzf.erp.dao.InBuyApplyDetailDao;
import com.lzf.erp.dao.InBuyContractDao;
import com.lzf.erp.dao.InBuyContractDetailDao;
import com.lzf.erp.model.InBuyApply;
import com.lzf.erp.model.InBuyContract;
import com.lzf.erp.model.InBuyContractDetail;
import com.lzf.erp.model.InGoodsInfo;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyContractServiceImpl.java
 * @类功能说明: 合同 管理 service 接口实现类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日上午11:44:41
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日上午11:44:41</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InBuyContractServiceImpl implements InBuyContractService {

	@Autowired
	private InBuyContractDao inBuyContractDao;
	@Autowired
	private InBuyContractDetailDao inBuyContractDetailDao;
	@Autowired
	private InBuyApplyDao inBuyApplyDao;
	@Autowired
	private InBuyApplyDetailDao inBuyApplyDetailDao;
	/**@方法名: findAllInBuyContract
	 * @方法说明: 合同+明细表查询+模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日上午11:45:19
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllInBuyContract(Map<String, Object> map) {
		List<InBuyContract> inBuyContracts=inBuyContractDao.findAllInBuyContract(map);
		JSONArray jsonArray=new JSONArray();
		for(InBuyContract inBuyContract:inBuyContracts) {
			JSONObject json=new JSONObject();
			//主表
			json.put("inbcid", inBuyContract.getInbcid());
			json.put("inbccode", inBuyContract.getInbccode());
			json.put("inbcname", inBuyContract.getInbcname());
			json.put("insiid", inBuyContract.getBusiid());
			json.put("insiname", inBuyContract.getInsiname());
			json.put("busiid", inBuyContract.getBusiid());
			json.put("businame", inBuyContract.getBusiname());
			json.put("busideptid", inBuyContract.getBusideptid());
			json.put("inbcdate", inBuyContract.getInbcdate());
			json.put("inbccontent", inBuyContract.getInbccontent());
			json.put("inbtid", inBuyContract.getInbtid());
			json.put("inbtname", inBuyContract.getInbtname());
			json.put("inbctotalprice", inBuyContract.getInbctotalprice());
			json.put("inbcofferprice", inBuyContract.getInbcofferprice());
			json.put("inbcactualprice", inBuyContract.getInbcactualprice());
			json.put("inbcadvancemoney", inBuyContract.getInbcadvancemoney());
			json.put("intwid", inBuyContract.getIntwid());
			json.put("intwiname", inBuyContract.getIntwiname());
			json.put("indwid", inBuyContract.getIndwid());
			json.put("indwname", inBuyContract.getIndwname());
			json.put("inbcdeliverydate", inBuyContract.getInbcdeliverydate());
			json.put("inbcdeliveryaddress", inBuyContract.getInbcdeliveryaddress());
			json.put("remark", inBuyContract.getRemark());
			json.put("optname", inBuyContract.getOptname());
			//子表
			JSONArray childrenArray=new JSONArray();
			List<InBuyContractDetail> inBuyContractDetails=inBuyContract.getInBuyContractDetails();
			for(InBuyContractDetail inBuyContractDetail:inBuyContractDetails) {
				JSONObject child=new JSONObject();
				child.put("inbcdid", inBuyContractDetail.getInbcdid());
				child.put("inbaid", inBuyContractDetail.getInbaid());
				child.put("inbadid", inBuyContractDetail.getInbadid());
				child.put("inbcid", inBuyContractDetail.getInbcid());
				child.put("insiid", inBuyContractDetail.getInsiid());
				child.put("ingiid", inBuyContractDetail.getIngiid());
				child.put("myprice", inBuyContractDetail.getMyprice());
				child.put("mycou", inBuyContractDetail.getMycou());
				child.put("mymoney", inBuyContractDetail.getMymoney());
				child.put("remark", inBuyContractDetail.getRemark());
				child.put("ingiid", inBuyContractDetail.getInGoodsInfo().getIngiid());
				child.put("inginame", inBuyContractDetail.getInGoodsInfo().getInginame());

				childrenArray.add(child);
				
			}
			json.put("inBuyContractDetails", childrenArray);
			jsonArray.add(json);
		}
		return jsonArray;
	}

	@Override
	public int findAllInBuyContractCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return inBuyContractDao.findAllInBuyContractCount();
	}

	// 查询inbuycontract表用于合同统计
	@Override
	public JSONArray queryInBuyContractForStatistics(Map<String,Object> map) {
		List<InBuyContract> inBuyContracts=inBuyContractDao.queryInBuyContractForStatistics(map);
		JSONArray jsonArray=new JSONArray();
		for(InBuyContract inBuyContract:inBuyContracts) {
			JSONObject json=new JSONObject();
			//主表
			json.put("inbcid", inBuyContract.getInbcid());
			json.put("inbccode", inBuyContract.getInbccode());
			json.put("inbcname", inBuyContract.getInbcname());
			json.put("insiid", inBuyContract.getBusiid());
			json.put("insiname", inBuyContract.getInsiname());
			json.put("busiid", inBuyContract.getBusiid());
			json.put("businame", inBuyContract.getBusiname());
			json.put("busideptid", inBuyContract.getBusideptid());
			json.put("inbcdate", inBuyContract.getInbcdate());
			json.put("inbccontent", inBuyContract.getInbccontent());
			json.put("inbtid", inBuyContract.getInbtid());
			json.put("inbtname", inBuyContract.getInbtname());
			json.put("inbctotalprice", inBuyContract.getInbctotalprice());
			json.put("inbcofferprice", inBuyContract.getInbcofferprice());
			json.put("inbcactualprice", inBuyContract.getInbcactualprice());
			json.put("inbcadvancemoney", inBuyContract.getInbcadvancemoney());
			json.put("intwid", inBuyContract.getIntwid());
			json.put("intwiname", inBuyContract.getIntwiname());
			json.put("indwid", inBuyContract.getIndwid());
			json.put("indwname", inBuyContract.getIndwname());
			json.put("inbcdeliverydate", inBuyContract.getInbcdeliverydate());
			json.put("inbcdeliveryaddress", inBuyContract.getInbcdeliveryaddress());
			json.put("remark", inBuyContract.getRemark());
			json.put("optname", inBuyContract.getOptname());
			//子表
			JSONArray childrenArray=new JSONArray();
			List<InBuyContractDetail> inBuyContractDetails=inBuyContract.getInBuyContractDetails();
			for(InBuyContractDetail inBuyContractDetail:inBuyContractDetails) {
				JSONObject child=new JSONObject();
				child.put("inbcdid", inBuyContractDetail.getInbcdid());
				child.put("inbaid", inBuyContractDetail.getInbaid());
				child.put("inbadid", inBuyContractDetail.getInbadid());
				child.put("inbcid", inBuyContractDetail.getInbcid());
				child.put("insiid", inBuyContractDetail.getInsiid());
				child.put("ingiid", inBuyContractDetail.getIngiid());
				InGoodsInfo iGI = inBuyContractDetail.getInGoodsInfo();
				child.put("inginame", iGI.getInginame());
				child.put("myprice", inBuyContractDetail.getMyprice());
				child.put("mycou", inBuyContractDetail.getMycou());
				child.put("mymoney", inBuyContractDetail.getMymoney());
				child.put("remark", inBuyContractDetail.getRemark());
				child.put("ingiid", inBuyContractDetail.getInGoodsInfo().getIngiid());
				child.put("inginame", inBuyContractDetail.getInGoodsInfo().getInginame());

				childrenArray.add(child);
				
			}
			json.put("inBuyContractDetails", childrenArray);
			jsonArray.add(json);
		}
		return jsonArray;
	}
	
	@Override
	public int addInBuyContract(InBuyContract inBuyContract, User user) {
		//根据子表找出申请表信息
		List<InBuyContractDetail> inBuyContractDetails=inBuyContract.getInBuyContractDetails();
		int inbaid=inBuyContractDetails.get(0).getInbaid(); //获得申请表id
		InBuyApply inBuyApply=inBuyApplyDao.findInBuyApplyById(inbaid);
		//设置合同签订人的信息
		inBuyContract.setBusiid(inBuyApply.getBusiid());
		inBuyContract.setBusiname(inBuyApply.getBusiname());
		inBuyContract.setBusiorgid(inBuyApply.getBusiorgid());
		inBuyContract.setBusideptid(inBuyApply.getBusideptid());
		//设置运输方式 交货方式 供应商 
		inBuyContract.setInsiid(Integer.parseInt(inBuyContract.getInsiname()));
		inBuyContract.setIntwid(Integer.parseInt(inBuyContract.getIntwiname()));
		inBuyContract.setIndwid(Integer.parseInt(inBuyContract.getIndwname()));
		//设置采购类型id
		inBuyContract.setInbtid(inBuyApply.getInbtid());
		//设置操作人信息
		inBuyContract.setOptid(user.getUid());
		inBuyContract.setOptname(user.getUname());
		inBuyContract.setOptdeptid(user.getRoleId());
		inBuyContract.setOptorgid(1);
		//添加主表信息
		int n=inBuyContractDao.addInBuyContract(inBuyContract);
		//添加子表信息
		int inbcidMax=inBuyContractDao.findMaxId();//查出添加主表的id
		for(InBuyContractDetail inBuyContractDetail:inBuyContractDetails) {
			inBuyContractDetail.setInbcid(inbcidMax);
			inBuyContractDetailDao.addInBuyContractDetail(inBuyContractDetail);//添加子表
			//修改申请表详细表的状态
			inBuyApplyDetailDao.updateState(inBuyContractDetail.getInbadid());
		}
		int count=inBuyApplyDetailDao.findNoContract(inbaid);
		if(count==0) {	//如果申请表子表全部生成合同，则更新主表状态
			inBuyApplyDao.updateWkexid(inbaid);
		}
		return n;
	}
}

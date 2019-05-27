package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InBuyApplyDao;
import com.lzf.erp.dao.InBuyApplyDetailDao;
import com.lzf.erp.model.InBuyApply;
import com.lzf.erp.model.InBuyApplyDetail;
import com.lzf.erp.model.InBuyType;
import com.lzf.erp.model.InGoodsInfo;
import com.lzf.erp.model.User;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyApplyServiceImpl.java
 * @类功能说明:  采购申请主表Service实现类
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日上午11:21:15
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日上午11:21:15</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InBuyApplyServiceImpl implements InBuyApplyService {
	
	@Autowired
	private InBuyApplyDao inBuyApplyDao;
	@Autowired
	private InBuyApplyDetailDao inBuyApplyDetailDao;

	// 全查inbuyapply表 
	@Override
	public JSONArray queryAllInBuyApply(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InBuyApply> IBAList = inBuyApplyDao.queryAllInBuyApply(map);
		for(InBuyApply ibaList: IBAList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("inbaid", ibaList.getInbaid());
			jsonObject.put("inbacode", ibaList.getInbacode());
			jsonObject.put("inbaname", ibaList.getInbaname());
			jsonObject.put("busiid", ibaList.getBusiid());
			jsonObject.put("businame", ibaList.getBusiname());
			jsonObject.put("busideptid", ibaList.getBusideptid());
			jsonObject.put("busiorgid", ibaList.getBusiorgid());
			jsonObject.put("inbtid", ibaList.getInbtid());
			jsonObject.put("inbareason", ibaList.getInbareason());
			jsonObject.put("inbadate", ibaList.getInbadate());
			jsonObject.put("remark", ibaList.getRemark());
			jsonObject.put("inbastate", ibaList.getInbastate());
			jsonObject.put("wkexid", ibaList.getWkexid());
			jsonObject.put("approvalview", ibaList.getApprovalview());
			jsonObject.put("state", ibaList.getState());
			jsonObject.put("delflag", ibaList.getDelflag());
			jsonObject.put("optid", ibaList.getOptid());
			jsonObject.put("optname", ibaList.getOptname());
			jsonObject.put("optdeptid", ibaList.getOptdeptid());
			jsonObject.put("optorgid", ibaList.getOptorgid());
			jsonObject.put("currdate", ibaList.getCurrdate());
			InBuyType inBuyType = ibaList.getInBuyType();
			jsonObject.put("inbtname", inBuyType.getInbtname());
			JSONArray jsonArrayDetail = new JSONArray();
			List<InBuyApplyDetail> IBADList = ibaList.getInBuyApplyDetail();
			for(InBuyApplyDetail ibadList: IBADList) {
				JSONObject jsonObjectDetail = new JSONObject();
				jsonObjectDetail.put("inbadid", ibadList.getInbadid());
				jsonObjectDetail.put("inbaid", ibadList.getInbaid());
				jsonObjectDetail.put("ingiid", ibadList.getIngiid());
				jsonObjectDetail.put("mycou", ibadList.getMycou());
				jsonObjectDetail.put("myprice", ibadList.getMyprice());
				jsonObjectDetail.put("mymoney", ibadList.getMymoney());
				jsonObjectDetail.put("usecou", ibadList.getUsecou());
				jsonObjectDetail.put("taxprice", ibadList.getTaxprice());
				jsonObjectDetail.put("taxmoney", ibadList.getTaxmoney());
				jsonObjectDetail.put("invoicesmoney", ibadList.getInvoicesmoney());
				jsonObjectDetail.put("paymoney", ibadList.getPaymoney());
				jsonObjectDetail.put("remark", ibadList.getRemark());
				jsonObjectDetail.put("state", ibadList.getState());
				jsonObjectDetail.put("delflag", ibadList.getDelflag());
				InGoodsInfo inGoodsInfo = ibadList.getInGoodsInfo();
				jsonObjectDetail.put("inginame", inGoodsInfo.getInginame());
				jsonArrayDetail.add(jsonObjectDetail);
			}
			jsonObject.put("inBuyApplyDetail", jsonArrayDetail);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询inbuyapply表条数
	@Override
	public Integer queryInBuyApplyCount(Map<String, Object> map) {
		return inBuyApplyDao.queryInBuyApplyCount(map);
	}

	// 添加inbuyapply表及其对应子表
	// (inbacode,inbaname,busiid,businame,inbtid,inbareason,inbadate,state,delflag,optid,optname,currdate)
	@Override
	public Integer addInBuyApply(InBuyApply inBuyApply, User user) {
		inBuyApply.setBusiid(user.getUid());
		inBuyApply.setBusiname(user.getUname());
		inBuyApply.setInbadate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		inBuyApply.setWkexid(0);
		inBuyApply.setState(0);
		inBuyApply.setDelflag(1);
		inBuyApply.setOptid(user.getUid());
		inBuyApply.setOptname(user.getUname());
		inBuyApply.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		Integer addRow = inBuyApplyDao.addInBuyApply(inBuyApply);
		Integer maxInbaid = inBuyApplyDao.getMaxInbaid();
		List<InBuyApplyDetail> IBADList = inBuyApply.getInBuyApplyDetail();
		for(InBuyApplyDetail ibadList: IBADList) {
			ibadList.setInbaid(maxInbaid);
			ibadList.setState(0);
			ibadList.setDelflag(1);
			System.out.println(ibadList);
			inBuyApplyDetailDao.addInBuyApplyDetail(ibadList);
		}
		return addRow;
	}

	// 逻辑删除inbuyapply表及其对应子表
	@Override
	public Integer deleteInBuyApply(Integer inbaid) {
		Integer delRowD = inBuyApplyDetailDao.deleteInBuyApplyDetailByInbaid(inbaid);
		Integer delRow = inBuyApplyDao.deleteInBuyApply(inbaid);
		return delRowD + delRow;
	}

	// 修改inbuyapply表及其对应子表
	@Override
	public Integer updateInBuyApply(InBuyApply inBuyApply) {
		Integer updRow =  inBuyApplyDao.updateInBuyApply(inBuyApply);
		List<InBuyApplyDetail> PageData = inBuyApply.getInBuyApplyDetail();
		List<InBuyApplyDetail> SqlData = inBuyApplyDetailDao.queryInBuyApplyDetailByInbaid(inBuyApply.getInbaid());
		if(SqlData != null) {
			for(InBuyApplyDetail sqlData: SqlData) {
				boolean isDelete = true;
				if(PageData != null) {
					for(InBuyApplyDetail pageData: PageData) {
						if(pageData.getInbadid() != null && pageData.getInbadid().equals(sqlData.getInbadid())) {
							isDelete = false;
						}
					}
				}
				if(isDelete) {
					inBuyApplyDetailDao.deleteInBuyApplyDetailByInbadid(sqlData.getInbadid());
				}
			}
		}
		if(PageData != null) {
			for(InBuyApplyDetail pageData: PageData) {
				if(pageData.getInbadid() == null) {
					pageData.setInbaid(inBuyApply.getInbaid());
					pageData.setState(0);
					pageData.setDelflag(1);
					inBuyApplyDetailDao.addInBuyApplyDetail(pageData);
				}else {
					inBuyApplyDetailDao.updateInBuyApplyDetail(pageData);
				}
			}
		}
		return updRow;
	}

	// 修改wkexid为1
	@Override
	public Integer updateWkexidForSubmit(Integer inbaid) {
		return inBuyApplyDao.updateWkexidForSubmit(inbaid);
	}

	// 查询已提交的inbuyapply表数据
	@Override
	public JSONArray querySubmitedInBuyApply(Map<String,Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InBuyApply> IBAList = inBuyApplyDao.querySubmitedInBuyApply(map);
		for(InBuyApply ibaList: IBAList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("inbaid", ibaList.getInbaid());
			jsonObject.put("inbacode", ibaList.getInbacode());
			jsonObject.put("inbaname", ibaList.getInbaname());
			jsonObject.put("busiid", ibaList.getBusiid());
			jsonObject.put("businame", ibaList.getBusiname());
			jsonObject.put("busideptid", ibaList.getBusideptid());
			jsonObject.put("busiorgid", ibaList.getBusiorgid());
			jsonObject.put("inbtid", ibaList.getInbtid());
			jsonObject.put("inbareason", ibaList.getInbareason());
			jsonObject.put("inbadate", ibaList.getInbadate());
			jsonObject.put("remark", ibaList.getRemark());
			jsonObject.put("inbastate", ibaList.getInbastate());
			jsonObject.put("wkexid", ibaList.getWkexid());
			jsonObject.put("approvalview", ibaList.getApprovalview());
			jsonObject.put("state", ibaList.getState());
			jsonObject.put("delflag", ibaList.getDelflag());
			jsonObject.put("optid", ibaList.getOptid());
			jsonObject.put("optname", ibaList.getOptname());
			jsonObject.put("optdeptid", ibaList.getOptdeptid());
			jsonObject.put("optorgid", ibaList.getOptorgid());
			jsonObject.put("currdate", ibaList.getCurrdate());
			InBuyType inBuyType = ibaList.getInBuyType();
			jsonObject.put("inbtname", inBuyType.getInbtname());
			JSONArray jsonArrayDetail = new JSONArray();
			List<InBuyApplyDetail> IBADList = ibaList.getInBuyApplyDetail();
			for(InBuyApplyDetail ibadList: IBADList) {
				JSONObject jsonObjectDetail = new JSONObject();
				jsonObjectDetail.put("inbadid", ibadList.getInbadid());
				jsonObjectDetail.put("inbaid", ibadList.getInbaid());
				jsonObjectDetail.put("ingiid", ibadList.getIngiid());
				jsonObjectDetail.put("mycou", ibadList.getMycou());
				jsonObjectDetail.put("myprice", ibadList.getMyprice());
				jsonObjectDetail.put("mymoney", ibadList.getMymoney());
				jsonObjectDetail.put("usecou", ibadList.getUsecou());
				jsonObjectDetail.put("taxprice", ibadList.getTaxprice());
				jsonObjectDetail.put("taxmoney", ibadList.getTaxmoney());
				jsonObjectDetail.put("invoicesmoney", ibadList.getInvoicesmoney());
				jsonObjectDetail.put("paymoney", ibadList.getPaymoney());
				jsonObjectDetail.put("remark", ibadList.getRemark());
				jsonObjectDetail.put("state", ibadList.getState());
				jsonObjectDetail.put("delflag", ibadList.getDelflag());
				InGoodsInfo inGoodsInfo = ibadList.getInGoodsInfo();
				jsonObjectDetail.put("inginame", inGoodsInfo.getInginame());
				jsonArrayDetail.add(jsonObjectDetail);
			}
			jsonObject.put("inBuyApplyDetail", jsonArrayDetail);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 申请驳回修改inbuyapply表数据
	@Override
	public Integer updateInBuyApplyForRejected(InBuyApply inBuyApply) {
		return inBuyApplyDao.updateInBuyApplyForRejected(inBuyApply);
	}

	// 申请通过修改inbuyapply表数据
	@Override
	public Integer updateInBuyApplyForThrough(InBuyApply inBuyApply) {
		return inBuyApplyDao.updateInBuyApplyForThrough(inBuyApply);
	}

	
	// 查询inbuyapply表数据申请统计用
	@Override
	public JSONArray queryInBuyApplyForStatistical(Map<String,Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<InBuyApply> IBAList = inBuyApplyDao.queryInBuyApplyForStatistical(map);
		for(InBuyApply ibaList: IBAList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("inbaid", ibaList.getInbaid());
			jsonObject.put("inbacode", ibaList.getInbacode());
			jsonObject.put("inbaname", ibaList.getInbaname());
			jsonObject.put("busiid", ibaList.getBusiid());
			jsonObject.put("businame", ibaList.getBusiname());
			jsonObject.put("busideptid", ibaList.getBusideptid());
			jsonObject.put("busiorgid", ibaList.getBusiorgid());
			jsonObject.put("inbtid", ibaList.getInbtid());
			jsonObject.put("inbareason", ibaList.getInbareason());
			jsonObject.put("inbadate", ibaList.getInbadate());
			jsonObject.put("remark", ibaList.getRemark());
			jsonObject.put("inbastate", ibaList.getInbastate());
			Integer wkexid =  ibaList.getWkexid();
			if(wkexid == 0) {
				jsonObject.put("wkexidTxt", "申请未提交");
			}
			if(wkexid == 1) {
				jsonObject.put("wkexidTxt", "申请未审核");
			}
			if(wkexid == 2) {
				jsonObject.put("wkexidTxt", "申请未签合同");
			}
			if(wkexid == 3) {
				jsonObject.put("wkexidTxt", "申请未下单");
			}
			if(wkexid == 4) {
				jsonObject.put("wkexidTxt", "申请未已下单");
			}
			jsonObject.put("approvalview", ibaList.getApprovalview());
			jsonObject.put("state", ibaList.getState());
			jsonObject.put("delflag", ibaList.getDelflag());
			jsonObject.put("optid", ibaList.getOptid());
			jsonObject.put("optname", ibaList.getOptname());
			jsonObject.put("optdeptid", ibaList.getOptdeptid());
			jsonObject.put("optorgid", ibaList.getOptorgid());
			jsonObject.put("currdate", ibaList.getCurrdate());
			InBuyType inBuyType = ibaList.getInBuyType();
			jsonObject.put("inbtname", inBuyType.getInbtname());
			JSONArray jsonArrayDetail = new JSONArray();
			List<InBuyApplyDetail> IBADList = ibaList.getInBuyApplyDetail();
			for(InBuyApplyDetail ibadList: IBADList) {
				JSONObject jsonObjectDetail = new JSONObject();
				jsonObjectDetail.put("inbadid", ibadList.getInbadid());
				jsonObjectDetail.put("inbaid", ibadList.getInbaid());
				jsonObjectDetail.put("ingiid", ibadList.getIngiid());
				jsonObjectDetail.put("mycou", ibadList.getMycou());
				jsonObjectDetail.put("myprice", ibadList.getMyprice());
				jsonObjectDetail.put("mymoney", ibadList.getMymoney());
				jsonObjectDetail.put("usecou", ibadList.getUsecou());
				jsonObjectDetail.put("taxprice", ibadList.getTaxprice());
				jsonObjectDetail.put("taxmoney", ibadList.getTaxmoney());
				jsonObjectDetail.put("invoicesmoney", ibadList.getInvoicesmoney());
				jsonObjectDetail.put("paymoney", ibadList.getPaymoney());
				jsonObjectDetail.put("remark", ibadList.getRemark());
				jsonObjectDetail.put("state", ibadList.getState());
				jsonObjectDetail.put("delflag", ibadList.getDelflag());
				InGoodsInfo inGoodsInfo = ibadList.getInGoodsInfo();
				jsonObjectDetail.put("inginame", inGoodsInfo.getInginame());
				jsonArrayDetail.add(jsonObjectDetail);
			}
			jsonObject.put("inBuyApplyDetail", jsonArrayDetail);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询inbuyapply表总条数申请统计用
	@Override
	public Integer queryInBuyApplyCountForStatistical(Map<String,Object> map) {
		return inBuyApplyDao.queryInBuyApplyCountForStatistical(map);
	}

	// 查询通过审核、不是直接采购的申请信息
	@Override
	public JSONArray queryInBuyApplyForContract() {
		JSONArray jsonArray = new JSONArray();
		List<InBuyApply> IBAList = inBuyApplyDao.queryInBuyApplyForContract();
		for(InBuyApply ibaList: IBAList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("inbaid", ibaList.getInbaid());
			jsonObject.put("inbacode", ibaList.getInbacode());
			jsonObject.put("inbaname", ibaList.getInbaname());
			jsonObject.put("busiid", ibaList.getBusiid());
			jsonObject.put("businame", ibaList.getBusiname());
			jsonObject.put("busideptid", ibaList.getBusideptid());
			jsonObject.put("busiorgid", ibaList.getBusiorgid());
			jsonObject.put("inbtid", ibaList.getInbtid());
			jsonObject.put("inbareason", ibaList.getInbareason());
			jsonObject.put("inbadate", ibaList.getInbadate());
			jsonObject.put("remark", ibaList.getRemark());
			jsonObject.put("inbastate", ibaList.getInbastate());
			jsonObject.put("wkexid", ibaList.getWkexid());
			jsonObject.put("approvalview", ibaList.getApprovalview());
			jsonObject.put("state", ibaList.getState());
			jsonObject.put("delflag", ibaList.getDelflag());
			jsonObject.put("optid", ibaList.getOptid());
			jsonObject.put("optname", ibaList.getOptname());
			jsonObject.put("optdeptid", ibaList.getOptdeptid());
			jsonObject.put("optorgid", ibaList.getOptorgid());
			jsonObject.put("currdate", ibaList.getCurrdate());
			InBuyType inBuyType = ibaList.getInBuyType();
			jsonObject.put("inbtname", inBuyType.getInbtname());
			JSONArray jsonArrayDetail = new JSONArray();
			List<InBuyApplyDetail> IBADList = ibaList.getInBuyApplyDetail();
			for(InBuyApplyDetail ibadList: IBADList) {
				JSONObject jsonObjectDetail = new JSONObject();
				jsonObjectDetail.put("inbadid", ibadList.getInbadid());
				jsonObjectDetail.put("inbaid", ibadList.getInbaid());
				jsonObjectDetail.put("ingiid", ibadList.getIngiid());
				jsonObjectDetail.put("mycou", ibadList.getMycou());
				jsonObjectDetail.put("myprice", ibadList.getMyprice());
				jsonObjectDetail.put("mymoney", ibadList.getMymoney());
				jsonObjectDetail.put("usecou", ibadList.getUsecou());
				jsonObjectDetail.put("taxprice", ibadList.getTaxprice());
				jsonObjectDetail.put("taxmoney", ibadList.getTaxmoney());
				jsonObjectDetail.put("invoicesmoney", ibadList.getInvoicesmoney());
				jsonObjectDetail.put("paymoney", ibadList.getPaymoney());
				jsonObjectDetail.put("remark", ibadList.getRemark());
				jsonObjectDetail.put("state", ibadList.getState());
				jsonObjectDetail.put("delflag", ibadList.getDelflag());
				InGoodsInfo inGoodsInfo = ibadList.getInGoodsInfo();
				jsonObjectDetail.put("inginame", inGoodsInfo.getInginame());
				jsonArrayDetail.add(jsonObjectDetail);
			}
			jsonObject.put("inBuyApplyDetail", jsonArrayDetail);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}


}

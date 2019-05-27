package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InBuyContractDao;
import com.lzf.erp.dao.InBuyOrderDao;
import com.lzf.erp.dao.InBuyOrderDetailDao;
import com.lzf.erp.model.InBuyContract;
import com.lzf.erp.model.InBuyOrder;
import com.lzf.erp.model.InBuyOrderDetail;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyOrderServiceimpl.java
 * @类功能说明: 订单 service 接口实现类
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日下午6:26:09
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日下午6:26:09</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class InBuyOrderServiceimpl implements InBuyOrderService {

	@Autowired
	private InBuyOrderDao inBuyOrderDao;
	
	@Autowired
	private InBuyOrderDetailDao inBuyOrderDetailDao;
	
	@Autowired
	private InBuyContractDao inBuyContractDao;
	/**@方法名: findAllInBuyOrder
	 * @方法说明: 查询订单 分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午6:26:28
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray findAllInBuyOrder(Map<String, Object> map) {
		List<InBuyOrder> inBuyOrders=inBuyOrderDao.findAllInBuyOrder(map);
		JSONArray jsonArray=new JSONArray();
		for(InBuyOrder inBuyOrder:inBuyOrders) {
			JSONObject json=new JSONObject();
			//主表
			json.put("inboid", inBuyOrder.getInboid());
			json.put("inbocode", inBuyOrder.getInbocode());
			json.put("inboname", inBuyOrder.getInboname());
			json.put("insiid", inBuyOrder.getBusiid());
			json.put("insiname", inBuyOrder.getInsiname());
			json.put("busiid", inBuyOrder.getBusiid());
			json.put("businame", inBuyOrder.getBusiname());
			json.put("inbodate", inBuyOrder.getInbodate());
			json.put("inbototalprice", inBuyOrder.getInbototalprice());
			json.put("inboofferprice", inBuyOrder.getInboofferprice());
			json.put("inboactualprice", inBuyOrder.getInboactualprice());
			json.put("intwid", inBuyOrder.getIntwid());
			json.put("intwiname", inBuyOrder.getIntwiname());
			json.put("indwid", inBuyOrder.getIndwid());
			json.put("indwname", inBuyOrder.getIndwname());
			json.put("inbodeliverydate", inBuyOrder.getInbodeliverydate());
			json.put("inbodeliveryaddress", inBuyOrder.getInbodeliveryaddress());
			json.put("remark", inBuyOrder.getRemark());
			json.put("optname", inBuyOrder.getOptname());
			//子表
			JSONArray childrenArray=new JSONArray();
			List<InBuyOrderDetail> inBuyOrderDetails=inBuyOrder.getInBuyOrderDetails();
			for(InBuyOrderDetail inBuyOrderDetail:inBuyOrderDetails) {
				JSONObject child=new JSONObject();
				child.put("inbodid", inBuyOrderDetail.getInbodid());
				child.put("inboid", inBuyOrderDetail.getInboid());
				child.put("inbodid", inBuyOrderDetail.getInbodid());
				child.put("inboid", inBuyOrderDetail.getInboid());
				child.put("inbaid", inBuyOrderDetail.getInbaid());
				child.put("inbadid", inBuyOrderDetail.getInbadid());
				child.put("insiid", inBuyOrderDetail.getInsiid());
				child.put("ingiid", inBuyOrderDetail.getIngiid());
				child.put("myprice", inBuyOrderDetail.getMyprice());
				child.put("mycou", inBuyOrderDetail.getMycou());
				child.put("mymoney", inBuyOrderDetail.getMymoney());
				child.put("remark", inBuyOrderDetail.getRemark());
				child.put("ingiid", inBuyOrderDetail.getInGoodsInfo().getIngiid());
				child.put("inginame", inBuyOrderDetail.getInGoodsInfo().getInginame());
				childrenArray.add(child);
				
			}
			json.put("inBuyOrderDetails", childrenArray);
			jsonArray.add(json);
		}
		return jsonArray;
	}

	/**@方法名: findAllInBuyOrderCount
	 * @方法说明: 订单查询  +模糊搜索总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午6:37:47
	 * @param map
	 * @return
	 * @return:
	 */
	@Override
	public int findAllInBuyOrderCount(Map<String, Object> map) {
		return inBuyOrderDao.findAllInBuyOrderCount(map);
	}

	/**@方法名: addInBuyOrder
	 * @方法说明: 添加订单表信息   修改合同表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日上午10:33:30
	 * @param inBuyOrder
	 * @param user
	 * @return
	 * @return:
	 */
	@Override
	public int addInBuyOrder(InBuyOrder inBuyOrder, User user) {
		List<InBuyOrderDetail> inBuyOrderDetails=inBuyOrder.getInBuyOrderDetails();
		int inbcid=inBuyOrderDetails.get(0).getInbcid();//获取合同id
		InBuyContract inBuyContract=inBuyContractDao.findInBuyContractById(inbcid);
		inBuyContractDao.updateWkexid(inbcid);//修改合同表状态
		inBuyOrder.setBusiid(inBuyContract.getBusiid());
		inBuyOrder.setInsiid(inBuyContract.getInsiid());
		inBuyOrder.setBusiname(inBuyContract.getBusiname());
		inBuyOrder.setBusiid(inBuyContract.getBusiid());
		inBuyOrder.setBusideptid(inBuyContract.getBusideptid());
		inBuyOrder.setBusiorgid(inBuyContract.getBusiorgid());
		inBuyOrder.setInbodate(inBuyContract.getInbcdate());
		inBuyOrder.setInbototalprice(inBuyContract.getInbctotalprice());
		inBuyOrder.setInboofferprice(inBuyContract.getInbcofferprice());
		inBuyOrder.setInboactualprice(inBuyContract.getInbcactualprice());
		inBuyOrder.setIndwid(inBuyContract.getIndwid());
		inBuyOrder.setIntwid(inBuyContract.getIntwid());
		inBuyOrder.setInbodeliverydate(inBuyContract.getInbcdeliverydate());
		inBuyOrder.setInbodeliveryaddress(inBuyContract.getInbcdeliveryaddress());
		inBuyOrder.setOptid(user.getUid());
		inBuyOrder.setOptname(user.getUname());
		inBuyOrder.setOptorgid(user.getRoleId());
		inBuyOrder.setOptdeptid(1);
		//添加主表
		int n =inBuyOrderDao.addInBuyOrder(inBuyOrder);
		int inboidMax=inBuyOrderDao.findMaxInboid();//找出添加的主表id
		
		for(InBuyOrderDetail inBuyOrderDetail:inBuyOrderDetails) {
			inBuyOrderDetail.setInboid(inboidMax);
			//添加子表
			inBuyOrderDetailDao.addInBuyOrderDetail(inBuyOrderDetail);
		}
		
		return n;
	}

	/**@方法名: updateInBuyOrder
	 * @方法说明: 修改订单主表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午1:56:53
	 * @param inBuyOrder
	 * @return
	 * @return:
	 */
	@Override
	public int updateInBuyOrder(InBuyOrder inBuyOrder) {
		// TODO Auto-generated method stub
		return inBuyOrderDao.updateInBuyOrder(inBuyOrder);
	}

	/**@方法名: deleteInBuyOrder
	 * @方法说明: 删除订单表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午2:17:50
	 * @param inbodid
	 * @return
	 * @return:
	 */
	@Override
	public int deleteInBuyOrder(int inboid) {
		// TODO Auto-generated method stub
		int n=inBuyOrderDao.deleteInBuyOrder(inboid);//删除主表
		inBuyOrderDetailDao.deleteInBuyOrderDetail(inboid);//删除子表
		return n;
	}

	// 查询inbuyorder用于订单统计
	@Override
	public JSONArray queryInBuyOrderForStatistics(Map<String, Object> map) {
		List<InBuyOrder> inBuyOrders=inBuyOrderDao.queryInBuyOrderForStatistics(map);
		JSONArray jsonArray=new JSONArray();
		for(InBuyOrder inBuyOrder:inBuyOrders) {
			JSONObject json=new JSONObject();
			//主表
			json.put("inboid", inBuyOrder.getInboid());
			json.put("inbocode", inBuyOrder.getInbocode());
			json.put("inboname", inBuyOrder.getInboname());
			json.put("insiid", inBuyOrder.getBusiid());
			json.put("insiname", inBuyOrder.getInsiname());
			json.put("busiid", inBuyOrder.getBusiid());
			json.put("businame", inBuyOrder.getBusiname());
			json.put("inbodate", inBuyOrder.getInbodate());
			json.put("inbototalprice", inBuyOrder.getInbototalprice());
			json.put("inboofferprice", inBuyOrder.getInboofferprice());
			json.put("inboactualprice", inBuyOrder.getInboactualprice());
			json.put("intwid", inBuyOrder.getIntwid());
			json.put("intwiname", inBuyOrder.getIntwiname());
			json.put("indwid", inBuyOrder.getIndwid());
			json.put("indwname", inBuyOrder.getIndwname());
			json.put("inbodeliverydate", inBuyOrder.getInbodeliverydate());
			json.put("inbodeliveryaddress", inBuyOrder.getInbodeliveryaddress());
			json.put("remark", inBuyOrder.getRemark());
			Integer wkexid =  inBuyOrder.getWkexid();
			if(wkexid == 3) {
				json.put("wkexidTxt", "未下单");
			}
			if(wkexid == 4) {
				json.put("wkexidTxt", "已下单");
			}
			json.put("optname", inBuyOrder.getOptname());
			//子表
			JSONArray childrenArray=new JSONArray();
			List<InBuyOrderDetail> inBuyOrderDetails=inBuyOrder.getInBuyOrderDetails();
			for(InBuyOrderDetail inBuyOrderDetail:inBuyOrderDetails) {
				JSONObject child=new JSONObject();
				child.put("inbodid", inBuyOrderDetail.getInbodid());
				child.put("inboid", inBuyOrderDetail.getInboid());
				child.put("inbodid", inBuyOrderDetail.getInbodid());
				child.put("inboid", inBuyOrderDetail.getInboid());
				child.put("inbaid", inBuyOrderDetail.getInbaid());
				child.put("inbadid", inBuyOrderDetail.getInbadid());
				child.put("insiid", inBuyOrderDetail.getInsiid());
				child.put("ingiid", inBuyOrderDetail.getIngiid());
				child.put("myprice", inBuyOrderDetail.getMyprice());
				child.put("mycou", inBuyOrderDetail.getMycou());
				child.put("mymoney", inBuyOrderDetail.getMymoney());
				child.put("remark", inBuyOrderDetail.getRemark());
				child.put("ingiid", inBuyOrderDetail.getInGoodsInfo().getIngiid());
				child.put("inginame", inBuyOrderDetail.getInGoodsInfo().getInginame());
				childrenArray.add(child);
				
			}
			json.put("inBuyOrderDetails", childrenArray);
			jsonArray.add(json);
		}
		return jsonArray;
	}

}

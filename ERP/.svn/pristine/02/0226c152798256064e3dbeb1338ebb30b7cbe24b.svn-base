package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.InsupplierCategoryDao;
import com.lzf.erp.dao.InsupplierInfoDao;
import com.lzf.erp.dao.InsupplierLinkManDao;
import com.lzf.erp.model.InsupplierInfo;
import com.lzf.erp.model.InsupplierLinkMan;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InsupplierInfoService;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class InsupplierInfoServiceimpl implements InsupplierInfoService {
	
	@Autowired
	private InsupplierInfoDao InsupplierInfoDao;
	@Autowired
	private InsupplierCategoryDao insupplierCategoryDao;
	@Autowired
	private InsupplierLinkManDao insupplierLinkManDao;

	/**@方法名: findAllinsupplierInfo
	 * @方法说明: 查询供应商列表  分页+模糊+联系人
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:16:53
	 * @param map
	 * @return
	 * @return: JSONArray
	 */
	@Override
	public JSONArray findAllinsupplierInfo(Map<String, Object> map) {
		List<InsupplierInfo> insupplierInfos=InsupplierInfoDao.findAllinsupplierInfo(map);
		JSONArray jsonArray=new JSONArray();
		for(InsupplierInfo insupplierInfo:insupplierInfos) {
			JSONObject json=new JSONObject();
			json.put("insiid", insupplierInfo.getInsiid());
			json.put("insicode", insupplierInfo.getInsicode());
			json.put("insiname", insupplierInfo.getInsiname());
			json.put("inscid", insupplierInfo.getInscid());
			json.put("inscname", insupplierCategoryDao.findNameById(insupplierInfo.getInscid()));
			json.put("inslid", insupplierInfo.getInslid());
			json.put("insaid", insupplierInfo.getInsaid());
			json.put("insiaddress", insupplierInfo.getInsiaddress());
			json.put("insiphone", insupplierInfo.getInsiphone());
			json.put("insilicense", insupplierInfo.getInsilicense());
			json.put("insipermitlicense", insupplierInfo.getInsipermitlicense());
			json.put("insilegalman", insupplierInfo.getInsilegalman());
			json.put("insitaxnum", insupplierInfo.getInsitaxnum());
			json.put("insibank", insupplierInfo.getInsibank());
			json.put("insibankaccount", insupplierInfo.getInsibankaccount());
			json.put("remark", insupplierInfo.getRemark());
			json.put("optname", insupplierInfo.getOptname());
			json.put("currdate", insupplierInfo.getCurrdate());
			//从表
			JSONArray childArray= new JSONArray();
			List<InsupplierLinkMan> insupplierLinkMans=insupplierInfo.getInsupplierLinkmans();
			for(InsupplierLinkMan insupplierLinkMan:insupplierLinkMans) {
				JSONObject childJson=new JSONObject();
				childJson.put("inslmid", insupplierLinkMan.getInslmid());
				childJson.put("inslmcode", insupplierLinkMan.getInslmcode());
				childJson.put("inslmname", insupplierLinkMan.getInslmname());
				childJson.put("insiid", insupplierLinkMan.getInsiid());
				childJson.put("inslmphone", insupplierLinkMan.getInslmphone());
				childJson.put("remark", insupplierLinkMan.getRemark());
				childArray.add(childJson);
			}
			json.put("Insupplierlinkmans", childArray);
			jsonArray.add(json);

			
		}
		return jsonArray;
	}
	/**@方法名: findAllinsupplierInfoCount
	 * @方法说明:  查询供应商列表总条数
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:17:18
	 * @param map
	 * @return
	 * @return: int
	 */
	@Override
	public int findAllinsupplierInfoCount(Map<String, Object> map) {
		
		return InsupplierInfoDao.findAllinsupplierInfoCount(map);
	}
	
	/**@方法名: addInsupplierInfo
	 * @方法说明: 添加供应商详情表 +子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:06:52
	 * @param user
	 * @param insupplierInfo
	 * @return
	 * @return:
	 */
	@Override
	public int addInsupplierInfo(User user, InsupplierInfo insupplierInfo) {
		//添加主表
		insupplierInfo.setInscid(Integer.parseInt(insupplierInfo.getInscname()));
		insupplierInfo.setInslid(Integer.parseInt(insupplierInfo.getInslname()));
		insupplierInfo.setInsaid(Integer.parseInt(insupplierInfo.getInsaname()));
		insupplierInfo.setState(1);
		insupplierInfo.setDelflag(1);
		//insupplierInfo.setOptid(user.getUid());
		insupplierInfo.setOptname(user.getUname());
		insupplierInfo.setOptdeptid(user.getRoleId());
		insupplierInfo.setOptorgid(1);
		insupplierInfo.setCurrdate(DateUtil.formatDate(new Date(), "yy-MM-dd HH:mm:ss"));
		int n =InsupplierInfoDao.addInsupplierInfo(insupplierInfo);
		int max=InsupplierInfoDao.findMaxId();
		List<InsupplierLinkMan> insupplierLinkMans=insupplierInfo.getInsupplierLinkmans();
		if(insupplierLinkMans!=null&&insupplierLinkMans.size()>0) {
			for(InsupplierLinkMan insupplierLinkMan:insupplierLinkMans) {
				insupplierLinkMan.setInsiid(max);
				insupplierLinkMan.setState(1);
				insupplierLinkMan.setDelflag(1);
				insupplierLinkManDao.addInsupplierLinkMan(insupplierLinkMan);
			}
		}
		
		return n;
	}
	/**@方法名: updateInsupplierInfo
	 * @方法说明: 修改商品供应商+子表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:57:48
	 * @param user
	 * @param insupplierInfo
	 * @return
	 * @return:
	 */
	@Override
	public int updateInsupplierInfo(User user,InsupplierInfo insupplierInfo) {
		insupplierInfo.setInscid(Integer.parseInt(insupplierInfo.getInscname()));
		insupplierInfo.setInslid(Integer.parseInt(insupplierInfo.getInslname()));
		insupplierInfo.setInsaid(Integer.parseInt(insupplierInfo.getInsaname()));
		int n =InsupplierInfoDao.updateInsupplierInfo(insupplierInfo);
		List<InsupplierLinkMan> insupplierLinkMans=insupplierInfo.getInsupplierLinkmans();
		insupplierLinkManDao.deleteInsupplierLinkManByInsiid(insupplierInfo.getInsiid());
		if(insupplierLinkMans!=null && insupplierLinkMans.size()>0) {
			for(InsupplierLinkMan insupplierLinkMan:insupplierLinkMans) {
				insupplierLinkMan.setInsiid(insupplierInfo.getInsiid());
				insupplierLinkMan.setState(1);
				insupplierLinkMan.setDelflag(1);
				insupplierLinkManDao.addInsupplierLinkMan(insupplierLinkMan);
			}
		}
		
		return n;
	}
	
	/**@方法名: deleteInsupplierInfo
	 * @方法说明: 删除 供应商信息表 +子表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午10:06:27
	 * @param insiid
	 * @return
	 * @return:
	 */
	@Override
	public int deleteInsupplierInfo(int insiid) {
		int n=InsupplierInfoDao.deleteInsupplierInfo(insiid);
		insupplierLinkManDao.deleteInsupplierLinkMan(insiid);
		return n;
	}
	/**@方法名: queryAllInBuygys
	 * @方法说明: 供应商下拉框数据
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午4:24:15
	 * @return
	 * @return:
	 */
	@Override
	public JSONArray queryAllInBuygys() {
		JSONArray jsonArray=new JSONArray();
		List<InsupplierInfo> insupplierInfos=InsupplierInfoDao.queryAllInBuygys();
		for(InsupplierInfo insupplierInfo:insupplierInfos) {
			JSONObject json=new JSONObject();
			json.put("insiid", insupplierInfo.getInsiid());
			json.put("insiname", insupplierInfo.getInsiname());
			jsonArray.add(json);
		}
		return jsonArray;
	}

}

package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.erp.model.InTransportWay;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InTransportWayService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InTransportWayController.java
 * @类功能说明: 采购类型控制层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日下午1:51:57
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日下午1:51:57</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inTransportWay")
public class InTransportWayController2 {
	
	@Autowired
	private InTransportWayService inTransportWayService;
	
	@RequestMapping("/queryAllInTransportWay.do")
	public void queryAllInTransportWay(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = inTransportWayService.queryAllInTransportWay();
		ResponseUtil.write(response, jsonArray);
	}
	/**@方法名: findAllInTransportWay
	 * @方法说明: 查询采购类型  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:06:31
	 * @param page
	 * @param s_intwname
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findAllInTransportWay")
	public void findAllInTransportWay(PageBean page,String s_intwname,HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageBean", page);
		map.put("s_intwname", s_intwname);
		JSONArray jsonArray=inTransportWayService.findAllInTransportWay(map);
		int total=inTransportWayService.findAllInTransportWayCount(map);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	/**@方法名: addInTransportWay
	 * @方法说明: 添加采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:11:39
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/addInTransportWay")
	public void addInTransportWay(InTransportWay ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=inTransportWayService.addInTransportWay(ibt,user);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: updateInTransportWay
	 * @方法说明: 修改采购类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:12:45
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInTransportWay")
	public void updateInTransportWay(InTransportWay ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inTransportWayService.updateInTransportWay(ibt);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: deleteInTransportWayById
	 * @方法说明: 删除采购类型  逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:16:48
	 * @param delIds
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/deleteInTransportWayById")
	public void deleteInTransportWayById(String delIds,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inTransportWayService.deleteInTransportWayById(delIds);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInTransportWayByCode
	 * @方法说明: 验证编码唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:17:56
	 * @param code
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findInTransportWayByCode") 
	public void findInTransportWayByCode(String code,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inTransportWayService.findInTransportWayeByCode(code);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInTransportWayByName
	 * @方法说明: 验证采购类型名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:18:37
	 * @param name
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findInTransportWayByName") 
	public void findInTransportWayByName(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inTransportWayService.findInTransportWayByName(name);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findAllInTransportWayList
	 * @方法说明: 采购类型 下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:19:35
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findAllInTransportWayList")
	public void findAllInTransportWayList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray=inTransportWayService.findAllInTransportWayList();
		ResponseUtil.write(response, jsonArray);
	}
}

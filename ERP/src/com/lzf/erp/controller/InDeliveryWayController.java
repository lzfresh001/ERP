package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.erp.model.InDeliveryWay;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InDeliveryWayService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InDeliveryWayController.java
 * @类功能说明: 交货方式类型控制层
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
@RequestMapping("/inDeliveryWay")
public class InDeliveryWayController {
	
	@Autowired  
	private InDeliveryWayService inDeliveryWayService;
	
	@RequestMapping("/queryAllInDeliveryWay.do")
	public void queryAllInDeliveryWay(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = inDeliveryWayService.queryAllInDeliveryWay();
		ResponseUtil.write(response, jsonArray);
	}
	/**@方法名: findAllInDeliveryWay
	 * @方法说明: 查询交货方式类型  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:06:31
	 * @param page
	 * @param s_intwname
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findAllInDeliveryWay")
	public void findAllInDeliveryWay(PageBean page,String s_indwname,HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageBean", page);
		map.put("s_indwname", s_indwname);
		JSONArray jsonArray=inDeliveryWayService.findAllInDeliveryWay(map);
		int total=inDeliveryWayService.findAllInDeliveryWayCount(map);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	/**@方法名: addInDeliveryWay
	 * @方法说明: 添加交货方式类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:11:39
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/addInDeliveryWay")
	public void addInDeliveryWay(InDeliveryWay ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println(ibt.getIndwcode());
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=inDeliveryWayService.addInDeliveryWay(ibt,user);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: updateInDeliveryWay
	 * @方法说明: 修改交货方式类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:12:45
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInDeliveryWay")
	public void updateInDeliveryWay(InDeliveryWay ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inDeliveryWayService.updateInDeliveryWay(ibt);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: deleteInDeliveryWayById
	 * @方法说明: 删除交货方式类型  逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:16:48
	 * @param delIds
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/deleteInDeliveryWayById")
	public void deleteInDeliveryWayById(String delIds,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inDeliveryWayService.deleteInDeliveryWayById(delIds);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInDeliveryWayByCode
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
	@RequestMapping("/findInDeliveryWayByCode") 
	public void findInDeliveryWayByCode(String code,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inDeliveryWayService.findInDeliveryWayeByCode(code);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInDeliveryWayByName
	 * @方法说明: 验证交货方式类型名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:18:37
	 * @param name
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findInDeliveryWayByName") 
	public void findInDeliveryWayByName(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inDeliveryWayService.findInDeliveryWayByName(name);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findAllInDeliveryWayList
	 * @方法说明: 交货方式类型 下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:19:35
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findAllInDeliveryWayList")
	public void findAllInDeliveryWayList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray=inDeliveryWayService.findAllInDeliveryWayList();
		ResponseUtil.write(response, jsonArray);
	}
}

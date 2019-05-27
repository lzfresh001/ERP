package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InsupplierInfo;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InsupplierInfoService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InsupplierInfoController.java
 * @类功能说明: 供应商详情controller 层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月13日下午2:14:42
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月13日下午2:14:42</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/insupplierInfo")
public class InsupplierInfoController {
	
	@Autowired
	private InsupplierInfoService insupplierInfoService;
	
	/**@方法名: findAllinsupplierInfo
	 * @方法说明: 查询所有的供应商信息 分页+模糊搜索+联系人列表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日下午2:15:02
	 * @param page
	 * @param s_insiname  模糊搜索字段
	 * @param s_insiaddress 模糊搜索字段
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("findAllinsupplierInfo")
	public void findAllinsupplierInfo(PageBean page,
			@RequestParam(value="s_insiname",required=false)String s_insiname,
			@RequestParam(value="s_insiaddress",required=false)String s_insiaddress,
			HttpServletResponse response) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("s_insiname", s_insiname);
		map.put("s_insiaddress", s_insiaddress);
		JSONArray jsonArray=insupplierInfoService.findAllinsupplierInfo(map);
		int total=insupplierInfoService.findAllinsupplierInfoCount(map);
		System.out.println(jsonArray);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	/**@方法名: addInsupplierInfo
	 * @方法说明: 添加供应商信息表  包括子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午8:58:12
	 * @param insupplierInfo
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("addInsupplierInfo")
	public void addInsupplierInfo(@RequestBody InsupplierInfo insupplierInfo,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=insupplierInfoService.addInsupplierInfo(user,insupplierInfo);
		JSONObject json=new JSONObject();
		if(n>0) {
			json.put("success", true);
		}else {
			json.put("success", false);
		}
		ResponseUtil.write(response, json);
	}
	/**@方法名: updateInsupplierInfo
	 * @方法说明: 修改供应商信息表  包括子表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:03:13
	 * @param insupplierInfo
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("updateInsupplierInfo")
	public void updateInsupplierInfo(@RequestBody InsupplierInfo insupplierInfo,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=insupplierInfoService.updateInsupplierInfo(user,insupplierInfo);
		JSONObject json=new JSONObject();
		if(n>0) {
			json.put("success", true);
		}else {
			json.put("success", false);
		}
		ResponseUtil.write(response, json);
	}
	@RequestMapping("deleteInsupplierInfo")
	public void deleteInsupplierInfo(int insiid,
			HttpServletResponse response) throws Exception {
		int n=insupplierInfoService.deleteInsupplierInfo(insiid);
		JSONObject json=new JSONObject();
		if(n>0) {
			json.put("success", true);
		}else {
			json.put("success", false);
		}
		ResponseUtil.write(response, json);
	}
	/**@方法名: queryAllInBuygys
	 * @方法说明: 供应商下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午4:23:11
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/queryAllInBuygys")
	public void queryAllInBuygys(HttpServletResponse response) throws Exception {
		JSONArray jsonArray=insupplierInfoService.queryAllInBuygys();
		System.out.println("供应商下拉框数据"+jsonArray);
		ResponseUtil.write(response, jsonArray);
	}
}

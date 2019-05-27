package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InsupplierCategory;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InsupplierCategoryService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InsupplierCategoryController.java
 * @类功能说明: 供应商类别 controller 层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月11日下午2:47:50
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月11日下午2:47:50</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/insupplierCategory")
public class InsupplierCategoryController {

	@Autowired
	private InsupplierCategoryService insupplierCategoryService;
	
	/**@方法名: findAllICategory
	 * @方法说明: 查询供应商类别表  分页+模糊搜索
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月11日下午3:06:35
	 * @param pageBean
	 * @param s_inscname
	 * @param s_optname
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findAllICategory")
	public void findAllICategory(PageBean pageBean,@RequestParam(value="s_inscname",required=false)String s_inscname,
			@RequestParam(value="s_optname",required=false)String s_optname,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageBean", pageBean);
		map.put("s_inscname", s_inscname);
		map.put("s_optname", s_optname);
		JSONArray jsonArray=insupplierCategoryService.findAllICategory(map);
		int total=insupplierCategoryService.findAllICategoryCount(map);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	/**@方法名: addCs
	 * @方法说明: 添加供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:37:50
	 * @param ic
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/addCs")
	public void addCs(InsupplierCategory ic,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=insupplierCategoryService.addCs(ic,user);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: updateCs
	 * @方法说明: 修改供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:43:12
	 * @param ic
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/updateCs")
	public void updateCs(InsupplierCategory ic,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=insupplierCategoryService.updateCs(ic);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: deleteCsById
	 * @方法说明: 删除供应商类别
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午9:43:20
	 * @param delIds
	 * @param ic
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteCsById")
	public void deleteCsById(String delIds,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=insupplierCategoryService.deleteCsById(delIds);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInsupplierCategoryByCode
	 * @方法说明: 验证编码唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:05:03
	 * @param code
	 * @param request
	 * @param response >0 已存在
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findInsupplierCategoryByCode") 
	public void findInsupplierCategoryByCode(String code,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=insupplierCategoryService.findInsupplierCategoryByCode(code);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInsupplierCategoryByName
	 * @方法说明: 验证供应商类别名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月13日上午11:05:56
	 * @param code
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findInsupplierCategoryByName") 
	public void findInsupplierCategoryByName(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=insupplierCategoryService.findInsupplierCategoryByName(name);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	@RequestMapping("/findAllICategoryList")
	public void findAllICategoryList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray=insupplierCategoryService.findAllICategoryList();
		ResponseUtil.write(response, jsonArray);
	}
}

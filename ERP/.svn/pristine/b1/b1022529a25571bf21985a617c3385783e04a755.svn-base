package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.erp.model.InBuyType;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InBuyTypeService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyTypeController.java
 * @类功能说明: 运输方式类型控制层
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
@RequestMapping("/inBuyType")
public class InBuyTypeController {
	
	@Autowired
	private InBuyTypeService inBuyTypeService;
	
	@RequestMapping("/queryAllInBuyType.do")
	public void queryAllInBuyType(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = inBuyTypeService.queryAllInBuyType();
		ResponseUtil.write(response, jsonArray);
	}
	/**@方法名: findAllInBuyType
	 * @方法说明: 查询运输方式类型  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:06:31
	 * @param page
	 * @param s_inbtname
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findAllInBuyType")
	public void findAllInBuyType(PageBean page,String s_inbtname,HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageBean", page);
		map.put("s_inbtname", s_inbtname);
		JSONArray jsonArray=inBuyTypeService.findAllInBuyType(map);
		int total=inBuyTypeService.findAllInBuyTypeCount(map);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	/**@方法名: addInBuyType
	 * @方法说明: 添加运输方式类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:11:39
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/addInBuyType")
	public void addInBuyType(InBuyType ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		int n=inBuyTypeService.addInBuyType(ibt,user);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: updateInBuyType
	 * @方法说明: 修改运输方式类型
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:12:45
	 * @param ibt
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInBuyType")
	public void updateInBuyType(InBuyType ibt,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inBuyTypeService.updateInBuyType(ibt);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: deleteInBuyTypeById
	 * @方法说明: 删除运输方式类型  逻辑删除
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:16:48
	 * @param delIds
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/deleteInBuyTypeById")
	public void deleteInBuyTypeById(String delIds,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inBuyTypeService.deleteInBuyTypeById(delIds);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInBuyTypeByCode
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
	@RequestMapping("/findInBuyTypeByCode") 
	public void findInBuyTypeByCode(String code,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inBuyTypeService.findInBuyTypeByCode(code);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findInBuyTypeByName
	 * @方法说明: 验证运输方式类型名称唯一性
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:18:37
	 * @param name
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findInBuyTypeByName") 
	public void findInBuyTypeByName(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		int n=inBuyTypeService.findInBuyTypeByName(name);
		JSONObject json =new JSONObject();
		json.put("result", n);
		ResponseUtil.write(response, json);
	}
	/**@方法名: findAllInBuyTypeList
	 * @方法说明: 运输方式类型 下拉框
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月15日上午10:19:35
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/findAllInBuyTypeList")
	public void findAllInBuyTypeList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray=inBuyTypeService.findAllInBuyTypeList();
		ResponseUtil.write(response, jsonArray);
	}
}

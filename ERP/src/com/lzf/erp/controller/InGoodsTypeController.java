package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InGoodsType;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InGoodsTypeService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsTypeController.java
 * @类功能说明: 商品类型Controller控制层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午11:26:28
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午11:26:28</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inGoodsType")
public class InGoodsTypeController {
	
	@Autowired
	private InGoodsTypeService inGoodsTypeService;
	
	/**@方法名: queryAllinGoodsType
	 * @方法说明: 全查商品类型路径
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月13日下午3:06:30
	 * @param page
	 * @param rows
	 * @param ingtname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryAllInGoodsType.do")
	public void queryAllInGoodsType(@RequestParam(value="page",required=false)String page,
						            @RequestParam(value="rows",required=false)String rows,
						            @RequestParam(value="ingtname",required=false)String ingtname,
						            HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		map.put("pageBean", pageBean);
		if(StringUtil.isNotEmpty(ingtname)) {
			map.put("ingtname", ingtname);
		}
		JSONArray jsonArray = inGoodsTypeService.queryAllInGoodsType(map);
		Integer total = inGoodsTypeService.queryInGoodsTypeCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngtcode
	 * @方法说明: 验证物品类型编码的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午2:43:55
	 * @param ingtcode
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngtcode.do")
	public void checkIngtcode(@RequestParam(value="ingtcode",required=false)String ingtcode,
							  HttpServletResponse response) throws Exception {
		InGoodsType inGoodsType = inGoodsTypeService.queryAllInGoodsTypeByIngtcode(ingtcode);
		JSONObject jsonObject = new JSONObject();
		if(inGoodsType != null) {
			jsonObject.put("hasIGT", "1");
		}else {
			jsonObject.put("hasIGT", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngtname
	 * @方法说明:验证物品类别名称的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午3:03:24
	 * @param ingtname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngtname.do")
	public void checkIngtname(@RequestParam(value="ingtname",required=false)String ingtname,
							  HttpServletResponse response) throws Exception {
		InGoodsType inGoodsType = inGoodsTypeService.queryAllInGoodsTypeByIngtname(ingtname);
		JSONObject jsonObject = new JSONObject();
		if(inGoodsType != null) {
			jsonObject.put("hasIGT", "1");
		}else {
			jsonObject.put("hasIGT", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: saveinGoodsType
	 * @方法说明: 添加物品类型
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午3:39:37
	 * @param inGoodsType
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/saveInGoodsType.do")
	public void saveinGoodsType(InGoodsType inGoodsType,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("currentUser");
		Integer addRow = inGoodsTypeService.addInGoodsType(inGoodsType, user);
		JSONObject jsonObject = new JSONObject();
		if(addRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "添加失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: updateInGoodsType
	 * @方法说明: 修改物品类型
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午3:57:22
	 * @param inGoodsType
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInGoodsType.do")
	public void updateInGoodsType(InGoodsType inGoodsType,HttpServletResponse response) throws Exception {
		Integer upRow = inGoodsTypeService.updateInGoodsType(inGoodsType);
		JSONObject jsonObject = new JSONObject();
		if(upRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "修改失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: deleteInGoodsType
	 * @方法说明: 逻辑删除物品类型
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午4:07:01
	 * @param ingtids
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/deleteInGoodsType.do")
	public void deleteInGoodsType(@RequestParam(value="ingtids",required=false)String ingtids,
								  HttpServletResponse response) throws Exception {
		Integer delRow = inGoodsTypeService.deleteInGoodsType(ingtids);
		JSONObject jsonObject = new JSONObject();
		if(delRow > 0) {
			jsonObject.put("isDel", "1");
			jsonObject.put("delRow", delRow);
		}else {
			jsonObject.put("isDel", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}

}

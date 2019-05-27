package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InGoodsCategory;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InGoodsCategoryService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsCategoryController.java
 * @类功能说明: 商品类别Controller层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午8:46:32
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午8:46:32</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inGoodsCategory")
public class InGoodsCategoryController {
	
	@Autowired
	private InGoodsCategoryService inGoodsCategoryService;
	
	/**@方法名: queryAllinGoodsCategory
	 * @方法说明: 全查商品类别
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日上午9:22:04
	 * @param page
	 * @param rows
	 * @param ingcname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryAllInGoodsCategory.do")
	public void queryAllinGoodsCategory(@RequestParam(value="page",required=false)String page,
										@RequestParam(value="rows",required=false)String rows,
										@RequestParam(value="ingcname",required=false)String ingcname,
										HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageBean", pageBean);
		if(StringUtil.isNotEmpty(ingcname)) {
			map.put("ingcname", ingcname);
		}
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = inGoodsCategoryService.queryAllInGoodsCategory(map);
		Integer total =  inGoodsCategoryService.queryInGoodsCategoryCount(map);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngccode
	 * @方法说明: 验证商品类型编码的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日上午10:19:44
	 * @param ingccode
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngccode.do")
	public void checkIngccode(@RequestParam(value="ingccode",required=false)String ingccode,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		InGoodsCategory inGoodsCategory = inGoodsCategoryService.queryInGoodsCategoryByIngccode(ingccode);
		if(inGoodsCategory != null) {
			jsonObject.put("hasIGC", "1");
		}else {
			jsonObject.put("hasIGC", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngcname
	 * @方法说明: 验证商品类别名称的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日上午11:00:24
	 * @param ingcname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngcname.do")
	public void checkIngcname(@RequestParam(value="ingcname",required=false)String ingcname,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		InGoodsCategory inGoodsCategory = inGoodsCategoryService.queryInGoodsCategoryByIngcname(ingcname);
		if(inGoodsCategory != null) {
			jsonObject.put("hasIGC", "1");
		}else {
			jsonObject.put("hasIGC", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: saveInGoodsCategory
	 * @方法说明: 添加商品类别
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日上午11:25:56
	 * @param inGoodsCategory
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/saveInGoodsCategory.do") 
	public void saveInGoodsCategory(InGoodsCategory inGoodsCategory,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("currentUser");
		Integer addRow = inGoodsCategoryService.addInGoodsCategory(inGoodsCategory, user);
		JSONObject jsonObject = new JSONObject();
		if(addRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "添加失败");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: updateInGoodsCategory
	 * @方法说明: 更新商品类别
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午1:38:21
	 * @param inGoodsCategory
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInGoodsCategory.do")
	public void updateInGoodsCategory(InGoodsCategory inGoodsCategory,HttpServletResponse response) throws Exception {
		Integer upRow = inGoodsCategoryService.updateInGoodsCategory(inGoodsCategory);
		JSONObject jsonObject = new JSONObject();
		if(upRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "修改失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}

	@RequestMapping("/deleteInGoodsCategory.do")
	public void deleteInGoodsCategory(@RequestParam(value="ingcids",required=false)String ingcids,
									  HttpServletResponse response) throws Exception {
		Integer delRow = inGoodsCategoryService.deleteInGoodsCategory(ingcids);
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

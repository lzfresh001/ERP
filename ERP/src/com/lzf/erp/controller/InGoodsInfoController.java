package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InGoodsInfo;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InGoodsInfoService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsInfo.java
 * @类功能说明: 商品信息Controller层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午1:50:46
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午1:50:46</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inGoodsInfo")
public class InGoodsInfoController {
	
	@Autowired
	private InGoodsInfoService inGoodsInfoService;
	
	/**@方法名: queryAllInGoodsInfo
	 * @方法说明: 全查商品信息路径
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月13日上午10:38:05
	 * @param page
	 * @param rows
	 * @param inginame
	 * @param ingishelflife
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryAllInGoodsInfo.do")
	public void queryAllInGoodsInfo(@RequestParam(value="page",required=false)String page,
			                        @RequestParam(value="rows",required=false)String rows,
			                        @RequestParam(value="inginame",required=false)String inginame,
			                        @RequestParam(value="ingishelflife",required=false)String ingishelflife,
			                        HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		map.put("pageBean", pageBean);
		InGoodsInfo goodsInfo = new InGoodsInfo();
		if(StringUtil.isNotEmpty(inginame)) {
			goodsInfo.setInginame(inginame);
		}
		if(StringUtil.isNotEmpty(ingishelflife)) {
			goodsInfo.setIngishelflife(Integer.parseInt(ingishelflife));
		}
		map.put("goodsInfo", goodsInfo);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = inGoodsInfoService.queryAllInGoodsInfo(map);
		Integer total = inGoodsInfoService.queryAllInGoodsInfoCount(map);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngicode
	 * @方法说明: 验证商品编码iongicode的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月13日上午10:50:38
	 * @param ingicode
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngicode.do")
	public void checkIngicode(@RequestParam(value="ingicode",required=false)String ingicode,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		InGoodsInfo inGoodsInfo = inGoodsInfoService.queryInGoodsInfoByIngicode(ingicode);
		if(inGoodsInfo != null) {
			jsonObject.put("hasIGI", "1");
		}else {
			jsonObject.put("hasIGI", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkInginame
	 * @方法说明: 验证商品编码inginame的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月13日下午4:02:36
	 * @param inginame
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkInginame.do")
	public void checkInginame(@RequestParam(value="inginame",required=false)String inginame,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		InGoodsInfo inGoodsInfo = inGoodsInfoService.queryInGoodsInfoByInginame(inginame);
		if(inGoodsInfo != null) {
			jsonObject.put("hasIGI", "1");
		}else {
			jsonObject.put("hasIGI", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: saveInGoodsInfo
	 * @方法说明: 添加商品信息
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月13日下午6:26:49
	 * @param inGoodsInfo
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/saveInGoodsInfo.do")
	public void saveInGoodsInfo(InGoodsInfo inGoodsInfo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("currentUser");
		Integer addRow = inGoodsInfoService.addInGoodsInfo(inGoodsInfo, user);
		JSONObject jsonObject = new JSONObject();
		if(addRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "添加失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: updateInGoodsInfo
	 * @方法说明: 修改商品信息
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日上午8:46:36
	 * @param inGoodsInfo
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInGoodsInfo.do")
	public void updateInGoodsInfo(InGoodsInfo inGoodsInfo,HttpServletResponse response) throws Exception {
		Integer upRow = inGoodsInfoService.updateInGoodsInfo(inGoodsInfo);
		JSONObject jsonObject = new JSONObject();
		if(upRow > 0) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "添加失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteInGoodsInfo.do")
	public void deleteInGoodsInfo(@RequestParam(value="ingiids",required=false)String ingiids,
								  HttpServletResponse response) throws Exception {
		Integer delRow = inGoodsInfoService.deleteInGoodsInfo(ingiids);
		JSONObject jsonObject = new JSONObject();
		if(delRow > 0) {
			jsonObject.put("isDel", "1");
			jsonObject.put("delRows", delRow);
		}else {
			jsonObject.put("isDel", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/queryAllInGoodsInfoForIBAD.do")
	public void queryAllInGoodsInfoForIBAD(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = inGoodsInfoService.queryInGoodsInfoForIBAD();
		ResponseUtil.write(response, jsonArray);
	}
}

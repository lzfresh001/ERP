package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.model.WorkBook;
import com.lzf.erp.service.WorkBookService;
import com.lzf.erp.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 数据字典主表Controller层
 * @filename WorkBookController.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午11:01:26
 * @version 1.0
 */
@Controller
@RequestMapping("/workBook")
public class WorkBookController {
	
	@Autowired
	private WorkBookService workBookService;
	
	// 生成查询数据字典主表信息的的路径
	@RequestMapping("/queryAllworkBook.do")
	public void queryAllworkBook(@RequestParam(value="page",required=false)String page,
								 @RequestParam(value="rows",required=false)String rows,
								 @RequestParam(value="wid",required=false)String wid,
								 @RequestParam(value="searchValue",required=false)String searchValue,
								 HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		//Integer widInt= Integer.parseInt(wid);
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("pageBean", pageBean);
		map.put("searchValue", searchValue);
		//map.put("wid", widInt);
		JSONArray jsonArray = workBookService.queryAllworkBook(map);
		Integer total = workBookService.queryAllworkBookCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		System.out.println(jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成添加workbook的路径
	@RequestMapping("/addWorkBook.do")
	public void addWorkBook(@RequestBody WorkBook workBook,HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		Integer addRows = workBookService.addWorkBook(workBook, currentUser);
		JSONObject jsonObject = new JSONObject();
		if(addRows > 0) {
			jsonObject.put("res", "1"); // 添加成功
		}else {
			jsonObject.put("res", "添加失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
	/**@方法名: deleteWorkBook
	 * @方法说明: 逻辑删除workbook及其workbookdetail路径(方法)
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月10日下午12:30:05
	 * @param wid
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteWorkBook.do")
	public void deleteWorkBook(@RequestParam(value="wid",required=false)String wid,
							   HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer delRow = workBookService.deleteWorkBookAndDetailByWid(Integer.parseInt(wid));
		if(delRow > 0) {
			jsonObject.put("isDel", "1"); // 删除成功
		}else {
			jsonObject.put("isDel", "删除失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}

	
	/**@方法名: updateWorkBook
	 * @方法说明: 修改workbook及其对应子表workbookdetail的路径(方法)
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月10日下午4:29:39
	 * @param workBook
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/updateWorkBook.do")
	public void updateWorkBook(@RequestBody WorkBook workBook,
							   HttpServletRequest request,
							   HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		Integer upRows = workBookService.updateWorkBookAndDetail(workBook, currentUser);
		JSONObject jsonObject = new JSONObject();
		if(upRows > 0) {
			jsonObject.put("res", "1"); // 修改成功
		}else {
			jsonObject.put("res", "修改失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
}

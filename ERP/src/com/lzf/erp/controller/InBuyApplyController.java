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

import com.lzf.erp.model.InBuyApply;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InBuyApplyService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyApplyController.java
 * @类功能说明: 采购申请主表控制层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月15日上午11:22:04
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月15日上午11:22:04</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inBuyApply")
public class InBuyApplyController {
	
	@Autowired
	private InBuyApplyService inBuyApplyService;
	
	/**@方法名: queryAllInBuyApply
	 * @方法说明: 全查采购申请主表
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月15日下午2:16:08
	 * @param page
	 * @param rows
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryAllInBuyApply.do")
	public void queryAllInBuyApply(@RequestParam(value="page",required=false)String page,
								   @RequestParam(value="rows",required=false)String rows,
								   @RequestParam(value="inbaname",required=false)String inbaname,
								   @RequestParam(value="businame",required=false)String businame,
								   @RequestParam(value="inbtid",required=false)String inbtid,
								   HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageBean", pageBean);
		InBuyApply inBuyApply =new InBuyApply();
		if(StringUtil.isNotEmpty(inbaname)) {
			inBuyApply.setInbaname(inbaname);
		}
		if(StringUtil.isNotEmpty(businame)) {
			inBuyApply.setBusiname(businame);
		}
		if(StringUtil.isNotEmpty(inbtid)) {
			inBuyApply.setInbtid(Integer.parseInt(inbtid));
		}
		map.put("inBuyApply", inBuyApply);
		JSONArray jsonArray = inBuyApplyService.queryAllInBuyApply(map);
		Integer total = inBuyApplyService.queryInBuyApplyCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: addInBuyApply
	 * @方法说明: 添加采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月18日下午1:52:40
	 * @param inBuyApply
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/addInBuyApply.do")
	public void addInBuyApply(@RequestBody InBuyApply inBuyApply,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("currentUser");
		Integer addRow = inBuyApplyService.addInBuyApply(inBuyApply, user);
		JSONObject jsonObject = new JSONObject();
		if(addRow > 0) {
			jsonObject.put("res", "1"); 
		}else {
			jsonObject.put("res", "添加失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: deleteInBuyApply
	 * @方法说明: 逻辑删除采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月18日下午2:48:12
	 * @param inbaid
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/deleteInBuyApply.do")
	public void deleteInBuyApply(@RequestParam(value="inbaid",required=false)String inbaid,
								 HttpServletResponse response) throws Exception {
		Integer delRow = inBuyApplyService.deleteInBuyApply(Integer.parseInt(inbaid));
		JSONObject jsonObject = new JSONObject();
		if(delRow > 0) {
			jsonObject.put("isDel", "1"); 
		}else {
			jsonObject.put("isDel", "0"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: updateInBuyApply
	 * @方法说明: 修改采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月20日上午9:59:46
	 * @param inBuyApply
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInBuyApply.do")
	public void updateInBuyApply(@RequestBody InBuyApply inBuyApply,HttpServletResponse response) throws Exception {
		Integer updRow = inBuyApplyService.updateInBuyApply(inBuyApply);
		JSONObject jsonObject = new JSONObject();
		if(updRow > 0) {
			jsonObject.put("res", "1"); 
		}else {
			jsonObject.put("res", "修改失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: submitInBuyApply
	 * @方法说明: 提交采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月20日上午10:38:25
	 * @param inbaid
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/submitInBuyApply.do")
	public void submitInBuyApply(@RequestParam(value="inbaid",required=false)String inbaid,
								 HttpServletResponse response) throws Exception {
		Integer subRow = inBuyApplyService.updateWkexidForSubmit(Integer.parseInt(inbaid));
		JSONObject jsonObject = new JSONObject();
		if(subRow > 0) {
			jsonObject.put("isSub", "1"); 
		}else {
			jsonObject.put("isSub", "0"); 
		}
		ResponseUtil.write(response, jsonObject);
	} 

	/**@方法名: querySubmitedInBuyApply
	 * @方法说明: 查询已提交的采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月20日上午11:33:50
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/querySubmitedInBuyApply.do")
	public void querySubmitedInBuyApply(@RequestParam(value="inbaname",required=false)String inbaname,
										@RequestParam(value="businame",required=false)String businame,
										@RequestParam(value="beginDate",required=false)String beginDate,
										@RequestParam(value="endDate",required=false)String endDate,
										HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(inbaname)) {
			map.put("inbaname", inbaname);
		}
		if(StringUtil.isNotEmpty(businame)) {
			map.put("businame", businame);
		}
		if(StringUtil.isNotEmpty(beginDate)) {
			map.put("beginDate", beginDate);
		}
		if(StringUtil.isNotEmpty(endDate)) {
			map.put("endDate", endDate);
		}
		JSONArray jsonArray = inBuyApplyService.querySubmitedInBuyApply(map);
		ResponseUtil.write(response, jsonArray);
	}
	
	/**@方法名: rejectedInBuyApply
	 * @方法说明: 驳回采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月20日下午4:33:49
	 * @param inBuyApply
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/rejectedInBuyApply.do")
	public void rejectedInBuyApply(InBuyApply inBuyApply,HttpServletResponse response) throws Exception {
		Integer rejectedRow = inBuyApplyService.updateInBuyApplyForRejected(inBuyApply);
		JSONObject jsonObject = new JSONObject();
		if(rejectedRow > 0) {
			jsonObject.put("res", "1"); 
			jsonObject.put("msg", "驳回成功！"); 
		}else {
			jsonObject.put("res", "驳回失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: throughInBuyApply
	 * @方法说明: 通过采购申请
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月21日上午9:06:30
	 * @param inBuyApply
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/throughInBuyApply.do")
	public void throughInBuyApply(InBuyApply inBuyApply,HttpServletResponse response) throws Exception {
		Integer throughRow = inBuyApplyService.updateInBuyApplyForThrough(inBuyApply);
		JSONObject jsonObject = new JSONObject();
		if(throughRow > 0) {
			jsonObject.put("res", "1"); 
			jsonObject.put("msg", "通过成功！");
		}else {
			jsonObject.put("res", "通过失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: queryInBuyApplyForStatistical
	 * @方法说明: 申请统计
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月21日上午11:35:05
	 * @param page
	 * @param rows
	 * @param inbaname
	 * @param businame
	 * @param inbtid
	 * @param wkexid
	 * @param beginDate
	 * @param endDate
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryInBuyApplyForStatistical.do")
	public void queryInBuyApplyForStatistical(@RequestParam(value="page",required=false)String page,
											  @RequestParam(value="rows",required=false)String rows,
											  @RequestParam(value="inbaname",required=false)String inbaname,
											  @RequestParam(value="businame",required=false)String businame,
											  @RequestParam(value="inbtid",required=false)String inbtid,
											  @RequestParam(value="wkexid",required=false)String wkexid,
											  @RequestParam(value="beginDate",required=false)String beginDate,
											  @RequestParam(value="endDate",required=false)String endDate,
											  HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageBean", pageBean);
		if(StringUtil.isNotEmpty(inbaname)) {
			map.put("inbaname", inbaname);
		}
		if(StringUtil.isNotEmpty(businame)) {
			map.put("businame", businame);
		}
		if(StringUtil.isNotEmpty(inbtid)) {
			map.put("inbtid", inbtid);
		}
		if(StringUtil.isNotEmpty(wkexid)) {
			map.put("wkexid", wkexid);
		}
		if(StringUtil.isNotEmpty(beginDate)) {
			map.put("beginDate", beginDate);
		}
		if(StringUtil.isNotEmpty(endDate)) {
			map.put("endDate", endDate);
		}
		JSONArray jsonArray = inBuyApplyService.queryInBuyApplyForStatistical(map);
		Integer total = inBuyApplyService.queryInBuyApplyCountForStatistical(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: queryInBuyApplyForContract
	 * @方法说明: 查询通过审核、不是直接采购的申请信息
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月21日上午11:48:46
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryInBuyApplyForContract.do")
	public void queryInBuyApplyForContract(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = inBuyApplyService.queryInBuyApplyForContract();
		ResponseUtil.write(response, jsonArray);
	}
}

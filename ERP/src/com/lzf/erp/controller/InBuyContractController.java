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

import com.lzf.erp.model.InBuyContract;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InBuyContractService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InBuyContractController.java
 * @类功能说明: 合同controller 层
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日上午11:42:34
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日上午11:42:34</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inBuyContract")
public class InBuyContractController {

	@Autowired
	private InBuyContractService InBuyContractService;
	
	/**@方法名: queryAllInBuyContract
	 * @方法说明: 合同主表+明细表 查询  模糊搜索+分页
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日上午11:42:02
	 * @param page
	 * @param s_inbcname
	 * @param s_businame
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findAllInBuyContract")
	public void queryAllInBuyContract(PageBean page,String s_inbcname,String s_businame,HttpServletResponse response) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("s_inbcname", s_inbcname);
		map.put("s_businame", s_businame);
		JSONArray jsonArray=InBuyContractService.findAllInBuyContract(map);
		int total=InBuyContractService.findAllInBuyContractCount(map);
		JSONObject json=new JSONObject();
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
	}
	
	@RequestMapping("/queryInBuyContractForStatistics.do")
	public void queryInBuyContractForStatistics(@RequestParam(value="inbcname",required=false)String inbcname,
												@RequestParam(value="businame",required=false)String businame,
												@RequestParam(value="inbtid",required=false)String inbtid,
												@RequestParam(value="beginDate",required=false)String beginDate,
												@RequestParam(value="endDate",required=false)String endDate,
												HttpServletResponse response) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(inbcname)) {
			map.put("inbcname", inbcname);
		}
		if(StringUtil.isNotEmpty(businame)) {
			map.put("businame", businame);
		}
		if(StringUtil.isNotEmpty(inbtid)) {
			map.put("inbtid", inbtid);
		}
		if(StringUtil.isNotEmpty(beginDate)) {
			map.put("beginDate", beginDate);
		}
		if(StringUtil.isNotEmpty(endDate)) {
			map.put("endDate", endDate);
		}
		JSONArray jsonArray = InBuyContractService.queryInBuyContractForStatistics(map);
		ResponseUtil.write(response, jsonArray);
	}
	/**@方法名: addInBuyContract
	 * @方法说明: 添加合同表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午5:11:38
	 * @param inBuyContract
	 * @param request
	 * @param response
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/addInBuyContract")
	public void addInBuyContract(@RequestBody InBuyContract inBuyContract,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user =(User)request.getSession().getAttribute("currentUser");
		int n=InBuyContractService.addInBuyContract(inBuyContract,user);
		JSONObject json=new JSONObject();
		json.put("res", n);
		ResponseUtil.write(response, json);
		
	}
}

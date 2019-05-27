package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.InGoodsProducer;
import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.User;
import com.lzf.erp.service.InGoodsProducerService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: InGoodsProducerController.java
 * @类功能说明: 商品生产厂家Controller控制层
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日下午2:37:30
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日下午2:37:30</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/inGoodsProducer")
public class InGoodsProducerController {

	@Autowired
	private InGoodsProducerService inGoodsProducerService;
	
	/**@方法名: queryAllInGoodsProducer
	 * @方法说明: 全查物品生产商
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午5:10:29
	 * @param page
	 * @param rows
	 * @param ingpname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/queryAllInGoodsProducer.do")
	public void queryAllInGoodsProducer(@RequestParam(value="page",required=false)String page,
							            @RequestParam(value="rows",required=false)String rows,
							            @RequestParam(value="ingpname",required=false)String ingpname,
							            HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageBean", pageBean);
		if(StringUtil.isNotEmpty(ingpname)) {
			map.put("ingpname", ingpname);
		}
		JSONArray jsonArray = inGoodsProducerService.queryAllInGoodsProducer(map);
		Integer total = inGoodsProducerService.queryInGoodsProducerCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngpcode
	 * @方法说明: 验证物品生产商编码的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午5:59:54
	 * @param ingpcode
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngpcode.do")
	public void checkIngpcode(@RequestParam(value="ingpcode",required=false)String ingpcode,
							  HttpServletResponse response) throws Exception {
		InGoodsProducer inGoodsProducer = inGoodsProducerService.queryAllInGoodsProducerByIngpcode(ingpcode);
		JSONObject jsonObject = new JSONObject();
		if(inGoodsProducer != null) {
			jsonObject.put("hasIGP", "1");
		}else {
			jsonObject.put("hasIGP", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: checkIngpname
	 * @方法说明:  验证物品生产商名称的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午6:15:56
	 * @param ingpname
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngpname.do")
	public void checkIngpname(@RequestParam(value="ingpname",required=false)String ingpname,
			                  HttpServletResponse response) throws Exception {
		InGoodsProducer inGoodsProducer = inGoodsProducerService.queryAllInGoodsProducerByIngpname(ingpname);
		JSONObject jsonObject = new JSONObject();
		if(inGoodsProducer != null) {
			jsonObject.put("hasIGP", "1");
		}else {
			jsonObject.put("hasIGP", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
	/**@方法名: checkIngpphone
	 * @方法说明:  验证物品生产商联系电话的唯一性
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午6:24:55
	 * @param ingpphone
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/checkIngpphone.do")
	public void checkIngpphone(@RequestParam(value="ingpphone",required=false)String ingpphone,
			                  HttpServletResponse response) throws Exception {
		InGoodsProducer inGoodsProducer = inGoodsProducerService.queryAllInGoodsProducerByIngpphone(ingpphone);
		JSONObject jsonObject = new JSONObject();
		if(inGoodsProducer != null) {
			jsonObject.put("hasIGP", "1");
		}else {
			jsonObject.put("hasIGP", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: saveInGoodsProducer
	 * @方法说明: 添加商品生产商
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月14日下午6:43:17
	 * @param inGoodsProducer
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/saveInGoodsProducer.do")
	public void saveInGoodsProducer(InGoodsProducer inGoodsProducer,HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("currentUser");
		Integer addRow = inGoodsProducerService.addInGoodsProducer(inGoodsProducer, user);
		JSONObject jsonObject = new JSONObject();
		if(addRow > 0 ) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "添加失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: updateInGoodsProducer
	 * @方法说明: 修改商品生产商
	 * @作者: Z.fresh Lee
	 * @邮箱：214222764@qq.com
	 * @日期: 2019年5月15日上午9:13:41
	 * @param inGoodsProducer
	 * @param response
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateInGoodsProducer.do")
	public void updateInGoodsProducer(InGoodsProducer inGoodsProducer,HttpServletResponse response) throws Exception {
		Integer upRow = inGoodsProducerService.updateInGoodsProducer(inGoodsProducer);
		JSONObject jsonObject = new JSONObject();
		if(upRow > 0 ) {
			jsonObject.put("res", true);
		}else {
			jsonObject.put("res", "修改失败！");
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteInGoodsProducer.do")
	public void deleteInGoodsProducer(@RequestParam(value="ingpids",required=false)String ingpids,
									  HttpServletResponse response) throws Exception {
		Integer delRow = inGoodsProducerService.deleteInGoodsProducer(ingpids);
		JSONObject jsonObject = new JSONObject();
		if(delRow > 0 ) {
			jsonObject.put("isDel", "1");
			jsonObject.put("delRow", delRow);
		}else {
			jsonObject.put("isDel", "0");
		}
		ResponseUtil.write(response, jsonObject);
	}
}

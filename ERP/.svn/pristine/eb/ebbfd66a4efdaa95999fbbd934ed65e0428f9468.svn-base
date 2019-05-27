package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InGoodsType;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InGoodsTypeService.java
 * @类功能说明:  商品类型Service接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午11:24:17
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午11:24:17</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsTypeService {
	
	// 全查ingoodstype表
	public JSONArray queryAllInGoodsType(Map<String,Object> map);
	
	// 查询ingoodstype表条数 
	public Integer queryInGoodsTypeCount(Map<String,Object> map);
	
	// 根据ingtcode查ingoodstype表 
	public InGoodsType queryAllInGoodsTypeByIngtcode(String ingtcode);
	
	// 根据ingtname查ingoodstype表
	public InGoodsType queryAllInGoodsTypeByIngtname(String ingtname);
	
	// 添加ingoodstype表
	public Integer addInGoodsType(InGoodsType inGoodsType,User user);
	
	// 修改ingoodstype表
	public Integer updateInGoodsType(InGoodsType inGoodsType);
	
	// 逻辑删除ingoodstype表
	public Integer deleteInGoodsType(String ingtids);

}

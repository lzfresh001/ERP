package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.InGoodsCategory;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InGoodsCategoryService.java
 * @类功能说明: 商品类别Service接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午8:42:34
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午8:42:34</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsCategoryService {

	// 全查ingoodscategory表
	public JSONArray queryAllInGoodsCategory(Map<String,Object> map);
	
	// 查询ingoodscategory表的条数
	public Integer queryInGoodsCategoryCount(Map<String,Object> map);
	
	// 根据ingccode查ingoodscategory表
	public InGoodsCategory queryInGoodsCategoryByIngccode(String ingccode);
	
	// 根据ingcname查ingoodscategory表
	public InGoodsCategory queryInGoodsCategoryByIngcname(String ingcname);
	
	// 添加ingoodscategory表
	public Integer addInGoodsCategory(InGoodsCategory inGoodsCategory,User user);
	
	// 修改ingoodscategory表
	public Integer updateInGoodsCategory(InGoodsCategory inGoodsCategory);
	
	// 逻辑删除ingoodscategory表
	public Integer deleteInGoodsCategory(String ingcids);
}

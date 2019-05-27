package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InGoodsCategory;

/**@文件名: InGoodsCategoryDao.java
 * @类功能说明: 商品类别Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午8:38:11
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午8:38:11</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsCategoryDao {
	
	// 全查ingoodscategory表
	public List<InGoodsCategory> queryAllInGoodsCategory(Map<String,Object> map);
	
	// 查询ingoodscategory表的条数
	public Integer queryInGoodsCategoryCount(Map<String,Object> map);
	
	// 根据ingcid查ingoodscategory表
	public InGoodsCategory queryAllInGoodsCategoryByIngcid(Integer ingcid);
	
	// 根据ingccode查ingoodscategory表
	public InGoodsCategory queryInGoodsCategoryByIngccode(String ingccode);
	
	// 根据ingcname查ingoodscategory表
	public InGoodsCategory queryInGoodsCategoryByIngcname(String ingcname);
	
	// 添加ingoodscategory表
	public Integer addInGoodsCategory(InGoodsCategory inGoodsCategory);
	
	// 修改ingoodscategory表
	public Integer updateInGoodsCategory(InGoodsCategory inGoodsCategory);
	
	// 逻辑删除ingoodscategory表
	public Integer deleteInGoodsCategory(Integer ingcid);

}

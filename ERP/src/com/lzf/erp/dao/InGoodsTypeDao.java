package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InGoodsType;

/**@文件名: InGoodsTypeDao.java
 * @类功能说明:  商品类型Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日上午11:21:27
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日上午11:21:27</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsTypeDao {
	
	// 全查ingoodstype表
	public List<InGoodsType> queryAllInGoodsType(Map<String,Object> map);
	
	// 查询ingoodstype表条数 
	public Integer queryInGoodsTypeCount(Map<String,Object> map);
	
	// 根据ingtid查ingoodstype表
	public InGoodsType queryAllInGoodsTypeByIngtid(Integer ingtid);
	
	// 根据ingtcode查ingoodstype表 
	public InGoodsType queryAllInGoodsTypeByIngtcode(String ingtcode);
	
	// 根据ingtname查ingoodstype表
	public InGoodsType queryAllInGoodsTypeByIngtname(String ingtname);
	
	// 添加ingoodstype表
	public Integer addInGoodsType(InGoodsType inGoodsType);
	
	// 修改ingoodstype表
	public Integer updateInGoodsType(InGoodsType inGoodsType);
	
	// 逻辑删除ingoodstype表
	public Integer deleteInGoodsType(Integer ingtid);

}

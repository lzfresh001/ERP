package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InGoodsInfo;

/**@文件名: InGoodsInfoDao.java
 * @类功能说明: 商品信息Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午1:55:29
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午1:55:29</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsInfoDao {
	
	// 全查ingoodsinfo表
	public List<InGoodsInfo> queryAllInGoodsInfo(Map<String,Object> map);
	
	// 查询ingoodsinfo的总条数
	public Integer queryAllInGoodsInfoCount(Map<String,Object> map);
	
	// 根据ingicode查ingoodsinfo表
	public InGoodsInfo queryInGoodsInfoByIngicode(String ingicode);
	
	// 根据inginame查ingoodsinfo表 
	public InGoodsInfo queryInGoodsInfoByInginame(String inginame);
	
	// 添加ingoodsinfo表 
	public Integer addInGoodsInfo(InGoodsInfo inGoodsInfo);
	
	// 修改ingoodsinfo表
	public Integer updateInGoodsInfo(InGoodsInfo inGoodsInfo);
	
	// 逻辑删除商品信息
	public Integer deleteInGoodsInfo(Integer ingiid);
	
	// 根据ingiid查询ingoodsinfo表
	public InGoodsInfo queryInGoodsInfoByIngiid(Integer ingiid);
	
	// 查询ingoodsinfo表给IBAD
	public List<InGoodsInfo> queryInGoodsInfoForIBAD();

}

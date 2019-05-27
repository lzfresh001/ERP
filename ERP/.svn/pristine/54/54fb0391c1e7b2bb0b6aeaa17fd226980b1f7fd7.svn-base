package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InGoodsInfo;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;

/**@文件名: InGoodsInfoService.java
 * @类功能说明: 商品信息service接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月11日下午1:59:47
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月11日下午1:59:47</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsInfoService {
	
	// 全查ingoodsinfo表
	public JSONArray queryAllInGoodsInfo(Map<String,Object> map);
	
	// 查询ingoodsinfo的总条数
	public Integer queryAllInGoodsInfoCount(Map<String,Object> map);
	
	// 根据ingicode查ingoodsinfo表
	public InGoodsInfo queryInGoodsInfoByIngicode(String ingicode);
	
	// 根据inginame查ingoodsinfo表 
	public InGoodsInfo queryInGoodsInfoByInginame(String inginame);
	
	// 添加ingoodsinfo表 
	public Integer addInGoodsInfo(InGoodsInfo inGoodsInfo,User user);
	
	// 修改ingoodsinfo表
	public Integer updateInGoodsInfo(InGoodsInfo inGoodsInfo);
	
	// 逻辑删除商品信息
	public Integer deleteInGoodsInfo(String ingiids);

	// 查询ingoodsinfo表给IBAD
	public JSONArray queryInGoodsInfoForIBAD();
}

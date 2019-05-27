package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.InGoodsProducer;

/**@文件名: InGoodsProducerDao.java
 * @类功能说明: 商品生产厂家Dao接口
 * @作者: Z.fresh Lee
 * @Email: 214222764@qq.com
 * @日期: 2019年5月13日下午2:31:59
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: Z.fresh Lee</li> 
 * 	 <li>日期: 2019年5月13日下午2:31:59</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InGoodsProducerDao {
	
	// 全查ingoodsproducer表
	public List<InGoodsProducer> queryAllInGoodsProducer(Map<String,Object> map);
	
	// 查询ingoodsproducer表条数
	public Integer queryInGoodsProducerCount(Map<String,Object> map);
	
	// 根据ingpid查ingoodsproducer表
	public InGoodsProducer queryAllInGoodsProducerByIngpid(Integer ingpid);
	
	// 根据ingpcode查ingoodsproducer表
	public InGoodsProducer queryAllInGoodsProducerByIngpcode(String ingpcode);
	
	// 根据ingpname查ingoodsproducer表
	public InGoodsProducer queryAllInGoodsProducerByIngpname(String ingpname);
	
	// 根据ingpphone查ingoodsproducer表
	public InGoodsProducer queryAllInGoodsProducerByIngpphone(String ingpphone);
	
	// 添加ingoodsproducer表
	public Integer addInGoodsProducer(InGoodsProducer inGoodsProducer);
	
	// 修改ingoodsproducer表
	public Integer updateInGoodsProducer(InGoodsProducer inGoodsProducer);

	// 逻辑删除ingoodsproducer表
	public Integer deleteInGoodsProducer(Integer ingpid);
}

package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.WorkBook;

/**
 * @comment 数据字典主表Dao接口
 * @filename WorkBookDao.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午10:53:45
 * @version 1.0
 */
public interface WorkBookDao {
	
	// 全查workbook表 
	public List<WorkBook> queryAllworkBook(Map<String,Object> map);
	
	// 查询workbook表的条数
	public Integer queryAllworkBookCount(Map<String,Object> map);
	
	// 添加workbook表
	public Integer addWorkBook(WorkBook workBook);
	
	// 获取workbook表中wid的最大值
	public Integer getMaxWid();
	
	// 逻辑删除workbook表 
	public Integer deleteWorkBook(Integer wid);
	
	// 修改workbook表
	public Integer updateWorkBook(WorkBook workBook);

}

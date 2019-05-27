package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.User;
import com.lzf.erp.model.WorkBook;

import net.sf.json.JSONArray;

/**
 * @comment 数据字典主表Service接口
 * @filename WorkBookService.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午10:56:09
 * @version 1.0
 */
public interface WorkBookService {
	
	// 查询数据字典主表全部信息
	public JSONArray queryAllworkBook(Map<String,Object> map);
	
	// 查询workbook表的条数
	public Integer queryAllworkBookCount(Map<String,Object> map);
	
	// 添加workbook表
	public Integer addWorkBook(WorkBook workBook,User user);
	
	// 逻辑删除workbook表及其对应的workbookdetail表
	public Integer deleteWorkBookAndDetailByWid(Integer wid);
	
	// 修改workbook表及其对应的workbookdetail表 
	public Integer updateWorkBookAndDetail(WorkBook workBook,User user);

}

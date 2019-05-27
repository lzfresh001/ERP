package com.lzf.erp.dao;

import java.util.List;

import com.lzf.erp.model.WorkBookDetail;

/**
 * @comment 数据字典系(细)表Dao接口
 * @filename WorkBookDetailDao.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午11:05:40
 * @version 1.0
 */
public interface WorkBookDetailDao {
	
	// 全查workbookdetail表
	public List<WorkBookDetail> queryAllWorkBookDetail(Integer wid);
	
	// 添加workbookdetail表
	public Integer addWorkBookDetail(WorkBookDetail workBookDetail);
	
	// 逻辑删除workbookdetail表
	public Integer deleteWorkBookDetail(Integer wid);
	
	// 修改workbookdetail表
	public Integer updateWorkBookDetail(WorkBookDetail workBookDetail);
	
	// 根据wbdid逻辑删除workbookdetail表
	public Integer deleteWorkBookDetailByWbdid(Integer wbdid);

}

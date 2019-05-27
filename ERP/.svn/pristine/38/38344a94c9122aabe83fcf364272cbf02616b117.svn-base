package com.lzf.erp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.WorkBookDao;
import com.lzf.erp.dao.WorkBookDetailDao;
import com.lzf.erp.model.User;
import com.lzf.erp.model.WorkBook;
import com.lzf.erp.model.WorkBookDetail;
import com.lzf.erp.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 数据字典主表Service实现类
 * @filename WorkBookServiceImpl.java
 * @author lzf
 * @email 214222764@qq.com
 * @date 2019年5月8日 上午10:57:44
 * @version 1.0
 */
@Service
public class WorkBookServiceImpl implements WorkBookService {
	
	@Autowired
	private WorkBookDao workBookDao;
	@Autowired
	private WorkBookDetailDao workBookDetailDao;

	// 查询数据字典主表全部信息
	@Override
	public JSONArray queryAllworkBook(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<WorkBook> workBookList =  workBookDao.queryAllworkBook(map);
		for(WorkBook workBook: workBookList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("wid", workBook.getWid());
			jsonObject.put("wname", workBook.getWname());
			jsonObject.put("delflag", workBook.getDelflag());
			jsonObject.put("remark", workBook.getRemark());
			jsonObject.put("currentTime", workBook.getCurrentTime());
			jsonObject.put("updateTime", workBook.getUpdateTime());
			jsonObject.put("optionPerson", workBook.getOptionPerson());
			JSONArray jsonArrayDetail = new JSONArray();
			List<WorkBookDetail> workBookDetailList =  workBook.getWorkBookDetail();
			for(WorkBookDetail workBookDetail: workBookDetailList) {
				JSONObject jsonObjectDetail = new JSONObject();
				jsonObjectDetail.put("wbdId", workBookDetail.getWbdId());
				jsonObjectDetail.put("wid", workBookDetail.getWid());
				jsonObjectDetail.put("wbdName", workBookDetail.getWbdName());
				jsonObjectDetail.put("remark", workBookDetail.getRemark());
				jsonObjectDetail.put("delflag", workBookDetail.getDelflag());
				jsonObjectDetail.put("currentTime", workBookDetail.getCurrentTime());
				jsonObjectDetail.put("updateTime", workBookDetail.getUpdateTime());
				jsonObjectDetail.put("optionPerson", workBookDetail.getOptionPerson());
				jsonArrayDetail.add(jsonObjectDetail);
			}
			jsonObject.put("workBookDetail", jsonArrayDetail);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	
	// 查询workbook表的条数
	@Override
	public Integer queryAllworkBookCount(Map<String, Object> map) {
		return workBookDao.queryAllworkBookCount(map);
	}


	// 添加workbook表
	@Override
	public Integer addWorkBook(WorkBook workBook, User user) {
		workBook.setOptionPerson(user.getUname());
		Integer addRow = workBookDao.addWorkBook(workBook);
		Integer maxWid = workBookDao.getMaxWid();
		Integer addDRows = 0;
		List<WorkBookDetail> wBDList = workBook.getWorkBookDetail();
		for(WorkBookDetail workBookDetail: wBDList) {
			workBookDetail.setWid(maxWid);
			workBookDetail.setOptionPerson(user.getUname());
			Integer addDRow = workBookDetailDao.addWorkBookDetail(workBookDetail);
			addDRows += addDRow;
		}
		return addRow + addDRows;
	}


	// 逻辑删除workbook表及其对应的workbookdetail表
	@Override
	public Integer deleteWorkBookAndDetailByWid(Integer wid) {
		Integer delRow = workBookDao.deleteWorkBook(wid);
		Integer delRowD = workBookDetailDao.deleteWorkBookDetail(wid);
		return delRow + delRowD;
	}


	// 修改workbook表及其对应的workbookdetail表 
	@Override
	public Integer updateWorkBookAndDetail(WorkBook workBook, User user) {
		workBook.setUpdateTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		Integer upRow = workBookDao.updateWorkBook(workBook);
		List<WorkBookDetail> PageData = workBook.getWorkBookDetail();
		List<WorkBookDetail> SqlData = workBookDetailDao.queryAllWorkBookDetail(workBook.getWid()); 
		if(SqlData != null) {
			for(WorkBookDetail sqlData: SqlData) {
				boolean isDelete = true;
				if(PageData != null) {
					for(WorkBookDetail pageData: PageData) {
						if(pageData.getWbdId() != null && pageData.getWbdId().equals(sqlData.getWbdId())) {
							isDelete = false;
						}
					}
				}
				if(isDelete) {
					workBookDetailDao.deleteWorkBookDetailByWbdid(sqlData.getWbdId());
				}
			}
		}
		if(PageData != null) {
			for(WorkBookDetail pageData: PageData) {
				if(pageData.getWbdId() == null) {
					pageData.setWid(workBook.getWid());
					pageData.setOptionPerson(user.getUname());
					workBookDetailDao.addWorkBookDetail(pageData);
				}else {
					pageData.setUpdateTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					workBookDetailDao.updateWorkBookDetail(pageData);
				}
			}
		}
		return upRow;
	}

}

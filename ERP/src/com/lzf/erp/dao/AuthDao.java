package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.Auth;

/**
 * @comment 菜单(角色)Dao接口层
 * @filename AuthDao.java
 * @author lzf
 * @date 2019年4月26日 下午4:19:12
 * @version 1.0
 */
public interface AuthDao {
	
	// 获取当前用户所有的auth
	public List<Auth> getAuthByparentIdAndAuthIds(Map<String,Object> map);
	
	// 根据parentId获取auth
	public List<Auth> getAuthByParentId(Integer parentId);
	
	// 根据authName查询auth表
	public Auth queryAuthByAuthName(String authName);

	// 根据authPath查询auth表
	public Auth queryAuthByAuthPath(String authPath);
	
	// 添加auth
	public Integer addAuth(Map<String,Object> map);
	
	// 修改auth信息 
	public Integer updateAuth(Auth auth);
	
	// 添加子菜单时修改state
	public Integer updateAuthStateToClosed(Map<String,Object> map);
	
	// 根据parentId逻辑删除auth
	public Integer updateAuthStateByParentId(Map<String,Object> map);
	
	// 根据authId逻辑删除auth
	public Integer updateAuthStateByAuthId(Map<String,Object> map);
}

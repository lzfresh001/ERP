package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.Auth;

import net.sf.json.JSONArray;

/**
 * @comment 菜单(权限)service接口层
 * @filename AuthService.java
 * @author lzf
 * @date 2019年4月26日 下午4:38:30
 * @version 1.0
 */
public interface AuthService {

	// 查询当前用户的所有权限(菜单)
	public JSONArray queryAllAuth(Integer parentId,List<Integer> authIdList);
	
	// 根据parentId authIds获取当前角色拥有auth
	public JSONArray getCheckedAuthByParentId(Integer parentId,String authIds);
	
	// 根据parentId查询auth
	public JSONArray queryAuthByParentId(Integer parentId);
	
	// 根据authName查询auth表
	public Auth queryAuthByAuthName(String authName);
	
	// 根据authPath查询auth表
	public Auth queryAuthByAuthPath(String authPath);
	
	// 添加auth
	public Integer addAuth(Map<String,Object> map);
	
	// 添加子菜单并更新state
	public Integer addAuthAndUpdatePstate(Map<String,Object> map);
	
	// 修改auth信息 
	public Integer updateAuth(Auth auth);
	
	// 根据authId逻辑删除auth
	public Integer updateAuthStateByAuthId(Map<String,Object> map);
	
	// 逻辑删除菜单及其子菜单
	public Integer updateAuthAndChildren(Map<String,Object> map);
}

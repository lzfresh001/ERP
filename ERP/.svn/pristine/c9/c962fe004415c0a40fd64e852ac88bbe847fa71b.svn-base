package com.lzf.erp.service;

import java.util.Map;

import com.lzf.erp.model.Role;

import net.sf.json.JSONArray;

/**
 * @comment 角色service接口层
 * @filename RoleService.java
 * @author lzf
 * @date 2019年4月26日 下午4:41:36
 * @version 1.0
 */
public interface RoleService {
	
	// 根据roleId查询authIds
	public String queryAuthIdsByRoleId(Integer roleId);
	
	// 根据roleId查询role
	public Role queryRoleByRoleId(Integer roleId);

	// 查询所有role信息(用户页面下拉框)
	public JSONArray queryAllRole();
	
	// 查询所有role信息(带分页)
	public JSONArray findAllRole(Map<String,Object> map);
	
	// 查询role表的总条数
	public Integer findRoleCount(Map<String,Object> map);
	
	// 根据roleName查role表
	public Role queryRoleByRoleName(Role role);
	
	// 添加role
	public Integer addRole(Role role);
	
	// 修改角色信息 
	public Integer updateRole(Role role);
	
	// 逻辑删除角色 
	public Integer deleteRole(Integer roleId);
	
	// 根据roleId更新authIds
	public Integer giveAuthIdsByRoleId(Role role);
}

package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.Role;

/**
 * @comment 角色Dao接口层
 * @filename RoleDao.java
 * @author lzf
 * @date 2019年4月26日 下午4:18:23
 * @version 1.0
 */
public interface RoleDao {

	// 根据roleId查authIds
	public String queryAuthIdsByRoleId(Integer roleId);
	
	// 根据roleId查询role
	public Role queryRoleByRoleId(Integer roleId);
	
	// 查询所有role信息(用户页面下拉框)
	public List<Role> queryAllRole();
	
	// 查询所有role信息(带分页)
	public List<Role> findAllRole(Map<String,Object> map);
	
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

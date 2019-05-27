package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.RoleDao;
import com.lzf.erp.model.Role;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 角色service实现层
 * @filename RoleServiceImpl.java
 * @author lzf
 * @date 2019年4月26日 下午4:43:22
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	// 根据roleId查authIds
	@Override
	public String queryAuthIdsByRoleId(Integer roleId) {
		return roleDao.queryAuthIdsByRoleId(roleId);
	}
	
	// 根据roleId查询role
	@Override
	public Role queryRoleByRoleId(Integer roleId) {
		return roleDao.queryRoleByRoleId(roleId);
	}

	@Override
	public JSONArray queryAllRole() {
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("roleId", "");
		json.put("roleName", "全部");
		jsonArray.add(json);
		List<Role> roleList = roleDao.queryAllRole();
		for(Role role: roleList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("roleId", role.getRoleId());
			jsonObject.put("roleName", role.getRoleName());
			jsonObject.put("authIds", role.getAuthIds());
			jsonObject.put("roleDescription", role.getRoleDescription());
			jsonObject.put("delflag", role.getDelflag());
			jsonObject.put("currentTime", role.getCurrentTime());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询所有role信息(带分页)
	@Override
	public JSONArray findAllRole(Map<String,Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<Role> roleList = roleDao.findAllRole(map);
		for(Role role: roleList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("roleId", role.getRoleId());
			jsonObject.put("roleName", role.getRoleName());
			jsonObject.put("authIds", role.getAuthIds());
			jsonObject.put("roleDescription", role.getRoleDescription());
			jsonObject.put("delflag", role.getDelflag());
			jsonObject.put("currentTime", role.getCurrentTime());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询role表的总条数
	@Override
	public Integer findRoleCount(Map<String,Object> map) {
		return roleDao.findRoleCount(map);
	}

	// 根据roleName查role表
	@Override
	public Role queryRoleByRoleName(Role role) {
		return roleDao.queryRoleByRoleName(role);
	}

	// 添加role
	@Override
	public Integer addRole(Role role) {
		return roleDao.addRole(role);
	}

	// 修改角色信息 
	@Override
	public Integer updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	// 逻辑删除角色 
	@Override
	public Integer deleteRole(Integer roleId) {
		return roleDao.deleteRole(roleId);
	}

	// 根据roleId更新authIds
	@Override
	public Integer giveAuthIdsByRoleId(Role role) {
		return roleDao.giveAuthIdsByRoleId(role);
	}

}

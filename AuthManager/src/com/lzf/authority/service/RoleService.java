package com.lzf.authority.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzf.authority.dao.RoleMapper;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.RoleAuth;

@Service
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	// 全查role表
	public List<Role> queryAllRole(PageUtil pageUtil){
		return roleMapper.queryAllRole(pageUtil);
	}
	
	// 查role表总条数
	public Integer queryRoleAllCount(PageUtil pageUtil) {
		return roleMapper.queryRoleAllCount(pageUtil);
	}
	
	// 根据role_code查role
	public Role queryRoleByRoleCode(String roleCode) {
		return roleMapper.queryRoleByRoleCode(roleCode);
	}
	
	// 添加role
	public Integer addRole(Role role) {
		return roleMapper.addRole(role);
	}
	
	// 修改role
	public Integer updateRole(Role role) {
		return roleMapper.updateRole(role);
	}
	
	// 启用/禁用 role_satte
	public Integer stopstartRoleState(Role role) {
		return roleMapper.stopstartRoleState(role);
	}
	
	// 根据role_id查询角色已有的auth_id
	public String queryAuthIdByRoleId(RoleAuth roleAuth) {
		return roleMapper.queryAuthIdByRoleId(roleAuth);
	}
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState(){
		return roleMapper.queryAuthInfoByAuthState();
	}

	// 根据role_id删除role_auth
	public Integer deleteRoleAuthByRoleId(RoleAuth roleAuth) {
		return roleMapper.deleteRoleAuthByRoleId(roleAuth);
	}
	
	// 在role_auth表中先删除原有的auth_id再添加auth_id
	@Transactional
	public Integer deleteInsertRoleAuth(RoleAuth roleAuth,String authIds) {
		Integer rows = 0;
		Integer delRows = roleMapper.deleteRoleAuthByRoleId(roleAuth);
		String[] authId = authIds.split(",");
		Integer insRows = 0;
		for(int i=0;i<authId.length;i++) {
			roleAuth.setAuthId(Integer.parseInt(authId[i]));
			Integer insRow = roleMapper.insertRoleAuth(roleAuth);
			insRows += insRow;
		}
		rows = delRows + insRows;
		return rows;
	}
	
	// 根据role_id删除role
	public Integer deleteRole(Role role) {
		return roleMapper.deleteRole(role);
	}
}

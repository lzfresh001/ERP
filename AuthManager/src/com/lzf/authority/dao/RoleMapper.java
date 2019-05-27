package com.lzf.authority.dao;

import java.util.List;

import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.RoleAuth;

public interface RoleMapper {
	
	// 全查role表
	public List<Role> queryAllRole(PageUtil pageUtil);
	
	// 查role表总条数
	public Integer queryRoleAllCount(PageUtil pageUtil);
	
	// 根据role_code查role
	public Role queryRoleByRoleCode(String roleCode);
	
	// 添加role
	public Integer addRole(Role role);
	
	// 修改role
	public Integer updateRole(Role role);
	 
	// 启用/禁用 role_satte
	public Integer stopstartRoleState(Role role);
	
	// 根据role_id查询角色已有的auth_id
	public String queryAuthIdByRoleId(RoleAuth roleAuth);
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState();
	
	// 根据role_id删除role_auth
	public Integer deleteRoleAuthByRoleId(RoleAuth roleAuth);
	
	// 根据role_id添加role_auth
	public Integer insertRoleAuth(RoleAuth roleAuth);
	
	// 根据role_id删除role
	public Integer deleteRole(Role role);
}
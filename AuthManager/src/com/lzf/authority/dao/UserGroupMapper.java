package com.lzf.authority.dao;

import java.util.List;

import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.GroupRole;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserGroup;

public interface UserGroupMapper {
	
	// 全查user_group
	public List<UserGroup> queryAllUserGroup(PageUtil pageUtil);
	
	// 查询user_group总条数
	public Integer queryUserGroupAllCount(PageUtil pageUtil);
	
	// 根据group_code查询user_group 
	public UserGroup queryUserGroupByGroupCode(UserGroup userGroup);
	
	// 添加部门
	public Integer insertUserGroup(UserGroup userGroup);
	
	// 修改部门
	public Integer updateUserGroupByGroupId(UserGroup userGroup);
	
	// 禁用/启用 group_state
	public Integer stopstartGroupState(UserGroup userGroup);
	
	// 根据group_id查询auth_id
	public String queryAuthIdByGroupId(Integer groupId);
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState();
	
	// 根据role_state查询role
	public List<Role> queryRoleByRoleState();
	
	// 根据group_id查询已有的role_id
	public String queryRoleIdByGroupId(GroupRole groupRole);
	
	// 根据group_id删除group_role
	public Integer deleteGroupRoleByGroupId(GroupRole groupRole);
	
	// 根据group_id添加group_role
	public Integer insertGroupRole(GroupRole groupRole);
	
	// 根据group_id删除user_group
	public Integer deleteUserGroupByGroupId(UserGroup userGroup);
	
}
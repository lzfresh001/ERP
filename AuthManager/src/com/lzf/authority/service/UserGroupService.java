package com.lzf.authority.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzf.authority.dao.UserGroupMapper;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.GroupRole;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserGroup;
import com.lzf.authority.vo.UserRole;

@Service
public class UserGroupService {
	
	@Autowired
	private UserGroupMapper userGroupMapper;
	
	// 全查user_group
	public List<UserGroup> queryAllUserGroup(PageUtil pageUtil){
		return userGroupMapper.queryAllUserGroup(pageUtil);
	}
	
	// 查询user_group总条数
	public Integer queryUserGroupAllGount(PageUtil pageUtil) {
		return userGroupMapper.queryUserGroupAllCount(pageUtil);
	}
	
	// 根据group_code查询user_group 
	public UserGroup queryUserGroupByGroupCode(UserGroup userGroup) {
		return userGroupMapper.queryUserGroupByGroupCode(userGroup);
	}

	// 添加部门
	public Integer insertUserGroup(UserGroup userGroup) {
		return userGroupMapper.insertUserGroup(userGroup);
	}
	
	// 修改部门
	public Integer updateUserGroupByGroupId(UserGroup userGroup) {
		return userGroupMapper.updateUserGroupByGroupId(userGroup);
	}
	
	// 禁用/启用 group_state
	public Integer stopstartGroupState(UserGroup userGroup) {
		return userGroupMapper.stopstartGroupState(userGroup);
	}
	
	// 根据group_id查询auth_id
	public String queryAuthIdByGroupId(Integer groupId) {
		return userGroupMapper.queryAuthIdByGroupId(groupId);
	}
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState(){
		return userGroupMapper.queryAuthInfoByAuthState();
	}
	
	// 根据role_state查询role
	public List<Role> queryRoleByRoleState(){
		return userGroupMapper.queryRoleByRoleState();
	}
	
	// 根据group_id查询已有的role_id
	public String queryRoleIdByGroupId(GroupRole groupRole) {
		return userGroupMapper.queryRoleIdByGroupId(groupRole);
	}
	
	// 根据group_id删除group_role
	public Integer deleteGroupRoleByGroupId(GroupRole groupRole) {
		return userGroupMapper.deleteGroupRoleByGroupId(groupRole);
	}
	
	// 先删除原有的role_id再添加role_id
	@Transactional
	public Integer deleteInsertGroupRole(GroupRole groupRole,String roleIds) {
		Integer rows = 0;
		Integer delRows = userGroupMapper.deleteGroupRoleByGroupId(groupRole);
		String roleId[] = roleIds.split(",");
		Integer insRows = 0;
		for(int i=0;i<roleId.length;i++) {
			groupRole.setRoleId(Integer.parseInt(roleId[i]));
			Integer insRow = userGroupMapper.insertGroupRole(groupRole);
			insRows += insRow;
		}
		rows = delRows+insRows;
		return rows;
	}
	
	// 根据group_id删除user_group
	public Integer deleteUserGroupByGroupId(UserGroup userGroup) {
		return userGroupMapper.deleteUserGroupByGroupId(userGroup);
	}
}

package com.lzf.authority.dao;

import java.util.HashMap;
import java.util.List;

import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserAuth;
import com.lzf.authority.vo.UserGroup;
import com.lzf.authority.vo.UserInfo;
import com.lzf.authority.vo.UserRole;

public interface UserInfoMapper {

	// 获取当前用户相应级别的权限
	public List<AuthInfo> queryUserAuth(HashMap map);
	
	// 分页查询用户信息
	// user_info(主表) ,role(从),user_group(从)三表联查 
	public List<UserInfo> queryUserInfoPage(PageUtil pageUtil);
	
	// 根据user_code查询user_info
	public UserInfo queryUserInfoByUserCode(String userCode);
	
	// 询user_group并且group_state为1的
	public List<UserGroup> queryUserGroupByGroupState();
	
	// 查询role并且role_state为1的
	public List<Role> queryRoleByRoleState();
	
	// 添加用户信息
	public Integer addUserInfo(UserInfo userInfo);
	
	// 查询user_info的总条数
	public Integer queryUserInfoAllCount(PageUtil pageUtil);
	
	// 修改用户信息
	public Integer updateUserInfo(UserInfo userInfo);
	
	// 逻辑删除用户
	public Integer deleteUserInfo(UserInfo userInfo);
	
	// 禁用/启用 用户权限
	public Integer startStopUser(UserInfo userInfo);
	
	// 重置密码
	public Integer resetUserPwd(UserInfo userInfo);
	
	// 查询用户已有角色的id
	public String queryUserRoleIdByUserId(UserRole userRole);
	
	// 根据user_id删除user_role
	public Integer deleteUserRoleByUserId(UserRole userRole);
	
	// 根据user_id添加user_role
	public Integer insertUserRole(UserRole userRole);
	
	// 查询用户已有的auth_id
	public String queryUserAuthIdByUserId(UserAuth userAuth);
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState();
	
	// 根据user_id删除user_auth
	public Integer deleteUserAuthByUserId(UserAuth userAuth);
	
	// 根据user_id添加user_auth
	public Integer insertUserAuth(UserAuth userAuth);
}
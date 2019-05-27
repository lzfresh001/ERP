package com.lzf.authority.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzf.authority.dao.UserInfoMapper;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserAuth;
import com.lzf.authority.vo.UserGroup;
import com.lzf.authority.vo.UserInfo;
import com.lzf.authority.vo.UserRole;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private PageUtil pageUtil;
	
	// 获取当前用户相应级别的权限
	public List<AuthInfo> queryUserAuth(HashMap map){
		return userInfoMapper.queryUserAuth(map);
	}
	
	// 分页查询用户信息
	// user_info(主表) ,role(从),user_group(从)三表联查 
	public List<UserInfo> queryUserInfoPage(PageUtil pageutil){
		return userInfoMapper.queryUserInfoPage(pageUtil);
	}
	
	// 查询user_info的总条数
	public Integer queryUserInfoAllCount(PageUtil pageUtil) {
		return userInfoMapper.queryUserInfoAllCount(pageUtil);
	}
	
	// 根据user_code查询user_info
	public UserInfo queryUserInfoByUserCode(String userCode) {
		return userInfoMapper.queryUserInfoByUserCode(userCode);
	}
	
	// 询user_group并且group_state为1的
	public List<UserGroup> queryUserGroupByGroupState(){
		return userInfoMapper.queryUserGroupByGroupState();
	}
	
	// 查询role并且role_state为1的
	public List<Role> queryRoleByRoleState(){
		return userInfoMapper.queryRoleByRoleState();
	}
	
	// 添加用户信息
	public Integer addUserInfo(UserInfo userInfo) {
		return userInfoMapper.addUserInfo(userInfo);
	}
	
	// 修改用户信息
	public Integer updateUserInfo(UserInfo userInfo) {
		return userInfoMapper.updateUserInfo(userInfo);
	}
	
	// 逻辑删除用户
	public Integer deleteUserInfo(UserInfo userInfo) {
		return userInfoMapper.deleteUserInfo(userInfo);
	}
	
	// 禁用/启用 用户权限
	public Integer startStopUser(UserInfo userInfo) {
		return userInfoMapper.startStopUser(userInfo);
	}
	
	// 重置密码
	public Integer resetUserPwd(UserInfo userInfo) {
		return userInfoMapper.resetUserPwd(userInfo);
	}
	
	// 查询用户已有角色的id
	public String queryUserRoleIdByUserId(UserRole userRole) {
		return userInfoMapper.queryUserRoleIdByUserId(userRole);
	}
	
	// 根据user_id删除user_role
	public Integer deleteUserRoleByUserId(UserRole userRole) {
		return userInfoMapper.deleteUserRoleByUserId(userRole);
	}
	
	// 先删除原有的role_id再添加role_id
	@Transactional
	public Integer deleteInsertUserRole(UserRole userRole,String roleIds) {
		Integer rows = 0;
		Integer delRows = userInfoMapper.deleteUserRoleByUserId(userRole);
		String roleId[] = roleIds.split(",");
		Integer insRows = 0;
		for(int i=0;i<roleId.length;i++) {
			userRole.setRoleId(Integer.parseInt(roleId[i]));
			Integer insRow = userInfoMapper.insertUserRole(userRole);
			insRows += insRow;
		}
		rows = delRows+insRows;
		return rows;
	}
	
	// 查询用户已有的auth_id
	public String queryUserAuthIdByUserId(UserAuth userAuth) {
		return userInfoMapper.queryUserAuthIdByUserId(userAuth);
	}
	
	// 查询auth_info并且auth_state=1
	public List<AuthInfo> queryAuthInfoByAuthState(){
		return userInfoMapper.queryAuthInfoByAuthState();
	}
	
	// 根据user_id删除user_auth
	public Integer deleteUserAuthByUserId(UserAuth userAuth) {
		return userInfoMapper.deleteUserAuthByUserId(userAuth);
	}
	
	// 先删除原有的auth_id再添加auth_id
	@Transactional
	public Integer deleteInsertUserAuth(UserAuth userAuth,String authIds) {
		Integer rows = 0;
		Integer delRows = userInfoMapper.deleteUserAuthByUserId(userAuth);
		String authId[] = authIds.split(",");
		Integer insRows = 0;
		for(int i=0;i<authId.length;i++) {
			userAuth.setAuthId(Integer.parseInt(authId[i]));
			Integer insRow = userInfoMapper.insertUserAuth(userAuth);
			insRows += insRow;
		}
		rows = delRows + insRows;
		return rows;
	}
}

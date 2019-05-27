package com.lzf.authority.dao;

import java.util.List;

import com.lzf.authority.vo.AuthInfo;

public interface AuthInfoMapper {
	
	// 全查auth_info
	public List<AuthInfo> queryAllAuthInfo();
	
	// 根据auth_name查auth_info
	public AuthInfo queryAuthInfoByAuthName(AuthInfo authInfo);
	
	// 根据auth_url查auth_info
	public AuthInfo queryAuthInfoByAuthUrl(AuthInfo authInfo);
	
	// 根据auth_code查auth_info
	public AuthInfo queryAuthInfoByAuthCode(AuthInfo authInfo);
	
	// 添加auth_info
	public Integer insertAuthInfo(AuthInfo authInfo);
	
	// 修改auth_info
	public Integer updateAuthInfo(AuthInfo authInfo);
	
	// 查询auth_info且auth_state=0
	public List<AuthInfo> queryAuthInfoByAuthStateZero();
	
	// 恢复权限
	public Integer startAuthState(AuthInfo authInfo);
	
	// 逻辑删除auth_info
	public Integer stopAuthState(AuthInfo authInfo);
	
	// 根据父id查所有子id
	public String querySonIdByAuthId(AuthInfo authInfo);
	
	// 查询user_auth中auth_id的条数
	public Integer queryUserAuthCountByAuthId(AuthInfo authInfo);
	
	// 查询role_auth中auth_id的条数
	public Integer queryRoleAuthCountByAuthId(AuthInfo authInfo);
}
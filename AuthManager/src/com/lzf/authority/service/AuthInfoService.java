package com.lzf.authority.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.authority.dao.AuthInfoMapper;
import com.lzf.authority.vo.AuthInfo;

@Service
public class AuthInfoService {
	
	@Autowired
	private AuthInfoMapper authInfoMapper;
	
	// 全查auth_info
	public List<AuthInfo> queryAllAuthInfo(){
		return authInfoMapper.queryAllAuthInfo();
	}
	
	// 根据auth_name查auth_info
	public AuthInfo queryAuthInfoByAuthName(AuthInfo authInfo) {
		return authInfoMapper.queryAuthInfoByAuthName(authInfo);
	}
	
	// 根据auth_url查auth_info
	public AuthInfo queryAuthInfoByAuthUrl(AuthInfo authInfo) {
		return authInfoMapper.queryAuthInfoByAuthUrl(authInfo);
	}
	
	// 根据auth_code查auth_info
	public AuthInfo queryAuthInfoByAuthCode(AuthInfo authInfo) {
		return authInfoMapper.queryAuthInfoByAuthCode(authInfo);
	}
	
	// 添加auth_info
	public Integer insertAuthInfo(AuthInfo authInfo) {
		return authInfoMapper.insertAuthInfo(authInfo);
	}
	
	// 修改auth_info
	public Integer updateAuthInfo(AuthInfo authInfo) {
		return authInfoMapper.updateAuthInfo(authInfo);
	}
	
	// 查询auth_info且auth_state=0
	public List<AuthInfo> queryAuthInfoByAuthStateZero(){
		return authInfoMapper.queryAuthInfoByAuthStateZero();
	}
	
	// 恢复权限
	public Integer startAuthState(AuthInfo authInfo) {
		return authInfoMapper.startAuthState(authInfo);
	}
	
	// 逻辑删除权限
	public boolean stopAuthInfo(AuthInfo authInfo) {
		// 查看当前操作的权限是否在使用
		Integer uAc = authInfoMapper.queryUserAuthCountByAuthId(authInfo);
		Integer rAc = authInfoMapper.queryRoleAuthCountByAuthId(authInfo);
		if((uAc+rAc)>0) { // 该权限在使用
			return false;
		}else {
			// 通过将authId赋给parentId,查询AuthIds拼接字符串
			String authIds = authInfoMapper.querySonIdByAuthId(authInfo);
			//从当前权限向下一级权限逐级禁用
			authInfoMapper.stopAuthState(authInfo);
			if(null != authIds && !authIds.equals("") ) {
				String[] authId = authIds.split(",");
				for(int i=0;i<authId.length;i++) {
					authInfo.setAuthId(Integer.parseInt(authId[i]));
					// 回调
					stopAuthInfo(authInfo);
				}
			}
		}
		return true;
	}
	
}

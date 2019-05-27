package com.lzf.authority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.authority.dao.LoginMapper;
import com.lzf.authority.vo.UserInfo;

import net.sf.json.JSONObject;

/**
 * @comment 
 * @filename LoginService.java
 * @author lzf
 * @date 2019年4月8日 下午1:19:25
 * @version 1.0
 */
@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private UserInfo userInfo;
	
	// 判断用户账号和密码的正确性及是否通过审核
	/*public boolean isRightUser(String userCode,String userPwd) {
		userInfo.setUserCode(userCode);
		userInfo.setUserPwd(userPwd);
		UserInfo user = loginMapper.queryUserInfoByUserCode(userInfo);
		if(null == user || user.getIsDelete().equals("1")) {
			return false;
		}
		return true;
	}*/
	
	
	// 根据账号和密码查UserInfo
	public UserInfo queryUserInfoByUserCode(String userCode,String userPwd) {
		userInfo.setUserCode(userCode);
		userInfo.setUserPwd(userPwd);
		UserInfo user = loginMapper.queryUserInfoByUserCode(userInfo);
		return user;
	}
	

}

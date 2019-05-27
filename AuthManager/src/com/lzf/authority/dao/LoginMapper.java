package com.lzf.authority.dao;

import com.lzf.authority.vo.UserInfo;

public interface LoginMapper {
	
	public UserInfo queryUserInfoByUserCode(UserInfo userInfo);

}

package com.lzf.erp.dao;

import java.util.List;
import java.util.Map;

import com.lzf.erp.model.User;

/**
 * @comment user Dao层
 * @filename UserMapper.java
 * @author lzf
 * @date 2019年4月25日 下午4:10:58
 * @version 1.0
 */
public interface UserMapper {

	// 根据uname和password查询user 
	public User queryUserByUnamePwd(User user);
	
	// 查询用户管理页面所需信息
	public List<User> queryAllUser(Map<String,Object> map);
	
	// 查询用户管理页面所需总条数
	public Integer queryAllUserCount(Map<String,Object> map);
	
	// 根据uname查询user表
	public User queryUserByUname(User user);
	
	// 添加用户
	public Integer saveUser(User user);
	
	// 修改用户信息
	public Integer updateUser(User user);
	
	// 逻辑删除用户信息
	public Integer deleteUser(Integer uid);
}

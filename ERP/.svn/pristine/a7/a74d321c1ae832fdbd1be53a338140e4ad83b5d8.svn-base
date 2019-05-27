package com.lzf.erp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.UserMapper;
import com.lzf.erp.model.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment  UserService实现层
 * @filename UserServiceImpl.java
 * @author lzf
 * @date 2019年4月25日 下午4:13:28
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	// 根据uname和password查询user
	@Override
	public User queryUserByUnamePwd(User user) {
		return userMapper.queryUserByUnamePwd(user);
	}

	// 查询用户管理页面所需信息
	@Override
	public JSONArray queryAllUser(Map<String,Object> map) {
		JSONArray jsonArray = new JSONArray();
		List<User> userList = userMapper.queryAllUser(map);
		for(User user: userList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("uid", user.getUid());
			jsonObject.put("uname", user.getUname());
			jsonObject.put("password", user.getPassword());
			jsonObject.put("userType", user.getUserType());
			jsonObject.put("roleId", user.getRoleId());
			jsonObject.put("userDescription", user.getUserDescription());
			jsonObject.put("delflag", user.getDelflag());
			jsonObject.put("currentTime", user.getCurrentTime());
			jsonObject.put("roleName", user.getRole().getRoleName());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 查询用户管理页面所需总条数
	@Override
	public Integer queryAllUserCount(Map<String,Object> map) {
		return userMapper.queryAllUserCount(map);
	}

	// 根据uname查询user表
	@Override
	public User queryUserByUname(User user) {
		return userMapper.queryUserByUname(user);
	}

	// 添加用户
	@Override
	public Integer saveUser(User user) {
		return userMapper.saveUser(user);
	}
	
	// 修改用户信息
	@Override
	public Integer updateUser(User user) {
		return userMapper.updateUser(user);
	}

	// 逻辑删除用户信息
	@Override
	public Integer deleteUser(Integer uid) {
		return userMapper.deleteUser(uid);
	}

	

	

}

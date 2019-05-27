package com.lzf.authority.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.authority.service.UserInfoService;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserAuth;
import com.lzf.authority.vo.UserGroup;
import com.lzf.authority.vo.UserInfo;
import com.lzf.authority.vo.UserRole;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment user控制层
 * @filename UserInfoController.java
 * @author lzf
 * @date 2019年4月9日 上午10:52:37
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PageUtil pageUtil;
	
	@RequestMapping("/index.action")
	public String index(HttpServletRequest request) {
		// 获取该用户所有的一级权限和相应的二级权限
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("USER");
		// 获取当前用户的一级权限
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userInfo.getUserId());
		map.put("groupId", userInfo.getGroupId());
		map.put("parentId", 0); // 一级权限 parent_id为0
		List<AuthInfo> firstList  = userInfoService.queryUserAuth(map);
		// 给一级权限绑定相应的二级权限
		for(AuthInfo authInfo: firstList) {
			// 一级权限的id 就是二级权限的父id
			map.put("parentId", authInfo.getAuthId());
			// 某一个一级权限下的子权限
			List<AuthInfo> secondList = userInfoService.queryUserAuth(map);
			// 将相应的二级权限绑定到父权限中
			authInfo.setChildList(secondList);
		}
		session.setAttribute("FirstList", firstList);
		return "/pages/index.jsp";
	}
	
	// 生成分页查询用户信息路径
	@RequestMapping("/list.action")
	public String list(Integer pageSize,Integer pageNum,String userCode,String userType,String userState,HttpServletRequest request) {
		//System.out.println("pageNum="+pageNum);
		HttpSession session = request.getSession();
		// pageSize 每页显示条数
		if(null==pageSize) {
			pageUtil.setPageSize(5);
		}else {
			pageUtil.setPageSize(pageSize);
		}
		
		// pageNum 当前页码
		if(null == pageNum) {
			pageUtil.setPageNum(1);
		}else {
			pageUtil.setPageNum(pageNum);
		}
		
		pageUtil.setUserCode(userCode);
		pageUtil.setUserType(userType);
		pageUtil.setUserState(userState);
		
		// 查询user_info的总条数
		Integer totalNum = userInfoService.queryUserInfoAllCount(pageUtil);
		pageUtil.setTotalNum(totalNum);
		session.setAttribute("PageUtil", pageUtil);
		List<UserInfo> userList = userInfoService.queryUserInfoPage(pageUtil);
		session.setAttribute("UserList", userList);
		session.setAttribute("UserCode", userCode);
		session.setAttribute("UserType", userType);
		session.setAttribute("UserState", userState);
	
		
		
		List<UserGroup> userGroupList = userInfoService.queryUserGroupByGroupState();
		session.setAttribute("UserGroupList", userGroupList);
		List<Role> roleList = userInfoService.queryRoleByRoleState();
		session.setAttribute("RoleList", roleList);
		return "/pages/user-list.jsp";
	}
	
	// 生成验证用户名唯一性的路径
	@RequestMapping("/checkUserCode.action")
	@ResponseBody
	public JSONObject checkUserCode(String userCode) {
		JSONObject json = new JSONObject();
		UserInfo user = userInfoService.queryUserInfoByUserCode(userCode);
		if(null == user) {
			json.put("isExist", "n"); // no
		}else {
			json.put("isExist", "y"); // yes
		}
		return json;
	}
	
	// 生成验证用户名唯一性的路径
	@RequestMapping("/addUserInfo.action")
	@ResponseBody
	public JSONObject addUserInfo(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("USER");
		userInfo.setCreateBy(user.getUserId()); // 通过session获取操作人的id
		JSONObject json = new JSONObject();
		Integer updateRows = userInfoService.addUserInfo(userInfo);
		if(updateRows>0) {
			json.put("isAdd", "1"); // 表示添加成功
		}else {
			json.put("isAdd", "0"); // 表示添加失败
		}
		return json;
	}
	
	// 生成修改用户信息的路径
	@RequestMapping("/updateUserInfo.action")
	@ResponseBody
	public JSONObject updateUserInfo(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("USER");
		userInfo.setUpdateBy(user.getUserId()); // 通过session获取操作人的id
		JSONObject json = new JSONObject();
		Integer updateRows = userInfoService.updateUserInfo(userInfo);
		if(updateRows>0) {
			json.put("isUpdate", "1"); // 表示修改成功
		}else {
			json.put("isUpdate", "0"); // 表示修改失败
		}
		return json;
	}
		
	// 生成逻辑删除用户的路径
	@RequestMapping("/deleteUserInfo.action")
	@ResponseBody
	public JSONObject deleteUserInfo(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("USER");
		userInfo.setUpdateBy(user.getUserId()); // 通过session获取操作人的id
		JSONObject json = new JSONObject();
		Integer updateRows = userInfoService.deleteUserInfo(userInfo);
		if(updateRows>0) {
			json.put("isDelete", "1"); // 表示修改成功
		}else {
			json.put("isDelete", "0"); // 表示修改失败
		}
		return json;
	}
	
	// 生成 禁用/启用 用户的路径
	@RequestMapping("/startStopUser.action")
	@ResponseBody
	public JSONObject startStopUser(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 判断用户当前权限状态
		String userState = userInfo.getUserState();
		if(userState.equals("1")) {
			userInfo.setUserState("0");
		}else if(userState.equals("0")) {
			userInfo.setUserState("1");
		}
		UserInfo user = (UserInfo)session.getAttribute("USER");
		userInfo.setUpdateBy(user.getUserId()); // 通过session获取操作人的id
		JSONObject json = new JSONObject();
		Integer updateRows = userInfoService.startStopUser(userInfo);
		if(updateRows>0) {
			json.put("result", "1"); // 表示切换成功
		}else {
			json.put("result", "0"); // 表示切换失败
		}
		return json;
	}
	
	// 生成重置用户密码的路径
	@RequestMapping("/resetUserPwd.action")
	@ResponseBody
	public JSONObject resetUserPwd(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("USER");
		userInfo.setUpdateBy(user.getUserId()); // 通过session获取操作人的id
		JSONObject json = new JSONObject();
		Integer updateRows = userInfoService.resetUserPwd(userInfo);
		if(updateRows>0) {
			json.put("isReset", "1"); // 表示重置成功
		}else {
			json.put("isReset", "0"); // 表示重置失败
		}
		return json;
	}
	
	// 生成查询用户已有角色id的路径
	@RequestMapping("/queryUserRoleId.action")
	@ResponseBody
	public JSONObject queryUserRoleId(UserRole userRole) {
		JSONObject json = new JSONObject();
		String roleIds = userInfoService.queryUserRoleIdByUserId(userRole);
		if(null == roleIds || roleIds.equals("")) {
			json.put("RoleIds", "0");
		}else {
			json.put("RoleIds", roleIds);
		}
		return json;
	}
	
	// 生成给用户分配角色的路径
	@RequestMapping("/allotUserRole.action")
	@ResponseBody
	public JSONObject allotUserRole(UserRole userRole,String roleIds) {
		JSONObject json = new JSONObject();
		// 判断roleIds是否为空
		if(null == roleIds || roleIds.equals("")) { // 把用户所有的role全部解除
			Integer del = userInfoService.deleteUserRoleByUserId(userRole);
			if(del>0) {
				json.put("Del", "1"); // 解除成功
			}else {
				json.put("Del", "0"); // 解除失败
			}
		}else {
			Integer rows = userInfoService.deleteInsertUserRole(userRole, roleIds);
			if(rows>0) {
				json.put("Rows", "1"); // 分配成功
			}else {
				json.put("Rows", "0"); // 分配失败
			}
		}
		return json;
	}
	
	// 用户分配权限回显的路径
	@RequestMapping("/allotUserAuth.action")
	public String allotUserAuth(UserAuth userAuth,HttpServletRequest request) {
		String authIds = userInfoService.queryUserAuthIdByUserId(userAuth);
		JSONArray array = new JSONArray();
		List<AuthInfo> authInfoList = userInfoService.queryAuthInfoByAuthState();
		// 循环遍历 依据zTree的格式 将依次存放到JSONObject JSONArray中
		for(AuthInfo authInfo: authInfoList) {
			JSONObject json = new JSONObject();
			json.put("open", false);
			json.put("id", authInfo.getAuthId());
			json.put("pId", authInfo.getParentId());
			json.put("name", authInfo.getAuthName());
			json.put("desc", authInfo.getAuthDesc());
			json.put("type", authInfo.getAuthType());
			json.put("url", authInfo.getAuthUrl());
			json.put("code", authInfo.getAuthCode());
			// 判断当前用户有没有该权限 有 就回显
			if((","+ authIds +",").contains(","+ authInfo.getAuthId() +",")) {
				json.put("checked", true);
			}
			array.add(json);
		}
		request.getSession().setAttribute("array", array);
		request.getSession().setAttribute("userId", userAuth.getUserId());
		return "/pages/user-authTree.jsp";
	}
	
	// 生成更改用户权限的路径
	@RequestMapping("/updateUserAuth.action")
	@ResponseBody
	public JSONObject updateUserAuth(UserAuth userAuth,String authIds) {
		JSONObject json = new JSONObject();
		// 判断authIds是否为空
		if(null == authIds || authIds.equals("")) { // 把用户的所有auth解除
			Integer del = userInfoService.deleteUserAuthByUserId(userAuth);
			if(del>0) {
				json.put("Del", "1"); // 解除成功
			}else {
				json.put("Del", "0"); // 解除失败
			}
		}else {
			Integer rows = userInfoService.deleteInsertUserAuth(userAuth, authIds);
			if(rows>0) {
				json.put("Rows", "1"); // 更改成功
			}else {
				json.put("Rows", "0"); // 更改失败
			}
		}
		return json;
	}
	
	// 生成导出数据的路径
	@RequestMapping("/downloadData.action")
	public String downloadData(String userCode,String userType,String userState,HttpServletRequest request) {
		pageUtil.setUserCode(userCode);
		pageUtil.setUserType(userType);
		pageUtil.setUserState(userState);
		pageUtil.setPageSize(9999); // 设置每页显示9999条
		pageUtil.setPageNum(1); // 设置当前页为第一页
		List<UserInfo> userInfoList = userInfoService.queryUserInfoPage(pageUtil);
		request.getSession().setAttribute("DownloadList", userInfoList);
		return "/pages/user-list-download.jsp";
	}
	
}

package com.lzf.authority.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.authority.service.UserGroupService;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.GroupRole;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.UserGroup;
import com.lzf.authority.vo.UserRole;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment UserGroup 控制层
 * @filename UserGroupController.java
 * @author lzf
 * @date 2019年4月15日 下午5:07:25
 * @version 1.0
 */
@Controller
@RequestMapping("/group")
public class UserGroupController {
	
	@Autowired
	private UserGroupService userGroupService;
	@Autowired
	private PageUtil pageUtil;
	
	// 生成分页查询user_group信息的路径
	@RequestMapping("/list.action")
	public String list(Integer pageNum,String groupCode,String groupState,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(null == pageNum) {
			pageUtil.setPageNum(1);
		}else {
			pageUtil.setPageNum(pageNum);
		}
		pageUtil.setPageSize(5);
		pageUtil.setGroupCode(groupCode);
		pageUtil.setGroupState(groupState);
		Integer totalNum = userGroupService.queryUserGroupAllGount(pageUtil);
		pageUtil.setTotalNum(totalNum);
		session.setAttribute("UserGroupPu", pageUtil);
		List<UserGroup> userGroupList = userGroupService.queryAllUserGroup(pageUtil);
		session.setAttribute("UserGroupList", userGroupList);
		List<Role> roleList = userGroupService.queryRoleByRoleState();
		session.setAttribute("RoleList", roleList);
		
		return "/pages/usergroup-list.jsp";
	}

	// 生成验证group_code唯一性的路径
	@RequestMapping("/checkGroupCode.action")
	@ResponseBody
	public JSONObject checkGroupCode(UserGroup userGroup) {
		JSONObject json = new JSONObject();
		UserGroup group = userGroupService.queryUserGroupByGroupCode(userGroup);
		if(null == group) {
			json.put("isExist", "0"); // 没有这个部门
		}else {
			json.put("isExist", "1"); // 有这个部门
		}
		return json;
	}
	
	 // 生成添加部门的路径
	@RequestMapping("/addUserGroup.action")
	@ResponseBody
	public JSONObject addUserGroup(UserGroup userGroup,HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Integer updateRow = userGroupService.insertUserGroup(userGroup);
		if(updateRow>0) {
			json.put("isAdd", "1"); // 添加成功
		}else {
			json.put("isAdd", "0"); // 添加失败
		}
		return json;
	}
	
	// 生成修改部门的路径
	@RequestMapping("/updateUserGroup.action")
	@ResponseBody
	public JSONObject updateUserGroup(UserGroup userGroup) {
		JSONObject json = new JSONObject();
		Integer updateRow = userGroupService.updateUserGroupByGroupId(userGroup);
		if(updateRow>0) {
			json.put("isUpdate", "1"); // 修改成功
		}else {
			json.put("isUpdate", "0"); // 修改失败
		}
		return json;
	}
	
	// 生成UserGroup禁用启用的路径
	@RequestMapping("/stopstartUserGroup.action")
	@ResponseBody
	public JSONObject stopstartUserGroup(UserGroup userGroup) {
		// 获取传过来的groupState
		String state = userGroup.getGroupState();
		if(state.equals("1")) {
			userGroup.setGroupState("0");
		}else if(state.equals("0")){
			userGroup.setGroupState("1");
		}
		JSONObject json = new JSONObject();
		Integer updateRow = userGroupService.stopstartGroupState(userGroup);
		if(updateRow>0) {
			json.put("isCut", "1"); // 切换成功
		}else {
			json.put("isCut", "0"); // 切换失败
		}
		return json;
	}
	
	// 生成更改部门权限回显路径
	@RequestMapping("/allotUserGroupAuth.action")
	public String allotUserGroupAuth(Integer groupId,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String authIds = userGroupService.queryAuthIdByGroupId(groupId);
		JSONArray array = new JSONArray();
		List<AuthInfo> authInfoList = userGroupService.queryAuthInfoByAuthState();
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
		session.setAttribute("array", array);
		session.setAttribute("groupId", groupId);
		return "/pages/group-authTree.jsp";
	}
	
	// 生成查询部门已有角色id的路径
	@RequestMapping("/queryGroupRoleId.action")
	@ResponseBody
	public JSONObject queryGroupRoleId(GroupRole groupRole) {
		JSONObject json = new JSONObject();
		String roleIds = userGroupService.queryRoleIdByGroupId(groupRole);
		if(null == roleIds || roleIds.equals("")) {
			json.put("RoleIds", "0"); // 没有绑定角色
		}else {
			json.put("RoleIds", roleIds);
		}
		return json;
	}
	
	// 生成给部门分配角色的路径
	@RequestMapping("/allotGroupRole.action")
	@ResponseBody
	public JSONObject allotGroupRole(GroupRole groupRole,String roleIds) {
		JSONObject json = new JSONObject();
		// 判断roleIds是否为空
		if(null == roleIds || roleIds.equals("")) { // 把用户所有的role全部解除
			Integer del = userGroupService.deleteGroupRoleByGroupId(groupRole);
			if(del>0) {
				json.put("Del", "1"); // 解除成功
			}else {
				json.put("Del", "0"); // 解除失败
			}
		}else {
			Integer rows = userGroupService.deleteInsertGroupRole(groupRole, roleIds);
			if(rows>0) {
				json.put("Rows", "1"); // 分配成功
			}else {
				json.put("Rows", "0"); // 分配失败
			}
		}
		return json;
	} 
	
	// 生成删除user_group的路径
	@RequestMapping("/deleteGroup.action")
	@ResponseBody
	public JSONObject deleteGroup(UserGroup userGroup) {
		JSONObject json = new JSONObject();
		Integer del = userGroupService.deleteUserGroupByGroupId(userGroup);
		if(del>0) {
			json.put("isDel", "1"); // 删除成功
		}else {
			json.put("isDel", "0"); // 删除失败
		}
		return json;
	}
}

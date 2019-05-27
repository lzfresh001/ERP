package com.lzf.authority.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.authority.service.RoleService;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.PageUtil;
import com.lzf.authority.vo.Role;
import com.lzf.authority.vo.RoleAuth;
import com.lzf.authority.vo.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment role控制层
 * @filename RoleController.java
 * @author lzf
 * @date 2019年4月14日 下午5:08:01
 * @version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private PageUtil pageUtil;
	
	// 生成分页查询role信息的路径
	@RequestMapping("/list.action")
	public String list(Integer pageNum,String roleCode,String roleState,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(null == pageNum) {
			pageUtil.setPageNum(1);
		}else {
			pageUtil.setPageNum(pageNum);
		}
		pageUtil.setPageSize(5);
		pageUtil.setRoleCode(roleCode);
		pageUtil.setRoleState(roleState);
		// 查询role总条数
		Integer totalNum = roleService.queryRoleAllCount(pageUtil);
		pageUtil.setTotalNum(totalNum);
		session.setAttribute("RolePu", pageUtil);
		List<Role> roleList = roleService.queryAllRole(pageUtil);
		session.setAttribute("RoleList", roleList);
		return "/pages/role-list.jsp";
	}
	
	// 生成验证role_code唯一性的路径
	@RequestMapping("checkRoleCode.action")
	@ResponseBody
	public JSONObject checkRoleCode(String roleCode) {
		JSONObject json = new JSONObject();
		Role role = roleService.queryRoleByRoleCode(roleCode);
		if(null == role) {
			json.put("isExist", "0"); // 没有这个角色
		}else {
			json.put("isExist", "1"); // 有这个角色
		}
		return json;
	}
	
	// 生成添加role的路径
	@RequestMapping("/addRole.action")
	@ResponseBody
	public JSONObject addRole(Role role,HttpServletRequest request) {
		// 获取创建人信息 并将创建人id设置到role中
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		role.setCreateBy(user.getUserId());
		JSONObject json = new JSONObject();
		Integer updateRows = roleService.addRole(role);
		if(updateRows>0) {
			json.put("isAdd", "1"); // 添加成功
		}else {
			json.put("isAdd", "0"); // 添加失败
		}
		return json;
	}
	
	// 生成修改role的路径
	@RequestMapping("/updateRole.action")
	@ResponseBody
	public JSONObject updateRole(Role role,HttpServletRequest request) {
		// 获取修改人信息 并将修改人id设置到role中
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		role.setUdateBy(user.getUserId());
		JSONObject json = new JSONObject();
		Integer updateRows = roleService.updateRole(role);
		if(updateRows>0) {
			json.put("isUpdate", "1"); // 修改成功
		}else {
			json.put("isUpdate", "0"); // 修改失败
		}
		return json;
	}
	
	// 生成role 禁用/启用 的路径
	@RequestMapping("/stopstartRole.action")
	@ResponseBody
	public JSONObject stopstartRole(Role role,HttpServletRequest request) {
		// 获取传过来的roleState
		String state = role.getRoleState();
		if(state.equals("1")) {
			role.setRoleState("0");
		}else if(state.equals("0")) {
			role.setRoleState("1");
		}
		// 获取修改人信息 并将修改人id设置到role中
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		role.setUdateBy(user.getUserId());
		JSONObject json = new JSONObject();
		Integer updateRows = roleService.stopstartRoleState(role);
		if(updateRows>0) {
			json.put("isCut", "1"); // 切换成功
		}else {
			json.put("isCut", "0"); // 切换失败
		}
		return json;
	}
	
	// 更改角色权限回显路径
	@RequestMapping("/allotRoleAuth.action")
	public String allotRoleAuth(RoleAuth roleAuth,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer roleId = roleAuth.getRoleId();
		// 根据role_id查询角色已有的auth_id
		String authIds = roleService.queryAuthIdByRoleId(roleAuth);
		JSONArray array = new JSONArray();
		List<AuthInfo> authInfoList = roleService.queryAuthInfoByAuthState();
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
		session.setAttribute("roleId", roleId);
		return "/pages/role-authTree.jsp";
	}
	
	// 生成更改角色权限的路径
	@RequestMapping("/updateRoleAuth.action")
	@ResponseBody
	public JSONObject updateRoleAuth(RoleAuth roleAuth,String authIds) {
		JSONObject json = new JSONObject();
		// 判断authIds是否为空
		if(null == authIds || authIds.equals("")) { // 把角色所有的auth解除
			Integer del = roleService.deleteRoleAuthByRoleId(roleAuth);
			if(del>0) {
				json.put("Del", "1"); // 解除成功
			}else {
				json.put("Del", "0"); // 解除失败
			}
		}else {
			Integer rows = roleService.deleteInsertRoleAuth(roleAuth, authIds);
			if(rows>0) {
				json.put("Rows", "1"); // 更改成功
			}else {
				json.put("Rows", "0"); // 更改失败
			}
		}
		return json;
	}
	
	// 生成删除role的路径
	@RequestMapping("/deleteRole.action")
	@ResponseBody
	public JSONObject deleteRole(Role role) {
		JSONObject json = new JSONObject();
		Integer delRow = roleService.deleteRole(role);
		if(delRow>0) {
			json.put("isDel", "1"); // 删除成功
		}else {
			json.put("isDel", "0"); // 删除失败
		}
		return json;
	}

}

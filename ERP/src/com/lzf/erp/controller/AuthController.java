package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzf.erp.model.Auth;
import com.lzf.erp.model.User;
import com.lzf.erp.service.AuthService;
import com.lzf.erp.service.RoleService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 菜单(权限)控制层
 * @filename AuthController.java
 * @author lzf
 * @date 2019年4月26日 下午4:44:52
 * @version 1.0
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private RoleService roleService;
	
	// 生成用户id查询用户对应权限(菜单)的路径
	@RequestMapping("/list")
	public void list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Integer parentId = -1;
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		String authIds = roleService.queryAuthIdsByRoleId(currentUser.getRoleId());
		List<Integer> authIdList = StringUtil.stringToArry(authIds);
		JSONArray jsonArray = authService.queryAllAuth(parentId,authIdList);
		ResponseUtil.write(response, jsonArray);
	}

	// 生成角色授权回显路径
	@RequestMapping("/authList.do")
	public void authList(String roleId,HttpServletResponse response) throws Exception {
		Integer parentId = -1;
		String authIds = roleService.queryAuthIdsByRoleId(Integer.parseInt(roleId));
		JSONArray jsonArray = authService.getCheckedAuthByParentId(parentId, authIds);
		ResponseUtil.write(response, jsonArray);
	}
	
	// 生成菜单管理加载treegrid的路径
	@RequestMapping("/manageList.do")
	public void manageList(HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer parentId = -1;
		JSONArray jsonArray = authService.queryAuthByParentId(parentId);
		jsonObject.put("rows", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成验证菜单名称唯一性的路径
	@RequestMapping("/checkAuthName.do")
	public void checkAuthName(@RequestParam(value="authName",required=false)String authName,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Auth auth = authService.queryAuthByAuthName(authName);
		if(auth != null) {
			jsonObject.put("hasAuth", "1"); // 表示有
		}else {
			jsonObject.put("hasAuth", "0"); // 表示没有
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成验证菜单path唯一性的路径
	@RequestMapping("/checkAuthPath.do")
	public void checkAuthPath(@RequestParam(value="authPath",required=false)String authPath,
							  HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Auth auth = authService.queryAuthByAuthPath(authPath);
		if(auth != null) {
			jsonObject.put("hasAuth", "1"); // 表示有
		}else {
			jsonObject.put("hasAuth", "0"); // 表示没有
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成添加菜单的路径
	@RequestMapping("/saveAuth.do")
	public void saveAuth(Auth auth,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer parentId = auth.getParentId();
		Integer rows = 0;
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("auth", auth);
		if(parentId == 1) {
			Integer addRow = authService.addAuth(map);
			rows = addRow;
		}else {
			map.put("authId", parentId);
			Integer Row = authService.addAuthAndUpdatePstate(map);
			rows = Row;
		}
		if(rows > 0) {
			jsonObject.put("res", true); // 添加成功
		}else {
			jsonObject.put("res", "添加失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成修改菜单信息的路径
	@RequestMapping("/updateAuth.do")
	public void updateAuth(Auth auth,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer upRow = authService.updateAuth(auth);
		if(upRow > 0) {
			jsonObject.put("res", true); // 修改成功
		}else {
			jsonObject.put("res", "修改失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成删除菜单及其子菜单的路径
	@RequestMapping("/deleteAuthAndchildren.do")
	public void deleteAuthAndchildren(@RequestParam(value="authId",required=false)String authId,
									   HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer AuthId =  Integer.parseInt(authId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("authId", AuthId);
		map.put("parentId", AuthId);
		Integer upRow = authService.updateAuthAndChildren(map);
		if(upRow > 0) {
			jsonObject.put("isDel", true); // 逻辑删除成功
		}else {
			jsonObject.put("isDel", "删除失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成删除菜单的路径
	@RequestMapping("/deleteAuth.do")
	public void deleteAuth(@RequestParam(value="authId",required=false)String authId,
			   HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer AuthId =  Integer.parseInt(authId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("authId", AuthId);
		Integer upRow = authService.updateAuthStateByAuthId(map);
		if(upRow > 0) {
			jsonObject.put("isDel", true); // 逻辑删除成功
		}else {
			jsonObject.put("isDel", "删除失败！"); 
		}
		ResponseUtil.write(response, jsonObject);
	}
}

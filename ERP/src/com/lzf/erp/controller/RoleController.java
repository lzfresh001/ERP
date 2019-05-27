package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.Role;
import com.lzf.erp.service.RoleService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 角色控制层
 * @filename RoleController.java
 * @author lzf
 * @date 2019年4月26日 下午4:45:56
 * @version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	// 生成查询所有role信息的路径(模糊查询用)
	@RequestMapping("/queryAllRole.do")
	public void queryAllRole(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = roleService.queryAllRole();
		ResponseUtil.write(response, jsonArray);
	}
	
	// 生成查询所有role的路径
	@RequestMapping("/findAllRole.do") 
	public void findAllRole(String page,String rows,String s_roleName,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<String,Object>();
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		map.put("pageBean", pageBean);
		Role role = new Role();
		if(StringUtil.isNotEmpty(s_roleName)) {
			role.setRoleName(s_roleName);
		}
		map.put("role", role);
		JSONArray jsonArray = roleService.findAllRole(map);
		Integer total = roleService.findRoleCount(map);
		jsonObject.put("total", total);
		jsonObject.put("rows", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成验证roleName唯一性的路径
	@RequestMapping("/checkRoleName.do")
	public void checkRoleName(Role role,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Role queryRole = roleService.queryRoleByRoleName(role);
		if(null != queryRole) {
			jsonObject.put("hasRole", "1"); // 表示有
		}else {
			jsonObject.put("hasRole", "0"); // 表示没有
		}
		ResponseUtil.write(response, jsonObject);
	}

	// 生成添加角色的路径
	@RequestMapping("/saveRole.do")
	public void saveRole(Role role,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer addRow = roleService.addRole(role);
		if(addRow > 0) {
			jsonObject.put("res", true);  // 添加成功
		}else {
			jsonObject.put("res", "添加失败！");  // 添加失败
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成修改角色信息的路径
	@RequestMapping("/updateRole.do")
	public void updateRole(Role role,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer upRow = roleService.updateRole(role);
		if(upRow > 0) {
			jsonObject.put("res", true);  // 修改成功
		}else {
			jsonObject.put("res", "修改失败！");  // 修改失败
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成删除角色的路径
	@RequestMapping("/deleteRole.do")
	public void deleteRole(String delIds,HttpServletResponse response) throws Exception {
		String[] srtRoleIds = delIds.split(",");
		Integer delRows = 0;
		JSONObject jsonObject = new JSONObject();
		for(int i=0;i<srtRoleIds.length;i++){
			delRows += roleService.deleteRole(Integer.parseInt(srtRoleIds[i]));
		}
		if(delRows > 0) {
			jsonObject.put("isDel", true); // 删除成功
			jsonObject.put("delRows", delRows); // 删除的条数
		}else {
			jsonObject.put("isDel", "删除失败！"); // 删除失败
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成角色授权的路径
	@RequestMapping("/updateAuthIds.do")
	public void updateAuthIds(Role role,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer upRow = roleService.giveAuthIdsByRoleId(role);
		if(upRow > 0) {
			jsonObject.put("isUpd", "1"); // 授权成功
		}else {
			jsonObject.put("isUpd", "0"); // 授权失败
		}
		ResponseUtil.write(response, jsonObject);
	}
}

package com.lzf.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.erp.model.PageBean;
import com.lzf.erp.model.Role;
import com.lzf.erp.model.User;
import com.lzf.erp.service.RoleService;
import com.lzf.erp.service.UserService;
import com.lzf.erp.util.ResponseUtil;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment  user控制层
 * @filename UserController.java
 * @author lzf
 * @date 2019年4月25日 上午11:01:54
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	// 生成用户登录的路径
	@RequestMapping("/login.do")
	public String login(String imageCode,User user,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User sessionUser = (User)session.getAttribute("currentUser");
		String sRand = (String)session.getAttribute("sRand");
		
		if(null != sessionUser && null==user.getUname()) {
			return "index";
		}else {
			if(null == imageCode) {
				return "redirect:/login.jsp";
			}else{
				if(!imageCode.equals(sRand)) {
					return "redirect:/login.jsp?error=1&imageCode="+imageCode+"&userName="+user.getUname()+"&password="+user.getPassword();
				}else {
					User queryUser = userService.queryUserByUnamePwd(user);
					if(null == queryUser) {
						return "redirect:/login.jsp?error=2&imageCode="+imageCode+"&userName="+user.getUname()+"&password="+user.getPassword();
					}else {
						Integer roleId = queryUser.getRoleId();
						Role queryRole = roleService.queryRoleByRoleId(roleId);
						session.setAttribute("currentUserRole", queryRole);
						session.setAttribute("currentUser", queryUser);
						return "index";
					}
				}
			}
		}
	}
	
	// 生成用户登录的路径
	@RequestMapping("/logout.do")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("currentUserRole");
		session.removeAttribute("currentUser");
		return "redirect:/login.jsp";
	}
	
	// 生成用户管理请求路径
	@RequestMapping("/queryAllUser.do")
	public void queryAllUser(String page,String rows,String s_userName,String s_roleId,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<String,Object>();
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		map.put("pageBean", pageBean);
		User user = new User();
		if(StringUtil.isNotEmpty(s_userName)) {
			user.setUname(s_userName);
		}
		if(StringUtil.isNotEmpty(s_roleId)) {
			user.setRoleId(Integer.parseInt(s_roleId));
		}
		map.put("user", user);
		JSONArray jsonArray = userService.queryAllUser(map);
		Integer total = userService.queryAllUserCount(map);
		jsonObject.put("total", total);
		jsonObject.put("rows", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成验证用户名唯一性的路径
	@RequestMapping("/checkUname.do")
	public void checkUname(User user,HttpServletResponse response) throws Exception {
		User queryUser = userService.queryUserByUname(user);
		JSONObject jsonObject = new JSONObject();
		if(null != queryUser) {
			jsonObject.put("hasUser", "1"); // 表示有
		}else {
			jsonObject.put("hasUser", "0"); // 表示没有
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成添加用户的路径
	@RequestMapping("/saveUser.do")
	public void saveUser(User user,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer addRow = userService.saveUser(user);
		if(addRow > 0) {
			jsonObject.put("res", true); // 添加成功
		}else {
			jsonObject.put("res", "添加失败"); // 添加失败
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成修改用户信息的路径
	@RequestMapping("/updateUser.do")
	public void updateUser(User user,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Integer upRow = userService.updateUser(user);
		if(upRow > 0) {
			jsonObject.put("res", true); // 修改成功
		}else {
			jsonObject.put("res", "修改失败"); // 修改失败
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	// 生成删除用户信息的路径
	@RequestMapping("/deleteUser.do")
	public void deleteUser(String delIds,HttpServletResponse response) throws Exception {
		String[] strUids = delIds.split(",");
		Integer delRows = 0;
		JSONObject jsonObject = new JSONObject();
		for(int i=0;i<strUids.length;i++) {
			delRows += userService.deleteUser(Integer.parseInt(strUids[i]));
		}
		if(delRows > 0) {
			jsonObject.put("isDel", true); // 删除成功
			jsonObject.put("delRows", delRows); // 删除的条数
		}else {
			jsonObject.put("isDel", "删除失败！"); // 删除失败
		}
		ResponseUtil.write(response, jsonObject);
	}
}

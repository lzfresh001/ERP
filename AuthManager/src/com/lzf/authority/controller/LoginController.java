package com.lzf.authority.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.authority.service.LoginService;
import com.lzf.authority.vo.UserInfo;

import net.sf.json.JSONObject;

/**
 * @comment 登录控制层
 * @filename LoginController.java
 * @author lzf
 * @date 2019年4月8日 上午10:55:32
 * @version 1.0
 */
@Controller
public class LoginController {
	// 1.判断验证码正确性
	// 2.判断账号和密码的正确性
	// 3.判断账号是否通过审核
	// 4.用户点击退出
	
	@Autowired
	private LoginService loginService;

	/**
	 * @comment 判断验证码的正确性
	 * @author lzf
	 * @date 2019年4月8日 上午11:50:09
	 * @param vCode
	 * @param request
	 * @param response
	 * @return JSONObject
	 * @version 1.0
	 */
	/*@RequestMapping("/validCode.action")
	@ResponseBody
	public JSONObject validCode(String vCode,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("****LoginController******validCode*****");
		String rand01 = (String)request.getSession().getAttribute("rand01");
		JSONObject json = new JSONObject();
		if(vCode.equals(rand01)) {
			json.put("msg", 1);
		}else {
			json.put("msg", 0);
		}
		return json;
	}*/
	
	
	/**
	 * @comment 用户登录验证
	 * @author lzf
	 * @date 2019年4月8日 下午2:50:49
	 * @param userCode
	 * @param userPwd
	 * @param request
	 * @param response
	 * @return JSONObject
	 * @version 1.0
	 */
	@RequestMapping("/login.action")
	@ResponseBody
	public JSONObject login(String userCode,String userPwd,String vCode,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("****LoginController******login*****");
		String rand01 = (String)request.getSession().getAttribute("rand01");
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		UserInfo user = loginService.queryUserInfoByUserCode(userCode, userPwd);
		if(null == user) {
			/*if(vCode.equals(rand01)) {
				json.put("res", "0"); // 用户不存在(验证码正确)
			}else if(!vCode.equals(rand01)) {
				json.put("res", "1"); // 用户不存在(验证码错误)
			}*/
			json.put("res", "0"); // 用户不存在
		}else if(null != user && user.getIsDelete().equals("1")) {
			/*if(vCode.equals(rand01)) {
				json.put("res", "2"); // 用户存在 但已逻辑删除(验证码正确)
			}else if(!vCode.equals(rand01)) {
				json.put("res", "3"); // 用户存在 但已逻辑删除(验证码错误)
			}*/
			json.put("res", "1"); // 用户存在 但已逻辑删除
		}else if(null != user && !user.getIsDelete().equals("1")) {
			if(vCode.equals(rand01)) {
				json.put("res", "2"); // 用户存在(验证码正确)
				session.setAttribute("USER", user);
			}else if(!vCode.equals(rand01)) {
				json.put("res", "3"); // 用户存在(验证码错误)
			}
		}
		/*if(loginService.isRightUser(userCode, userPwd) && vCode.equals(rand01)) {
			json.put("res","3"); // 全符合
			UserInfo user = loginService.queryUserInfoByUserCode(userCode, userPwd);
			//System.out.println(user);
			session.setAttribute("USER", user);
		}else if(loginService.isRightUser(userCode, userPwd) && !vCode.equals(rand01)){
			json.put("res","2"); // 验证码不符合
		}else if(!loginService.isRightUser(userCode, userPwd) && vCode.equals(rand01)) {
			json.put("res","1"); // 用户名密码不符合
		}else if(!loginService.isRightUser(userCode, userPwd) && !vCode.equals(rand01)) {
			json.put("res","0"); // 全不符合
		}else {
			json.put("res","s"); // 未审核
		}*/
		return json;
	}
	
	// 用户点击退出路径
	@RequestMapping("/logout.action")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("USER");
		return "/pages/login.jsp";
	}
}

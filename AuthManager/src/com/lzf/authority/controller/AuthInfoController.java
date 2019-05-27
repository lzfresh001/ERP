package com.lzf.authority.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.authority.service.AuthInfoService;
import com.lzf.authority.vo.AuthInfo;
import com.lzf.authority.vo.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment AuthInfo 控制层
 * @filename AuthInfoConntroller.java
 * @author lzf
 * @date 2019年4月15日 下午4:49:50
 * @version 1.0
 */
@Controller
@RequestMapping("/auth")
public class AuthInfoController {
	
	@Autowired
	private AuthInfoService authInfoService;
	
	
	// 生成查询auth_info信息的路径
	@RequestMapping("/list.action")
	public String list(HttpServletRequest request) {
		JSONArray array = new JSONArray();
		List<AuthInfo> authInfoList = authInfoService.queryAllAuthInfo();
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
			json.put("order", authInfo.getAuthOrder());
			json.put("state", authInfo.getAuthState());
			array.add(json);
		}
		request.getSession().setAttribute("array", array);
		List<AuthInfo> authZeroList = authInfoService.queryAuthInfoByAuthStateZero();
		Integer aZsize = authZeroList.size();
		request.getSession().setAttribute("AuthZero", authZeroList);
		request.getSession().setAttribute("aZsize", aZsize);
		return "/pages/authTree.jsp";
	}
	
	// 生成验证auth_name唯一性的路径
	@RequestMapping("/checkAuthName.action")
	@ResponseBody
	public JSONObject checkAuthName(AuthInfo authInfo) {
		JSONObject json = new JSONObject();
		AuthInfo auth = authInfoService.queryAuthInfoByAuthName(authInfo);
		if(null == auth) {
			json.put("cNres", "0"); // 表示没有
		}else {
			json.put("cNres", "1"); // 表示有
		}
		return json;
	}
	
	// 生成验证auth_name唯一性的路径
	@RequestMapping("/checkAuthUrl.action")
	@ResponseBody
	public JSONObject checkAuthUrl(AuthInfo authInfo) {
		JSONObject json = new JSONObject();
		AuthInfo auth = authInfoService.queryAuthInfoByAuthUrl(authInfo);
		if(null == auth) {
			json.put("cUres", "0"); // 表示没有
		}else {
			json.put("cUres", "1"); // 表示有
		}
		return json;
	}
	
	// 生成验证auth_code唯一性的路径
	@RequestMapping("/checkAuthCode.action")
	@ResponseBody
	public JSONObject checkAuthCode(AuthInfo authInfo) {
		JSONObject json = new JSONObject();
		AuthInfo auth = authInfoService.queryAuthInfoByAuthCode(authInfo);
		if(null == auth) {
			json.put("cCres", "0"); // 表示没有
		}else {
			json.put("cCres", "1"); // 表示有
		}
		return json;
	}
	
	// 生成添加auth_info的路径
	@RequestMapping("/addAuthInfo.action")
	@ResponseBody
	public JSONObject addAuthInfo(AuthInfo authInfo,HttpServletRequest request) {
		// 获取创建人信息
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		authInfo.setCreateBy(user.getUserId());
		JSONObject json = new JSONObject();
		Integer insRow = authInfoService.insertAuthInfo(authInfo);
		if(insRow>0) {
			json.put("isAdd", "1"); // 添加成功
		}else {
			json.put("isAdd", "0"); // 添加失败
		}
		return json;
	}
	
	// 生成修改auth_info的路径
	@RequestMapping("/updateAuthInfo.action")
	@ResponseBody
	public JSONObject updateAuthInfo(AuthInfo authInfo,HttpServletRequest request) {
		// 获取修改人信息
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		authInfo.setUpdateBy(user.getUserId());
		JSONObject json = new JSONObject();
		Integer upRow = authInfoService.updateAuthInfo(authInfo);
		if(upRow>0) {
			json.put("isUp", "1"); // 修改成功
		}else {
			json.put("isUp", "0"); // 修改失败
		}
		return json;
	}
	
	// 生成恢复权限的路径
	@RequestMapping("/startAuth.action")
	@ResponseBody
	public JSONObject startAuth(String authIds,AuthInfo authInfo,HttpServletRequest request) {
		// 获取修改人信息
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		authInfo.setUpdateBy(user.getUserId());
		String[] authId = authIds.split(",");
		Integer startRows = 0;
		for(int i=0;i<authId.length;i++) {
			authInfo.setAuthId(Integer.parseInt(authId[i]));
			Integer startRow = authInfoService.startAuthState(authInfo);
			startRows += startRow;
		}
		JSONObject json = new JSONObject();
		if(startRows>0) {
			json.put("isStart", "1"); // 恢复成功
		}else {
			json.put("isStart", "0"); // 恢复失败
		}
		return json;
	}
	
	// 生成逻辑删除权限的路径
	@RequestMapping("/stopAuth.action")
	@ResponseBody
	public JSONObject stopAuth(AuthInfo authInfo,HttpServletRequest request) {
		// 获取修改人信息
		UserInfo user = (UserInfo)request.getSession().getAttribute("USER");
		authInfo.setUpdateBy(user.getUserId());
		JSONObject json = new JSONObject();
		boolean res = authInfoService.stopAuthInfo(authInfo);
		if(res == true) {
			json.put("isStop", "1"); // 逻辑删除成功
		}else {
			json.put("isStop", "0"); // 逻辑删除失败
		}
		return json;
	}
	

}

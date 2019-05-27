package com.lzf.erp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.erp.dao.AuthDao;
import com.lzf.erp.model.Auth;
import com.lzf.erp.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @comment 菜单(权限)service实现层
 * @filename AuthServiceImpl.java
 * @author lzf
 * @date 2019年4月26日 下午4:40:30
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthDao authDao;
	// 根据用户id查询用户对应权限(菜单)的路径
	// 递归判断获取到的节点是否存在子节点
	@Override
	public JSONArray queryAllAuth(Integer parentId, List<Integer> authIdList) {
		JSONArray jsonArray = this.getAuthIdByparentIdAndAuthIds(parentId, authIdList);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.get("state"))) {
				continue;
			}else {
				jsonObject.put("children", queryAllAuth(jsonObject.getInt("id"), authIdList));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAuthIdByparentIdAndAuthIds(Integer parentId, List<Integer> authIdList) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parentId", parentId);
		map.put("authIdList", authIdList);
		List<Auth> authList = authDao.getAuthByparentIdAndAuthIds(map);
		JSONArray jsonArray = new JSONArray();
		for(Auth auth: authList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", auth.getAuthId());
			jsonObject.put("text", auth.getAuthName());
			jsonObject.put("state", auth.getState());
			jsonObject.put("iconCls", auth.getIconCls());
			JSONObject json = new JSONObject();
			json.put("authPath", auth.getAuthPath());
			jsonObject.put("attributes", json);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}


	// 根据parentId authIds获取当前角色拥有auth
	// 递归判断获取到的节点是否需要选中
	@Override
	public JSONArray getCheckedAuthByParentId(Integer parentId, String authIds) {
		JSONArray jsonArray=this.getAuthByParentId(parentId,authIds);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;
			}else {
				jsonObject.put("children", getCheckedAuthByParentId(jsonObject.getInt("id"),authIds));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAuthByParentId(Integer parentId, String authIds) {
		JSONArray jsonArray = new JSONArray();
		List<Auth> authList = authDao.getAuthByParentId(parentId);
		for(Auth auth: authList) {
			JSONObject jsonObject=new JSONObject();
			Integer authId = auth.getAuthId();
			if(StringUtil.existStrArr(authId+"", authIds.split(","))) {
				jsonObject.put("checked", true);
			}
			jsonObject.put("id", auth.getAuthId());
			jsonObject.put("text", auth.getAuthName());
			jsonObject.put("state",auth.getState());
			jsonObject.put("iconCls", auth.getIconCls());
			JSONObject json = new JSONObject();
			json.put("authPath", auth.getAuthPath());
			jsonObject.put("attributes", json);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	// 根据parentId查询auth
	// 递归判断获取到的节点是否存在子节点
	@Override
	public JSONArray queryAuthByParentId(Integer parentId) {
		JSONArray jsonArray = this.getAuthByPid(parentId);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("authState"))) {
				continue;
			}else {
				jsonObject.put("children", queryAuthByParentId(jsonObject.getInt("authId")));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAuthByPid(Integer parentId) {
		JSONArray jsonArray = new JSONArray();
		List<Auth> authList = authDao.getAuthByParentId(parentId);
		for(Auth auth: authList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("authId", auth.getAuthId());
			jsonObject.put("authName", auth.getAuthName());
			jsonObject.put("authPath", auth.getAuthPath());
			jsonObject.put("parentId", auth.getParentId());
			jsonObject.put("authState",auth.getState());
			jsonObject.put("state",auth.getState());
			jsonObject.put("iconCls", auth.getIconCls());
			jsonObject.put("authDescription", auth.getAuthDescription());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	
	// 根据authName查询auth表
	@Override
	public Auth queryAuthByAuthName(String authName) {
		return authDao.queryAuthByAuthName(authName);
	}

	// 根据authPath查询auth表
	@Override
	public Auth queryAuthByAuthPath(String authPath) {
		return authDao.queryAuthByAuthPath(authPath);
	}

	// 添加auth
	@Override
	public Integer addAuth(Map<String,Object> map) {
		return authDao.addAuth(map);
	}

	// 修改auth信息 
	@Override
	public Integer updateAuth(Auth auth) {
		return authDao.updateAuth(auth);
	}

	// 添加子菜单并更新state
	@Override
	public Integer addAuthAndUpdatePstate(Map<String,Object> map) {
		Integer addRow = authDao.addAuth(map);
		Integer upRow = authDao.updateAuthStateToClosed(map);
		return addRow + upRow;
	}

	// 根据authId逻辑删除auth
	@Override
	public Integer updateAuthStateByAuthId(Map<String, Object> map) {
		return authDao.updateAuthStateByAuthId(map);
	}

	// 逻辑删除菜单及其子菜单
	@Override
	public Integer updateAuthAndChildren(Map<String, Object> map) {
		Integer pRow = authDao.updateAuthStateByParentId(map);
		Integer aRow = authDao.updateAuthStateByAuthId(map);
		return pRow + aRow;
	}

}

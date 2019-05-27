package com.orange.web.service;

import java.util.List;

import com.orange.web.dao.DBHelper;
import com.orange.web.vo.Address;
import com.orange.web.vo.Collection;
import com.orange.web.vo.Nut;
import com.orange.web.vo.Orde;
import com.orange.web.vo.Shopcart;
import com.orange.web.vo.User;

public class UserService {
	
	DBHelper helper = new DBHelper();
	
	// 用户注册
	public int insertUser(User user) {
		
		return helper.insertUser(user);
	}
	
	// 判断用户名密码正确性
	public boolean isRightUser(String uname,String password) {
		User user = helper.findUserByUname(uname);
		if(null == user || !user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}
	
	// 判断是不是identity
	public boolean isIdentity(String uname) {
		User user = helper.findUserByUname(uname);
		if(null != user && user.getIdentity() == 1) {
			return true;
		}
		return false;
	}
	
	// 全查nut表
	public List<Nut> findAllNut(){
		
		return helper.findAllNut();
	}
	
	// 根据id查nut
	public Nut findNutById(int id) {
		
		return helper.findNutById(id);
	}
	
	// 根据name模糊查询nut表
	public List<Nut> findNutByName(String name){
		
		return helper.findNutByName(name);
	}
	// 添加Nut表
	public int insertNut(Nut nut) {
		
		return helper.insertNut(nut);
	}
	// 修改Nut表
	public int updateNut(Nut nut) {
		
		return helper.updateNut(nut);
	}
	// 根据id删除Nut表
	public int deleteNut(int id) {
		
		return helper.deleteNut(id);
	}
	// 根据用户名查User
	public User findUserByUname(String uname) {
			
		return helper.findUserByUname(uname);
	}
	
	// 添加shopcart表
	public int insertShopcart(int uid,int id,int num,int state,String date) {
		
		return helper.insertShopcart(uid, id, num, state, date);
	}
	
	// 根据详情页面的操作更新shopcart表中的num
	public int uptateShopcart(int uid,int id,int num) {
			
		return helper.uptateShopcart(uid, id, num);
	}
	
	// 根据购物车页面的操作更新shopcart表中的num
	public int updateShopcartBySC(int uid,int id,int num) {
		
		return helper.updateShopcartBySC(uid, id, num);
	}
	
	// 根据提交订单操作更新shopcart表中的state
	public int updateShopcartBySO(int uid,int id,int state) {
		
		return helper.updateShopcartBySO(uid, id, state);
	}
	
	// 根据提交订单操作更新shopcart表中的date
	public int updateShopcartBySOD(int uid,int id,String date) {
		
		return helper.updateShopcartBySOD(uid, id, date);
	}
	
	// 查询shopcart表判断有没有添加过购物车
	public boolean isAdd(int uid,int id) {
		
		return helper.isAdd(uid, id);
	}
	
	// 查询shopcart类
	public List<Shopcart> findShopcarByUid(int uid){
		
		return helper.findShopcarByUid(uid);
	}
	
	// 根据uid和id查询shopcart类
	public Shopcart findShoparById(int uid,int id){
		
		return helper.findShoparById(uid, id);
	}
	
	// 删除shopcart表中的id
	public int deleteShopcartById(int uid,int id) {
		
		return helper.deleteShopcartById(uid, id);
	}
	
	
		
	// 添加address表
	public int insertAddress(Address address) {
		
		return helper.insertAddress(address);
	}
	
	// 根据uid查Address表
	public List<Address> findAddressByUid(int uid) {
		
		return helper.findAddressByUid(uid);
	}
	
	//根据uid和phone查Address表
	public Address findAddressByUP(int uid,String phone){
		
		return helper.findAddressByUP(uid, phone);
	}
	
	// 根据uid和uname删Address表
	public int deleteAddressByU(int uid,String addd) {
		
		return helper.deleteAddressByU(uid, addd);
	}
	
	// 根据uid查询Orde类
	public List<Orde> findOrdeByUid(int uid){
			
		return helper.findOrdeByUid(uid);
	}
	
	// 添加Collection表
	public int insertCollection(int uid,int id) {
		
		return helper.insertCollection(uid, id);
	}
	
	// 根据uid查询Collection表
	public List<Collection> findCollection(int uid){
			
		return helper.findCollection(uid);
	}
	
	// 根据uid和id删除Collection表
	public int deleteCollectionById(int uid,int id) {
		
		return helper.deleteCollectionById(uid, id);
	}
		
}

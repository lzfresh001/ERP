package com.orange.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orange.web.vo.Address;
import com.orange.web.vo.Collection;
import com.orange.web.vo.Nut;
import com.orange.web.vo.Orde;
import com.orange.web.vo.Shopcart;
import com.orange.web.vo.User;

public class DBUtils {
	
	// 获取数据库连接
	public static Connection grtConn() {
		Connection conn = null;
		try {
			Class.forName(DBInfo.MYSQL_DRIVER);
			conn = DriverManager.getConnection(DBInfo.MYSQL_URL, DBInfo.MYSQL_USERNAME, DBInfo.MYSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 查询user表
	public static List<User> findUser(String sql){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<User> Users = new ArrayList<User>();
		try {
			conn = DBUtils.grtConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setIdentity(rs.getInt("identity"));
				
				Users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return Users;
	}
	
	// 查询nut表
	public static List<Nut> findNut(String sql){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Nut> Nuts = new ArrayList<Nut>();
		try {
			conn = DBUtils.grtConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Nut nut = new Nut();
				
				nut.setId(rs.getInt("id"));
				nut.setName(rs.getString("name"));
				nut.setCount(rs.getInt("count"));
				nut.setSrcs(rs.getString("srcs"));
				nut.setSrc(rs.getString("src"));
				nut.setSrcc(rs.getString("srcc"));
				nut.setSrccc(rs.getString("srccc"));
				nut.setSrca(rs.getString("srca"));
				nut.setSrcb(rs.getString("srcb"));
				nut.setSrcd(rs.getString("srcd"));
				nut.setWeight(rs.getString("weight"));
				nut.setPlno(rs.getString("plno"));
				nut.setExdate(rs.getString("exdate"));
				nut.setDate(rs.getString("date"));
				nut.setPrice(rs.getDouble("price"));
				nut.setBrand(rs.getString("brand"));
				nut.setPlace(rs.getString("place"));
				
				Nuts.add(nut);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return Nuts;
	}
	
	// 查询shopcart表
	public static boolean  findShopcart(String sql){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = DBUtils.grtConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return flag;
	}
	
	// 查询shopcart类
		public static List<Shopcart> findShopcar(String sql){
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement ps = null;
			List<Shopcart> Shopcarts = new ArrayList<Shopcart>();
			try {
				conn = DBUtils.grtConn();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					Shopcart shopcart = new Shopcart();
					
					shopcart.setId(rs.getInt("id"));
					shopcart.setName(rs.getString("name"));
					shopcart.setSrc(rs.getString("src"));
					shopcart.setSrcs(rs.getString("srcs"));
					shopcart.setPlace(rs.getString("place"));
					shopcart.setPrice(rs.getDouble("price"));
					shopcart.setNum(rs.getInt("num"));
					shopcart.setState(rs.getInt("state"));
					
					Shopcarts.add(shopcart);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, rs);
			}
			return Shopcarts;
		}
	
		// 查询address表
		public static List<Address> findAddress(String sql){
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement ps = null;
			List<Address> Addresss = new ArrayList<Address>();
			try {
				conn = DBUtils.grtConn();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					Address address = new Address();
					
					address.setUid(rs.getInt("uid"));
					address.setUname(rs.getString("uname"));
					address.setPhone(rs.getString("phone"));
					address.setAddp(rs.getString("addp"));
					address.setAddc(rs.getString("addc"));
					address.setAdd(rs.getString("add"));
					address.setAddd(rs.getString("addd"));
					
					Addresss.add(address);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, rs);
			}
			return Addresss;
		}
		
		// 查询Orde类
		public static List<Orde> findOrde(String sql){
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement ps = null;
			List<Orde> Ordes = new ArrayList<Orde>();
			try {
				conn = DBUtils.grtConn();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					Orde orde = new Orde();
					
					orde.setId(rs.getInt("id"));
					orde.setName(rs.getString("name"));
					orde.setSrcs(rs.getString("srcs"));
					orde.setPrice(rs.getDouble("price"));
					orde.setNum(rs.getInt("num"));
					orde.setPlace(rs.getString("place"));
					orde.setState(rs.getString("state"));
					orde.setDate(rs.getString("date"));
					
					Ordes.add(orde);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, rs);
			}
			return Ordes;
		}
		
		// 查询Collection类
		public static List<Collection> findCollection(String sql){
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement ps = null;
			List<Collection> Collections = new ArrayList<Collection>();
			try {
				conn = DBUtils.grtConn();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					Collection collection = new Collection();
					
					collection.setUid(rs.getInt("uid"));
					collection.setId(rs.getInt("id"));
					collection.setSrc(rs.getString("src"));
					collection.setName(rs.getString("name"));
					collection.setWeight(rs.getString("weight"));
					collection.setPrice(rs.getDouble("price"));
					
					Collections.add(collection);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, rs);
			}
			return Collections;
		}
	
	// 增删改
		public static int updateTable(String sql) {
			int updateRows = 0;
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = DBUtils.grtConn();
				ps = conn.prepareStatement(sql);
				updateRows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn, ps, null);
			}
			return updateRows;
		}
	
	// 关流
		public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
			try {
				if(null != rs) {
					rs.close();
				}
				if(null != ps) {
					ps.close();
				}
				if(null != conn && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}

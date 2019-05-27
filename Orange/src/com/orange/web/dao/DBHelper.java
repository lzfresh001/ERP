package com.orange.web.dao;

import java.util.List;

import com.orange.web.vo.Address;
import com.orange.web.vo.Collection;
import com.orange.web.vo.Nut;
import com.orange.web.vo.Orde;
import com.orange.web.vo.Shopcart;
import com.orange.web.vo.User;

public class DBHelper {
	
	// 添加新的User
	public int insertUser(User user) {
		String sql = "insert into user(uname,password) values('"+user.getUname()+"','"+user.getPassword()+"')";
		return DBUtils.updateTable(sql);
	}
	
	// 根据用户名查User
	public User findUserByUname(String uname) {
		String sql = "select * from user where uname='" + uname + "'";
		List<User> users = DBUtils.findUser(sql);
		return users.size()==0?null:users.get(0);
	}
	
	// 全查nut表
	public List<Nut> findAllNut(){
		String sql = "select * from nut";
		return DBUtils.findNut(sql);
	}
	
	// 根据id查nut
	public Nut findNutById(int id) {
		String sql = "select * from nut where id=" + id;
		List<Nut> nuts = DBUtils.findNut(sql);
		return nuts.size()==0?null:nuts.get(0);
	}
	
	// 根据name模糊查询nut表
	public List<Nut> findNutByName(String name){
		String sql = "select * from nut where name like '%" + name + "%'";
		//System.out.println(sql);
		List<Nut> nuts = DBUtils.findNut(sql);
		return nuts.size()==0?null:nuts;
	}
	// 添加Nut表
	public int insertNut(Nut nut) {
		String sql = "insert into nut values("+nut.getId()+",'"+nut.getName()+"',"+nut.getCount()+",'"+nut.getSrcs()+"','"+nut.getSrc()+"','"+nut.getSrcc()+"','"+nut.getSrccc()+"','"+nut.getSrca()+"','"+nut.getSrcb()+"','"+nut.getSrcd()+"','"+nut.getWeight()+"','"+nut.getPlno()+"','"+nut.getExdate()+"','"+nut.getDate()+"',"+nut.getPrice()+",'"+nut.getBrand()+"','"+nut.getPlace()+"')";
		return DBUtils.updateTable(sql);
	}
	// 修改Nut表
	public int updateNut(Nut nut) {
		String sql = "update nut set name='"+nut.getName()+"',count="+nut.getCount()+",srcs='"+nut.getSrcs()+"',src='"+nut.getSrc()+"',srcc='"+nut.getSrcc()+"',srccc='"+nut.getSrccc()+"',srca='"+nut.getSrca()+"',srcb='"+nut.getSrcb()+"',srcd='"+nut.getSrcd()+"',weight='"+nut.getWeight()+"',plno='"+nut.getPlno()+"',exdate='"+nut.getExdate()+"',date='"+nut.getDate()+"',price="+nut.getPrice()+",brand='"+nut.getBrand()+"',place='"+nut.getPlace()+"' where id="+nut.getId();
		return DBUtils.updateTable(sql);
	}
	// 根据id删除Nut表
	public int deleteNut(int id) {
		String sql = "delete from nut where id=" + id;;
		return DBUtils.updateTable(sql);
	}
	
	// 添加shopcart表
	public int insertShopcart(int uid,int id,int num,int state,String date) {
		String sql = "insert into shopcart values("+uid+","+id+","+num+","+state+",'"+date+"')";
		return DBUtils.updateTable(sql);
	}
	
	// 根据详情页面的操作更新shopcart表中的num
	public int uptateShopcart(int uid,int id,int num) {
		String sql = "update shopcart set num=num+" + num + " where uid=" + uid + " and id=" + id;
		//System.out.println(sql);
		return DBUtils.updateTable(sql);
	}
	// 根据购物车页面的操作更新shopcart表中的num
	public int updateShopcartBySC(int uid,int id,int num) {
		String sql = "update shopcart set num=" + num + " where uid=" + uid + " and id=" + id;
		return DBUtils.updateTable(sql);
	}
	// 根据提交订单操作更新shopcart表中的state
	public int updateShopcartBySO(int uid,int id,int state) {
		String sql = "update shopcart set state=" + state + " where uid=" + uid + " and id=" + id;
		return DBUtils.updateTable(sql);
	}
	// 根据提交订单操作更新shopcart表中的date
	public int updateShopcartBySOD(int uid,int id,String date) {
		String sql = "update shopcart set date='"  +date + "' where uid=" + uid + " and id=" + id;
		return DBUtils.updateTable(sql);
	}
	// 查询shopcart表
	public boolean isAdd(int uid,int id) {
		String sql = "select * from shopcart where uid=" + uid + " and id=" + id;
		return DBUtils.findShopcart(sql);
	}
	
	// 查询shopcart类
	public List<Shopcart> findShopcarByUid(int uid){
		String sql = "select n.id,n.name,n.srcs,n.src,n.place,n.price,s.num,s.state from nut n,shopcart s where n.id=s.id and s.uid=" + uid;
		List<Shopcart> shopcarts = DBUtils.findShopcar(sql);
		return shopcarts.size()==0?null:shopcarts;
	}
	
	// 根据uid和id查询shopcart类
	public Shopcart findShoparById(int uid,int id){
		String sql = "select n.id,n.name,n.srcs,n.src,n.place,n.price,s.num,s.state from nut n,shopcart s where n.id=s.id and s.uid=" + uid + " and s.id=" + id;
		List<Shopcart> shopcarts = DBUtils.findShopcar(sql);
		return shopcarts.size()==0?null:shopcarts.get(0);
	}
	
	// 根据uid查询Orde类
	public List<Orde> findOrdeByUid(int uid){
		String sql = "select n.id,n.name,n.srcs,n.price,n.place,s.num,s.state,s.date from nut n,shopcart s where n.id=s.id and s.uid=" + uid;
		List<Orde> ordes = DBUtils.findOrde(sql);
		return ordes.size()==0?null:ordes;
	}
	
	// 删除shopcart表中的id
	public int deleteShopcartById(int uid,int id) {
		String sql = "delete from shopcart where uid=" + uid + " and id=" + id;
		return DBUtils.updateTable(sql);
	}
	
	// 添加address表
	public int insertAddress(Address address) {
		String sql = "insert into address values("+address.getUid()+",'"+address.getUname()+"','"+address.getPhone()+"','"+address.getAddp()+"','"+address.getAddc()+"','"+address.getAdd()+"','"+address.getAddd()+"')";
		return DBUtils.updateTable(sql);
	}
	
	// 根据uid查Address表
	public List<Address> findAddressByUid(int uid) {
		String sql = "select * from address where uid=" + uid;
		List<Address> addresss = DBUtils.findAddress(sql);
		return addresss.size()==0?null:addresss;
	}
	
	// 根据uid和addd删Address表
	public int deleteAddressByU(int uid,String addd) {
		String sql = "delete from address where uid=" + uid + " and addd='" + addd + "'";
		return DBUtils.updateTable(sql);
	}
	
	//根据uid和phone查Address表
	public Address findAddressByUP(int uid,String phone){
		String sql = "select * from address where uid=" + uid + " and phone='" + phone + "'";
		List<Address> addresss = DBUtils.findAddress(sql);
		return addresss.size()==0?null:addresss.get(0);
	}
	
	// 添加Collection表
	public int insertCollection(int uid,int id) {
		String sql = "insert into collection values(" + uid + "," + id + ")";
		return DBUtils.updateTable(sql);
	}
	
	// 根据uid查询Collection表
	public List<Collection> findCollection(int uid){
		String sql = "select c.uid,n.id,n.src,n.name,n.weight,n.price from collection c,nut n where c.id=n.id and uid=" + uid;
		List<Collection> collections = DBUtils.findCollection(sql);
		return collections.size()==0?null:collections;
	}
	
	// 根据uid和id删除Collection表
	public int deleteCollectionById(int uid,int id) {
		String sql = "delete from collection where uid=" + uid + " and id=" + id;
		return DBUtils.updateTable(sql);
	}
	/*public static void main(String[] args) {
		DBHelper db=new DBHelper();
		List<Nut> nuts=db.findNutByName("松子");
		for(Nut nut:nuts) {
			System.out.println(nut);
		}
	}
*/
}

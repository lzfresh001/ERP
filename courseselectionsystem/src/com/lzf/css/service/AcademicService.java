package com.lzf.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.css.dao.AcademicMapper;
import com.lzf.css.vo.Academic;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Student;
import com.lzf.css.vo.Teacher;


@Service  // 生成一个类名首字母小写的bean
public class AcademicService {
	
	@Autowired  // 将和academic名字一样的bean注入给变量
	private AcademicMapper academicMapper;
	@Autowired
	private Student stu;
	@Autowired
	private Teacher teac;
	@Autowired
	private Course cour;
	@Autowired
	private Elect elect;
	
	// 判断教务处账号密码的正确性
	public boolean isRigehtAcad(String id,String key) {
		Academic acad = academicMapper.findAcadByAid(id);
		if(null == acad || !acad.getAkey().equals(key)) {
			return false;
		}
		return true;
	}
	
	// 根据aid查Academic
	public Academic findAcadByAid(String id) {
		return academicMapper.findAcadByAid(id);
	}
	
	// 修改academic密码
	public int updateAcadAkey(Academic acad) {
		return academicMapper.updateAcadAkey(acad);
	}
	
	// 全查学生
	public List<Student> findAllStu(){
		return academicMapper.findAllStu();
	}
	
	// 全查教师
	public List<Teacher> findAllTeac(){
		return academicMapper.findAllTeac();
	}
	
	// 全查课程及对应的老师
	public List<Course> findAllCourseAndTeacher(){
		return academicMapper.findAllCourseAndTeacher();
	}
	
	// 判断是否有该学号
	public boolean hasStu(String sid) {
		Student stu = academicMapper.findStuBySid(sid);
		if(null == stu) {
			return false;
		}
		return true;
	}
	
	// 判断是否有该工号
	public boolean hasTeac(String tid) {
		Teacher teac = academicMapper.findTeacByTid(tid);
		if(null == teac) {
			return false;
		}
		return true;
	}
	
	// 判断是否有该课程编号
	public boolean hasCour(int cid) {
		Course cour = academicMapper.findCourByCid(cid);
		if(null == cour) {
			return false;
		}
		return true;
	}
		
	// 添加学生
	public int insertStu(String sid,String skey,String sname,String ssex,int sage,double scredit,String saddress,String sphone,String semail,String sbrithday) {
		stu.setSid(sid);
		stu.setSkey(skey);
		stu.setSname(sname);
		stu.setSsex(ssex);
		stu.setSage(sage);
		stu.setScredit(scredit);
		stu.setSaddress(saddress);
		stu.setSphone(sphone);
		stu.setSemail(semail);
		stu.setSbrithday(sbrithday);
		return academicMapper.insertStu(stu);
	}
	
	// 添加学生后给添加必修课
	public int insertCourseM(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return academicMapper.insertCourseM(elect);
	}
	
	// 查询所有必修的cid
	public List<Integer>  findCidByCtypeM(){
		return academicMapper.findCidByCtypeM();
	}
	
	// 删除学生
	public int deleteStu(String sid) {
		return academicMapper.deleteStu(sid);
	}
	
	// 删除学生后删除相应的课
	public int deleteCourseM(String sid) {
		return academicMapper.deleteCourse(sid);
	}
	//根据sid查stu
	public Student findStuBySid(String sid) {
		return academicMapper.findStuBySid(sid);
	}
	
	// 修改学生信息
	public int updeteStudent(String sid,String sname,String ssex,int sage,double scredit,String saddress,String sphone,String semail) {
		stu.setSid(sid);
		stu.setSname(sname);
		stu.setSsex(ssex);
		stu.setSage(sage);
		stu.setScredit(scredit);
		stu.setSaddress(saddress);
		stu.setSphone(sphone);
		stu.setSemail(semail);
		return academicMapper.updeteStudent(stu);
	}
	
	// 添加老师
	public int insertTeac(String tid,String tkey,String tname,String tsex,int tage,String tphone,String temail) {
		teac.setTid(tid);
		teac.setTkey(tkey);
		teac.setTname(tname);
		teac.setTsex(tsex);
		teac.setTage(tage);
		teac.setTphone(tphone);
		teac.setTemail(temail);
		return academicMapper.insertTeac(teac);
	}
	
	// 删除老师
	public int deleteTeac(String tid) {
		return academicMapper.deleteTeac(tid);
	}
	
	// 根据tid查teac
	public Teacher findTeacByTid(String tid) {
		return academicMapper.findTeacByTid(tid);
	}
	
	// 修改老师信息
	public int updateTeacher(String tid,String tname,String tsex,int tage,String tphone,String temail) {
		teac.setTid(tid);
		teac.setTname(tname);
		teac.setTsex(tsex);
		teac.setTage(tage);
		teac.setTphone(tphone);
		teac.setTemail(temail);
		return academicMapper.updateTeac(teac);
	}
	
	// 修改其所代课的老师
	public int updateTid(String tid) {
		return academicMapper.updateTid(tid);
	}
	
	// 添加课程
	public int insertCour(int cid,String tid,String cname,String ctype,double ccredit,int cmax,String cnote,int cprecid,String ctime,String croom) {
		cour.setCid(cid);
		cour.setTid(tid);
		cour.setCname(cname);
		cour.setCtype(ctype);
		cour.setCcredit(ccredit);
		cour.setCmax(cmax);
		cour.setCnote(cnote);
		cour.setCprecid(cprecid);
		cour.setCtime(ctime);
		cour.setCroom(croom);
		return academicMapper.insertCour(cour);
	}
	
	// 删除课程
	public int deleteCour(int cid) {
		return academicMapper.deleteCour(cid);
	}
	
	// 根据cid查cour
	public Course findCourByCid(int cid) {
		return academicMapper.findCourByCid(cid);
	}
	
	// 修改课程信息
	public int updateCour(int cid,String tid,String cname,String ctype,double ccredit,int cmax,String cnote,int cprecid,String ctime,String croom) {
		cour.setCid(cid);
		cour.setTid(tid);
		cour.setCname(cname);
		cour.setCtype(ctype);
		cour.setCcredit(ccredit);
		cour.setCmax(cmax);
		cour.setCnote(cnote);
		cour.setCprecid(cprecid);
		cour.setCtime(ctime);
		cour.setCroom(croom);
		return academicMapper.updateCour(cour);
	}
	
	// 分页查询student表的总条数
	public List<Student> findAllCountStu(int num){
		return academicMapper.findAllCountStu(num);
	}
	
	// 查询student表的总条数
	public int findStuAllCount() {
		return academicMapper.findStuAllCount();
	}
	
	// 查询teacher表的总条数
	public int findTeacAllCount() {
		return academicMapper.findTeacAllCount();
	}
	
	// 查询course表的总条数
	public int findCourAllCount() {
		return academicMapper.findCourAllCount();
	}
	
	// 当添加的课程为必修课时，把该课给所有学生添加到elect表 
	// 查询所有学生的sid 
	public List<String> findAllSid(){
		return academicMapper.findAllSid();
	}
	// 添加elect表
	public int insertElectM(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return academicMapper.insertElectM(elect);
	}
	
	// 根据cid删除elect表
	public int delectElectByCid(int cid) {
		return academicMapper.delectElectByCid(cid);
	}
}

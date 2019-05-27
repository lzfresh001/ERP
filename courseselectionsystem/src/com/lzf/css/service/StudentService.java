package com.lzf.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.css.dao.StudentMapper;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.QueryVo;
import com.lzf.css.vo.Student;

@Service  // 生成一个类名首字母小写的bean
public class StudentService {
	@Autowired  // 将和studentMapper名字一样的bean注入给变量
	private StudentMapper studentMapper;
	@Autowired  // 将和queryVo名字一样的bean注入给变量
	private QueryVo queryVo;
	@Autowired
	private Student stu;
	@Autowired
	private Course cour;
	@Autowired
	private Elect elect;
	
	// 判断学生的账号和密码的正确性
	public boolean isRightStu(String id,String key) {
		Student stu = studentMapper.findStuBySid(id);
		if(null == stu || !stu.getSkey().equals(key)) {
			return false;
		}
		return true;
	}
	
	// 根据sid查student表
	public Student findStuBySid(String id) {
		return studentMapper.findStuBySid(id);
	}
	
	// 判断修改密码时填的原密码是否正确
	public boolean isRightSkey(String sid,String skey) {
		Student stu = studentMapper.findStuBySid(sid);
		if(null == stu || !stu.getSkey().equals(skey)) {
			return false;
		}
		return true;
	}
	
	// 学生修改密码
	public int updateStuSkey(Student stu) {
		return studentMapper.updateStuSkey(stu);
	}
	
	// 查询选修课
	public List<Course> findXxk(){
		return studentMapper.findXxk();
	}
	
	// 查询已选课程
	public List<Course> findXXK(){
		return studentMapper.findXXK();
	}
	
	// 学生选课 添加elect表
	public int insertElect(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return studentMapper.insertElect(elect);
	}
	
	// 学生取消选课 删除elect表
	public int deleteElect(String sid,int cid) {
		stu.setSid(sid);
		cour.setCid(cid);
		queryVo.setStu(stu);
		queryVo.setCour(cour);
		return studentMapper.deleteElect(queryVo);
	}
	
	// 判断学生有没有选过这门课
	public boolean hasQueryCourse(String sid,int cid) {
		stu.setSid(sid);
		cour.setCid(cid);
		queryVo.setStu(stu);
		queryVo.setCour(cour);
		Elect elect = studentMapper.findElectBySidCid(queryVo);
		if(null == elect) {
			return false;
		}
		return true;
	}
	
	// 查询必修课
	public List<Course> findMuElect(){
		return studentMapper.findMuElect();
	}
	
	// 查询没有选择的选修课
	public List<Course> fingNoElect(String sid){
		return studentMapper.fingNoElect(sid);
	}

	// 查询已选择的选修课
	public List<Course> findYeElect(String sid){
		return studentMapper.findYeElect(sid);
	}
	
	// 学生选课 增加course表中的cprecid
	public int AddCourCpre(int cid) {
		return studentMapper.AddCourCpre(cid);
	}
	
	// 学生取消选课 减少course表中的cprecid 
	public int LostCourCpre(int cid) {
		return studentMapper.LostCourCpre(cid);
	}
	
	// 查询学生的考试成绩及单科学分
	public List<Elect> findScoreCreditBySid(String sid){
		return studentMapper.findScoreCreditBySid(sid);
	}
	
	// 查询学生所有学分
	public List<Elect> findCreditBySid(String sid){
		return studentMapper.findCreditBySid(sid);
	}
	
	// 修改学生的学分
	public int updateScreditBySid(String sid,double scredit) {
		stu.setSid(sid);
		stu.setScredit(scredit);
		return studentMapper.updateScreditBySid(stu);
	}
	
	// 根据sid和cid查score
	public double findScoreBySidCid(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return studentMapper.findScoreBySidCid(elect);
	}
	
	// 学生取消选课 减掉student表中相应的scredit
	public int updateStuScredit(String sid) {
		return studentMapper.updateStuScredit(sid);
	}
	
	// 查询course中的cmax
	public int findCmaxByCid(int cid) {
		return studentMapper.findCmaxByCid(cid);
	}
	
	// 查询course中的cprecid
	public int findCprecidByCid(int cid) {
		return studentMapper.findCprecidByCid(cid);
	}
	
	// 查询student表中的sbrithday
	public String findStuSbrithdayBySid(String sid) {
		return studentMapper.findStuSbrithdayBySid(sid);
	}
	
	// 根据当前时间更新student的sage
	public int updateSageByND(String sid,int sage) {
		stu.setSid(sid);
		stu.setSage(sage);
		return studentMapper.updateSageByND(stu);
	}
}

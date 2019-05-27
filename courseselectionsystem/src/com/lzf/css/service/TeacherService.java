package com.lzf.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.css.dao.TeacherMapper;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Teacher;

@Service // 生成一个类名首字母小写的bean
public class TeacherService {
	
	@Autowired // 将和teacherMapper名字一样的bean注入给变量
	private TeacherMapper teacherMapper;
	@Autowired
	private Elect elect;
	
	// 判断老师账号密码的正确性
	public boolean isRightTeac(String id,String key) {
		Teacher teac = teacherMapper.findTeacByTid(id);
		if(null == teac || !teac.getTkey().equals(key)) {
			return false;
		}
		return true;
	}
	// 根据tid查teacher
	public Teacher findTeacByTid(String id) {
		return teacherMapper.findTeacByTid(id);
	}
	
	// 老师修改密码
	public int updateTeacTkey(Teacher teac) {
		return teacherMapper.updateTeacTkey(teac);
	}
	
	// 查询老师所代的课程
	public List<Course> findCourByTid(String tid){
		return teacherMapper.findCourByTid(tid);
	}
	
	// 查看哪些学生选了哪些课并给分
	public List<Elect> findECSByTid(String tid){
		return teacherMapper.findECSByTid(tid);
	}
	
	// 修改学生成绩
	public int updateScoreBySidCid(String sid,int cid,double score) {
		elect.setSid(sid);
		elect.setCid(cid);
		elect.setScore(score);
		return teacherMapper.updateScoreBySidCid(elect);
	}

	// 修改学生学分 
	public int updateCreditBySidCid(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return teacherMapper.updateCreditBySidCid(elect);
	}
	// 修改学生学分
	public int updateCreditBySC(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return teacherMapper.updateCreditBySC(elect);
	}
	// 修改学生学分
	public int updateCreditBySidCidM(String sid,int cid) {
		elect.setSid(sid);
		elect.setCid(cid);
		return teacherMapper.updateCreditBySidCidM(elect);
	}
	
	// 查询老师所代课有多少学生在上
	public int findElectCountByTid(String tid) {
		return teacherMapper.findElectCountByTid(tid);
	}
	
	// 查看哪些学生选了哪些课并给分由高到低排序
	public List<Elect> findECSByTidAndTopToBot(String tid){
		return teacherMapper.findECSByTidAndTopToBot(tid);
	}
	
	// 查看哪些学生选了哪些课并给分由低到高排序
	public List<Elect> findECSByTidAndBotToTop(String tid){
		return teacherMapper.findECSByTidAndBotToTop(tid);
	}
}


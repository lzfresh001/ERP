package com.lzf.css.dao;

import java.util.List;

import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Teacher;

public interface TeacherMapper {
	
	public Teacher findTeacByTid(String id);
	
	public int updateTeacTkey(Teacher teac);
	
	public List<Course> findCourByTid(String tid);
	
	public List<Elect> findECSByTid(String tid);
	
	public int updateScoreBySidCid(Elect elect);
	
	public int updateCreditBySidCid(Elect elect);
	
	public int updateCreditBySC(Elect elect);
	
	public int updateCreditBySidCidM(Elect elect);
	
	public int findElectCountByTid(String tid);
	
	public List<Elect> findECSByTidAndTopToBot(String tid);
	
	public List<Elect> findECSByTidAndBotToTop(String tid);

}

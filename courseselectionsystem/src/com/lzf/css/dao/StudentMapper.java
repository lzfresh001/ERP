package com.lzf.css.dao;

import java.util.List;

import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.QueryVo;
import com.lzf.css.vo.Student;

public interface StudentMapper {
	
	public Student findStuBySid(String id);
	
	public int updateStuSkey(Student stu);
	
	public List<Course> findXxk();
	
	public List<Course> findXXK();
	
	public List<Course> findMuElect();
	
	public List<Course> fingNoElect(String sid);
	
	public List<Course> findYeElect(String sid);
	
	public int insertElect(Elect elect);
	
	public int deleteElect(QueryVo qv);
	
	public Elect findElectBySidCid(QueryVo qv);
	
	public int AddCourCpre(int cid);
	
	public int LostCourCpre(int cid);
	
	public List<Elect> findScoreCreditBySid(String sid);
	
	public List<Elect> findCreditBySid(String sid);
	
	public int updateScreditBySid(Student stu);
	
	public double findScoreBySidCid(Elect elect);
	
	public int updateStuScredit(String sid);
	
	public int findCmaxByCid(int cid);
	
	public int findCprecidByCid(int cid);
	
	public String findStuSbrithdayBySid(String sid);
	
	public int updateSageByND(Student stu);
}

package com.lzf.css.dao;

import java.util.List;

import com.lzf.css.vo.Academic;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Student;
import com.lzf.css.vo.Teacher;

public interface AcademicMapper {
	
	public Academic findAcadByAid(String id);
	
	public int updateAcadAkey(Academic acad);
	
	public List<Student> findAllStu();
	
	public List<Teacher> findAllTeac();
	
	public List<Course> findAllCourseAndTeacher();
	
	public Student findStuBySid(String sid);
	
	public Teacher findTeacByTid(String tid);
	
	public Course findCourByCid(int cid);
	
	public int insertStu(Student stu);
	
	public int insertCourseM(Elect elect);
	
	public List<Integer>  findCidByCtypeM();
	
	public int deleteStu(String sid);
	
	public int deleteCourse(String sid);
	
	public int updeteStudent(Student stu);
	
	public int insertTeac(Teacher teac);
	
	public int deleteTeac(String tid);
	
	public int updateTeac(Teacher teac);
	
	public int updateTid(String tid);
	
	public int insertCour(Course cour);
	
	public int deleteCour(int cid);
	
	public int updateCour(Course cour);
	
	public List<Student> findAllCountStu(int num);
	
	public int findStuAllCount();
	
	public int findTeacAllCount();
	
	public int findCourAllCount();
	
	public List<String> findAllSid();
	
	public int insertElectM(Elect elect);
	
	public int delectElectByCid(int cid);

}

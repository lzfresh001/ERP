package com.lzf.css.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.css.service.AcademicService;
import com.lzf.css.vo.Academic;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Student;
import com.lzf.css.vo.Teacher;

@Controller  // 生成一个类名首字母的bean
public class AcademicController {

	@Autowired  // 将和academicMapper名字一样的bean注入给变量
	private AcademicService academicService;
	
	@RequestMapping("/isRightAkey.action") // 生成判断管理员密码正确性的路径
	public void isRightAkey(String akey,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Object acadObj = session.getAttribute("ACAD");
		if(null == acadObj) {
			out.println("<script>alert(请正确登录！！！'');location.href='jsp/login.jsp';</script>");
			return;
		}
		Academic acad = (Academic)acadObj;
		String aid = acad.getAid();
		
		boolean isRightAkey = academicService.isRigehtAcad(aid, akey);
		out.print(isRightAkey);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateAcadAkey.action") // 生成修改管理员密码的路径
	public void updateAcadAkey(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Object acadObj = session.getAttribute("ACAD");
		String akey = request.getParameter("renewpass");
		
		if(null == acadObj || null == akey) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Academic acad = (Academic)acadObj;
		acad.setAkey(akey);
		academicService.updateAcadAkey(acad);
		out.println("<script>alert('修改成功！！！');location.href='jsp/login.jsp';</script>");
		
	}
	
	
	@RequestMapping("/isRightSid.action") // 生成请求路径
	public void isRightSid(String sid, HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		PrintWriter out = response.getWriter();
		
		boolean isRightSid = academicService.hasStu(sid);
		out.print(isRightSid);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/isRightTid.action") // 生成请求路径
	public void isRightTid(String tid, HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		PrintWriter out = response.getWriter();
		
		boolean isRightTid = academicService.hasTeac(tid);
		out.print(isRightTid);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/isRightCid.action") // 生成请求路径
	public void isRightCid(int cid, HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		PrintWriter out = response.getWriter();
		
		boolean isRightCid = academicService.hasCour(cid);
		out.print(isRightCid);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/insertStu.action") // 生成添加学生的路径
	public void insertStu(String sid,String skey,String sname,String ssex,int sage,double scredit,String saddress,String sphone,String semail,String sbrithday,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		List<Integer> cids = academicService.findCidByCtypeM();
		academicService.insertStu(sid, skey, sname, ssex, sage, scredit, saddress, sphone, semail,sbrithday);
		for(Integer cid: cids) {
			academicService.insertCourseM(sid,cid);
		}
		List<Student> astus = academicService.findAllStu();
		session.setAttribute("ASTUS", astus);
		out.println("<script>alert('添加成功！！！');location.href='jsp/studentcate.jsp';</script>");
	}
	
	@RequestMapping("/deleteStu.action") // 生成删除学生的路径
	public void deleteStu(String sid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//System.out.println(sid);
		academicService.deleteCourseM(sid);
		academicService.deleteStu(sid);
		List<Student> astus = academicService.findAllStu();
		session.setAttribute("ASTUS", astus);
		out.println("<script>alert('删除成功！！！');location.href='jsp/studentcate.jsp';</script>");
	}
	
	@RequestMapping("/updateStu.action") // 生成修改学生的路径
	public void updateStu(String sid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//System.out.println(sid);
		Student stu = academicService.findStuBySid(sid);
		session.setAttribute("STU", stu);
		out.println("<script>location.href='jsp/updatestudent.jsp';</script>");
	}
	
	@RequestMapping("/updateStudent.action") // 生成修改学生的路径
	public void updateStudent(String sid,String sname,String ssex,int sage,double scredit,String saddress,String sphone,String semail,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.updeteStudent(sid, sname, ssex, sage, scredit, saddress, sphone, semail);
		List<Student> astus = academicService.findAllStu();
		session.setAttribute("ASTUS", astus);
		out.println("<script>alert('修改成功！！！');location.href='jsp/studentcate.jsp';</script>");

	}
	
	@RequestMapping("/insertTeac.action") // 生成添加老师的路径
	public void insertTeac(String tid,String tkey,String tname,String tsex,int tage,String tphone,String temail,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.insertTeac(tid, tkey, tname, tsex, tage, tphone, temail);
		List<Teacher> ateacs = academicService.findAllTeac();
		session.setAttribute("ATEACS", ateacs);
		out.println("<script>alert('添加成功！！！');location.href='jsp/teachercate.jsp';</script>");
	}
	
	@RequestMapping("/deleteTeac.action") // 生成删除老师的路径
	public void deleteTeac(String tid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.updateTid(tid);
		academicService.deleteTeac(tid);
		List<Teacher> ateacs = academicService.findAllTeac();
		session.setAttribute("ATEACS", ateacs);
		List<Course> acours = academicService.findAllCourseAndTeacher();
		session.setAttribute("ACOURS", acours);
		out.println("<script>alert('删除成功！！！');location.href='jsp/teachercate.jsp';</script>");
	}
	
	@RequestMapping("/updateTeac.action") // 生成修改老师的路径
	public void updateTeac(String tid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Teacher teac = academicService.findTeacByTid(tid);
		session.setAttribute("TEAC", teac);
		out.println("<script>location.href='jsp/updateteacher.jsp';</script>");
	}
	
	@RequestMapping("/updateTeacher.action") // 生成修改老师的路径
	public void updateTeacher(String tid,String tname,String tsex,int tage,String tphone,String temail,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.updateTeacher(tid, tname, tsex, tage, tphone, temail);
		List<Teacher> ateacs = academicService.findAllTeac();
		session.setAttribute("ATEACS", ateacs);
		out.println("<script>alert('修改成功！！！');location.href='jsp/teachercate.jsp';</script>");
	}
	
	@RequestMapping("/insertCour.action") // 生成添加课程的路径
	public void insertCour(int cid,String tid,String cname,String ctype,double ccredit,int cmax,String cnote,int cprecid,String ctime,String croom,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.insertCour(cid, tid, cname, ctype, ccredit, cmax, cnote, cprecid, ctime, croom);
		if(ctype.equals("必修")) {
			List<String> sids = academicService.findAllSid();
			for(String sid: sids) {
				academicService.insertElectM(sid, cid);
			}
		}
		List<Course> acours = academicService.findAllCourseAndTeacher();
		session.setAttribute("ACOURS", acours);
		out.println("<script>alert('添加成功！！！');location.href='jsp/coursecate.jsp';</script>");
	}
	
	@RequestMapping("/deleteCour.action") // 生成删除课程的路径
	public void deleteCour(int cid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.delectElectByCid(cid);
		academicService.deleteCour(cid);
		List<Course> acours = academicService.findAllCourseAndTeacher();
		session.setAttribute("ACOURS", acours);
		out.println("<script>alert('删除成功！！！');location.href='jsp/coursecate.jsp';</script>");
	}
	
	@RequestMapping("/updateCour.action") // 生成修改课程的路径
	public void updateCour(int cid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Course cour = academicService.findCourByCid(cid);
		session.setAttribute("COUR", cour);
		out.println("<script>location.href='jsp/updatecourse.jsp';</script>");
	}
	
	@RequestMapping("/updateCourse.action") // 生成修改课程的路径
	public void updateCourse(int cid,String tid,String cname,String ctype,double ccredit,int cmax,String cnote,int cprecid,String ctime,String croom,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		academicService.updateCour(cid, tid, cname, ctype, ccredit, cmax, cnote, cprecid, ctime, croom);
		List<Course> acours = academicService.findAllCourseAndTeacher();
		session.setAttribute("ACOURS", acours);
		out.println("<script>alert('修改成功！！！');location.href='jsp/coursecate.jsp';</script>");
	}
	
	@RequestMapping("/studentFy.action") // 生成学生分页的路径
	public void studentFy(int pageNum,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		List<Student> astus = academicService.findAllStu();
		session.setAttribute("ASTUS", astus);
		
		// 当前页数 pageNum
		session.setAttribute("PAGENUM", pageNum);
		int pageSize = 5; //每页显示的条数
		int count = academicService.findStuAllCount(); // 学生总数
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1; // 总共有多少页
		session.setAttribute("PAGECOUNT", pageCount);
		int begin = (pageNum-1)*pageSize; // 每页的开始
		session.setAttribute("BEGIN", begin);
		int end = pageNum==pageCount?count-1:pageNum*pageSize-1;
		session.setAttribute("END", end);
		
		response.sendRedirect("jsp/studentcate.jsp");
		
	}
	
	@RequestMapping("/teacherFy.action") // 生成老师分页的路径
	public void teacherFy(int pageNum,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		List<Teacher> ateacs = academicService.findAllTeac();
		session.setAttribute("ATEACS", ateacs);
		
		// 当前页数 pageNum
		session.setAttribute("PAGENUM", pageNum);
		int pageSize = 5; //每页显示的条数
		int count = academicService.findTeacAllCount(); // 老师总数
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1; // 总共有多少页
		session.setAttribute("PAGECOUNT", pageCount);
		int begin = (pageNum-1)*pageSize; // 每页的开始
		session.setAttribute("BEGIN", begin);
		int end = pageNum==pageCount?count-1:pageNum*pageSize-1;
		session.setAttribute("END", end);
		
		response.sendRedirect("jsp/teachercate.jsp");
		
	}
	
	@RequestMapping("/courseFy.action") // 生成课程分页的路径
	public void courseFy(int pageNum,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		List<Course> acours = academicService.findAllCourseAndTeacher();
		session.setAttribute("ACOURS", acours);
		
		// 当前页数 pageNum
		session.setAttribute("PAGENUM", pageNum);
		int pageSize = 5; //每页显示的条数
		int count = academicService.findCourAllCount(); // 课程总数
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1; // 总共有多少页
		session.setAttribute("PAGECOUNT", pageCount);
		int begin = (pageNum-1)*pageSize; // 每页的开始
		session.setAttribute("BEGIN", begin);
		int end = pageNum==pageCount?count-1:pageNum*pageSize-1;
		session.setAttribute("END", end);
		
		response.sendRedirect("jsp/coursecate.jsp");
		
	}
}

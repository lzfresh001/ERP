package com.lzf.css.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzf.css.service.AcademicService;
import com.lzf.css.service.StudentService;
import com.lzf.css.service.TeacherService;
import com.lzf.css.vo.Academic;
import com.lzf.css.vo.Course;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Student;
import com.lzf.css.vo.Teacher;

@Controller  // 生成一个类名首字母小写的bean
public class StudentController {
	
	// 将和studentService名字一样的bean注入给变量
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private AcademicService academicService;
	

	@RequestMapping("/isRightUser.action") // 生成请求路径
	public void isRightUser(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException  {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("name");
		String key = request.getParameter("password");
		String identity = request.getParameter("identity");
		
		if(null == id || null == key || null == identity ) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		
		//System.out.println(studentService==null);
		
		Student stu = null;
		if(identity.equals("x")) {
			if(studentService.isRightStu(id, key)) {
				//System.out.println(id);
				String sbrithday = studentService.findStuSbrithdayBySid(id);
				if(null != sbrithday) {
					String sbir = sbrithday.substring(0, 4);
					int sd = Integer.parseInt(sbir);
					Calendar c = Calendar.getInstance();
					int nd = c.get(Calendar.YEAR);
					int ad = nd - sd;
					studentService.updateSageByND(id, ad);
				}
				stu = studentService.findStuBySid(id);
				session.setAttribute("STU", stu);
				List<Course> courses = studentService.fingNoElect(id);
				session.setAttribute("COURS", courses);
				List<Course> coursed = studentService.findYeElect(id);
				session.setAttribute("COURD", coursed);
				List<Course> coursem = studentService.findMuElect();
				session.setAttribute("COURM", coursem);
				List<Elect> elects = studentService.findScoreCreditBySid(id);
				session.setAttribute("ELECTS", elects);
				List<Elect> electCredit = studentService.findCreditBySid(id);
				double sum = 0;
				for(Elect elect: electCredit) {
					sum += elect.getCredit();
				}
				studentService.updateScreditBySid(id, sum);
				stu = studentService.findStuBySid(id);
				session.setAttribute("STU", stu);
				out.println("<script>alert('登录成功！！！');location.href='jsp/studentindex.jsp';</script>");
			}else {
				out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp'</script>");
			}
		}
			
		
		Teacher teac = null;
		if(identity.equals("l")) {
			if(teacherService.isRightTeac(id, key)) {
				teac = teacherService.findTeacByTid(id);
				session.setAttribute("TEAC", teac);
				List<Course> tcourses = teacherService.findCourByTid(id);
				session.setAttribute("TCOUR", tcourses);
				List<Elect> telect = teacherService.findECSByTid(id);
				session.setAttribute("TELECT", telect);
				out.println("<script>alert('登录成功！！！');location.href='jsp/teacherindex.jsp';</script>");
			}else {
				out.println("<script>alert('请正确登录！！！！');location.href='jsp/login.jsp';</script>");
			}
		}
		Academic acad = null;
		if(identity.equals("j")) {
			if(academicService.isRigehtAcad(id, key)) {
				acad = academicService.findAcadByAid(id);
				session.setAttribute("ACAD", acad);
				List<Student> astus = academicService.findAllStu();
				session.setAttribute("ASTUS", astus);
				List<Teacher> ateacs = academicService.findAllTeac();
				session.setAttribute("ATEACS", ateacs);
				List<Course> acours = academicService.findAllCourseAndTeacher();
				session.setAttribute("ACOURS", acours);
				out.println("<script>alert('登录成功！！！');location.href='jsp/academicindex.jsp';</script>");
			}else {
				out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			}
		}
	}
	
	@RequestMapping("/isRightSkey.action") // 生成请求路径
	public void isRightSkey(String skey, HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		Object stuObj = session.getAttribute("STU");
		
		if(null == stuObj) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Student stu = (Student)stuObj;
		String sid = stu.getSid();
		
		boolean isRightSkey = studentService.isRightSkey(sid, skey);
		out.print(isRightSkey);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateStuSkey.action") // 生成请求路径
	public void updateStuSkey(HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Object stuObj = session.getAttribute("STU");
		String skey = request.getParameter("renewpass");
		
		if(null == stuObj || null == skey) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Student stu = (Student)stuObj;
		stu.setSkey(skey);
		
		studentService.updateStuSkey(stu);
		out.println("<script>alert('修改成功！！！');location.href='jsp/login.jsp';</script>");
	}
	
	@RequestMapping("/insertElect.action")
	public void insertElect(String sid,int cid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(null == sid) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		int cmax = studentService.findCmaxByCid(cid);
		int cprecid = studentService.findCprecidByCid(cid);
		if(cprecid < cmax) {
			studentService.insertElect(sid, cid);
			studentService.AddCourCpre(cid);
		}else {
			out.println("<script>alert('该课名额已满！！！');location.href='jsp/studentbook.jsp';</script>");
			return;
		}
		List<Course> courses = studentService.fingNoElect(sid);
		session.setAttribute("COURS", courses);
		List<Course> coursed = studentService.findYeElect(sid);
		session.setAttribute("COURD", coursed);
		List<Elect> elects = studentService.findScoreCreditBySid(sid);
		session.setAttribute("ELECTS", elects);
		out.println("<script>alert('已选择！！！');location.href='jsp/studentbook.jsp';</script>");
	}
	
	@RequestMapping("/deleteElect.action")
	public void deleteElect(String sid,int cid,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(null == sid) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		double score = studentService.findScoreBySidCid(sid, cid);
		
		if(score >= 60) {
			out.println("<script>alert('该课成绩已生效，不能取消！！！');location.href='jsp/studentbooked.jsp';</script>");
			return;
		}else {
			studentService.deleteElect(sid, cid);
			studentService.LostCourCpre(cid);
			
			List<Course> coursed = studentService.findYeElect(sid);
			session.setAttribute("COURD", coursed);
			List<Course> courses = studentService.fingNoElect(sid);
			session.setAttribute("COURS", courses);
			List<Elect> elects = studentService.findScoreCreditBySid(sid);
			session.setAttribute("ELECTS", elects);
			Student stu = studentService.findStuBySid(sid);
			session.setAttribute("STU", stu);
			out.println("<script>alert('已取消！！！');location.href='jsp/studentbooked.jsp';</script>");
		}
	}
	
	@RequestMapping("/queryCode.action")
	public void getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 获取out对象
		PrintWriter out = response.getWriter();
		String serverCode = (String)request.getSession().getAttribute("CODE");
		//System.out.println("服务端验证码:" + serverCode);
		out.print(serverCode);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/removeSession.action")
	public void removeSession(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("STU");
		session.removeAttribute("COURS");
		session.removeAttribute("COURD");
		session.removeAttribute("COURM");
		session.removeAttribute("ELECTS");
		session.removeAttribute("TEAC");
		session.removeAttribute("TCOUR");
		session.removeAttribute("TELECT");
		session.removeAttribute("ACAD");
		session.removeAttribute("ASTUS");
		session.removeAttribute("ATEACS");
		session.removeAttribute("ACOURS");
		
		response.sendRedirect("jsp/login.jsp");
	}
	
	
}

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

import com.lzf.css.service.TeacherService;
import com.lzf.css.vo.Elect;
import com.lzf.css.vo.Teacher;

@Controller // 生成一个类名首字母小写的bean
public class TeacherController {

	@Autowired // 将和teacherService名字一样的bean注入给变量
	private TeacherService teacherService;
	
	@RequestMapping("/isRightTkey.action") // 生成请求路径
	public void isRightTkey(String tkey, HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		Object teacObj = session.getAttribute("TEAC");
		
		if(null == teacObj) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Teacher teac = (Teacher)teacObj;
		String tid = teac.getTid();
		
		boolean isRightTkey = teacherService.isRightTeac(tid, tkey);
		out.print(isRightTkey);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateTeacTkey.action") // 生成修改教师密码的路径
	public void updateTeacTkey(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Object teacObj = session.getAttribute("TEAC");
		String tkey = request.getParameter("renewpass");
		
		if(null == teacObj || null == tkey) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Teacher teac = (Teacher)teacObj;
		teac.setTkey(tkey);
		
		teacherService.updateTeacTkey(teac);
		out.println("<script>alert('修改成功！！！');location.href='jsp/login.jsp';</script>");
	}
	
	@RequestMapping("/updateScoreBySidCid.action") // 生成老师给分的路径
	public void updateScoreBySidCid(String sid,int cid,double score,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//System.out.println(sid + cid + score);
		
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Object teacObj = session.getAttribute("TEAC");
		if(null == teacObj) {
			out.println("<script>alert('请正确登录！！！');location.href='jsp/login.jsp';</script>");
			return;
		}
		Teacher teac = (Teacher)teacObj;
		String tid = teac.getTid();
		
		teacherService.updateScoreBySidCid(sid, cid, score);
		teacherService.updateCreditBySidCid(sid, cid);
		teacherService.updateCreditBySC(sid, cid);
		teacherService.updateCreditBySidCidM(sid, cid);
		List<Elect> telect = teacherService.findECSByTid(tid);
		session.setAttribute("TELECT", telect);
		System.out.println(telect);
		out.println("<script>alert('打分成功！！！');location.href='jsp/teacherbookg.jsp';</script>");
	}
	
	@RequestMapping("/giveScore.action")
	public void giveScore(String order,String tid,int pageNum,HttpServletRequest request,HttpServletResponse response) throws IOException {
	
		HttpSession session = request.getSession();
		session.setAttribute("ORDER", order);
		if(order.equals("no")) {
			List<Elect> telect = teacherService.findECSByTid(tid);
			session.setAttribute("TELECT", telect);
		}
		if(order.equals("tb")) {
			List<Elect> telect = teacherService.findECSByTidAndTopToBot(tid);
			session.setAttribute("TELECT", telect);
		}
		if(order.equals("bt")) {
			List<Elect> telect = teacherService.findECSByTidAndBotToTop(tid);
			session.setAttribute("TELECT", telect);
		}
		
		// 当前页数 pageNum
		session.setAttribute("PAGENUM", pageNum);
		int pageSize = 5; //每页显示的条数
		int count = teacherService.findElectCountByTid(tid); // 课程总数
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1; // 总共有多少页
		session.setAttribute("PAGECOUNT", pageCount);
		int begin = (pageNum-1)*pageSize; // 每页的开始
		session.setAttribute("BEGIN", begin);
		int end = pageNum==pageCount?count-1:pageNum*pageSize-1;
		session.setAttribute("END", end);
		
		response.sendRedirect("jsp/teacherbookg.jsp");
	}
	
	
}

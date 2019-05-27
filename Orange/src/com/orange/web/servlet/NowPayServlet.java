package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orange.web.service.UserService;

/**
 * Servlet implementation class NowPayServlet
 */
public class NowPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NowPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		UserService us = new UserService();
		
		Object uname = session.getAttribute("USERNAME");
		Object uidObj = session.getAttribute("UID");
		if(null == uidObj) {
			response.sendRedirect("orange/orange/login.jsp");
			return;
		}
		int uid = (Integer)uidObj;
		String pid = request.getParameter("PID");
		String idStr = request.getParameter("ID");
		if(null == idStr) {
			response.sendRedirect("orange/orange/home.jsp");
			return;
		}
		int id = Integer.parseInt(idStr);
		String numStr = request.getParameter("NUM");
		if(null == numStr) {
			response.sendRedirect("orange/orange/introduction.jsp");
			return;
		}
		int num = Integer.parseInt(numStr);
		int state = 0;
		String date = null;
		if(null != uname) {
			if(us.isAdd(uid, id)) {
				us.uptateShopcart(uid, id, num);
			}else {
				us.insertShopcart(uid, id, num, state, date);
			}
			response.sendRedirect("orange/orange/pay.jsp?pid=" + pid);
		}else {
			out.println("<script>alert('请先正确登录！！！'); location.href='orange/orange/login.jsp;'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

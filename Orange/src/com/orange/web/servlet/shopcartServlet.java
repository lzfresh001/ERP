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
 * Servlet implementation class shopcartServlet
 */
public class shopcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserService us = new UserService();
		
		String idstr = request.getParameter("id");
		//System.out.println(idstr);
		if(null == idstr) {
			response.sendRedirect("orange/orange/home.jsp");
			return;
		}
		int id = Integer.parseInt(idstr.trim());
		String numstr = request.getParameter("num");
		int num = Integer.parseInt(numstr.trim());
		
		Object uidobj = session.getAttribute("UID");
		//System.out.println(uidobj);
		if(null == uidobj) {
			//System.out.println("********1*******");
			response.sendRedirect("orange/orange/login.jsp");
			return;
		}
		int uid = (Integer)uidobj;
		Object uname = session.getAttribute("USERNAME");
		int state = 0;
		String date = null;
		if(null != uname) {
			if(us.isAdd(uid, id)) {
				us.uptateShopcart(uid, id, num);
			}else {
				us.insertShopcart(uid, id, num, state, date);
			}
			response.sendRedirect("orange/orange/shopcart.jsp");
			//out.println("<script>alert('购物车欢迎您！！！'); location.href='orange/orange/shopcart.jsp;'</script>");
			//System.out.println("********2*********");
		}else {
			//System.out.println("*******3************");
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

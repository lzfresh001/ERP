package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orange.web.service.UserService;
import com.orange.web.vo.User;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		HttpSession session =  request.getSession();
		UserService us = new UserService();
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String rem = request.getParameter("rem");
		
		User user = null;
		
		if(us.isRightUser(uname, password)) {
			session.setAttribute("USERNAME", uname);
			user = us.findUserByUname(uname);
			if(null != user) {
				int uid = user.getUid();
				session.setAttribute("UID", uid);
			}
			Cookie ckName = null;
			Cookie ckPass = null;
			if(null != rem) {
				ckName = new Cookie("UNAME", uname);
				ckPass = new Cookie("PASS", password);
			} else {
				ckName = new Cookie("UNAME", "");
				ckPass = new Cookie("PASS", "");
			}
			ckName.setMaxAge(60*60*24*30);
			ckPass.setMaxAge(60*60*24*30);
			
			response.addCookie(ckName);
			response.addCookie(ckPass);
			
			String page = "";
			Object obj = session.getAttribute("page");
			Object OBJ = session.getAttribute("PAGE");
			//Object Obj = session.getAttribute("PAge");
			
			if(null != obj && null == OBJ) {
				page = String.valueOf(obj);
			}else if(null == obj && null != OBJ) {
				page = String.valueOf(OBJ);
			}else {
				page = "orange/orange/home.jsp";
			}
			out.println("<script>alert('登录成功！！！');location.href='" + page + "';</script>");
		} else {
			out.println("<script>alert('请先cc正确登录！！！');location.href='orange/orange/login.jsp';</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

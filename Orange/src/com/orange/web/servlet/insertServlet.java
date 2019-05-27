package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orange.web.service.UserService;
import com.orange.web.vo.User;

/**
 * Servlet implementation class insertServlet
 */
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
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
		User user = new User();
		UserService us = new UserService();
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("passwordRepeat");
		if(password.length()>6 && password.length()<18 && password.equals(passwordRepeat)) {
			user.setUname(uname);
			user.setPassword(password);
			us.insertUser(user);
			out.println("<script>alert('注册成功！！！');location.href='orange/orange/login.jsp';</script>");
		}else {
			out.println("<script>alert('密码确认失败！！！');location.href='orange/orange/register.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

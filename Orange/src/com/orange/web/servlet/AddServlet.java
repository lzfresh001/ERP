package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orange.web.service.UserService;
import com.orange.web.vo.Address;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		
		Object uidObj = session.getAttribute("UID");
		if(null == uidObj) {
			response.sendRedirect("orange/orange/login.jsp");
			return;
		}
		int uid = (Integer)uidObj;
		String uname = request.getParameter("uname");
		String phone = request.getParameter("phone");
		String addp = request.getParameter("addp");
		String addc = request.getParameter("addc");
		String add = request.getParameter("add");
		String addd = request.getParameter("addd");
		
		String pid = request.getParameter("PID");
		
		Address address = new Address();
		
		address.setUid(uid);
		address.setUname(uname);
		address.setPhone(phone);
		address.setAddp(addp);
		address.setAddc(addc);
		address.setAdd(add);
		address.setAddd(addd);
		
		us.insertAddress(address);
		
		response.sendRedirect("orange/orange/pay.jsp?pid="+pid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

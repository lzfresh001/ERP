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
 * Servlet implementation class UpdateShopcart
 */
public class UpdateShopcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopcart() {
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
		
		Object uidobj = session.getAttribute("UID");
		if(null == uidobj) {
			response.sendRedirect("orange/orange/login.jsp");
			return;
		}
		int uid = (Integer)uidobj;
		String idstr = request.getParameter("id");
		//System.out.println("idstr" + idstr);
		if(null == idstr) {
			response.sendRedirect("orange/orange/home.jsp");
			return;
		}
		int id = Integer.parseInt(idstr.trim());
		String numstr = request.getParameter("num");
		//System.out.println("num" + numstr);
		if(null == numstr) {
			response.sendRedirect("orange/orange/introduction.jsp");
			return;
		}
		int num = Integer.parseInt(numstr.trim());
		us.updateShopcartBySC(uid, id, num);
		
		String US = request.getParameter("US");
		//System.out.println("us" + US.equals(""));
		String PID = request.getParameter("PID");
		if(US.equals("S")) {
			response.sendRedirect("orange/orange/shopcart.jsp");
		}
		if(US.equals("P")) {
			response.sendRedirect("orange/orange/pay.jsp?pid=" + PID);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

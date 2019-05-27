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
 * Servlet implementation class NowCollectionServlet
 */
public class NowCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NowCollectionServlet() {
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
		String idStr = request.getParameter("ID");
		if(null == idStr) {
			response.sendRedirect("orange/orange/home.jsp");
			return;
		}
		int id = Integer.parseInt(idStr);
		
		us.insertCollection(uid, id);
		
		out.println("<script>alert('已加入收藏！！！');location.href='orange/orange/collection.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

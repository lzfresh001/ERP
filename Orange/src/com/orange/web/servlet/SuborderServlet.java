package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orange.web.service.UserService;
import com.orange.web.vo.Shopcart;

/**
 * Servlet implementation class SuborderServlet
 */
public class SuborderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuborderServlet() {
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
		
		Object uidobj = session.getAttribute("UID");
		if(null == uidobj) {
			response.sendRedirect("orange/orange/login.jsp");
			return;
		}
		int uid = (Integer)uidobj;
		int state = 1;
		
		String money = request.getParameter("MONEY");
		//String uname = request.getParameter("UNAME");
		String phone = request.getParameter("PHONE");
		//String addp = request.getParameter("ADDP");
		//System.out.println("addp:" + addp);
		//String addp = URLDecoder.decode("addp", "UTF-8");
		//String addc = request.getParameter("ADDC");
		//String add = request.getParameter("ADD");
		//String addd = request.getParameter("ADDD");
		
		String pid = request.getParameter("PID");
		if(null == pid){
			response.sendRedirect("shopcart.jsp");
			return;
		}
		String[] pids = pid.split(",");
		
		if(pids.length == 0){
			response.sendRedirect("shopcart.jsp");
			return;
		}
		//Shopcart shopcart = new Shopcart();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String date = sdf.format(d);
		
		for(int i=0;i<pids.length;i++){
			String pd = pids[i];
			if(pd.equals("")){
				out.println("<script>alert('请先选择需要购买的商品！！！');location.href='shopcart.jsp';</script>");
				return;
			}
		int id = Integer.parseInt(pd);
		
		us.updateShopcartBySO(uid, id, state);
		
		us.updateShopcartBySOD(uid, id, date);
		}
		
		
		
		response.sendRedirect("orange/orange/success.jsp?MONEY="+money+"&PHONE="+phone+"&DATE="+date);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

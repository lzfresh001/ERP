package com.orange.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.orange.web.service.UserService;
import com.orange.web.vo.Nut;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		Nut nut = new Nut();
		
		String CZ = request.getParameter("CZ");
		if(null == CZ) {
			response.sendRedirect("orange/orange/insertNut.jsp");
			return;
		}
		String idStr = request.getParameter("id");
		if(null == idStr) {
			response.sendRedirect("orange/orange/insertNut.jsp");
			return;
		}
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String countStr = request.getParameter("count");
		if(null == countStr) {
			response.sendRedirect("orange/orange/insertNut.jsp");
			return;
		}
		int count = Integer.parseInt(countStr);
		String srcs = request.getParameter("srcs");
		String src = request.getParameter("src");
		String srcc = request.getParameter("srcc");
		String srccc = request.getParameter("srccc");
		String srca = request.getParameter("srca");
		String srcb = request.getParameter("srcb");
		String srcd = request.getParameter("srcd");
		String weight = request.getParameter("weight");
		String plno = request.getParameter("plno");
		String exdate = request.getParameter("exdate");
		String date = request.getParameter("date");
		String priceStr = request.getParameter("price");
		if(null == priceStr) {
			response.sendRedirect("orange/orange/insertNut.jsp");
			return;
		}
		double price = Double.parseDouble(priceStr);
		String brand = request.getParameter("brand");
		String place = request.getParameter("place");
		
		nut.setId(id);
		nut.setName(name);
		nut.setCount(count);
		nut.setSrcs(srcs);
		nut.setSrc(src);
		nut.setSrcc(srcc);
		nut.setSrccc(srccc);
		nut.setSrca(srca);
		nut.setSrcb(srcb);
		nut.setSrcd(srcd);
		nut.setWeight(weight);
		nut.setPlno(plno);
		nut.setExdate(exdate);
		nut.setDate(date);
		nut.setPrice(price);
		nut.setBrand(brand);
		nut.setPlace(place);
		
		if(CZ.equals("I")) {
			us.insertNut(nut);
		}
		if(CZ.equals("U")) {
			us.updateNut(nut);
		}
		
		out.println("<script>alert('数据已更新！！！');location.href='orange/orange/admin.jsp';</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

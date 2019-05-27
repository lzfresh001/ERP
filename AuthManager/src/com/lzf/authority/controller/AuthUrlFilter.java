package com.lzf.authority.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AuthUrlFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		// 获得用户请求的URI
		String url = request.getServletPath();
		System.out.println(url);
		// 从session里取员工信息
		Object user = session.getAttribute("USER");
		// 未登录返回路径
		String returnUrl = request.getContextPath() + "/pages/login.jsp";
		
		if(null == user) { // 未登录
			if(url.endsWith("/login.jsp") || 
			   url.endsWith("/image.jsp") ||
			   url.endsWith("/validCode.action") ||
			   url.endsWith("/login.action") ||
			   url.endsWith("/logout.action") ||
			   url.indexOf("static")>-1
			) {
				chain.doFilter(servletRequest, servletResponse);
			}else {
				PrintWriter out = response.getWriter();
				System.out.println("****start***");
				out.print("<script>alert('请先正确登录！');location.href='"+returnUrl+"';</script>");
				System.out.println("****end***");
			}
		}else { // 已登录
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

<%@page import="com.orange.web.vo.Address"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>付款成功</title>
	<link rel="stylesheet" type="text/css"
		href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
	<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
		type="text/css">
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="../css/sustyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
</head>

<body>


	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<%
						String flag = request.getParameter("flag");
						if (null != flag) {
							session.removeAttribute("USERNAME");
							session.removeAttribute("UID");
							session.removeAttribute("page");
							session.removeAttribute("PAGE");
						}
						Object obj = session.getAttribute("USERNAME");
						if (null == obj) {
					%>
					亲，请<a href="login.jsp" target="_top" class="h">登录</a> 免费<a
						href="register.jsp" target="_top">注册</a>
					<%
						} else {
					%>
					您好，<%=obj%>
					<a href="home.jsp?flag=exit" target="_top">退出</a>
					<%
						}
					%>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="home.jsp" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="order.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>订单管理</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="shopcart.jsp" target="_top"><i
						class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h"></strong></a>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="collection.jsp" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
				</div>
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="../../image/logo.jpg" />
		</div>
		<div class="logoBig">
			<li><img src="../../image/logo.jpg" /></li>
		</div>

		<div class="search-bar pr">
			<form action="search.jsp" method="post">
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit" value="搜索" index="1" type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>

	<%
		Object uidObj = session.getAttribute("UID");
		if(null == uidObj){
			response.sendRedirect("login.jsp");
			return;
		}
		int uid = (Integer)uidObj;
		String money = request.getParameter("MONEY");
		String phone = request.getParameter("PHONE");
		String date = request.getParameter("DATE");
		
		UserService us = new UserService();
		Address address = new Address();
		address = us.findAddressByUP(uid, phone);
		
	%>

	<div class="take-delivery">
		<div class="status">
			<h2>您已成功付款</h2>
			<div class="successInfo">
				<ul>
					<li>付款金额<em>¥:<%=money %>0</em></li>
					<div class="user-info">
						<p>收货人：<%=address.getUname() %></p>
						<p>联系电话：<%=phone %></p>
						<p>收货地址：<%=address.getAddp() %> <%=address.getAddc() %> <%=address.getAdd() %> <%=address.getAddd() %></p>
						<p>成交时间：<%=date %></p>
					</div>
					请认真核对您的收货信息，如有错误请联系客服

				</ul>
				<div class="option">
					<span class="info">您可以</span> <a href="order.jsp?"
						class="J_MakePoint"><span>查看全部订单</span></a> <a
						href="orderinfo.jsp" class="J_MakePoint"><span></span></a>
				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<div class="footer-hd">
			<p>
				<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
					href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
			</p>
		</div>
		<div class="footer-bd">
			<p>
				<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
					href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
					href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
					target="_blank">网页模板</a></em>
			</p>
		</div>
	</div>


</body>
</html>

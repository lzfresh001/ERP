<%@page import="com.orange.web.vo.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>我的收藏</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/colstyle.css" rel="stylesheet" type="text/css">
		
		<style>
			#box{margin: auto;}
			#ng{text-align: center;}
		</style>
	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<%
										String flag = request.getParameter("flag");
										if(null != flag){
											session.removeAttribute("USERNAME");
											session.removeAttribute("UID");
											session.removeAttribute("page");
											session.removeAttribute("PAGE");
										}
										Object obj = session.getAttribute("USERNAME");
										if(null == obj){
									%>	
											亲，请<a href="login.jsp" target="_top" class="h">登录</a>
											免费<a href="register.jsp" target="_top">注册</a>
									<%	
										} else {
									
									%>		您好，<%=obj %>
											<a href="home.jsp?flag=exit" target="_top">退出</a>
									<%
										}
									%>
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="home.jsp" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="order.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>订单管理</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="shopcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="collection.jsp" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="../../image/logo.jpg" /></li>
							</div>

							<div class="search-bar pr">
								<form action="search.jsp" method="post" >
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部收藏</span></div>
					   <div class="nav-cont">
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div id="box"  class="user-collection">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的收藏</strong> / <small>My&nbsp;Collection</small></div>
						</div>
						<hr/>

						<div class="you-like">
							<div class="s-content">
							
								<%
									PrintWriter pw =  response.getWriter();
									Object uidObj = session.getAttribute("UID");
									if(null == uidObj){
										response.sendRedirect("login.jsp");
										return;
									}
									int uid = (Integer)uidObj;
									UserService us = new UserService();
									List<Collection> collections = us.findCollection(uid);
									if(null == collections){
										pw.println("<script>alert('您还未收藏商品！！！');location.href='home.jsp';</script>");
										return;
									}
									for(Collection collection: collections){
								%>
									<div class="s-item-wrap" >
										<div class="s-item">
	
											<div class="s-pic" onclick="goIntroduction(this,<%=collection.getId() %>)">
												<a  class="s-pic-link">
													<img src="<%=collection.getSrc() %>" alt="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰" class="s-pic-img s-guess-item-img">
												</a>
											</div>
											<div class="s-info">
												<div  id="ng" class="s-title"><span title="s925纯银千纸鹤锁骨链短款简约时尚韩版素银项链小清新秋款女配饰"><%=collection.getName() %> <%=collection.getWeight() %>g/袋</span></div>
												<div class="s-price-box">
													<span class="s-price"><em class="s-price-sign">¥</em><em class="s-value"><%=collection.getPrice() %>0</em></span>
												</div>
												<div class="s-extra-box">
													<a onclick="deleteCollection(this,<%=collection.getId() %>)" >取消收藏</a>
												</div>
											</div>
										</div>
									</div>
								<%		
									}
								%>
								
								<script>
									function goIntroduction(gi,id){
										location.href = "introduction.jsp?id=" + id;
									}
									function deleteCollection(dc,id){
										location.href = "../../DeleteCollection?ID=" + id;
									}
								</script>



									</div>
								</div>

							</div>


						</div>

					</div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>

		</div>

	</body>

</html>
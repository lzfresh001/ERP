<%@page import="java.math.BigDecimal"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.orange.web.vo.Orde"%>
<%@page import="java.util.List"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>订单管理</title>

<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="../css/personal.css" rel="stylesheet" type="text/css">
<link href="../css/orstyle.css" rel="stylesheet" type="text/css">

<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	<style>
		#box{margin-left: -180px}
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
								<a href="collection.jsp" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
							</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="../../image/logo.jpg" /></li>
					</div>

					<div class="search-bar pr">
						<form action="search.jsp" method="post">
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部订单</span>
		</div>
		<div class="nav-cont">
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			
					<!--标题 -->
				<div id="box">
				<div class="main-wrap">
				<div class="user-order">

				
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a>订单详情</a></li>
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
									
									<%	
										PrintWriter pw = response.getWriter();
										Object uidObj =  session.getAttribute("UID");
										if(null == uidObj){
											response.sendRedirect("login.jsp");
											return;
										}
										int uid = (Integer)uidObj;
										UserService us = new UserService();
										List<Orde> ordes = us.findOrdeByUid(uid);
										if(null == ordes){
											pw.println("<script>alert('您还未购物！！！');location.href='home.jsp';</script>");
											return;
										}
										
										double sum =0;
										String state = "";
										int s = 0;
										String date = null;
										for(Orde orde: ordes){
											sum = orde.getPrice()*orde.getNum();
											BigDecimal sbd = new BigDecimal(sum);
											sum = sbd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
											state = orde.getState();
											s = Integer.parseInt(state);
											date = orde.getDate();
											
									%>
										<!--订单信息-->
										<div class="order-status5">
											<div class="order-title">
											<%
												if(date.equals("null")){
											%>
												<div class="dd-num">
													未付款<a href=""></a>
												</div>
											<%		
												}else{
											%>
												<div class="dd-num">
													成交时间：<a href=""><%=date %></a>
												</div>
											<%		
												}
											%>
												
												<span></span>
											</div>
											<div class="order-content">
												<div class="order-left">


													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="<%=orde.getSrcs() %>"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p><%=orde.getName() %></p><br>
																		<p class="info-little">编号：<%=orde.getId() %></p>
																		<p class="info-little">产地：<%=orde.getPlace() %></p>	
																		
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price"><%=orde.getPrice() %>0</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span><%=orde.getNum() %></span>
															</div>
														</li>
														<li class="td td-operation">
														<%
															if(s == 1){
														%>
																<div class="item-operation"><a onclick="rebuy(this,<%=orde.getId()%>)" >再次购买</a></div>	
														<% 		
															}else{
														%>	
																<div class="item-operation"><a onclick="gopay(this,<%=orde.getId()%>)" >付款</a></div>
														<% 	
															}
														%>
														
														<script>
															// 再次购买点击事件
															function rebuy(rb,id){
																location.href = "introduction.jsp?id=" + id;
															}
															// 付款点击事件
															function gopay(gp,pid){
																location.href = "pay.jsp?pid=" + pid;
															}
														</script>
															
														</li>
													</ul>
												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="">
															合计：<%=sum %>0
															<p>
																(含运费)
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus"></p>
																<p class="order-info">
																	<a href="orderinfo.html"></a>
																</p>
																<p class="order-info">
																	<%
																		if(s == 1){
																	%>
																			<a href>待收货</a>	
																	<% 		
																		}else{
																	%>	
																			<a href>待付款</a>
																	<% 	
																		}
																	%>
																	
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu">删除订单</div>
														</li>
													</div>
												</div>
											</div>
										</div>
									
									<% 	
										}
									%>
									




							<div class="am-tab-panel am-fade" id="tab2">

								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-status1">
											<div class="order-title">
												<div class="dd-num">
													<a href="javascript:;"></a>
												</div>
												<span></span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">


													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul>
												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">等待买家付款</p>
																<p class="order-info">
																	<a href="#">取消订单</a>
																</p>

															</div>
														</li>
														<li class="td td-change"><a href="pay.html">
																<div class="am-btn am-btn-danger anniu">一键支付</div>
														</a></li>
													</div>
												</div>

											</div>
										</div>
									</div>

								</div>
							</div>
							<div class="am-tab-panel am-fade" id="tab3">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-status2">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款</a>
															</div>
														</li>
													</ul>
												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">买家已付款</p>
																<p class="order-info">
																	<a href="orderinfo.html">订单详情</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu">提醒发货</div>
														</li>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="am-tab-panel am-fade" id="tab4">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<div class="order-status3">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>

												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">卖家已发货</p>
																<p class="order-info">
																	<a href="orderinfo.html">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.html">查看物流</a>
																</p>
																<p class="order-info">
																	<a href="#">延长收货</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu">确认收货</div>
														</li>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="am-tab-panel am-fade" id="tab5">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">
										<!--不同状态的订单	-->
										<div class="order-status4">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>

											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>

												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易成功</p>
																<p class="order-info">
																	<a href="orderinfo.html">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.html">查看物流</a>
																</p>
															</div>
														</li>
														<li class="td td-change"><a href="commentlist.html">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
														</a></li>
													</div>
												</div>
											</div>
										</div>


										<div class="order-status4">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="javascript:;">1601430</a>
												</div>
												<span>成交时间：2015-12-20</span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/62988.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>礼盒袜子女秋冬 纯棉袜加厚 韩国可爱</p>
																		<p class="info-little">
																			颜色分类：李清照 <br />尺码：均码
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>

													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint"> <img
																	src="../images/kouhong.jpg_80x80.jpg"
																	class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>美康粉黛醉美唇膏 持久保湿滋润防水不掉色</p>
																		<p class="info-little">
																			颜色：12#川南玛瑙 <br />包装：裸装
																		</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">333.00</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>2
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<a href="refund.html">退款/退货</a>
															</div>
														</li>
													</ul>


												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：676.00
															<p>
																含运费：<span>10.00</span>
															</p>
														</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易成功</p>
																<p class="order-info">
																	<a href="orderinfo.html">订单详情</a>
																</p>
																<p class="order-info">
																	<a href="logistics.html">查看物流</a>
																</p>
															</div>
														</li>
														<li class="td td-change"><a href="commentlist.html">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
														</a></li>
													</div>
												</div>
											</div>
										</div>


									</div>

								</div>

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
		</div>
	</div>

</body>

</html>
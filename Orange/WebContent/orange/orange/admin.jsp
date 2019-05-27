<%@page import="com.orange.web.vo.Nut"%>
<%@page import="java.util.List"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>管理员页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/jquery.js"></script>
		
		<style>
			#box{margin-top: 10px}
			#gy{padding-right:550px}
			#sl{margin-left: 12px}
			#tj{font-size: 16px; font-weight: bold;}
		</Style>

	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<%
							String flag = request.getParameter("flag");
							if(null != flag){
								session.removeAttribute("UNAME");
							}
							Object obj = session.getAttribute("UNAME");
							if(null == obj){
						%>	
								亲，请<a href="adlogin.jsp" target="_top" class="h">登录</a>
						<%	
							}else{
						%>	
								您好，<%=obj %>
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
					<div class="menu-hd MyShangcheng"><a target="_top"><i class="am-icon-user am-icon-fw"></i>订单管理</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd"  target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a  target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../../image/logo.jpg" /></div>
				<div class="logoBig">
					<li><img src="../../image/logo.jpg" /></li>
				</div>

				<div class="search-bar pr">
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
				<div id="box" class="nav-table">
					<div class="long-title">
						<span class="all-goods">管理员页面</span>
					</div>
				</div>
			<b class="line"></b>
			<br>
			
			<%
				if(null == obj){
					response.sendRedirect("adlogin.jsp");
					return;
				}
				// 分页查询
				// 设置每页显示的条数
				int pageSize = 4;
				// 查询总条数
				int count = 0;
				// 当前是第几页
				int pageNum = 1;
				// 总共有多少页
				int pageCount = 0;
				
				// count
				UserService us = new UserService();
				List<Nut> nuts = us.findAllNut();
				count = nuts.size();
				// pageNum
				String pn = request.getParameter("pageNum");
				if(null == pn){
					pageNum = 1;
				}else{
					pageNum = Integer.parseInt(pn);
				}
				// pageCount
				pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
				
			%>
			
			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">生产日期</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<%
						// 计算遍历区间
						int start = (pageNum-1)*pageSize;
						int end = pageNum==pageCount?count-1:pageNum*pageSize-1;
						for(int i=start;i<=end;i++){
							Nut nut = nuts.get(i);
					%>
							<tr class="item-list">
								<div class="bundle  bundle-last ">
									<div class="bundle-hd">
										<div class="bd-promos">
											<div class="bd-has-promo"><span class="bd-has-promo-content"></span>&nbsp;&nbsp;</div>
											<div class="act-promo">
												<a href="#" target="_blank"><span class="gt"></span></a>
											</div>
											<span class="list-change theme-login"></span>
										</div>
									</div>
									<div class="clear"></div>
									
									<div class="bundle-main">
										<ul class="item-content clearfix">
											<li class="td td-chk">
												<div class="cart-checkbox ">
													<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
													<label for="J_CheckBox_170037950254"></label>
												</div>
											</li>
											<li class="td td-info">
												<div class="item-props">
													<span class="">编号：<%=nut.getId() %></span>
													<br />
													<span class="">品名：<%=nut.getName() %></span>
												</div>
											</li>
											<li class="td td-item">
												<div class="item-pic">
													<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
														<img src="<%=nut.getSrcs() %>" class="itempic J_ItemImg"></a>
												</div>
												<div class="item-info">
													<div class="item-basic-info">
														<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11">产地：<%=nut.getPlace() %></a>
													</div>
												</div>
											</li>
											
											<li class="td td-price">
												<div class="item-price price-promo-promo">
													<div class="price-content">
														<div class="price-line">
															<em class="price-original"><%=nut.getPrice()*2 %>0</em>
														</div>
														<div class="price-line">
															<em class="J_Price price-now" tabindex="0"><%=nut.getPrice() %>0</em>
														</div>
													</div>
												</div>
											</li>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<div class="sl">
															<span id="sl" class="text_box" style="width:30px;"><%=nut.getCount() %> 袋</span>
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number"><%=nut.getDate() %></em>
												</div>
											</li>
											<li class="td td-op">
												<div class="td-inner">
													<a title="移入收藏夹" class="btn-fav" href="updateNut.jsp?id=<%=nut.getId() %>">修改</a>
													<br/>
													<a title="移入收藏夹" class="btn-fav" href="../../AdminDelete?id=<%=nut.getId() %>">删除</a>
		                  
												</div>
											</li>
										</ul>
									</div>
								</div>
							</tr>
					<%	
						}
					%>
					
					<div class="clear"></div>

					
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					
					<div class="float-bar-right">
						<div class="amount-sum">
						    <a id="tj" href="insertNut.jsp" >添加商品</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<span id="dy" class="txt">第<%=pageNum %>页</span>&nbsp&nbsp
							<span id="gy" class="txt">共<%=pageCount %>页</span>
							<%
								// 当前为第一页 首页和上一页 不可点击
								if(pageNum == 1){
							%>	
									<span class="txt">首页</span>&nbsp&nbsp
									<span class="txt">上一页</span>&nbsp&nbsp
							<%	
								}else{
							%>	
									<span class="txt"><a href="admin.jsp?pageNum=1" >首页</a></span>&nbsp&nbsp
									<span class="txt"><a href="admin.jsp?pageNum=<%=pageNum-1 %>" >上一页</a></span>&nbsp&nbsp
							<%	
								}
								// 当前为最后一页 下一页和末页 不可点击
								if(pageNum == pageCount){
							%>
									<span class="txt">下一页</span>&nbsp&nbsp
									<span class="txt">末页</span>&nbsp&nbsp
							
							<%		
								}else{
							%>
									<span class="txt"><a href="admin.jsp?pageNum=<%=pageNum+1 %>" >下一页</a></span>&nbsp&nbsp
									<span class="txt"><a href="admin.jsp?pageNum=<%=pageCount %>" >末页</a></span>&nbsp&nbsp
							
							<%		
								}
							%>
							
							<em id="J_SelectedItemsCount"></em><span class="txt"></span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						
						<div class="price-sum">
							<span class="txt"></span>
							<strong class="price"><em id="J_Total"></em></strong>
						</div>
						
					</div>
					
					

				</div>

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

			<!--操作页面-->

			<div class="theme-popover-mask"></div>

			<div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">

							<li class="theme-options">
								<div class="cart-title">颜色：</div>
								<ul>
									<li class="sku-line selected">12#川南玛瑙<i></i></li>
									<li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title">包装：</div>
								<ul>
									<li class="sku-line selected">包装：裸装<i></i></li>
									<li class="sku-line">两支手袋装（送彩带）<i></i></li>
								</ul>
							</li>
							<div class="theme-options">
								<div class="cart-title number">数量</div>
								<dd>
									<input class="min am-btn am-btn-default" name="" type="button" value="-" />
									<input class="text_box" name="" type="text" value="1" style="width:30px;" />
									<input class="add am-btn am-btn-default" name="" type="button" value="+" />
									<span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
								</dd>

							</div>
							<div class="clear"></div>
							<div class="btn-op">
								<div class="btn am-btn am-btn-warning">确认</div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>
						<div class="theme-signin-right">
							<div class="img-info">
								<img src="../images/kouhong.jpg_80x80.jpg" />
							</div>
							<div class="text-info">
								<span class="J_Price price-now">¥39.00</span>
								<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
							</div>
						</div>

					</form>
				</div>
			</div>
		<!--引导 -->
		<div class="navCir">
			<li><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
	</body>

</html>
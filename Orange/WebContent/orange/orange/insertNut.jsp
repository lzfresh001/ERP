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

		<title>添加商品页面</title>

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
			#tjsp{width: 400px; margin: 30px auto; font-size: 18px}
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
						
						<%
							if(null == obj){
								response.sendRedirect("adlogin.jsp");
								return;
							}
						%>
						
						
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd"  target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
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
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
				<div id="box" class="nav-table">
					<div class="long-title">
						<span class="all-goods">添加商品页面</span>
					</div>
				</div>
			<b class="line"></b>
			<br>
			
			<form id="tjsp" action="../../Admin" method="post">
				<input type="hidden" name="CZ" value="I" />
				商品id: <input type="text" name="id" placeholder="请输入商品ID(数字)" /><br /><br /><br />
				商品名: <input type="text" name="name" placeholder="请输入商品名" /><br /><br /><br />
				商品数量: <input type="text" name="count" placeholder="请输入商品数量" /><br /><br /><br />
				商品图1: <input type="text" name="srcs" placeholder="请输入图片路径" /><br /><br /><br />
				商品图2: <input type="text" name="src" placeholder="请输入图片路径" /><br /><br /><br />
				商品图3: <input type="text" name="srcc" placeholder="请输入图片路径" /><br /><br /><br />
				商品图4: <input type="text" name="srccc" placeholder="请输入图片路径" /><br /><br /><br />
				商品图5: <input type="text" name="srca" placeholder="请输入图片路径" /><br /><br /><br />
				商品图6: <input type="text" name="srcb" placeholder="请输入图片路径" /><br /><br /><br />
				商品图7: <input type="text" name="srcd" placeholder="请输入图片路径" /><br /><br /><br />
				净含量: <input type="text" name="weight" placeholder="请输入商品净含量" /><br /><br /><br />
				生产许可证: <input type="text" name="plno" placeholder="请输入商品生产许可证号" /><br /><br /><br />
				保质期: <input type="text" name="exdate" placeholder="请输入商品保质期天数" /><br /><br /><br />
				生产日期: <input type="text" name="date" placeholder="请输入商品生产日期 "/><br /><br /><br />
				商品价格: <input type="text" name="price" placeholder="请输入商品价格" /><br /><br /><br />
				品牌名: <input type="text" name="brand" placeholder="请输入商品品牌" /><br /><br /><br />
				商品产地: <input type="text" name="place" placeholder="请输入商品产地" /><br /><br /><br />
				<input type="submit" value="确认提交" />
			</form>
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
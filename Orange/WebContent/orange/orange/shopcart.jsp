<%@page import="java.io.PrintWriter"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%@page import="com.orange.web.vo.Shopcart"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src=""></script>
		
		<style>
			#box{margin-top: 10px}
		</Style>

	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
							<%
								session.setAttribute("PAGE", "orange/orange/shopcart.jsp");
							
								String flag = request.getParameter("flag");
								//System.out.println("flag=" + flag);
								if(null != flag){
									//System.out.println("&&&&&&&&&&&&&&");
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
				<div class="logo"><img src="../../image/logo.jpg" /></div>
				<div class="logoBig">
					<li><img src="../../image/logo.jpg" /></li>
				</div>

				<div class="search-bar pr">
					<form action="search.jsp" method="post">
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			
			<div class="clear"></div>
				<div id="box" class="nav-table">
					<div class="long-title">购物车</div>
				</div>
			<b class="line"></b>
			<br>

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
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<%
						PrintWriter pw =  response.getWriter();
						Object objuid = session.getAttribute("UID");
						if(null == objuid){
							response.sendRedirect("login.jsp");
							return;
						}
						int uid = (Integer)objuid;
						UserService us = new UserService();
						List<Shopcart> shopcarts = us.findShopcarByUid(uid);
						if(null == shopcarts){
							pw.println("<script>alert('您的购物车空空如也！！！');location.href='home.jsp';</script>");
							return;
						}
						double sum = 0;
						if(shopcarts.size()>0){
							for(Shopcart shopcart: shopcarts){
								double money = shopcart.getNum()*shopcart.getPrice();
								BigDecimal mbd = new BigDecimal(money);
								money = mbd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
								sum += money;
								BigDecimal sbd = new BigDecimal(sum);
								sum = sbd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
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
														<input class="checked" id="J_CheckBox_170037950254" name="items[]" value="<%=shopcart.getNum()*shopcart.getPrice() %>" type="checkbox">
														<label for="J_CheckBox_170037950254"></label>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														编号：<span class="scid"><%=shopcart.getId() %></span><br />
														品名：<span class=""><%=shopcart.getName() %></span>
													</div>
												</li>
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
															<img src="<%=shopcart.getSrcs() %>" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11">产地：<%=shopcart.getPlace() %></a>
														</div>
													</div>
												</li>
												
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<div class="price-line">
																<em class="price-original"><%=shopcart.getPrice()*2 %>0</em>
															</div>
															<div class="price-line">
																<em class="J_Price price-now" tabindex="0"><%=shopcart.getPrice() %>0</em>
															</div>
														</div>
													</div>
												</li>
												<li class="td td-amount">
													<div class="amount-wrapper ">
														<div class="item-amount ">
															<div class="sl">
																<input onclick="minus(this,<%=shopcart.getId() %>)" class="min am-btn" name="" type="button" value="-" />
																<input onchange="changeNum(this,<%=shopcart.getId() %>)" onkeyup="changeNum(this,<%=shopcart.getId() %>)" class="text_box" name="" type="text" value="<%=shopcart.getNum() %>" style="width:30px;" />
																<input onclick="add(this,<%=shopcart.getId() %>)" class="add am-btn" name="" type="button" value="+" onclick="addNum(this)" />
															</div>
														</div>
													</div>
												</li>
												<li class="td td-sum">
													<div class="td-inner">
														<em tabindex="0" class="J_ItemSum number"><%=money %>0</em>
													</div>
												</li>
												<li class="td td-op">
													<div class="td-inner">
														<a title="移入收藏夹" class="btn-fav" href="#">移入收藏夹</a>
			                  
														<a href="../../DeleteShopcart?id=<%=shopcart.getId() %>" data-point-url="#" class="delete">删除</a>
			                  
													</div>
												</li>
											</ul>
									</div>
								</tr>
													
					<%			
							}
						}
					%>
					
					<div class="clear"></div>
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="qx" name="select-all"  type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="#" hidefocus="true" class="deleteAll">删除</a>
						<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						<div class="btn-area">
							<div id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></div>
						</div>
					</div>

				</div>
				<script>
						// 获取全选框
						var qx = document.getElementById("qx");
						// 获取所有商品的复选框
						var nuts = document.getElementsByClassName("checked");
						// 获取所买几件商品的标签
						var count = document.getElementById("J_SelectedItemsCount");
						var cut = 0;
						// 获取合计对应的标签
						var total = document.getElementById("J_Total");
						// 获取结算对应的标签
						var js = document.getElementById("J_Go");
						var pid = "";
						// 获取商品id对应的标签
						var scids = document.getElementsByClassName("scid");
						// 获取num输入框并限制输入
						var text_boxs = document.getElementsByClassName("text_box");
						
						for(var i=0;i<text_boxs.length;i++){
							text_boxs[i].onkeydown = function(ev){
								var keycode = ev.keyCode;
								var keychar = String.fromCharCode(keycode);
								//console.log("keycode=" + keychar);
								if(keychar >= '0' && keychar <= '9' || keycode == 8 || keycode == 37 || keycode == 39){
									return true;
								}
								return false;
							}
							text_boxs[i].onblur = function(){
								if(this.value == "" || this.value == "0"){
									this.value = 1;
								}
							}
						}
						// 给全选框添加事件
						qx.onclick = function(){
							for(var i=0;i<nuts.length;i++){
								nuts[i].checked = this.checked;
							}
							if(this.checked){
								total.innerHTML = <%=sum %>;
								count.innerHTML = nuts.length;
								cut = nuts.length;
							}else{
								total.innerHTML = "0.00";
								count.innerHTML = "0";
							}
						}
						// 给所有nut复选框添加事件
						for(var i=0;i<nuts.length;i++){
							var nut = nuts[i];
							nut.onclick = function(){
								// 获取小计
								var subTotal_txt = this.value;
								var subTotal = Number(subTotal_txt);
								// 获取总价
								var totalPrice_txt = total.innerHTML.trim();
								var totalPrice = Number(totalPrice_txt);
								if(this.checked){ // 该产品被选中则将小计加到合计中
									totalPrice += subTotal;
									cut++;
								}else{ // 取消选中时将小计从合计中减掉
									totalPrice -= subTotal;
								   
									// 取消选中时如果全选框选中则将全选框也取消选中
									if(qx.checked){
										qx.checked = false;
									}
									cut--;
								}
								
								total.innerHTML = totalPrice;
								count.innerHTML = cut;
							}
						}
						// 点击减号 btn 所点击的减号按钮
						function minus(btn,id){
							// 获取所点击的减号按钮所对应的数字框
							var num_input = btn.nextElementSibling;
							var num_txt = num_input.value.trim();
							var num = parseInt(num_txt);
							if(num>1){
								num--;
							}
							// 将修改过的num显示到页面
							num_input.value = num;
							// 请求后台Servlet修改数据库中的数量
							location.href = "../../UpdateShopcart?US=S&id=" + id + "&num=" + num;
						}
						// 点击加号 btn 所点击的加号按钮
						function add(btn,id){
							// 获取所点击的减号按钮所对应的数字框
							var num_input = btn.previousElementSibling;
							var num_txt = num_input.value.trim();
							var num = parseInt(num_txt);
							num++;
							// 将修改过的num显示到页面
							num_input.value = num;
							// 请求后台Servlet修改数据库中的数量
							location.href = "../../UpdateShopcart?US=S&id=" + id + "&num=" + num;
						}
						// 数字框改变
						function changeNum(num_input,id){
							// 获取所改变数字框对应的值
							var num_txt  = num_input.value.trim();
							var num = parseInt(num_txt);
							// 请求后台servlet修改数据库中的数量
							location.href = "../../UpdateShopcart?US=S&id=" + id + "&num=" + num;
							
						}
						
						js.onclick = function(){
							for(var i=0;i<nuts.length;i++){
								var nut = nuts[i];
								var scid = scids[i];
								if(nut.checked){
									pid += scid.innerHTML + ",";
								}
							}
							pid = pid.slice(0,-1);
							location.href = "pay.jsp?pid="+pid;
						}
						
						
					</script>
				

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
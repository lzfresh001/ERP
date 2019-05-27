<%@page import="java.io.PrintWriter"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.orange.web.vo.Shopcart"%>
<%@page import="com.orange.web.vo.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.orange.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>付款</title>

	<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
		type="text/css" />

	<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />

	<link href="../css/jsstyle.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="../js/address.js"></script>
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
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<div class="concent">
		<!--地址 -->
		<div class="paycont">
			<div class="address">
				<h3>确认收货地址</h3>
				<div class="control">
					<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
				</div>
				<div class="clear"></div>
				
				<%
					PrintWriter pw = response.getWriter();
				
					Object uidObj = session.getAttribute("UID");
					if(null == uidObj) {
						response.sendRedirect("login.jsp");
						return;
					}
					int uid = (Integer)uidObj;
					
					String pid = request.getParameter("pid");
					
					
					UserService us = new UserService();
					List<Address> addresss = us.findAddressByUid(uid);
					
					if(null != addresss){
						for(Address address: addresss){
				%>
					<ul>
						<div class=""></div>
						<div class=""></div>
						<li class="user-addresslist">
							<div class="">
								<div class="user DefaultAddr">
	
									<span class="buy-address-detail"> <span class="buy-user">收件人：<%=address.getUname() %>
									</span><br /> <span class="buy-phone">联系电话：<%=address.getPhone() %></span>
									</span>
								</div>
								<div class="default-address DefaultAddr">
									<span class="buy-line-title buy-line-title-type">收货地址：</span> <span
										class="buy--address-detail"> <span class="province"><%=address.getAddp() %></span>
										<span class="city"><%=address.getAddc() %> </span><span class="dist"><%=address.getAdd() %></span> <span
										class="street"><%=address.getAddd() %></span>
									</span> </span>
								</div>
							</div>
							<div class="clear"></div>
	
							<div class="new-addr-btn">
								<a href="pay.jsp?pid=<%=pid%>&UNAME=<%=address.getUname() %>&PHONE=<%=address.getPhone() %>&ADDP=<%=address.getAddp() %>&ADDC=<%=address.getAddc() %>&ADD=<%=address.getAdd() %>&ADDD=<%=address.getAddd() %>">选择该地址</a> <span class="new-addr-bar">|</span> 
								<a href="../../DeleteAdd?ADDD=<%=address.getAddd() %>&PID=<%=pid %>" onclick="delClick(this);">删除</a>
									
							</div>
	
						</li>
	
					</ul>
				<%	
						}
					}
				%>
			
				

				<div class="clear"></div>
			</div>
			<!--物流 -->
			<div class="logistics">
				<h3>选择物流方式</h3>
				<ul class="op_express_delivery_hot">
					<li data-value="yuantong" class="OP_LOG_BTN  "><i
						class="c-gap-right" style="background-position: 0px -468px"></i>圆通<span></span></li>
					<li data-value="shentong" class="OP_LOG_BTN  "><i
						class="c-gap-right" style="background-position: 0px -1008px"></i>申通<span></span></li>
					<li data-value="yunda" class="OP_LOG_BTN  "><i
						class="c-gap-right" style="background-position: 0px -576px"></i>韵达<span></span></li>
					<li data-value="zhongtong"
						class="OP_LOG_BTN op_express_delivery_hot_last "><i
						class="c-gap-right" style="background-position: 0px -324px"></i>中通<span></span></li>
					<li data-value="shunfeng"
						class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i
						class="c-gap-right" style="background-position: 0px -180px"></i>顺丰<span></span></li>
				</ul>
			</div>
			<div class="clear"></div>

			<!--支付方式-->
			<div class="logistics">
				<h3>选择支付方式</h3>
				<ul class="pay-list">
					<li class="pay card"><img src="../images/wangyin.jpg" />银联<span></span></li>
					<li class="pay qq"><img src="../images/weizhifu.jpg" /><span>微信</span></li>
					
					<li class="pay taobao"><img src="../images/zhifubao.jpg" />支付宝<span></span></li>
				</ul>
			</div>
			<div class="clear"></div>

			<!--订单 -->
			<div class="concent">
				<div id="payTable">
					<h3>确认订单信息</h3>
					<div class="cart-table-th">
						<div class="wp">

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
							<div class="th th-oplist">
								<div class="td-inner">配送方式</div>
							</div>

						</div>
					</div>
					<div class="clear"></div>
					
				
						<tr class="item-list">
								<div class="bundle  bundle-last">
		
									<div class="bundle-main">
											<%	
												//System.out.println("PID" + pid);
												if(null == pid){
													response.sendRedirect("shopcart.jsp");
													return;
												}
												String[] pids = pid.split(",");
												
												if(pids.length == 0){
													response.sendRedirect("shopcart.jsp");
													return;
												}
												Shopcart shopcart = new Shopcart();
												double sum = 0;
												for(int i=0;i<pids.length;i++){
													String pd = pids[i];
													if(pd.equals("")){
														pw.println("<script>alert('请先选择需要购买的商品！！！');location.href='shopcart.jsp';</script>");
														return;
													}
													int id = Integer.parseInt(pd);
													shopcart = us.findShoparById(uid, id);
													//System.out.println("shopcart"+shopcart);
													double money = shopcart.getNum()*shopcart.getPrice();
													BigDecimal mbd = new BigDecimal(money);
													money = mbd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
													sum += money;
													BigDecimal sbd = new BigDecimal(sum);
													sum = sbd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
											%> 
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint"> <img
															src="<%=shopcart.getSrcs() %>"
															class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint"
																data-point="tbcart.8.11">品名：<%=shopcart.getName() %></a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">编号：<%=shopcart.getId() %></span><br /> <span
															class="sku-line">产地：<%=shopcart.getPlace() %></span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now"><%=shopcart.getPrice() %>0</em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl">
															<input onclick="minus(this,<%=shopcart.getId() %>)" class="" name="" type="button" value="-" />
															<input onchange="changeNum(this,<%=shopcart.getId() %>)" onkeyup="changeNum(this,<%=shopcart.getId() %>)" class="text_box" name="" type="text" value="<%=shopcart.getNum() %>"style="width: 30px;" />
															<input onclick="add(this,<%=shopcart.getId() %>)" class="" name="" type="button" value="+" />
																
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number"><%=money %>0</em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														包邮<b class="sys_item_freprice"></b>
													</div>
												</div>
											</li>
		
										</ul>
									 	<%
											}
										%>
										<div class="clear"></div>
		
									</div>
							</tr>
					
					<script>
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
						
						// 点击减号 btn 所点击的减号按钮
						function minus(btn,id){
							// 获取pid
							var pid = "<%=pid%>";
							//console.log(id);
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
							location.href = "../../UpdateShopcart?US=P&PID=" + pid + "&id=" + id + "&num=" + num;
						}
						// 点击加号 btn 所点击的加号按钮
						function add(btn,id){
							// 获取pid
							var pid = "<%=pid%>";
							// 获取所点击的减号按钮所对应的数字框
							var num_input = btn.previousElementSibling;
							var num_txt = num_input.value.trim();
							var num = parseInt(num_txt);
							num++;
							// 将修改过的num显示到页面
							num_input.value = num;
							// 请求后台Servlet修改数据库中的数量
							location.href = "../../UpdateShopcart?US=P&PID=" + pid + "&id=" + id + "&num=" + num;
						}
						// 数字框改变
						function changeNum(num_input,id){
							// 获取pid
							var pid = "<%=pid%>";
							// 获取所改变数字框对应的值
							var num_txt  = num_input.value.trim();
							var num = parseInt(num_txt);
							// 请求后台servlet修改数据库中的数量
							location.href = "../../UpdateShopcart?US=P&PID=" + pid + "&id=" + id + "&num=" + num;
							
						}
					</script>
					

					
					<div class="clear"></div>
				</div>

			</div>
			<div class="clear"></div>
			<div class="pay-total">
				<!--留言-->
				<div class="order-extra">
					<div class="order-user-info">
						<div id="holyshit257" class="memo">
							<label>买家留言：</label> <input type="text"
								title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）"
								placeholder="选填,建议填写和卖家达成一致的说明"
								class="memo-input J_MakePoint c2c-text-default memo-close">
								<div class="msg hidden J-msg">
									<p class="error">最多输入500个字符</p>
								</div>
						</div>
					</div>

				</div>
				<!--优惠券 -->
				<div class="buy-agio">
					<li class="td td-coupon"><span class="coupon-title">优惠券</span>
						<select data-am-selected>
							<option value="a">
								<div class="c-price">
									<strong>￥8</strong>
								</div>
								<div class="c-limit">【消费满95元可用】</div>
							</option>
							<option value="b" selected>
								<div class="c-price">
									<strong>￥3</strong>
								</div>
								<div class="c-limit">【无使用门槛】</div>
							</option>
					</select></li>

					<li class="td td-bonus"><span class="bonus-title">红包</span> <select
						data-am-selected>
							<option value="a">
								<div class="item-info">
									¥50.00<span>元</span>
								</div>
								<div class="item-remainderprice">
									<span>还剩</span>10.40<span>元</span>
								</div>
							</option>
							<option value="b" selected>
								<div class="item-info">
									¥50.00<span>元</span>
								</div>
								<div class="item-remainderprice">
									<span>还剩</span>50.00<span>元</span>
								</div>
							</option>
					</select></li>

				</div>
				<div class="clear"></div>
			</div>
			<!--含运费小计 -->
			<div class="buy-point-discharge ">
				<p class="price g_price ">
					合计（含运费） <span>¥</span><em class="pay-sum"><%=sum %>0</em>
				</p>
			</div>

			<!--信息 -->
			<div class="order-go clearfix">
				<div class="pay-confirm clearfix">
					<div class="box">
						<div tabindex="0" id="holyshit267" class="realPay">
							<em class="t">实付款：</em> <span class="price g_price "> <span>¥</span>
								<em class="style-large-bold-red " id="J_ActualFee"><%=sum %>0</em>
							</span>
						</div>
						
						<%
							String UNAME = request.getParameter("UNAME");
							String PHONE = request.getParameter("PHONE");
							String ADDP = request.getParameter("ADDP");
							String ADDC = request.getParameter("ADDC");
							String ADD = request.getParameter("ADD");
							String ADDD = request.getParameter("ADDD");
						%>

						<div id="holyshit268" class="pay-address">

							<p class="buy-footer-address">
								<span class="buy-line-title buy-line-title-type">寄送至：</span> <span
									class="buy--address-detail"> <span class="province"><%=ADDP %></span>
									<span class="city"><%=ADDC %></span> <span class="dist"><%=ADD %></span> <span
									class="street"><%=ADDD %></span>
								</span> </span>
							</p>
							<p class="buy-footer-address">
								<span class="buy-line-title">收货人：</span> <span
									class="buy-address-detail"> <span class="buy-user"><%=UNAME %>
								</span> <span class="buy-phone"><%=PHONE %></span>
								</span>
							</p>
						</div>
					</div>

					<div id="holyshit269" class="submitOrder">
						<div class="go-btn-wrap">
							<a id="J_Go" href="../../Suborder?PID=<%=pid %>&MONEY=<%=sum %>&PHONE=<%=PHONE %>" class="btn-go" tabindex="0"
								title="点击此按钮，提交订单">提交订单</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<div class="clear"></div>
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
	</div>
	<div class="theme-popover-mask"></div>
	<div class="theme-popover">

		<!--标题 -->
		<div class="am-cf am-padding">
			<div class="am-fl am-cf">
				<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add
					address</small>
			</div>
		</div>
		<hr />

		<div class="am-u-md-12">
			<form action="../../Add" method="post" class="am-form am-form-horizontal">

				<div class="am-form-group">
					<label for="user-name" class="am-form-label">收货人</label>
					<div class="am-form-content">
						<input type="hidden" name="PID" value="<%=pid %>" />
						<input type="text" id="user-name" name="uname" placeholder="收货人">
					</div>
				</div>

				<div class="am-form-group">
					<label for="user-phone" class="am-form-label">手机号码</label>
					<div class="am-form-content">
						<input id="user-phone" name="phone" placeholder="手机号必填" type="text">
					</div>
				</div>

				<div class="am-form-group">
					<label for="user-phone" class="am-form-label">所在地</label>
					<div class="am-form-content address">
						
							<select name="addp" id="province">
								<option>==请选择==</option>
							</select> <select name="addc" id="city">
								<option>==请选择==</option>
							</select> <select name="add" id="district">
								<option>==请选择==</option>
							</select>
						
						<script>
							var data = [ [ "陕西省", "610000" ],
									[ "西安市", "610100" ], [ "咸阳市", "610200" ],
									[ "宝鸡市", "610300" ], [ "雁塔区", "610101" ],
									[ "新城区", "610102" ], [ "碑林区", "610103" ],
									[ "灞桥区", "610104" ], [ "陈仓区", "610301" ],
									[ "秦都区", "610201" ], [ "山西省", "620000" ],
									[ "太原市", "620100" ], [ "小店区", "620101" ],
									[ "迎泽区", "620102" ], [ "运城市", "620200" ],
									[ "甘肃省", "630000" ], [ "天水市", "630100" ],
									[ "兰州市", "630200" ], [ "酒泉市", "630300" ],
									[ "敦煌市", "630400" ], [ "河南省", "640000" ],
									[ "河北省", "650000" ] ];
							// 获取省市县的下拉框
							var province = document.getElementById("province");
							var city = document.getElementById("city");
							var district = document.getElementById("district");
							// 初始化身份的数据
							for (var i = 0; i < data.length; i++) {
								// 编码
								var code = data[i][1]; // 610000
								if (code.slice(2) == "0000") { // 编码后四位为0，表示省份
									province.innerHTML += "<option>"
											+ data[i][0] + "</option>";
								}
							}
							// 给省份下拉框添加事件
							province.onchange = function() {
								// 初始化城市
								city.innerHTML = "<option>==请选择==</option>";
								district.innerHTML = "<option>==请选择==</option>";
								// 1. 获取当前选择的省份名称
								var pname = this.value; // 陕西省
								console.log(pname);
								// 2. 获取省份对应的编码
								var pcode = findCode(pname); // 610000
								// 3. 根据省份编码找到该省里面的市，并添加到市的下拉框
								for (var i = 0; i < data.length; i++) {
									var ccode = data[i][1];
									if (ccode.slice(0, 2) == pcode.slice(0, 2)
											&& ccode.slice(2, 4) != "00"
											&& ccode.slice(4) == "00") {
										city.innerHTML += "<option>"
												+ data[i][0] + "</option>";
									}
								}
							}

							// 选择城市，将该城市下的区县数据添加到区县的下拉框中
							city.onchange = function() {
								// 1. 初始化区县
								district.innerHTML = "<option>==请选择==</option>";
								// 2. 获取选择的城市
								var cname = this.value; // 咸阳市
								// 3. 找到城市编码
								var ccode = findCode(cname);
								// 4. 根据城市编码，将该城市里面的区县添加到区县的下拉框中
								for (var i = 0; i < data.length; i++) {
									var dcode = data[i][1];
									if (dcode.slice(0, 4) == ccode.slice(0, 4)
											&& dcode.slice(4) != "00") {
										district.innerHTML += "<option>"
												+ data[i][0] + "</option>";
									}
								}
							}

							// 根据名称找编码
							function findCode(name) {
								for (var i = 0; i < data.length; i++) {
									var pcname = data[i][0];
									if (pcname == name) {
										return data[i][1];
									}
								}
							}
							
							// 限制电话输入框
							var phone = document.getElementById("user-phone");
							phone.onkeydown = function(ev) {
								var keycode = ev.keyCode;
								var keychar = String.fromCharCode(keycode);
										
								if (keychar >= '0' && keychar <= '9' || keycode == 8 || keycode == 37 || keycode == 39) {
									return true;
								}else{
									return false;
								}
							}
							phone.onblur = function() {
								if(this.value == "" || this.value == "0"){
									this.value = 1;
								}
							}
						</script>
					</div>
				</div>

				<div class="am-form-group">
					<label for="user-intro" class="am-form-label">详细地址</label>
					<div class="am-form-content">
						<textarea name="addd" class="" rows="4" cols="60" id="user-intro"
							placeholder="输入详细地址"></textarea>
						<br /> <small>100字以内写出你的详细地址...</small>
					</div>
				</div>

				<div class="am-form-group theme-poptit">
					<div class="am-u-sm-9 am-u-sm-push-3">
						<input class="am-btn am-btn-danger" type="submit" value="保存" />
						<div class="am-btn am-btn-danger close">取消</div>
					</div>
				</div>
			</form>
		</div>

	</div>

	<div class="clear"></div>
</body>

</html>
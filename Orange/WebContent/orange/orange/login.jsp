<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div class="login-boxtitle">
		<a href="home.html"><img alt="logo" src="../../image/logo.jpg" /></a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="../images/big.jpg" />
			</div>
			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>

				<div class="login-form">
					
					<%
						String username = "";
						String password = "";
						Cookie[] cks = request.getCookies();
						if(null != cks){
							for(Cookie ck: cks){
								if(ck.getName().equals("UNAME")){
									username = ck.getValue();
								}
								if(ck.getName().equals("PASS")){
									password = ck.getValue();
								}
							}
						}
						
					%>
					
					<form action="../../login" method="post" >
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="uname" id="user" placeholder="邮箱/手机/用户名" value="<%=username %>" />
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="password" id="password" placeholder="请输入密码" value="<%=password %>" />
						</div>
						</div>
		
						<div class="login-links">
							<label for="remember-me"><input id="remember-me" name="rem"
								type="checkbox">记住密码</label> <a href="adlogin.jsp" class="am-fr">管理员登录</a> <a
								href="register.jsp" class="zcnext am-fr am-btn-default">注册</a> <br />
						</div>
						<div class="am-cf">
							<input type="submit" name="" value="登 录"
								class="am-btn am-btn-primary am-btn-sm">
						</div>
					</form>
					
					<script>
						var uname = "<%=username %>";
						var pass = "<%=password %>";
						var rem = document.getElementById("remember-me");
						if(uname != "" && pass != ""){
							rem.checked = true;
						}
					</script>
				
				<div class="partner">
					<h3>合作账号</h3>
					<div class="am-btn-group">
						<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
						<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span>
						</a></li>
						<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span>
						</a></li>
					</div>
				</div>

			</div>
		</div>
	</div>


	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
					href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
					href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
					target="_blank">网页模板</a></em>
			</p>
		</div>
	</div>
</body>

</html>
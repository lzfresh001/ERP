<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>学生中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<style>
	#time{margin-left: 650px; font-size: 16px; font-weight: bold; color: white;}
</style>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/xue.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />${STU.sname } 同学,您好！
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 学校首页</a> &nbsp;&nbsp;
			<a class="button button-little bg-red" href="${pageContext.request.contextPath }/removeSession.action"><span class="icon-power-off"></span> 退出登录</a>
			<span id="time">
				<fmt:formatDate value="<%=new java.util.Date() %>" dateStyle="full"/>
			</span>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="page.jsp" target="right"><span
					class="icon-caret-right"></span>学校首页</a></li>
			<li><a href="studentinfo.jsp" target="right"><span
					class="icon-caret-right"></span>个人信息</a></li>
			<li><a href="studentbooksc.jsp" target="right"><span
					class="icon-caret-right"></span>学分明细</a></li>
			<li><a href="studentbookm.jsp" target="right"><span
					class="icon-caret-right"></span>学生必修</a></li>
			<li><a href="studentbook.jsp" target="right"><span
					class="icon-caret-right"></span>学生选修</a></li>
			<li><a href="studentbooked.jsp" target="right"><span
					class="icon-caret-right"></span>已选课程</a></li>
			<li><a href="studentpass.jsp" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>		
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>栏目管理
		</h2>
		<ul>
			<li><a href="list.jsp" target="right"><span
					class="icon-caret-right"></span>内容管理</a></li>
			<li><a href="add.jsp" target="right"><span
					class="icon-caret-right"></span>添加内容</a></li>
			<li><a href="cate.jsp" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="studentindex.jsp" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="" rameborder="0" src="page.jsp" name="right"
			width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;">
		<p>
			来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>
</body>
</html>
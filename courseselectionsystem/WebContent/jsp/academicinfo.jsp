<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>个人信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    <style>
    	.grxx{font-size: 23px}
    </style>
    
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 个人信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>学生学号：</label>
        </div>
        <div class="grxx">
        	${STU.sid }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生照片：</label>
        </div>
        <img alt="" src="images/xue.jpg">
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="grxx">
        	${STU.sname }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生性别：</label>
        </div>
         <div class="grxx">
         	${STU.ssex }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生年龄：</label>
        </div>
         <div class="grxx">
         	${STU.sage }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生总学分：</label>
        </div>
        <div class="grxx">
        	${STU.scredit }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生地址：</label>
        </div>
        <div class="grxx">
        	${STU.saddress }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生电话：</label>
        </div>
        <div class="grxx">
        	${STU.sphone }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生Email：</label>
        </div>
        <div class="grxx">
        	${STU.semail }
        </div>
      </div>
     
    </form>
  </div>
</div>
</body></html>
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
    	.grxx{font-size: 15px; font-weight: bold; padding-top: 7px;}
    </style>
    
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 个人信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>教师工号：</label>
        </div>
        <div class="grxx">
        	${TEAC.tid }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师照片：</label>
        </div>
        <img alt="" src="images/lao.jpg">
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师姓名：</label>
        </div>
        <div class="grxx">
        	${TEAC.tname }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师性别：</label>
        </div>
         <div class="grxx">
         	${TEAC.tsex }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师年龄：</label>
        </div>
         <div class="grxx">
         	${TEAC.tage }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师电话：</label>
        </div>
        <div class="grxx">
        	${TEAC.tphone }
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师Email：</label>
        </div>
        <div class="grxx">
        	${TEAC.temail }
        </div>
      </div>
     
    </form>
  </div>
</div>
</body></html>
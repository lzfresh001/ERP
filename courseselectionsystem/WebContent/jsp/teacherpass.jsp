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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<style>
	#info{margin-top: 10px}
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改登录密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath }/updateTeacTkey.action" >
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师工号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           ${TEAC.tid }
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" onblur="checktkey(this);" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
      	  <span id="info"></span>
      </div>    
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
    <script>
    	var info = document.getElementById("info");
    	// 异步请求服务器，判断原密码是否正确
    	// 1.创建神奇空间
    	var xml = new XMLHttpRequest();
    	function checktkey(input){
    		// 2.open (请求方式，请求地址)
    		console.log("原密码：" + input.value);
    		xml.open("GET","${pageContext.request.contextPath}/isRightTkey.action?tkey=" + input.value);
    		// 3.设置回调函数(接收服务端的返回信息)
    		xml.onreadystatechange = callback;
    		// 发送请求
    		xml.send();
    	}
    	
    	// 定义回调方法
    	function callback(){
    		if(xml.readyState == 4 && xml.status == 200){
    			// 获取服务端返回信息
    			var txt = xml.responseText;
    			if(txt == "false"){
    				//alert("asdf");
    				info.innerHTML = "原始密码错误！！！";
    				info.style.color = "red";
    				//alert("hjkl")
    			}else if(txt == "true"){
    				info.innerHTML = "";
    			}
    		}
    	}
    </script>
  </div>
</div>
</body></html>
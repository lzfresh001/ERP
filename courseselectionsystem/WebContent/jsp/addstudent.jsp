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
	#tidt{width: 238px; height: 40px; font-size: 15px; }
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加学生</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath }/insertStu.action">  
      <div class="form-group">
        <div class="label">
          <label>学生学号：</label>
        </div>
        <div class="field">
          <input type="text" onblur="checksid(this);" class="input w50" value="" name="sid" data-validate="required:请输入学生学号" />
          <span id="info"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>初始密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="skey" data-validate="required:请输入初始密码" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="sname" data-validate="required:请输入学生姓名" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生性别：</label>
        </div>
        <div class="field">
          <select id="tidt" type="" class="" value="" name="ssex" data-validate="" >
          <option>男</option>
          <option>女</option>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="sage" data-validate="required:请输入学生年龄" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>初始学分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="scredit" data-validate="required:请输入初始学分" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="saddress" data-validate="required:请输入学生地址" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="sphone" data-validate="required:请输入学生电话" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="semail" data-validate="required:请输入学生邮箱" />
          <div class="tips"></div>
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
		function checksid(input){
			// 2.open (请求方式，请求地址)
			//console.log("原密码：" + input.value);
			xml.open("GET","${pageContext.request.contextPath}/isRightSid.action?sid=" + input.value);
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
				if(txt == "true"){
					//alert("asdf");
					info.innerHTML = "该学号已被占用！！！";
					info.style.color = "red";
					//alert("hjkl")
				}else if(txt == "false"){
					info.innerHTML = "";
				}
			}
		}
    </script>
  </div>
</div>

</body></html>
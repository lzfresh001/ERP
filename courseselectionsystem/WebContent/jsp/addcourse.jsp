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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加课程</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath }/insertCour.action">  
      <div class="form-group">
        <div class="label">
          <label>课程编号：</label>
        </div>
        <div class="field">
          <input type="text" onblur="checkcid(this);" class="input w50" value="" name="cid" data-validate="required:请输入课程编号" />
          <span id="info"></span>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师工号：</label>
        </div>
        <div class="field">
          <select id="tidt" class="" value="" name="tid" data-validate="">
          	<option>请选择代课老师</option>
          	<c:forEach items="${ATEACS }" var="ateacs">
	          	<option>${ateacs.tid }</option>
          	</c:forEach>
          </select>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="cname" data-validate="required:请输入课程名称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="ctype" data-validate="required:请输入课程类型" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程学分：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="ccredit" data-validate="required:请输入课程学分" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>CMAX：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="cmax" data-validate="required:请输入CMAX" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="cnote" data-validate="required:请输入备注" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>CPRECID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="cprecid" data-validate="required:请输入CPRECID" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="ctime" data-validate="required:请输入课程时间" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>上课教室：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="croom" data-validate="required:请输入上课教室" />
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
		function checkcid(input){
			// 2.open (请求方式，请求地址)
			//console.log("原密码：" + input.value);
			xml.open("GET","${pageContext.request.contextPath}/isRightCid.action?cid=" + input.value);
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
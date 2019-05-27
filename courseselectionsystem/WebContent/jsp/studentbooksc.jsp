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
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 学分明细</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>课程编号</th>
        <th>课程名称</th>       
        <th>代课老师</th>
        <th>课程学分</th>
        <th>考试成绩</th>
        <th>实得学分</th>
      </tr>   
      <c:forEach items="${ELECTS }" var="elects">
	      <tr>
	        <td>${elects.cour.cid }</td>
	        <td>${elects.cour.cname }</td>
	        <td>${elects.cour.teac.tname }</td>
	        <td>${elects.cour.ccredit }</td>  
	        <td>${elects.score }</td>
	        <td>${elects.credit }</td>
	      </tr>
      </c:forEach>   
    </table>
  </div>
</form>
	<script>
		var xk = document.getElementById("xk");
		// 异步请求服务器 判断该课程是否已选
		// 1.创建神奇控件
		var xml = new XMLHttpRequest();
		function checkcourse(check,sid,cid){
			// 2.open (请求方式，请求地址)
			xml.open("GET","${pageContext.request.contextPath}/insertElect.action?sid="+sid+"&cid="+cid);
			// 3.设置回调函数(接收服务端返回的信息)
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
					xk.innerHTML = "已选择";
				}
			}
		}
	</script>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>
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
		#fy{text-align: center; margin-top: 30px; margin-bottom: 50px; font-size: 15px; }
		#px{margin-top: 20px; margin-left: 15px; font-weight: bold; }
	</style>
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head">
    	<strong class="icon-reorder"> 课程打分</strong><br/>
    	<div id="px">
    		<a href="${pageContext.request.contextPath }/giveScore.action?order=tb&tid=${TEAC.tid }&pageNum=1">成绩由高到低</a>
    		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    		<a href="${pageContext.request.contextPath }/giveScore.action?order=bt&tid=${TEAC.tid }&pageNum=1">成绩由低到高</a>
    	</div>
    </div>
    <div class="padding border-bottom">
      <ul class="search">
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>学生学号</th>
        <th>学生姓名</th>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>课程类型</th> 
        <th>课程得分</th>      
        <th>操作</th>       
      </tr>   
      <c:forEach items="${TELECT }" var="telect" begin="${BEGIN }" end="${END }" varStatus="status">
	      <tr>
	        <td>${telect.stu.sid }</td>
	        <td>${telect.stu.sname }</td>
	        <td>${telect.cour.cid }</td>
	        <td>${telect.cour.cname }</td>
	        <td>${telect.cour.ctype }</td>
	        <td><input  index="${status.count }" class="df" type="text" maxlength="2" value="${telect.score }"/></td>
	        <td><div  class="button-group"> <a class="button border-red" onclick="giveScore(this);" index="${status.count }" cid="${telect.cour.cid }" sid="${telect.stu.sid }"  ><span class=""></span> 提交</a> </div></td>
	      </tr>
      </c:forEach>   
    </table>
    <div id="fy">
    	<c:set var="OD" value="${ORDER }"></c:set>
	 	<c:if test="${PAGENUM eq 1 }">
	 		<span>首页</span>&nbsp&nbsp&nbsp<span>上一页</span>
	 	</c:if>
	 	<c:if test="${PAGENUM ne 1 }">
	 		<a href="${pageContext.request.contextPath }/giveScore.action?order=${OD }&tid=${TEAC.tid }&pageNum=1">首页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/giveScore.action?order=${OD }&tid=${TEAC.tid }&pageNum=${PAGENUM-1 }" >上一页</a>
	 	</c:if>
	 		&nbsp&nbsp&nbsp
	 	<c:if test="${PAGENUM eq PAGECOUNT }">
	 		<span>下一页</span>&nbsp&nbsp&nbsp<span>末页</span>
	 	</c:if>
	 	<c:if test="${PAGENUM ne PAGECOUNT }">
	 		<a href="${pageContext.request.contextPath }/giveScore.action?order=${OD }&tid=${TEAC.tid }&pageNum=${PAGENUM+1 }">下一页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/giveScore.action?order=${OD }&tid=${TEAC.tid }&pageNum=${PAGECOUNT }">末页</a>
	 	</c:if>
	  		&nbsp&nbsp&nbsp
	  		<span>第${PAGENUM }页 共${PAGECOUNT }页</span>
	</div>
  </div>
</form>
	<script>
		// 获取提交对应的标签
		var tj = document.getElementById("tj");
		// 获取所有打分框
		var dfs = document.getElementsByClassName("df");
		// 给所有的打分框添加事件
		for(var i=0;i<dfs.length;i++){
			var df_input = dfs[i];
			df_input.onkeydown = function(ev){
				var keyCode = ev.keyCode;
				var keyChar = String.fromCharCode(keyCode);
				if(keyChar>='0' && keyChar<='9' || keyCode==8 || keyCode==37 || keyCode==39){
					return true;
				}
				return false;
			}
			df_input.onblur = function(){
				if(this.value == "" || this.value == "0"){
					this.value = 0.0;
				}
			}
		}
		function giveScore(a){
			
			var a_index = a.getAttribute("index");
			var cid = a.getAttribute("cid");
			var sid = a.getAttribute("sid");
			var score = "";
			for(var i=0;i<dfs.length;i++){
				if(dfs[i].getAttribute("index")==a_index){
					score = dfs[i].value;
				}
			}
					
			location.href="${pageContext.request.contextPath}/updateScoreBySidCid.action?sid="+sid+"&cid="+cid+"&score="+score;		
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
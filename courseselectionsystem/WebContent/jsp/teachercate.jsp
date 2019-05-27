<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 教师列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='addteacher.jsp'"><span class="icon-plus-square-o"></span> 添加教师</button>
  </div>
  
  <table class="table table-hover text-center">
    <tr>
      <th>教师工号</th>
      <th>教师姓名</th>
      <th>教师性别</th>
      <th>教师年龄</th>
      <th>教师电话</th>
      <th>教师邮箱</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${ATEACS }" var="ateacs" begin="${BEGIN }" end="${END }" varStatus="status">
	    <tr>
	      <td>${ateacs.tid }</td>
	      <td>${ateacs.tname }</td>
	      <td>${ateacs.tsex }</td>
	      <td>${ateacs.tage }</td>
	      <td>${ateacs.tphone }</td>
	      <td>${ateacs.temail }</td>
	      <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath }/updateTeac.action?tid=${ateacs.tid }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="${pageContext.request.contextPath }/deleteTeac.action?tid=${ateacs.tid }" onclick=""><span class="icon-trash-o"></span> 删除</a> </div></td>
	    </tr>
    </c:forEach>
  </table>
</div>
<div id="fy">
 	<c:if test="${PAGENUM eq 1 }">
 		<span>首页</span>&nbsp&nbsp&nbsp<span>上一页</span>
 	</c:if>
 	<c:if test="${PAGENUM ne 1 }">
 		<a href="${pageContext.request.contextPath }/teacherFy.action?pageNum=1">首页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/teacherFy.action?pageNum=${PAGENUM-1 }" >上一页</a>
 	</c:if>
 		&nbsp&nbsp&nbsp
 	<c:if test="${PAGENUM eq PAGECOUNT }">
 		<span>下一页</span>&nbsp&nbsp&nbsp<span>末页</span>
 	</c:if>
 	<c:if test="${PAGENUM ne PAGECOUNT }">
 		<a href="${pageContext.request.contextPath }/teacherFy.action?pageNum=${PAGENUM+1 }">下一页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/teacherFy.action?pageNum=${PAGECOUNT }">末页</a>
 	</c:if>
		&nbsp&nbsp&nbsp
  		<span>第${PAGENUM }页 共${PAGECOUNT }页</span> 
  </div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		
	}
}
</script>
</body>
</html>
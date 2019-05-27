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
  <div class="panel-head"><strong class="icon-reorder"> 课程列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='addcourse.jsp'"><span class="icon-plus-square-o"></span> 添加课程</button>
  </div>
  
  <table class="table table-hover text-center">
    <tr>
      <th>课程编号</th>
      <th>代课老师</th>
      <th>课程名字</th>
      <th>课程类型</th>
      <th>课程学分</th>
      <th>CMAX</th>
      <th>CPRE</th>
      <th>课程时间</th>
      <th>上课教室</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${ACOURS }" var="acours" begin="${BEGIN }" end="${END }" varStatus="status">
	    <tr>
	      <td>${acours.cid }</td>
	      <td>${acours.teac.tname }</td>
	      <td>${acours.cname }</td>
	      <td>${acours.ctype }</td>
	      <td>${acours.ccredit }</td>
	      <td>${acours.cmax }</td>
	      <td>${acours.cprecid }</td>
	      <td>${acours.ctime }</td>
	      <td>${acours.croom }</td>
	      <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath }/updateCour.action?cid=${acours.cid }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="${pageContext.request.contextPath }/deleteCour.action?cid=${acours.cid }" onclick=""><span class="icon-trash-o"></span> 删除</a> </div></td>
	    </tr>
    </c:forEach>
  </table>
</div>
<div id="fy">
 	<c:if test="${PAGENUM eq 1 }">
 		<span>首页</span>&nbsp&nbsp&nbsp<span>上一页</span>
 	</c:if>
 	<c:if test="${PAGENUM ne 1 }">
 		<a href="${pageContext.request.contextPath }/courseFy.action?pageNum=1">首页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/courseFy.action?pageNum=${PAGENUM-1 }" >上一页</a>
 	</c:if>
 		&nbsp&nbsp&nbsp
 	<c:if test="${PAGENUM eq PAGECOUNT }">
 		<span>下一页</span>&nbsp&nbsp&nbsp<span>末页</span>
 	</c:if>
 	<c:if test="${PAGENUM ne PAGECOUNT }">
 		<a href="${pageContext.request.contextPath }/courseFy.action?pageNum=${PAGENUM+1 }">下一页</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath }/courseFy.action?pageNum=${PAGECOUNT }">末页</a>
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
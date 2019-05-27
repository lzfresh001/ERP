<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
总共 ${PageUtil.totalNum} 条&nbsp; 
每页 ${PageUtil.pageSize} 条&nbsp; 
总共 ${PageUtil.pageCount} 页 &nbsp; 
第 ${PageUtil.pageNum} 页&nbsp; 
<c:if test="${PageUtil.pageNum==1}">首页</c:if>
<c:if test="${PageUtil.pageNum!=1}"><a href="${pageContext.request.contextPath}/user/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=1">首页</a></c:if>
&nbsp;
<c:if test="${PageUtil.pageNum==1}">上一页</c:if>
<c:if test="${PageUtil.pageNum!=1}"><a href="${pageContext.request.contextPath}/user/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${PageUtil.pageNum-1}">上一页</a></c:if>
&nbsp;
<c:if test="${PageUtil.pageNum==PageUtil.pageCount}">下一页</c:if>
<c:if test="${PageUtil.pageNum!=PageUtil.pageCount}"><a href="${pageContext.request.contextPath}/user/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${PageUtil.pageNum+1}">下一页</a></c:if>
&nbsp;
<c:if test="${PageUtil.pageNum==PageUtil.pageCount}">尾页</c:if>
<c:if test="${PageUtil.pageNum!=PageUtil.pageCount}"><a href="${pageContext.request.contextPath}/user/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${PageUtil.pageCount}">尾页</a></c:if>
&nbsp;

 第<select onchange="location.href='${pageContext.request.contextPath}/user/list.action?pageSize=${PageUtil.pageSize}&pageNum='+this.value">
	<c:forEach var="selectvalue" begin="1" end="${PageUtil.pageCount}" step="1">
		<option value="${selectvalue}" ${PageUtil.pageNum eq selectvalue ?"selected='selected'":""}>
			${selectvalue}   
		</option>
	</c:forEach>
</select>
页 

每页
<select onchange="location.href='${pageContext.request.contextPath}/user/list.action?pageNum=${PageUtil.pageNum}&pageSize='+this.value">
	<option value="5" ${PageUtil.pageSize eq 5 ?"selected='selected'":""}>5</option>
	<option value="6" ${PageUtil.pageSize eq 6 ?"selected='selected'":""}>6</option>
	<option value="7" ${PageUtil.pageSize eq 7 ?"selected='selected'":""}>7</option>
	<option value="8" ${PageUtil.pageSize eq 8 ?"selected='selected'":""}>8</option>
</select>
条



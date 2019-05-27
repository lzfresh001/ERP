<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
总共 ${RolePu.totalNum} 条&nbsp; 
每页 ${RolePu.pageSize} 条&nbsp; 
总共 ${RolePu.pageCount} 页 &nbsp; 
第 ${RolePu.pageNum} 页&nbsp; 
<c:if test="${RolePu.pageNum==1}">首页</c:if>
<c:if test="${RolePu.pageNum!=1}"><a href="${pageContext.request.contextPath}/role/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=1">首页</a></c:if>
&nbsp;
<c:if test="${RolePu.pageNum==1}">上一页</c:if>
<c:if test="${RolePu.pageNum!=1}"><a href="${pageContext.request.contextPath}/role/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${RolePu.pageNum-1}">上一页</a></c:if>
&nbsp;
<c:if test="${RolePu.pageNum==RolePu.pageCount}">下一页</c:if>
<c:if test="${RolePu.pageNum!=RolePu.pageCount}"><a href="${pageContext.request.contextPath}/role/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${RolePu.pageNum+1}">下一页</a></c:if>
&nbsp;
<c:if test="${RolePu.pageNum==RolePu.pageCount}">尾页</c:if>
<c:if test="${RolePu.pageNum!=RolePu.pageCount}"><a href="${pageContext.request.contextPath}/role/list.action?userCode=${UserCode }&userType=${UserType }&userState=${UserState }&pageNum=${RolePu.pageCount}">尾页</a></c:if>
&nbsp;

 第<select onchange="location.href='${pageContext.request.contextPath}/role/list.action?${page.params}&pageNum='+this.value">
	<c:forEach var="selectvalue" begin="1" end="${RolePu.pageCount}" step="1">
		<option value="${selectvalue}" ${RolePu.pageNum eq selectvalue ?"selected='selected'":""}>
			${selectvalue}   
		</option>
	</c:forEach>
</select>
页 




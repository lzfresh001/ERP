<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="application/msexcel"%>
<%-- 
Word只需要把contentType="application/msexcel"改为contentType="application/msword" 
--%>
<%
	//独立打开excel软件   
	//response.setHeader("Content-disposition","attachment; filename=MyExcel.xls");   

	//嵌套在ie里打开excel   

	response.setHeader("Content-disposition","inline; filename=MyExcel.xls");   

	//response.setHeader("Content-disposition", "inline; filename=MyExcel.doc");
%>
<html>  

<head>  
<title>测试导出Excel和Word</title>  
</head>  
<body>  
 

<table border="2px" cellspacing="0" style="text-align: center;font-size:16px;">
                <tr>
                   <td colspan="6" style="text-align: center;font-size:20px;font-weight:800">用户信息表</td>
                </tr>
            	<tr>
                    <td>用户ID</td>
                    <td>用户名</td>
                    <td>用户状态</td>
                    <td>所在部门</td>
                    <td>用户类型</td>
                    <td>权限状态</td>
                    <td>创建时间</td>
                </tr>
                <c:forEach items="${DownloadList }" var="user">
                	<tr>
                		<td>${user.userId }</td>
                		<td>${user.userCode}</td>
                		<c:if test="${user.isDelete eq 1 }">
                			<td>删除</td>
                		</c:if>
                		<c:if test="${user.isDelete eq 0 }">
                			<td>正常</td>
                		</c:if>
                		<td>${user.userGroup.groupName }</td>
                		<td>${user.role.roleName }</td>
                		<c:if test="${user.userState eq 1 }">
                		   <td>启用</td>
                		</c:if>
                		<c:if test="${user.userState eq 0 }">
                		   <td>禁用</td>
                		</c:if>
                		<td>
                			<fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                		</td>
                	</tr>
               </c:forEach> 
            </table>
</body>  

</html>  


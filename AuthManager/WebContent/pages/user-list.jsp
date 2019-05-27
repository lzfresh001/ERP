<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>用户管理 - 用户列表</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/static/css/layout.css"
	rel="stylesheet">
<style>
	.xl{width: 150px; height: 26px; padding-bottom: 1px;}
	#fz{margin-left: 45%;}
	#fs{float:left;}
	#fx{clear: both; }
	#biaotou{font-weight: bold;}
	#qy{color: green;}
	#jy{color: red;}
	#ysh{color: green;}
	#wsh{color: red;}
   	.red{color:red; font-size: 9px;}
</style>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="navibar.jsp" />
			</div>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">用户列表</h1>
			<div class="row placeholders">
				<div id="fs">
					<button type="button" class="btn btn-warning download-query"
						data-toggle="modal" data-target="">导出数据</button>
					<!--  删除所选对话框 -->
					<div class="modal fade " id="delete-confirm-dialog" tabindex="-1"
						role="dialog" aria-labelledby="mySmallModalLabel">
						<div class="modal-dialog modal-sm" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">警告</h4>
								</div>
								<div class="modal-body">确认删除所选用户吗</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="button"
										class="btn btn-primary delete-selected-confirm">确认</button>
								</div>
							</div>
						</div>
					</div>
					<button type="button" class="btn btn-primary show-user-form"
						data-toggle="modal" data-target="#add-user-form">添加新用户</button>

					<!--添加新用户表单-->

					<div class="modal fade " id="add-user-form" tabindex="-1"
						role="dialog" aria-labelledby="mySmallModalLabel">
						<div class="modal-dialog modal-sm" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">添加新用户</h4>
								</div>
								<div class="modal-body">
									<form class="user-form">
										<div class="form-group">
											<label for="userNameInput">用户名</label> 
											<input type="text" name="userCode" value=""
												class="form-control" id="userCodeInput" placeholder="用户名">
											<label id="userCodeError"></label>
										</div>
										<div class="form-group">
											<label for="userNameInput">昵称</label> 
											<input type="text" name="nickName" value=""
												class="form-control" id="nickNameInput" placeholder="昵称">
											<label id="nickNameError"></label>
										</div>
										<div class="form-group">
											<label for="userNameInput">部门</label> 
											<select type="" name="groupId" value="" class="form-control" id="groupIdInput" required="required">
												<option disabled selected hidden >请选择部门</option>
												<c:forEach items="${UserGroupList }" var="userGroup">
													<option value="${userGroup.groupId }">${userGroup.groupName }</option>
												</c:forEach>
											</select>
											<label id="groupIdError"></label>
										</div>
										<div class="form-group">
											<label for="passwordInput">密码</label> 
											<input type="password" name="password" class="form-control" id="passwordInput"
												placeholder="密码">
											<label id="passwordError"></label>
										</div>
										<div class="form-group">
											<label for="passwordInput">确认密码</label> 
											<input type="password" name="repassword" class="form-control" id="repasswordInput"
												placeholder="确认密码">
											<label id="repasswordError"></label>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary add-user-submit" onclick="adduser()">添加
									</button>
								</div>
							</div>
						</div>
					</div>

				</div>
				
				<!-- 模糊查询 -->
				<div id="fz">
					<form action="" method="post">
						<input type="text" id="userCodeSearch" name="userName" placeholder="用户名"
							value="${UserCode }">
						<select class="xl" id="userTypeSearch">
							<option hidden value="" >请选择用户类型</option>
							<option value=""  ${UserType eq ""?"selected='selected'":""}>全部</option>
							<c:forEach items="${RoleList }" var="role">
								<option value="${role.roleId }" ${UserType eq role.roleId ?"selected='selected'":""}>${role.roleName }</option>
							</c:forEach>
						</select>
						<select class="xl" id="userStateSearch">
							<option value="" selected hidden >请选择权限状态</option>
							<option value=""  ${UserState eq ""?"selected='selected'":""}>全部</option>
							<option value="1" ${UserState eq 1 ?"selected='selected'":""}>启用</option>
							<option value="0" ${not empty UserState and UserState eq 0 ?"selected='selected'":""}>禁用</option>
						</select>
						<button type="button" class="btn btn-primary show-user-form"
							data-toggle="" data-target="" onclick="searchUser()">确定查询</button>
					</form>
				</div>
				<div id="fx" class="space-div"></div>
				<table class="table table-hover table-bordered user-list">
					<tr id="biaotou">
						<td>用户ID</td>
						<td>用户名</td>
						<td>用户昵称</td>
						<td>用户状态</td>
						<td>所在部门</td>
						<td>用户类型</td>
						<td>权限状态</td>
						<td>创建时间</td>
						<td>操作</td>
					</tr>
					<!--  <tr>
                	<td><input type="checkbox" name="userIds" value="11"/></td>
                    <td class="userid">1</td>
                    <td class="username">sisu</td>
                    <td><a href="javascript:void(0);" class="show-user-roles" >查看所有角色</a></td>
                    <td>
                    	<a class="glyphicon glyphicon-wrench show-userrole-form" aria-hidden="true" title="修改所有角色" href="javascript:void(0);" data-toggle="modal" data-target="#update-userrole-dialog"></a>
                    	<a class="glyphicon glyphicon-remove delete-this-user" aria-hidden="true" title="删除用户" href="javascript:void(0);"></a>
                    </td>
                </tr>-->
					<c:forEach items="${UserList }" var="user">
						<tr>
							<td class="userId">${user.userId }</td>
							<td class="userCode">${user.userCode}</td>
							<td class="nickName">${user.nickName}</td>
							<input class="userStateInput" type="hidden" value="${user.userState }" />
							<input class="userPwdInput" type="hidden" value="${user.userPwd }" />
							<input class="isDeleteInput" type="hidden" value="${user.isDelete }"/>
							<c:if test="${user.isDelete eq 1 }">
								<td id="wsh" class="isDelete">删除</td>
							</c:if>
							<c:if test="${user.isDelete eq 0 }">
								<td id="ysh" class="isDelete">正常</td>
							</c:if>
							<input class="groupIdInput" type="hidden" value="${user.groupId }"/>
							<td class="groupName">${user.userGroup.groupName }</td>
							<td class="username">${user.role.roleName }</td>
							<c:if test="${user.userState eq 1 }">
								<td id="qy" class="username">启用</td>
							</c:if>
							<c:if test="${user.userState eq 0 }">
								<td id="jy" class="username">禁用</td>
							</c:if>
							<td class="username">
								<fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td><a class="glyphicon glyphicon-wrench show-userrole-form" aria-hidden="true" title="修改所有角色" href="javascript:void(0);" data-toggle="modal" data-target="#update-userrole-dialog"></a> 
								<a class="glyphicon glyphicon-remove delete-this-user" aria-hidden="true" title="删除用户" href="javascript:void(0);"></a>
								<c:if test="${user.userState eq 1 }">
									<button type="button" class="btn btn-warning stopstart-user-submit" data-toggle="modal" data-target="">禁用</button>
									<button type="button" class="btn btn-primary resetPwd-user-submit" data-toggle="modal" data-target="">重置密码</button>
									<button type="button" class="btn btn-primary allotRole-user-form" data-toggle="modal" data-target="#allot-userrole-dialog">分配角色</button>
									<button type="button" class="btn btn-primary allot-userauth-submit" data-toggle="modal" data-target="">更改权限</button>
								</c:if>
								<c:if test="${user.userState eq 0 }">
									<button type="button" class="btn btn-warning stopstart-user-submit" data-toggle="modal" data-target="">启用</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<jsp:include page="standard.jsp" />
				<!--修改用户角色表单-->
				<div class="modal fade " id="update-userrole-dialog" tabindex="-1"
					role="dialog" aria-labelledby="mySmallModalLabel">
					<div class="modal-dialog modal-sm" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">修改用户</h4>
							</div>
							<div class="modal-body">
								<form class="update-userrole-form">
									<div class="form-group">
										<label for="userNameInput">用户名</label> 
										<input type="text" name="userCode" value=""
											class="form-control" id="userCodeUpdate" readonly="readonly" >
									</div>
									<div class="form-group">
										<label for="nickNameInput">用户昵称</label> 
										<input type="text" name="nickName" value=""
											class="form-control" id="nickNameUpdate" >
										<label id="nickNameUpdateError"></label>
									</div>
									<div class="form-group">
										<label for="userNameInput">用户状态</label> 
										<select type="" name="groupId" value="" class="form-control" id="isDeleteUpdate" required="required">
											<option class="iDU" value="0" >正常</option>
											<option class="iDU" value="1" >删除</option>
										</select>
									</div>
									<div class="form-group">
										<label for="userNameInput">部门</label> 
										<select type="" name="groupId" value="" class="form-control" id="groupIdUpdate" required="required">
											<c:forEach items="${UserGroupList }" var="userGroup">
												<option class="gIU" value="${userGroup.groupId }">${userGroup.groupName }</option>
											</c:forEach>
										</select>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button"
									class="btn btn-primary update-userrole-submit">提交</button>
							</div>
						</div>
					</div>
				</div>
				<!--分配角色表单-->
				<div class="modal fade " id="allot-userrole-dialog" tabindex="-1"
					role="dialog" aria-labelledby="mySmallModalLabel">
					<div class="modal-dialog modal-sm" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">分配角色</h4>
							</div>
							<div class="modal-body">
								<form class="update-userrole-form">
									<div class="form-group">
										<label for="userNameInput">用户名</label> 
										<input type="hidden" id="userId_role_hidden">
										<input type="text" name="userCode" value=""
											class="form-control" id="userCode_role" readonly="readonly" >
									</div>
									<div class="form-group">
										<label for="userNameInput">用户角色</label><br/>
										<c:forEach items="${RoleList }" var="role">
											<input type="checkbox" class="role_name_input" name="roleNameInput" id="userRoleIdInput" value="${role.roleId }">${role.roleName }<br>
										</c:forEach>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button"
									class="btn btn-primary allot-userrole-submit">提交</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 提示框 -->
	<div class="modal fade" id="op-tips-dialog" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body" id="op-tips-content"></div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script>
		// 根据光标失去判断验证用户名的格式和正确性
		var flag = true;
		$(function(){
			var flag=false;
			$("#userCodeInput").blur(function(){
				var userCode = $("#userCodeInput").val(); // 获取正在添加的用户名
				if(!!userCode){ // 用户名不能为空
					if(!/^\w{4,16}$/.test(userCode)){
						var flag=false;
						$("#userCodeError").addClass("red").html("用户名不合法！必须4-16位、数字或字母、下划线");
					}else{
						$.ajax({
							type:"post",
							dataType:"json",
							data:{
								userCode:userCode
							},
							url:"${pageContext.request.contextPath}/user/checkUserCode.action",
							success:function(data){
								if(data.isExist == "y"){
									$("#userCodeError").addClass("red").html("用户名已存在");
								}else if(data.isExist == "n"){
									$("#userCodeError").addClass("red").html("");
								}
							},
							error:function(){
								alert("系统错误！");
							}
						});
					}
				}else{
					flag=false;
					$("#userCodeError").addClass("red").html("用户名不能为空");
				}
			});
		});
		// 添加用户 并做非空非空校验
		function adduser(){
			var userCode = $("#userCodeInput").val(); // 获取用户名
			var nickName = $("#nickNameInput").val(); // 获取昵称
			var groupId = $("#groupIdInput").val(); // 获取部门
			var password = $("#passwordInput").val(); // 获取密码
			var repassword = $("#repasswordInput").val(); // 获取确认密码
			//alert("用户名："+userCode+"昵称"+nickName+"部门"+groupId+"密码"+password+"确认密码"+repassword);
			if(!/^\w{4,16}$/.test(userCode)){
				$("#userCodeError").addClass("red").html("用户名不合法！必须4-16位、数字或字母、下划线");
				return false;
			}else if(!/^\S{3,16}$/.test(nickName)){
				$("#userCodeError").removeClass("red").html("");
				$("#nickNameError").addClass("red").html("昵称不合法！必须3-16位、汉字、数字或字母、下划线");
				return false;
			}else if(groupId<1){
				$("#nickNameError").removeClass("red").html("");
				$("#groupIdError").addClass("red").html("请选择部门");
				return false;
			}else if(!/^\w{6,16}$/.test(password)){
				$("#groupIdError").removeClass("red").html("");
				$("#passwordError").addClass("red").html("密码不合法！必须6-16位、数字或字母、下划线");
				return false;
			}else if(password != repassword){
				$("#passwordError").removeClass("red").html("");
				$("#repasswordError").addClass("red").html("两次密码不一致");
				return false;
			}else if(!flag){
				$("#userCodeError").addClass("red").html("用户名不能为空");
			}else{
				$("#userCodeError").removeClass("red").html(""); 
				$("#nickNameError").removeClass("red").html("");
				$("#groupIdError").removeClass("red").html("");
				$("#passwordError").removeClass("red").html("");
				$("#repasswordError").removeClass("red").html("");
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userCode:userCode,
						nickName:nickName,
						groupId:groupId,
	                    userPwd:password
					},
					url:"${pageContext.request.contextPath}/user/addUserInfo.action",
					success:function(data){
						if(data.isAdd == "1"){
							alert("添加成功！");
							location.reload();
							//location.href="${pageContext.request.contextPath}/user/list.action";
						}else if(data.isAdd == "0"){
							alert("添加失败！");
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			}
		}
		
		// 修改用户信息前信息回显
		$(function(){
			$(".show-userrole-form").click(function(){
				var userCode=$(this).parents("tr").find(".userCode").text();//获取当前对象用户名
				var nickName=$(this).parents("tr").find(".nickName").text();//获取当前对象昵称
				var isDelete=$(this).parents("tr").find(".isDeleteInput").val();//获取当前的用户状态
				var groupId=$(this).parents("tr").find(".groupIdInput").val();//获取当前用户所在部门
				//alert(userCode + isDelete + groupId);
				$("#userCodeUpdate").val(userCode);
				$("#nickNameUpdate").val(nickName);
				var idus=document.getElementsByClassName("iDU");
				var gius=document.getElementsByClassName("gIU");
				for(var i=0;i<idus.length;i++){
					if(isDelete==idus[i].value){
						idus[i].selected=true;
					}
				}
				for(var i=0;i<gius.length;i++){
					if(groupId==gius[i].value){
						gius[i].selected=true;
					}
				}
			});
		});
		
		// 提交修改完的用户信息
		$(function(){
			$(".update-userrole-submit").click(function(){
				var userCode = $("#userCodeUpdate").val(); // 账号
				var isDelete=-1; // 用户状态
				var groupId=0; // 部门
				var idus=document.getElementsByClassName("iDU");
				var gius=document.getElementsByClassName("gIU");
				for(var i=0;i<idus.length;i++){
					if(idus[i].selected){
						isDelete=idus[i].value;
					}
				}
				for(var i=0;i<gius.length;i++){
					if(gius[i].selected){
						groupId=gius[i].value;
					}
				}
				var nickName = $("#nickNameUpdate").val();
				//alert(userCode +":"+ isDelete +":"+ groupId);
				if(!/^\S{3,16}$/.test(nickName)){
					$("#nickNameUpdateError").addClass("red").html("昵称不合法！必须3-16位、汉字、数字或字母、下划线");
					return;
				}else{
					$("#nickNameUpdateError").removeClass("red").html("")
				}
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userCode:userCode,
						nickName:nickName,
						isDelete:isDelete,
						groupId:groupId
					},
					url:"${pageContext.request.contextPath}/user/updateUserInfo.action",
					success:function(data){
						if(data.isUpdate == "1"){
							alert("修改成功！");
							location.reload(); // 刷新当前页面
						}else{
							alert("修改失败！");
						}
					},
					error:function(){
						 alert("系统错误！");
					}
				});
			});
		});
		
		// 逻辑删除用户
		$(function(){
			$(".delete-this-user").click(function(){
				var userCode=$(this).parents("tr").find(".userCode").text();//获取当前对象用户名
				//alert(userCode);
				alert("确定要删除吗？");
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userCode:userCode
					},
					url:"${pageContext.request.contextPath}/user/deleteUserInfo.action",
					success:function(data){
						if(data.isDelete == "1"){
							alert("删除成功！");
							location.reload(); // 刷新当前页面
						}else{
							alert("删除失败！");
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 禁用/启用
		$(function(){
			$(".stopstart-user-submit").click(function(){
				var userCode=$(this).parents("tr").find(".userCode").text();//获取当前对象用户名
				var userState=$(this).parents("tr").find(".userStateInput").val();//获取当前对象的权限状态
				//alert(userCode +"："+ userState);
				alert("确定要切换吗？");
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userCode:userCode,
						userState:userState
					},
					url:"${pageContext.request.contextPath}/user/startStopUser.action",
					success:function(data){
						if(data.result == "1"){
							alert("切换成功！");
							location.reload(); // 刷新当前页面
						}else{
							alert("切换失败！");
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 重置密码
		$(function(){
			$(".resetPwd-user-submit").click(function(){
				var userCode=$(this).parents("tr").find(".userCode").text();//获取当前对象用户名
				//alert(userCode);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userCode:userCode
					},
					url:"${pageContext.request.contextPath}/user/resetUserPwd.action",
					success:function(data){
						if(data.isReset == "1"){
							alert("密码已重置为：123456！");
							location.reload();
						}else{
							alert("重置失败！");
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 模糊查询用户
		function searchUser(){
			var userCodeS = $("#userCodeSearch").val(); // 获取用户名
			var userTypeS = $("#userTypeSearch").val(); // 获取用户类型
			var userStateS = $("#userStateSearch").val(); // 获取用户权限状态
			//alert(userCodeS +":"+ userTypeS +":"+ userStateS);
			if(userCodeS == "" && userTypeS == "" && userStateS == ""){
				alert("还没选择查询条件~");
				return;
			}
			//console.log(userStateS.length);
			location.href="${pageContext.request.contextPath}/user/list.action?userCode="+userCodeS+"&userType="+userTypeS+"&userState="+userStateS;
		}
		
		// 分配角色前信息回显
		$(function(){
			$(".allotRole-user-form").click(function(){
				var userId=$(this).parents("tr").find(".userId").text(); // 获取当前对象的用户id
				var userCode=$(this).parents("tr").find(".userCode").text(); // 获取当前对象的用户名
				//alert(userId +":"+ userCode);
				$("#userId_role_hidden").val(userId);
				$("#userCode_role").val(userCode);
				var roleNameChecks = $(".role_name_input"); // 将复选框全部设置为不选状态，避免缓存
				for(var i=0;i<roleNameChecks.length;i++){
					$(roleNameChecks[i]).prop("checked",false);
				}
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userId:userId
					},
					url:"${pageContext.request.contextPath}/user/queryUserRoleId.action",
					success:function(data){
						if(data.RoleIds == "0"){
							alert("该用户没有绑定角色！");
						}else{
							var checkIds = data.RoleIds.split(",");
							for(var i=0;i<roleNameChecks.length;i++){
								for(var j=0;j<checkIds.length;j++){
									if(roleNameChecks[i].value == checkIds[j]){
										$(roleNameChecks[i]).prop("checked",true);
									}
								}
							}
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 给用户分配角色
		$(function(){
			$(".allot-userrole-submit").click(function(){
				var userId = $("#userId_role_hidden").val(); // 获取当前对象的用户id
				//alert(userId);
				var roleIds = "";
				$(".role_name_input").each(function(){
					if($(this).prop("checked") == true){
						roleIds += $(this).val() + ",";
					}
				});
				//alert(roleIds);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						userId:userId,
						roleIds:roleIds
					},
					url:"${pageContext.request.contextPath}/user/allotUserRole.action",
					success:function(data){
						if(data.Del == "1"){
							alert("角色解除成功！");
							location.reload();
						}else if(data.Del == "0"){
							alert("角色解除失败！");
							location.reload();
						}else if(data.Rows == "1"){
							alert("角色分配成功！");
							location.reload();
						}else if(data.Rows == "0"){
							alert("角色分配失败！");
							location.reload();
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 用户分配权限
		$(function(){
			$(".allot-userauth-submit").click(function(){
				var userId = $(this).parents("tr").find(".userId").text(); // 获取当前对象的用户id
				//alert(userId);
				location.href="${pageContext.request.contextPath}/user/allotUserAuth.action?userId="+userId;
			});
		});
		
		// 导出数据
		$(".download-query").click(function(){
			var userCode = $("#userCodeSearch").val(); // 获取模糊查询用户名
			var userType = $("#userTypeSearch").val(); // 获取模糊查询用户类型
			var userState = $("#userStateSearch").val(); // 获取模糊查询用户权限状态
			//alert(userCode +":"+ userType +":"+ userState);
			location.href="${pageContext.request.contextPath}/user/downloadData.action?userCode="+userCode+"&userType="+userType+"&userState="+userState;
		});
	</script>
</body>
</html>

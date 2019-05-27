<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>用户管理 - 角色列表</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/static/css/layout.css"
	rel="stylesheet">
	
<style>
	.xl{width: 180px; height: 26px; padding-bottom: 1px;}
	#fz{margin-left: 58%;}
	#fs{float:left;}
	#fx{clear: both; }
	#biaotou{font-weight: bold;}
	#roleQY{color: green;}
	#roleJY{color: red;}
	.red{color: red;}
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
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">角色列表</h1>
				<div class="row placeholders">
					<div>
						<!-- <button type="button" class="btn btn-warning delete-query" data-toggle="modal" data-target="#delete-confirm-dialog">删除所选</button> -->
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
									<div class="modal-body">确认删除所选角色吗</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button"
											class="btn btn-primary delete-selected-confirm">确认</button>
									</div>
								</div>
							</div>
						</div>
						<button id="fs" type="button" class="btn btn-default show-add-form"
							data-toggle="modal" data-target="#role-form-div">添加新角色</button>
						<!--添加新角色表单-->
						<div class="modal fade " id="role-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="role-form-title">添加新角色</h4>
									</div>
									<div class="modal-body">
										<form class="role-form">
											<input type="hidden" name="roleId" class="form-control"
												id="">
											<div class="form-group">
												<label for="roleName">角色名称</label> <input type="text"
													name="roleName" class="form-control" id="roleCodeInput"
													placeholder="角色名称">
												<label id="roleCodeError"></label>
											</div>
											<div class="form-group">
												<label for="descInput">角色昵称</label> <input type="text"
													name="roleDesc" class="form-control" id="roleNameInput"
													placeholder="角色昵称">
												<label id="roleNameError"></label>
											</div>
											<div class="form-group">
												<label for="codeInput">角色描述</label> <input type="text"
													name="roleCode" class="form-control" id="roleDescInput"
													placeholder="角色描述">
												<label id="roleDescError"></label>
											</div>

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary role-submit">确定</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 模糊查询 -->
					<div id="fz">
					<form action="" method="post">
						<input type="text" id="roleCodeSearch" name="userName" placeholder="角色名"
							value="${RolePu.roleCode }">
						<select class="xl" id="roleStateSearch">
							<option value="" selected hidden >请选择角色状态</option>
							<option value=""  ${RolePu.roleState eq ""?"selected='selected'":""}>全部</option>
							<option value="1" ${RolePu.roleState eq 1 ?"selected='selected'":""}>启用</option>
							<option value="0" ${not empty RolePu.roleState and RolePu.roleState eq 0 ?"selected='selected'":""}>禁用</option>
						</select>
						<button type="button" class="btn btn-primary show-user-form"
							data-toggle="" data-target="" onclick="searchRole()">确定查询</button>
					</form>
				</div>
				<!--修改角色表单-->
				<div class="modal fade " id="update-role-form" tabindex="-1"
					role="dialog" aria-labelledby="mySmallModalLabel">
					<div class="modal-dialog modal-md" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="role-form-title">修改角色信息</h4>
							</div>
							<div class="modal-body">
								<form class="role-form">
									<input type="hidden" name="roleId" class="form-control"
										id="roleIdUpdate">
									<div class="form-group">
										<label for="roleName">角色名称</label> <input type="text" readonly
											name="roleName" class="form-control" id="roleCodeUpdate"
											placeholder="角色名称">
									</div>
									<div class="form-group">
										<label for="descInput">更改昵称</label> 
										<input type="text" name="roleDesc" class="form-control" id="roleNameUpdate" placeholder="角色昵称">
										<label id="roleNameUpdateError"></label>
									</div>
									<div class="form-group">
										<label for="codeInput">更改描述</label> <input type="text"
											name="roleCode" class="form-control" id="roleDescUpdate"
											placeholder="角色描述">
										<label id="roleDescUpdateError"></label>
									</div>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary update-role-submit">确定</button>
							</div>
						</div>
					</div>
				</div>
						
					<div id="fx" class="space-div"></div>
					<table class="table table-hover table-bordered role-list">
						<tr id="biaotou">
							<td>角色ID</td>
							<td>角色昵称</td>
							<td>角色名称</td>
							<td>角色描述</td>
							<td>角色状态</td>
							<td>操作</td>
						</tr>
						<!--  <tr>
                	<td><input type="checkbox" name="roleIds"/></td>
                    <td class="roleid">11</td>
                    <td>用户管理员</td>
                    <td>用户管理</td>
                    <td>user_admin</td>
                    <td><a href="javascript:void(0);" class="show-role-perms" >查看所有权限</a></td>
                    <td><a class="glyphicon glyphicon-pencil show-roleinfo-form" aria-hidden="true" title="修改角色信息" href="javascript:void(0);" data-toggle="modal" data-target="#role-form"></a>
                    	<a class="glyphicon glyphicon-remove delete-this-role" aria-hidden="true" title="删除角色" href="javascript:void(0);"></a></td>
                </tr>-->
						<c:forEach items="${RoleList }" var="role">
							<tr>
								<td id="roleIdShow" class="roleid">${role.roleId }</td>
								<td id="roleNameShow">${role.roleName }</td>
								<td id="roleCodeShow">${role.roleCode }</td>
								<td id="roleDescShow">${role.roleDesc }</td>
								<input type="hidden" id="roleStateShow" value="${role.roleState }"/>
								<c:if test="${role.roleState eq 1 }">
									<td id="roleQY">启用</td>
								</c:if>
								<c:if test="${role.roleState eq 0 }">
									<td id="roleJY">禁用</td>
								</c:if>
								<td>
									<a class="glyphicon glyphicon-pencil show-roleinfo-form" aria-hidden="true" title="修改角色信息" href="javascript:void(0);" data-toggle="modal" data-target="#update-role-form"></a>
								    <a class="glyphicon glyphicon-remove delete-this-role" aria-hidden="true" title="删除角色" href="javascript:void(0);"></a>
									<c:if test="${role.roleState eq 1 }">
										<button type="button" class="btn btn-primary stopstart-role-submit" data-toggle="modal" data-target="">禁用</button>
										<button type="button" class="btn btn-primary allot-roleauth-submit" data-toggle="modal" data-target="">更改权限</button>
									</c:if>
									<c:if test="${role.roleState eq 0 }">
										<button type="button" class="btn btn-primary stopstart-role-submit" data-toggle="modal" data-target="">启用</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="role-standard.jsp" />
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
		// 模糊查询角色
		function searchRole(){
			var roleCode = $("#roleCodeSearch").val(); // 获取角色名
			var roleState = $("#roleStateSearch").val(); // 获取角色状态
			//alert(roleCode +":"+ roleState);
			if(roleCode == "" && roleState == ""){
				alert("还没选择查询条件~");
				return;
			}
			location.href="${pageContext.request.contextPath}/role/list.action?roleCode="+roleCode+"&roleState="+roleState;
		}
		
		// 验证角色名称的唯一性
		$(function(){
			$("#roleCodeInput").blur(function(){
				var roleCode = $("#roleCodeInput").val(); // 获取角色名称
				if(!!roleCode){ // 角色名称不为空
					if(!/^\w{6,18}$/.test(roleCode)){
						$("#roleCodeError").addClass("red").html("角色名称不合法!必须6-18位,数字、字母或下划线");
					}else{
						//alert(roleCode);
						$.ajax({
							type:"post",
							dataType:"json",
							data:{
								roleCode:roleCode
							},
							url:"${pageContext.request.contextPath}/role/checkRoleCode.action",
							success:function(data){
								if(data.isExist == "1"){
									$("#roleCodeError").addClass("red").html("角色名称已存在！");
								}else{
									$("#roleCodeError").removeClass("red").html("");
								}
							},
							error:function(){
								alet("系统错误！");
							}
						});
					}
				}else{
					$("#roleCodeError").addClass("red").html("角色名称不能为空！");
				}
			});
		})
		
		// 添加角色
		$(function(){
			$(".role-submit").click(function(){
				var roleCode = $("#roleCodeInput").val(); // 获取角色名称
				var roleName = $("#roleNameInput").val(); // 获取角色昵称
				var roleDesc = $("#roleDescInput").val(); // 获取角色描述
				//alert(roleCode +":"+ roleName +":"+ roleDesc);
				if(!/^\w{6,18}$/.test(roleCode)){
					$("#roleCodeError").addClass("red").html("角色名称不合法!必须6-18位,数字、字母或下划线");
					return;
				}else if(!/^\S{3,18}$/.test(roleName)){
					$("#roleCodeError").removeClass("red").html("");
					$("#roleNameError").addClass("red").html("角色昵称不合法!必须3-18位,汉字、数字、字母或下划线");
					return;
				}else if(!/^\S{0,50}$/.test(roleDesc)){
					$("#roleCodeError").removeClass("red").html("");
					$("#roleNameError").removeClass("red").html("");
					$("#roleDescError").addClass("red").html("角色描述不合法!必须0-50位,汉字、数字、字母或下划线");
					return;
				}else{
					$("#roleCodeError").removeClass("red").html("");
					$("#roleNameError").removeClass("red").html("");
					$("#roleDescError").removeClass("red").html("");
					//alert(roleCode +":"+ roleName +":"+ roleDesc);
					$.ajax({
						type:"post",
						dataType:"json",
						data:{
							roleCode:roleCode,
							roleName:roleName,
							roleDesc:roleDesc
						},
						url:"${pageContext.request.contextPath}/role/addRole.action",
						success:function(data){
							if(data.isAdd == "1"){
								alert("添加成功！");
								location.reload();
							}else{
								alert("添加失败！");
								location.reload();
							}
						},
						error:function(){
							alert("系统错误！");
						}
					});
				}
			});
		})
		
		// 修改角色信息前信息回显
		$(function(){
			$(".show-roleinfo-form").click(function(){
				var roleId = $(this).parents("tr").find("#roleIdShow").text(); // 获取当前roleId
				var roleName = $(this).parents("tr").find("#roleNameShow").text(); // 获取当前roleName
				var roleCode = $(this).parents("tr").find("#roleCodeShow").text(); // 获取当前roleCode
				var roleDesc = $(this).parents("tr").find("#roleDescShow").text(); // 获取当前roleDesc
				//alert(roleId +":"+ roleName +":"+ roleCode +":"+ roleDesc);
				$("#roleIdUpdate").val(roleId);
				$("#roleNameUpdate").val(roleName);
				$("#roleCodeUpdate").val(roleCode);
				$("#roleDescUpdate").val(roleDesc);
			});
		});
		
		// 修改角色
		$(function(){
			$(".update-role-submit").click(function(){
				var roleId = $("#roleIdUpdate").val();
				var roleName = $("#roleNameUpdate").val();
				var roleCode = $("#roleCodeUpdate").val();
				var roleDesc = $("#roleDescUpdate").val();
				//alert(roleId +":"+ roleName +":"+ roleCode +":"+ roleDesc);
				if(!/^\S{3,18}$/.test(roleName)){
					$("#roleNameUpdateError").addClass("red").html("角色昵称不合法!必须3-18位,汉字、数字、字母或下划线");
					return;
				}else if(!/^\S{0,50}$/.test(roleDesc)){
					$("#roleNameUpdateError").removeClass("red").html("");
					$("#roleDescUpdateError").addClass("red").html("角色描述不合法!必须0-50位,汉字、数字、字母或下划线");
					return;
				}else{
					$("#roleNameUpdateError").removeClass("red").html("");
					$("#roleDescUpdateError").removeClass("red").html("");
					alert(roleId +":"+ roleName +":"+ roleCode +":"+ roleDesc);
					$.ajax({
						type:"post",
						dataType:"json",
						data:{
							roleId:roleId,
							roleName:roleName,
							roleCode:roleCode,
							roleDesc:roleDesc
						},
						url:"${pageContext.request.contextPath}/role/updateRole.action",
						success:function(data){
							if(data.isUpdate == "1"){
								alert("修改成功！");
								location.reload();
							}else{
								alert("修改失败！");
								location.reload();
							}
						},
						error:function(){
							alert("系统错误！");
						}
					});
				}
			});
		});
		
		// 角色 禁用/启用
		$(function(){
			$(".stopstart-role-submit").click(function(){
				var roleId = $(this).parents("tr").find("#roleIdShow").text(); // 获取当前的roleId
				var roleState = $(this).parents("tr").find("#roleStateShow").val(); // 获取当前的roleState
				//alert(roleId +":"+ roleState);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						roleId:roleId,
						roleState:roleState
					},
					url:"${pageContext.request.contextPath}/role/stopstartRole.action",
					success:function(data){
						if(data.isCut == "1"){
							alert("切换成功！");
							location.reload();
						}else{
							alert("切换失败！");
							location.reload();
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
		
		// 角色 更改权限
		$(function(){
			$(".allot-roleauth-submit").click(function(){
				var roleId = $(this).parents("tr").find("#roleIdShow").text(); // 获取当前roleId
				//alert(roleId);
				location.href="${pageContext.request.contextPath}/role/allotRoleAuth.action?roleId="+roleId;
			});
		});
		// 删除角色
		$(function(){
			$(".delete-this-role").click(function(){
				var roleId = $(this).parents("tr").find("#roleIdShow").text(); // 获取当前roleId
				//alert(roleId);
				alert("确定要删除吗？");
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						roleId:roleId
					},
					url:"${pageContext.request.contextPath}/role/deleteRole.action",
					success:function(data){
						if(data.isDel == "1"){
							alert("删除成功！");
							location.reload();
						}else{
							alert("删除失败！");
							location.reload();
						}
					},
					error:function(){
						alert("系统错误！");
					}
				});
			});
		});
	</script>
</body>
</html>

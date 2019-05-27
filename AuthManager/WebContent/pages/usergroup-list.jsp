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

<title>用户管理 - 部门列表</title>

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
				<h1 class="page-header">部门列表</h1>
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
							data-toggle="modal" data-target="#group-form-div">添加新部门</button>
						<!--添加新部门表单-->
						<div class="modal fade " id="group-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="role-form-title">添加新部门</h4>
									</div>
									<div class="modal-body">
										<form class="role-form">
											<input type="hidden" name="roleId" class="form-control"
												id="">
											<div class="form-group">
												<label for="roleName">部门名称</label> <input type="text"
													name="roleName" class="form-control" id="groupCodeInput"
													placeholder="部门名称">
												<label id="groupCodeError"></label>
											</div>
											<div class="form-group">
												<label for="descInput">部门昵称</label> <input type="text"
													name="roleDesc" class="form-control" id="groupNameInput"
													placeholder="部门昵称">
												<label id="groupNameError"></label>
											</div>
											<div class="form-group">
												<label for="codeInput">部门描述</label> <input type="text"
													name="roleCode" class="form-control" id="groupDescInput"
													placeholder="部门描述">
												<label id="groupDescError"></label>
											</div>

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary group-submit">确定</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 模糊查询 -->
					<div id="fz">
					<form action="" method="post">
						<input type="text" id="groupCodeSearch" name="userName" placeholder="部门名称"
							value="${UserGroupPu.groupCode }">
						<select class="xl" id="groupStateSearch">
							<option value="" selected hidden >请选择部门状态</option>
							<option value=""  ${UserGroupPu.groupState eq ""?"selected='selected'":""}>全部</option>
							<option value="1" ${UserGroupPu.groupState eq 1 ?"selected='selected'":""}>启用</option>
							<option value="0" ${not empty UserGroupPu.groupState and UserGroupPu.groupState eq 0 ?"selected='selected'":""}>禁用</option>
						</select>
						<button type="button" class="btn btn-primary show-user-form"
							data-toggle="" data-target="" onclick="searchGroup()">确定查询</button>
					</form>
				</div>
				<!--修改部门表单-->
				<div class="modal fade " id="update-group-form" tabindex="-1"
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
										id="groupIdUpdate">
									<div class="form-group">
										<label for="roleName">角色名称</label> <input type="text" readonly
											name="roleName" class="form-control" id="groupCodeUpdate"
											placeholder="角色名称">
									</div>
									<div class="form-group">
										<label for="descInput">更改昵称</label> 
										<input type="text" name="roleDesc" class="form-control" id="groupNameUpdate" placeholder="角色昵称">
										<label id="groupNameUpdateError"></label>
									</div>
									<div class="form-group">
										<label for="codeInput">更改描述</label> <input type="text"
											name="roleCode" class="form-control" id="groupDescUpdate"
											placeholder="角色描述">
										<label id="groupDescUpdateError"></label>
									</div>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary update-group-submit">确定</button>
							</div>
						</div>
					</div>
				</div>
				<!--分配角色表单-->
				<div class="modal fade " id="allot-grouprole-dialog" tabindex="-1"
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
										<label for="userNameInput">部门名称</label> 
										<input type="hidden" id="groupId_role_allot">
										<input type="text" name="groupCode" value=""
											class="form-control" id="groupCode_role_allot" readonly="readonly" >
									</div>
									<div class="form-group">
										<label for="userNameInput">部门角色</label><br/>
										<c:forEach items="${RoleList }" var="role">
											<input type="checkbox" class="role_name_input" name="roleNameInput" id="group_role_allot" value="${role.roleId }">${role.roleName }<br>
										</c:forEach>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button"
									class="btn btn-primary allot-grouprole-submit">提交</button>
							</div>
						</div>
					</div>
				</div>
						
					<div id="fx" class="space-div"></div>
					<table class="table table-hover table-bordered role-list">
						<tr id="biaotou">
							<td>部门ID</td>
							<td>部门昵称</td>
							<td>部门名称</td>
							<td>部门描述</td>
							<td>部门状态</td>
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
						<c:forEach items="${UserGroupList }" var="userGroup">
							<tr>
								<td id="groupIdShow" class="roleid">${userGroup.groupId }</td>
								<td id="groupNameShow">${userGroup.groupName }</td>
								<td id="groupCodeShow">${userGroup.groupCode }</td>
								<td id="groupDescShow">${userGroup.groupDesc }</td>
								<input type="hidden" id="groupStateShow" value="${userGroup.groupState }"/>
								<c:if test="${userGroup.groupState eq 1 }">
									<td id="roleQY">启用</td>
								</c:if>
								<c:if test="${userGroup.groupState eq 0 }">
									<td id="roleJY">禁用</td>
								</c:if>
								<td>
									<a class="glyphicon glyphicon-pencil show-groupinfo-form" aria-hidden="true" title="修改部门信息" href="javascript:void(0);" data-toggle="modal" data-target="#update-group-form"></a>
								    <a class="glyphicon glyphicon-remove delete-this-group" aria-hidden="true" title="删除部门" href="javascript:void(0);"></a>
									<c:if test="${userGroup.groupState eq 1 }">
										<button type="button" class="btn btn-primary stopstart-group-submit" data-toggle="modal" data-target="">禁用</button>
										<button type="button" class="btn btn-primary allotRole-group-form" data-toggle="modal" data-target="#allot-grouprole-dialog">分配角色</button>
										<button type="button" class="btn btn-primary allot-groupauth-submit" data-toggle="modal" data-target="">查看部门权限</button>
									</c:if>
									<c:if test="${userGroup.groupState eq 0 }">
										<button type="button" class="btn btn-primary stopstart-group-submit" data-toggle="modal" data-target="">启用</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
					<jsp:include page="usergroup-standard.jsp" />
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
		// 模糊查询部门
		function searchGroup(){
			var groupCode = $("#groupCodeSearch").val(); // 获取部门名称
			var groupState = $("#groupStateSearch").val(); // 获取部门状态
			//alert(groupCode +":"+ groupState);
			if(groupCode == "" && groupState == ""){
				alert("还没选择查询条件~");
				return;
			}
			location.href="${pageContext.request.contextPath}/group/list.action?groupCode="+groupCode+"&groupState="+groupState;
		}
		
		// 验证部门名称的唯一性
		$(function(){
			$("#groupCodeInput").blur(function(){
				var groupCode = $("#groupCodeInput").val(); // 获取角色名称
				if(!!groupCode){ // 角色名称不为空
					if(!/^\w{6,18}$/.test(groupCode)){
						$("#groupCodeError").addClass("red").html("部门名称不合法!必须6-18位,数字、字母或下划线");
					}else{
						//alert(groupCode);
						$.ajax({
							type:"post",
							dataType:"json",
							data:{
								groupCode:groupCode
							},
							url:"${pageContext.request.contextPath}/group/checkGroupCode.action",
							success:function(data){
								if(data.isExist == "1"){
									$("#groupCodeError").addClass("red").html("部门名称已存在！");
								}else{
									$("#groupCodeError").removeClass("red").html("");
								}
							},
							error:function(){
								alet("系统错误！");
							}
						});
					}
				}else{
					$("#groupCodeError").addClass("red").html("部门名称不能为空！");
				}
			});
		})
		
		// 添加部门
		$(function(){
			$(".group-submit").click(function(){
				var groupCode = $("#groupCodeInput").val(); // 获取部门名称
				var groupName = $("#groupNameInput").val(); // 获取部门昵称
				var groupDesc = $("#groupDescInput").val(); // 获取部门描述
				//alert(groupCode +":"+ groupName +":"+ groupDesc);
				if(!/^\w{6,18}$/.test(groupCode)){
					$("#groupCodeError").addClass("red").html("部门名称不合法!必须6-18位,数字、字母或下划线");
					return;
				}else if(!/^\S{3,18}$/.test(groupName)){
					$("#groupCodeError").removeClass("red").html("");
					$("#groupNameError").addClass("red").html("部门昵称不合法!必须3-18位,汉字、数字、字母或下划线");
					return;
				}else if(!/^\S{0,50}$/.test(groupDesc)){
					$("#groupCodeError").removeClass("red").html("");
					$("#groupNameError").removeClass("red").html("");
					$("#groupDescError").addClass("red").html("部门描述不合法!必须0-50位,汉字、数字、字母或下划线");
					return;
				}else{
					$("#groupCodeError").removeClass("red").html("");
					$("#groupNameError").removeClass("red").html("");
					$("#groupDescError").removeClass("red").html("");
					//alert(groupCode +":"+ groupName +":"+ groupDesc);
					$.ajax({
						type:"post",
						dataType:"json",
						data:{
							groupCode:groupCode,
							groupName:groupName,
							groupDesc:groupDesc
						},
						url:"${pageContext.request.contextPath}/group/addUserGroup.action",
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
		
		// 修改部门信息前信息回显
		$(function(){
			$(".show-groupinfo-form").click(function(){
				var groupId = $(this).parents("tr").find("#groupIdShow").text(); // 获取当前groupId
				var groupName = $(this).parents("tr").find("#groupNameShow").text(); // 获取当前groupName
				var groupCode = $(this).parents("tr").find("#groupCodeShow").text(); // 获取当前groupCode
				var groupDesc = $(this).parents("tr").find("#groupDescShow").text(); // 获取当前groupDesc
				//alert(groupId +":"+ groupName +":"+ groupCode +":"+ groupDesc);
				$("#groupIdUpdate").val(groupId);
				$("#groupNameUpdate").val(groupName);
				$("#groupCodeUpdate").val(groupCode);
				$("#groupDescUpdate").val(groupDesc);
			});
		});
		
		// 修改部门
		$(function(){
			$(".update-group-submit").click(function(){
				var groupId = $("#groupIdUpdate").val();
				var groupName = $("#groupNameUpdate").val();
				var groupCode = $("#groupCodeUpdate").val();
				var groupDesc = $("#groupDescUpdate").val();
				//alert(groupId +":"+ groupName +":"+ groupCode +":"+ groupDesc);
				if(!/^\S{3,18}$/.test(groupName)){
					$("#groupNameUpdateError").addClass("red").html("部门昵称不合法!必须3-18位,汉字、数字、字母或下划线");
					return;
				}else if(!/^\S{0,50}$/.test(groupDesc)){
					$("#groupNameUpdateError").removeClass("red").html("");
					$("#groupDescUpdateError").addClass("red").html("部门描述不合法!必须0-50位,汉字、数字、字母或下划线");
					return;
				}else{
					$("#groupNameUpdateError").removeClass("red").html("");
					$("#groupDescUpdateError").removeClass("red").html("");
					//alert(groupId +":"+ groupName +":"+ groupCode +":"+ groupDesc);
					$.ajax({
						type:"post",
						dataType:"json",
						data:{
							groupId:groupId,
							groupName:groupName,
							groupCode:groupCode,
							groupDesc:groupDesc
						},
						url:"${pageContext.request.contextPath}/group/updateUserGroup.action",
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
		
		// 部门 禁用/启用
		$(function(){
			$(".stopstart-group-submit").click(function(){
				var groupId = $(this).parents("tr").find("#groupIdShow").text(); // 获取当前的groupId
				var groupState = $(this).parents("tr").find("#groupStateShow").val(); // 获取当前的groupState
				//alert(groupId +":"+ groupState);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						groupId:groupId,
						groupState:groupState
					},
					url:"${pageContext.request.contextPath}/group/stopstartUserGroup.action",
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
		
		// 部门权限回显
		$(function(){
			$(".allot-groupauth-submit").click(function(){
				var groupId = $(this).parents("tr").find("#groupIdShow").text(); // 获取当前grouId
				//alert(groupId);
				location.href="${pageContext.request.contextPath}/group/allotUserGroupAuth.action?groupId="+groupId;
			});
		});
		
		// 分配角色前信息回显
		$(function(){
			$(".allotRole-group-form").click(function(){
				var groupId = $(this).parents("tr").find("#groupIdShow").text(); // 获取当前的groupId
				var groupCode = $(this).parents("tr").find("#groupCodeShow").text(); // 获取当前的groupCode
				//alert(groupId +":"+ groupCode);
				$("#groupId_role_allot").val(groupId);
				$("#groupCode_role_allot").val(groupCode);
				var roleNameChecks = $(".role_name_input"); // 将复选框全部设置为不选状态，避免缓存
				for(var i=0;i<roleNameChecks.length;i++){
					$(roleNameChecks[i]).prop("checked",false);
				}
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						groupId:groupId
					},
					url:"${pageContext.request.contextPath}/group/queryGroupRoleId.action",
					success:function(data){
						if(data.RoleIds == "0"){
							alert("该部门没有绑定角色！");
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
		
		// 给部门分配角色
		$(function(){
			$(".allot-grouprole-submit").click(function(){
				var groupId = $("#groupId_role_allot").val(); // 获取当前对象的groupId
				//alert(groupId);
				var roleIds = "";
				$(".role_name_input").each(function(){
					if($(this).prop("checked") == true){
						roleIds += $(this).val() + ",";
					}
				});
				alert(roleIds);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						groupId:groupId,
						roleIds:roleIds
					},
					url:"${pageContext.request.contextPath}/group/allotGroupRole.action",
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
		
		// 删除部门
		$(function(){
			$(".delete-this-group").click(function(){
				var groupId = $(this).parents("tr").find("#groupIdShow").text(); // 获取当前对象groupId
				//alert(groupId);
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						groupId:groupId
					},
					url:"${pageContext.request.contextPath}/group/deleteGroup.action",
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

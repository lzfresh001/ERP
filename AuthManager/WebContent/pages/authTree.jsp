<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>权限管理 - 权限列表</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/static/css/layout.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/zTree/css/demo.css"
	type="text/css">
<style type="text/css">
	.red {color: red }
	.green{color: green }
</style>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">
	var setting = {

		check : {
			enable : true, // 显示或不显示 单选框/复选框
			chkStyle : "radio", //单选框  (默认为复选框)
			radioType : "all" //对所有节点设置单选
		},

		/*   check:{//使用复选框
		   enable:true
		},   */
		//设置禁用模块列表按钮颜色
		view:{
		      fontCss:setColor
		 },
		data : {
			simpleData : {//是否使用简单数据模式
				enable : true
			}
		},
		callback : {
			onCheck : onCheck
		}
	};
	//id 标识 ，pId 父id，name 名称，open 是否展开节点， checked  是否选中    
	var zNodes = ${array}
	/*  var zNodes = [
	     { id:1, pId:0, name:"随意勾选 1", open:false},
	     { id:11, pId:1, name:"随意勾选 1-1", open:true},
	     { id:111, pId:11, name:"随意勾选 1-1-1"},
	     { id:112, pId:11, name:"随意勾选 1-1-2",checked:true},
	     { id:12, pId:1, name:"随意勾选 1-2", open:true},
	     { id:121, pId:12, name:"随意勾选 1-2-1"},
	     { id:122, pId:12, name:"随意勾选 1-2-2"},
	     { id:2, pId:0, name:"随意勾选 2",  open:false},
	     { id:21, pId:2, name:"随意勾选 2-1"},
	     { id:22, pId:2, name:"随意勾选 2-2", open:true},
	     { id:221, pId:22, name:"随意勾选 2-2-1"},
	     { id:222, pId:22, name:"随意勾选 2-2-2"},
	     { id:23, pId:2, name:"随意勾选 2-13"}
	 ]; */

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	//选中复选框后触发事件
	function onCheck(e, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo"), 
		nodes = treeObj.getCheckedNodes(true), 
		v = "";
		//获取选中的复选框的值
		for (var i = 0; i < nodes.length; i++) {
			v = nodes[i].id;
			//alert(nodes[i].id); //获取选中节点的值
			/* $("#authIdInput").val(v); */
		}
		//alert(v);
	}

	// 添加权限之前根据权限级别 显示/隐藏 相应的列
	$(document).ready(function(){
		$(".add-auth-form").click(function(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = treeObj.getCheckedNodes(true);
			var authType = ""; // authType初始化
			var parentId = ""; // parentId初始化
			var authId = ""; // authId初始化
			for(var i=0;i<nodes.length;i++){ // 获取选中的对象相应的属性值
				authType = nodes[i].type;
				parentId = nodes[i].pId;
				authId = nodes[i].id;
			}
			//alert(authId +":"+ parentId +":"+ authType);
			if(authType == ""){
				$("#add-authUrl-div").hide(); // 隐藏获取的标签(div)
				$("#add-authCode-div").hide(); 
				$("#add-authType option:eq(0)").prop("selected","selected"); // 将模块选中
				$("#add-authType option:gt(0)").prop("disabled","disabled"); // 将模块隐藏
				$("#add-parentId").val(0); // 设置父id
				$("#add-authType").val(1); // 设置auth_type
			}else if(authType == "1"){
				$("#add-authUrl-div").show(); // 展示获取的标签(div)
				$("#add-authCode-div").hide();
				$("#add-authType option:eq(1)").prop("selected","selected"); // 将模块选中
				$("#add-authType option:lt(1)").prop("disabled","disabled"); // 将模块隐藏
				$("#add-authType option:gt(1)").prop("disabled","disabled"); // 将模块隐藏
				$("#add-parentId").val(authId); // 设置父id
				$("#add-authType").val(2); // 设置auth_type
			}else if(authType == "2"){
				$("#add-authUrl-div").show(); // 展示获取的标签(div)
				$("#add-authCode-div").show();
				$("#add-authType option:eq(2)").prop("selected","selected"); // 将模块选中
				$("#add-authType option:lt(2)").prop("disabled","disabled"); // 将模块隐藏
				$("#add-parentId").val(authId); // 设置父id
				$("#add-authType").val(3); // 设置auth_type
			}else{
				$("#add-authName-div").hide();
				$("#add-authDesc-div").hide();
				$("#add-authUrl-div").hide();
				$("#add-authCode-div").hide();
				$("#add-authType-div").hide();
				$("#add-authBtn-div").hide();
				alert("没有相应操作！");
				location.reload();
			}
		});
	});
	
	// 验证权限名称的唯一性
	$(document).ready(function(){
		$("#add-authName").blur(function(){
			var authName = $("#add-authName").val();
			//alert(authName);
			if(!/^\S{4,18}$/.test(authName)){
				$("#authNameError").addClass("red").html("权限名称不合法！4-18位、中文、字母或数字、下划线");
				return;
			}
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					authName:authName
				},
				url:"${pageContext.request.contextPath}/auth/checkAuthName.action",
				success:function(data){
					if(data.cNres == "1"){
						$("#authNameError").addClass("red").html("权限名称已存在");
					}else{
						$("#authNameError").addClass("green").html("权限名称可用");
					}
				},
				error:function(){
					alert("系统错误！");
				}
			});
		});
	});
	
	// 验证权限URL的唯一性
	$(document).ready(function(){
		$("#add-authUrl").blur(function(){
			var authUrl = $("#add-authUrl").val();
			//alert(authUrl);
			if(!/^\/\w{3,18}\/\w{3,18}\.(action)$/.test(authUrl)){
				$("#authUrlError").addClass("red").html("权限Url不合法！如：/user/list.action");
				return;
			}
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					authUrl:authUrl
				},
				url:"${pageContext.request.contextPath}/auth/checkAuthUrl.action",
				success:function(data){
					if(data.cUres == "1"){
						$("#authUrlError").addClass("red").html("权限Url已存在");
					}else{
						$("#authUrlError").addClass("green").html("权限Url可用");
					}
				},
				error:function(){
					alert("系统错误！");
				}
			});
		});
	});
	
	// 验证权限code的唯一性
	$(document).ready(function(){
		$("#add-authCode").blur(function(){
			var authCode = $("#add-authCode").val();
			//alert(authCode);
			if(!/^\w{8,50}$/.test(authCode)){
				$("#authCodeError").addClass("red").html("权限Code不合法！8-15位、字母或数字、下划线");
				return;
			}
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					authCode:authCode
				},
				url:"${pageContext.request.contextPath}/auth/checkAuthCode.action",
				success:function(data){
					if(data.cCres == "1"){
						$("#authCodeError").addClass("red").html("权限Code已存在");
					}else{
						$("#authCodeError").addClass("green").html("权限Code可用");
					}
				},
				error:function(){
					alert("系统错误！");
				}
			});
		});
	});
	
	// 添加权限
	$(document).ready(function(){
		$(".add-auth-submit").click(function(){
			var parentId = $("#add-parentId").val(); // 获取父id
			var authName = $("#add-authName").val(); // 获取权限名称
			var authDesc = $("#add-authDesc").val(); // 获取权限描述
			var authUrl = $("#add-authUrl").val(); // 获取权限URL
			var authCode = $("#add-authCode").val(); // 获取权限Code
			var authType = $("#add-authType").val(); // 获取权限Type
			//alert(parentId +":"+ authName +":"+ authDesc +":"+ authUrl +":"+ authCode +":"+ authType);
			if(authType == 1){
				if(!/^\S{4,18}$/.test(authName)){
					$("#authNameError").addClass("red").html("权限名称不合法！4-18位、中文、字母或数字、下划线");
					return;
				}else if(!/^\S{0,100}$/.test(authDesc)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").addClass("red").html("权限描述不合法！0-100位、中文、字母或数字、下划线");
					return;
				}
			}else if(authType == 2){
				if(!/^\S{4,18}$/.test(authName)){
					$("#authNameError").addClass("red").html("权限名称不合法！4-18位、中文、字母或数字、下划线");
					return;
				}else if(!/^\S{0,100}$/.test(authDesc)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").addClass("red").html("权限描述不合法！0-100位、中文、字母或数字、下划线");
					return;
				}else if(!/^\/\w{3,18}\/\w{3,18}\.(action)$/.test(authUrl)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").removeClass("red").html("");
					$("#authUrlError").addClass("red").html("权限Url不合法！如：/user/list.action");
					return;
				}
			}else if(authType == 3){
				if(!/^\S{4,18}$/.test(authName)){
					$("#authNameError").addClass("red").html("权限名称不合法！4-18位、中文、字母或数字、下划线");
					return;
				}else if(!/^\S{0,100}$/.test(authDesc)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").addClass("red").html("权限描述不合法！0-100位、中文、字母或数字、下划线");
					return;
				}else if(!/^\/\w{3,18}\/\w{3,18}\.(action)$/.test(authUrl)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").removeClass("red").html("");
					$("#authUrlError").addClass("red").html("权限Url不合法！如：/user/list.action");
					return;
				}else if(!/^\w{8,50}$/.test(authCode)){
					$("#authNameError").removeClass("red").html("");
					$("#authDescError").removeClass("red").html("");
					$("#authUrlError").removeClass("red").html("");
					$("#authCodeError").addClass("red").html("权限Code不合法！8-15位、字母或数字、下划线");
					return;
				}
			}else{
				$("#authNameError").removeClass("red").html("");
				$("#authDescError").removeClass("red").html("");
				$("#authUrlError").removeClass("red").html("");
				$("#authCodeError").removeClass("red").html("");
			}
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					parentId:parentId,
					authName:authName,
					authDesc:authDesc,
					authUrl:authUrl,
					authCode:authCode,
					authType:authType
				},
				url:"${pageContext.request.contextPath}/auth/addAuthInfo.action",
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
		});
	});
	
	// 添加权限时 点击 取消 刷新页面
	$(document).ready(function(){
		$(".add-auth-cancel").click(function(){
			location.reload();
		});
	});
	
	// 修改权限之前 按照不同的等级 显示/隐藏 相应的div 及信息回显
	$(document).ready(function(){
		$(".update-auth-form").click(function(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = treeObj.getCheckedNodes(true);
			var authId = 0; // 初始化authId
			for(var i=0;i<nodes.length;i++){
				authId = nodes[i].id;
				authName = nodes[i].name;      
		        authDesc = nodes[i].desc;
		        authOrder = nodes[i].order;
			}
            if(authId == 0 ){ // 没有点击权限radio
            	$("#update-authError-div").show();
            	$("#update-authError-div").addClass("red").html("还没有选择要修改的权限！");
            	$("#update-authName-div").hide();
            	$("#update-authDesc-div").hide();
            	$("#update-authOrder-div").hide();
            	$("#updateSubmit").hide();
            }else{
            	$("#update-authError-div").hide();
            	$("#update-authName-div").show();
            	$("#update-authDesc-div").show();
            	$("#update-authOrder-div").show();
            	$("#updateSubmit").show();
	            
	            $("#update-authId").val(authId); //将选取的authId回显到复选框
	            $("#update-authName").val(authName);
	            $("#update-authDesc").val(authDesc);
	            $("#update-authOrder").val(authOrder);
            }
		});
	});
	
	// 修改权限 
	$(document).ready(function(){
		$(".update-auth-submit").click(function(){
			var authId = $("#update-authId").val(); // 获取当前修改的authId
			var authName = $("#update-authName").val(); 
			var authDesc = $("#update-authDesc").val();
			var authOrder = $("#update-authOrder").val();
			if(!/^\S{4,18}$/.test(authName)){
				$("#update-authNameError").addClass("red").html("权限名称不合法！4-18位、中文、字母或数字、下划线");
				return;
			}else if(!/^\S{0,100}$/.test(authDesc)){
				$("#update-authNameError").removeClass("red").html("");
				$("#update-authDescError").addClass("red").html("权限描述不合法！0-100位、中文、字母或数字、下划线");
				return;
			}else{
				$("#update-authNameError").removeClass("red").html("");
				$("#update-authDescError").removeClass("red").html("");
			}
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					authId:authId,
					authName:authName,
					authDesc:authDesc,
					authOrder:authOrder
				},
				url:"${pageContext.request.contextPath}/auth/updateAuthInfo.action",
				success:function(data){
					if(data.isUp == "1"){
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
 		});
	});
	
	// 修改权限时 点击 取消 刷新页面
	$(document).ready(function(){
		$(".update-auth-cancel").click(function(){
			location.reload();
		});
	});
	
	//模块、列表、按钮.....禁用用显示红色
    function setColor(treeId,node){
       return node.state==0?{color:"blue"}:{};
    }
	
	// 恢复权限
	$(document).ready(function(){
		$(".start-auth-submit").click(function(){
			var authIds = "";
			$(".auth-name-input").each(function(){
				if($(this).prop("checked") == true){
					authIds += $(this).val() + ",";
				}
			});
			//alert(authIds);
			if(null == authIds || authIds == ""){
				alert("还没有选择需要恢复的权限！");
				return;
			}else{
				$.ajax({
					type:"post",
					dataType:"json",
					data:{
						authIds:authIds
					},
					url:"${pageContext.request.contextPath}/auth/startAuth.action",
					success:function(data){
						if(data.isStart == "1"){
							alert("恢复成功！");
							location.reload();
						}else{
							alet("恢复失败！");
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
	
	// 恢复权限时 点击 取消 刷新页面
	$(document).ready(function(){
		$(".start-auth-cancel").click(function(){
			location.reload();
		});
	});
	
	// 删除权限(逻辑删除) 之前判断有没有选权限
	$(document).ready(function(){
		$(".delete-auth-form").click(function(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			nodes = treeObj.getCheckedNodes(true);
			var authId = 0; // 初始化authId
			var authType = ""; // 初始化authType
			for(var i=0;i<nodes.length;i++){
				authId = nodes[i].id;
				authType = nodes[i].type;
			}
			if(authId == 0 && authType == ""){
				$("#noSelectDelete").show();
            	$("#yesSelectDelete").hide();
            	$("#sonYesSelectDelete").hide();
            	$(".delete-auth-submit").hide();
			}else if(authType == "3"){
				$("#noSelectDelete").hide();
            	$("#yesSelectDelete").show();
            	$("#sonYesSelectDelete").hide();
            	$(".delete-auth-submit").show();
            	$("#deleteAuthId").val(authId); // 把需要删除的authId存放到隐藏域
            	$("#deleteAuthType").val(authType); // 把需要删除的authAuthType存放到隐藏域
			}else{
				$("#noSelectDelete").hide();
            	$("#yesSelectDelete").hide();
            	$("#sonYesSelectDelete").show();
            	$(".delete-auth-submit").show();
            	$("#deleteAuthId").val(authId); // 把需要删除的authId存放到隐藏域
            	$("#deleteAuthType").val(authType); // 把需要删除的authAuthType存放到隐藏域
			}
		});
	});
	
	// 删除权限时 点击 取消 刷新页面
	$(document).ready(function(){
		$(".delete-auth-cancel").click(function(){
			location.reload();
		});
	});
	
	// 删除权限(逻辑删除)
	$(document).ready(function(){
		$(".delete-auth-submit").click(function(){
			var authId = $("#deleteAuthId").val(); // 获取隐藏域的值
			var authType = $("#deleteAuthType").val();
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					authId:authId,
					authType:authType
				},
				url:"${pageContext.request.contextPath}/auth/stopAuth.action",
				success:function(data){
					if(data.isStop == "1"){
						alert("删除成功！");
						location.reload();
					}else{
						alert("权限正在使用，删除失败！");
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
</head>

<body>

	<!-- 头部 -->
	<jsp:include page="header.jsp" />

	<div class="container-fluid" style="margin-top: 30px;">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="navibar.jsp" />
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">权限列表</h1>
				<div class="row placeholders">
					<!--添加权限表单 start-->
					<div>
						<button type="button" class="btn btn-default update-auth-form"
							style="width: 100px;" data-toggle="modal"
							data-target="#update-auth-form-div">修改权限</button>
						<button type="button" style="width: 100px;"
							class="btn btn-primary" data-toggle="modal"
							data-target="#rein-auth-form-div">恢复权限</button>
						<button type="button" class="btn btn-default add-auth-form"
							data-toggle="modal" data-target="#role-form-div"
							style="width: 100px;">添加权限</button>
						<button type="button" style="width: 100px;"
							class="btn btn-primary delete-auth-form" data-toggle="modal"
							data-target="#delete-tips-dialog" >删除权限</button>
						<!-- 修改权限 -->
						<div class="modal fade " id="update-auth-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="role-form-title">修改权限</h4>
									</div>
									<div class="modal-body">
										<form class="role-form">

											<!-- <input type="text" name="authId" class="form-control" id="authIdInput"> -->
											<div id="update-authError-div" ></div>
											<div class="form-group" id="update-authName-div">
												<input type="hidden" id="update-authId" />
												<label for="authNameInput">权限名称</label> <input type="text"
													name="authName" class="form-control" id="update-authName"
													placeholder="要修改的权限名称">
												<label id="update-authNameError"></label>
											</div>
											<div class="form-group" id="update-authDesc-div">
												<label for="descInput">权限描述</label> <input type="text"
													name="authGrade" class="form-control" id="update-authDesc"
													placeholder="要修改的权限描述">
												<label id="update-authDescError"></label>
											</div>
											<div class="form-group" id="update-authOrder-div">
												<label for="descInput">权限排序</label> <input type="text"
													name="authGrade" class="form-control" id="update-authOrder"
													placeholder="要修改的权限排序">
												<label id="update-authOrderError"></label>
											</div>

										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default update-auth-cancel"
											data-dismiss="modal">取消</button>
										<button type="button" class="btn btn-primary update-auth-submit"
											id="updateSubmit">提交</button>
									</div>
								</div>
							</div>
						</div>
						<!-- 恢复权限 -->
						<div class="modal fade " id="rein-auth-form-div" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-md" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="role-form-title">恢复权限</h4>
									</div>
									<c:if test="${aZsize gt 0 }">
										<div class="modal-body">
											<div style="font-weight: bold;">请选择需要恢复的权限</div><br/>
											<c:forEach items="${AuthZero}" var="authZero">
												<div>
													<input type="checkbox" class="auth-name-input" name="authId" value="${authZero.authId}" />${authZero.authName}</div>
											</c:forEach><br/>
											<button type="button" style="width: 100px;"
												class="btn btn-primary start-auth-cancel" data-dismiss="modal">取消</button>
											<button type="button" style="width: 100px;"
												class="btn btn-primary start-auth-submit" >提交</button>
										</div>
									</c:if>
									<c:if test="${aZsize le 0 }">
										<div class="modal-body">
											<div style="font-weight: bold;">没有需要恢复的权限</div><br/>
											<button type="button" style="width: 100px;"
												class="btn btn-primary start-auth-cancel" data-dismiss="modal">取消</button>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
					<!-- 添加权限 -->
					<div class="modal fade " id="role-form-div" tabindex="-1"
						role="dialog" aria-labelledby="mySmallModalLabel">
						<div class="modal-dialog modal-md" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="role-form-title">添加权限</h4>
								</div>
								<div class="modal-body">
									<form class="role-form">

										<!-- <input type="text" name="authId" class="form-control" id="authIdInput"> -->
										<div class="form-group" id="add-authName-div">
											<input type="hidden" id="add-parentId"/>
											<label for="authNameInput1">名称</label> <input type="text"
												name="authName" class="form-control" id="add-authName"
												placeholder="权限名称">
											<label id="authNameError"></label>
										</div>
										<div class="form-group" id="add-authDesc-div">
											<label for="descInput1">权限描述</label> <input type="text"
												name="authDesc" class="form-control" id="add-authDesc"
												placeholder="权限描述">
											<label id="authDescError"></label>
										</div>
										<div class="form-group" id="add-authUrl-div">
												<label for="descInput1">权限url</label> <input type="text"
													name="authurl" class="form-control" id="add-authUrl"
													placeholder="权限url">
												<label id="authUrlError"></label>
											</div>
										<div class="form-group" id="add-authCode-div">
											<label for="codeInput1">权限code</label> <input type="text"
												name="authCode" class="form-control" id="add-authCode"
												placeholder="权限代码">
											<label id="authCodeError"></label>
										</div>
											<div class="form-group" id="add-authType-div">
												<label for="descInput1">权限等级</label><br/>
												<select id="add-authType" style="width: 100px;height: 30px">
												   <option value="1">模块</option>
												   <option value="2">列表</option>
												   <option value="3">按钮</option>
												</select>
											</div>

									</form>
								</div>
								<div class="modal-footer" id="add-authBtn-div">
									<button type="button" class="btn btn-default add-auth-cancel"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary add-auth-submit"
										id="checkon" >提交</button>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--添加权限表单 end-->
				<!-- 权限树区域 -->
				<div class="space-div"></div>

				<div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree" style="width: 1024px;"></ul>
				</div>
				<div class="space-div"></div>
			</div>
		</div>
	</div>
	</div>

	<!-- 删除提示框 -->
	<div class="modal fade" id="delete-tips-dialog" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">警告</h4>
				</div>
				<div class="modal-body" id="op-tips-content">
					<div id="noSelectDelete" style="font-weight: bold;">还没有选择要删除的权限</div>
					<div id="yesSelectDelete" style="font-weight: bold;">确定删除所选权限吗?</div>
					<div id="sonYesSelectDelete" style="font-weight: bold;">确定删除所选权限及其子权限吗?</div>
					<input type="hidden" id="deleteAuthId" />
					<input type="hidden" id="deleteAuthType" />
				</div>
				<div class="modal-footer" id="add-authBtn-div">
					<button type="button" class="btn btn-default delete-auth-cancel"
						data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary delete-auth-submit"
						id="checkon" >确定</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</body>
</html>

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
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">

       var setting = {    
        
        	/*    check:{
               enable:true, // 显示或不显示 单选框/复选框
               chkStyle: "radio",  //单选框  (默认为复选框)
               radioType: "all"   //对所有节点设置单选
            },   */
            
               check:{//使用复选框
                enable:true
            },  
            data: {
                simpleData:{//是否使用简单数据模式
                    enable:true
                }
            },
            callback:{
                onCheck:onCheck
            }           
        };
         //id 标识 ，pId 父id，name 名称，open 是否展开节点， checked  是否选中       
         var zNodes = ${array}
        /* var zNodes = [
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

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
        
        // 选中复选框后触发事件
        function onCheck(e,treeId,treeNode){
        	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        	nodes = treeObj.getCheckedNodes(true);
        	v = ""; // 定义authId
        	// 获取选中的authId
        	for(var i=0;i<nodes.length;i++){
        		v += nodes[i].id+",";
        	}
        	//alert(v);
        	$("#authIds").val(v); // 将authId放入隐藏域
        	$("#isClick").val("1"); // 判断是否点击过复选框
        }
        
        // 更改权限
        $(document).ready(function(){
        	$(".give-auth").click(function(){
        		var authIds = $("#authIds").val(); // 获取隐藏域中的authIds
        		var isClick = $("#isClick").val(); // 判断是否点击过复选框
        		var roleId = ${roleId } // 获取session中的userId
        		//alert(authIds +"::"+ isClick +"::"+ roleId);
        		if(null == authIds || authIds == "" && null == isClick || isClick == ""){
        			alert("还没有对用户权限进行操作哦~");
        			return;
        		}
        		alert(authIds +"::"+ isClick +"::"+ roleId);
        		$.ajax({
        			type:"post",
        			dataType:"json",
        			data:{
        				authIds:authIds,
        				roleId:roleId
        			},
        			url:"${pageContext.request.contextPath}/role/updateRoleAuth.action",
        			success:function(data){
        				if(data.Del == "1"){
        					alert("权限解除成功！");
        					location.reload();
        				}else if(data.Del == "0"){
        					alert("权限解除失败！");
        					location.reload();
        				}else if(data.Rows == "1"){
        					alert("权限更改成功！");
        					location.raload();
        				}else if(data.Rows == "0"){
        					alert("权限更改失败！");
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
				<h1 class="page-header">角色权限列表</h1>
				<div class="row placeholders">
					<button type="button" class="btn btn-default give-auth" style="width:110px;">确认更改权限</button>
					<a href="${pageContext.request.contextPath}/role/list.action">
						<button type="button" style="width:110px;" class="btn btn-primary">返回角色列表</button>
					</a>
                    <!--  将选择后的authId存隐藏域中-->
					<input type="hidden" id="authIds">
					<input type="hidden" id="isClick">
					<!--权限数区域-->
					<div class="space-div"></div>

					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree" style="width:1024px;"></ul>
					</div>
					<div class="space-div"></div>
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
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</body>
</html>

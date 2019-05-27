<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>系统首页</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.6/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.6/themes/icon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/locale/easyui-lang-zh_CN.js"></script>
		<style type="text/css">
			#userMsg{padding-left: 780px; padding-bottom: 8px; font-size: 17px;font-weight: bold;}
			a:link{color: black;} 
			a:visited{color: black;}
			a:hover{color: red;}
			a{text-decoration: none;}
			#syBox{background-image:url("${pageContext.request.contextPath}/images/sj.jpg");
				  width: 100%; height: 80%; }
		</style>
	</head>
	 <body class="easyui-layout">
	 	<div region="north" style="height: 68px;"> 
	    	<div style="padding: 0px;margin: 0px;background-color: #E0ECFF;">
				<table>
				     <tr>
				         <td><img alt="北邮在线" src="${pageContext.request.contextPath}/images/mainlogo.png"></td>
				          <td id="userMsg" valign="bottom">欢迎：${currentUser.uname }『${currentUserRole.roleName}』</td>
				    </tr>
				</table>
          </div>
	 		
		</div> 
		<div region="west" style="width: 200px;padding: 5px;" title="导航菜单" split="true">
			<ul id="tree" class="easyui-tree"></ul>
		</div>
		<div region="center">
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
				<div title="首页" data-options="iconCls:'icon-home'">
					<div id="syBox" align="center" style="padding-top: 100px;">
						<font color="red" size="10"></font>
					</div>
				</div>
			</div>
		</div>
		<div region="south" style="height: 25px;padding: 5px;" align="center">
			版权所有 北邮在线<a href="http://www.xianyazhuo.com" target="_blank">http://www.xianyazhuo.com</a>
		</div>
	</body>
	<script type="text/javascript">
		// 查询当前用户的菜单树(权限)
		$(function(){
			$("#tree").tree({
				lines:true,
				url:"${pageContext.request.contextPath}/auth/list.do",
				onLoadSuccess:function(){
					$("#tree").tree("expandAll"); // collapseAll 合闭状态   expandAll 展开状态
				},
				onClick:function(node){
					if(node.id==54){
						logout();
					}else if(node.id==53){
						openPasswordModifyDialog();
					}else if(node.attributes.authPath){
						openTab(node);
					}
				}
			});
		});
		
		// 添加Tab
		function openTab(node){
			if($("#tabs").tabs("exists",node.text)){
				$("#tabs").tabs("select",node.text);
			}else{
				var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src=${pageContext.request.contextPath}/html/"+node.attributes.authPath+"></iframe>"
				$("#tabs").tabs("add",{
					title:node.text,
					iconCls:node.iconCls,
					closable:true,
					content:content
				});
			}
		}
		
		// 安全退出
		function logout(){
			$.messager.confirm("退出提示","您确认要退出吗？",function(r){
				if(r){
					location.href="${pageContext.request.contextPath}/user/logout.do";
				}
			});
		}
		
	</script>
</html>
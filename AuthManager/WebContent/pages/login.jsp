<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录页面</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
   <style type="text/css">
   	.red{color:red}
   </style>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.cookie.js"></script>
   
   <script>
   		// 记住密码
        $(document).ready(function(){
            var rem = $.cookie('remember');
            if(rem){
                $("#remember").prop("checked",true);
                $("#inputEmail").val($.cookie("userName"));
                $("#inputPassword").val($.cookie("userPassword"));
            }
        });
   		// 回车登录
        $(function(){
        	$(this).keyup(function(ev){
        		if(ev.keyCode == 13){ // 13回车键
        			login();
        		}
        	});
        });
    </script>
 
  </head>
  
  <body>
    	<form class="form-signin" method="post" action="##">
			<h3 class="form-signin-heading">请登录</h3>
			<label for="inputEmail" class="sr-only">用户名</label>
			<input type="text" id="inputEmail" class="form-control class123456" placeholder="用户名"  name="username" maxlength="20" value="">
			 <label id="userNameError"></label>
			<label for="inputPassword" class="sr-only">密码</label>
			<input type="password"  id="inputPassword" class="form-control" placeholder="密码" name="password" maxlength="10" value="">
		   	<label id="userPassError"></label><br/>
			<label for="inputEmail" class="sr-only" >验证码</label>
			<input type="text" id="inputCode" placeholder="验证码" name="code" tabindex="6" style="width:80px;text-transform:uppercase;ime-mode:disabled" maxlength="4">
			<img id="vdimgck"  src="${pageContext.request.contextPath}/pages/image.jsp?d="+new Date()+"" alt="看不清？点击更换" align="absmiddle" width="75" style="cursor:pointer" onclick="this.src=this.src+'?'" />
			<br/>
			<label id="userVcodeError"></label>
			<!-- <label id="error_html" style="font-size:18px;"></label> -->
		   <div class="checkbox" id="checkboxid" >
			  <label>
				<input type="checkbox" id="remember" name="rememberMe" > 记住我&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </label>
			</div>
			<%-- <p class="bg-warning">${error}</p> --%>
			<button class="btn btn-lg btn-primary btn-block" type="button" style="cursor:pointer" onclick="return login()" >登录</button>
     </form>

<script type="text/javascript">	
   // 标识验证码的正确性
   /*  var flag=false;
     	
	$(document).ready(function(){
		$("#inputCode").blur(function (){	
		// 用户输入的验证码 
		var vCode=$("#inputCode").val();
	 	 if(!!vCode && vCode.length == 4){
	 		 // 代码走到这 说明验证码不为空
	 	 	$.ajax({  
	                type:"POST", //请求方式 
	                url:"${pageContext.request.contextPath}/validCode.action",
	                dataType:"json", //返回数据类型
	                data:{//请求参数
	               		vCode:vCode
	                },
	                success:function(data){ //请求成功后
	                	if(data.msg=='1'){
	                      	flag=true;
                      	 	alert("验证码正确！");
                      	 	$("#error_html").removeClass("red").html("");
                       }else{
                        	alert("验证码不正确！");
                        	$("#error_html").addClass("red").html("验证码不正确!");
                        	flag=false;
                       }
	                },
	                error:function (){
	                	alert("系统出现异常！");
	                }    
	         }); 
         }else{
           flag=false;
           alert("验证码不能为空或者长度不够，必须为4位")
         }
	} );
	
	}); */
	
	// 验证登录信息和验证码
	function login(){
		var userName=$("#inputEmail").val();// 获取用户名
		var psw=$("#inputPassword").val(); // 获取密码
		var vCode=$("#inputCode").val(); // 获取验证码
			if(!/^\w{4,16}$/.test(userName)){
				//alert("用户名不合法! 4-16位，字母，数字，下划线");
				$("#userNameError").addClass("red").text("用户名不合法! 4-16位，字母，数字，下划线");
				return;
			}else if(psw.length>16 || psw.length<6){
			   // alert("密码不合法! 6-16位，字母，数字");
			   $("#userNameError").removeClass("red").text("");
			   $("#userPassError").addClass("red").text("密码不合法! 6-16位，字母，数字");
				return;
			}else if(vCode.length<4){
				// alert("验证码不正确！");
				$("#userNameError").removeClass("red").text("");
				$("#userPassError").removeClass("red").text("");
				$("#userVcodeError").addClass("red").text("验证码不合法！4位数字");
				return;
			}else{
				$("#userNameError").removeClass("red").text("");
				$("#userPassError").removeClass("red").text("");
				$("#userVcodeError").removeClass("red").text("");
				// 账号 密码 验证码基本规则验证通过
				$.ajax({  
	                type:"POST",  
	                url:"${pageContext.request.contextPath}/login.action",
	                dataType:"json",  
	                data:{
	                	vCode:vCode,
	               		userPwd:psw,
	                	userCode:userName
	                },  
	                success:function(data){ 
	                  if( data.res=="2"){
		                 //登录成功
		                 //var chc=$("input[name='rememberMe']:checked"); 
		                  //判断checkbox是否被选中
		                  if($("#remember").prop("checked")){
		                  	$.cookie("remember","true",{expires:7});
		                    $.cookie("userName", userName,{expires:7});
		                    $.cookie("userPassword", psw,{expires:7});
		                   // $.cookie("token", token);
		                  }else{
		                  	//清空
		                  	$.cookie("remember","false",{expires:-1});
		                  	$.cookie("userName","",{expires:-1});
		                  	$.cookie("userPassword","",{expires:-1});
		                   }
	                 	  window.location.href="${pageContext.request.contextPath}/user/index.action";
	                  }else if(data.res=="0"){
	                  	alert("账号或密码不正确！");
	                  	return;
	                  }else if(data.res=="1"){
	                  	alert("账号状态异常！！");
	                  	return;
	                  }else if(data.res=="3"){
	                	  alert("验证码不正确！");
	                	  return;
	                  }
	                },
	                error:function (){
	                   alert("系统错误！");
	                }   
         });
	}

	}
	
</script>    
    
    
</body>
</html>

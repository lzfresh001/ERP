<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script> 
    <script>
    	if(top.location!=self.location){top.location=self.location}
    </script> 
    <style>
    	#tt{margin-top: 100px;padding-bottom: 40px;text-align: center;font-size: 30px}
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <h1 id="tt">欢 迎 进 入 西 大 选 课 系 统</h1>    
            <form action="${pageContext.request.contextPath }/isRightUser.action" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>登录入口</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="name" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" id="code" name="code" maxLength="4" onblur="judgeCode()" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="verification.jsp?d=" + new Date() alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">  
                                                   
                        </div>
                    </div><br/>
                    <input type="radio" name="identity" value="x" />学生 &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="identity" value="l" />教师 &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="identity" value="j" />教务处 &nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form> 
            
            <script>
				var http = new XMLHttpRequest();
				var input_code = document.getElementById("code");
				// 判断验证码的正确性
				function judgeCode(){
					// 用户输入的验证码
					//var userCode = input_code.value;
					// 服务端的验证码
					// var serverCode = "${CODE}";
					//console.log("用户名输入的验证码:" + userCode);
					//console.log("服务端的验证码:" + serverCode);
					// 发送异步请求，获取服务端最新的验证码
					http.open("GET","${pageContext.request.contextPath }/queryCode.action");
					http.onreadystatechange = callback;
					http.send();
				}
				
				function callback(){
					if(http.readyState == 4 && http.status == 200){
						var userCode = input_code.value;
						var serverCode = http.responseText;
						console.log("用户名输入的验证码:" + userCode);
						console.log("服务端的验证码:" + serverCode);
						if(userCode.toUpperCase()!=serverCode){
							alert("验证码错误");
						}
					}
				}
			</script>         
        </div>
    </div>
</div>

</body>
</html>
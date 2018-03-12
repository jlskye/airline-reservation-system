<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<!-- Custom Theme files -->
<link href="<%=basePath%>css/sty.css" rel="stylesheet" type="text/css" media="all" />
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script>
function checkusername() {
	var phone = document.getElementById("user_phone").value;
	$.ajax({
		url:"signIn/checkExist",
		data:{'user_phone':phone},
		success:function (resp) {
            var resultname=resp['user_phone']
			console.log(resultname)
            if (phone.trim().length == 0) {
                document.getElementById("mission1").innerHTML = "<font color='red'>用户名不可为空</font>";
                return false;
            } else {
                if(resultname==null){
                    document.getElementById("mission1").innerHTML = "<font color='red'>用户不存在</font>";
                    return false;
                }else{
                    document.getElementById("mission1").innerHTML = "<font color='red'></font>";
                    return true;
				}
            }
        }
	})
};

function checkpassword() {
	var password = document.getElementById("user_password").value;
	if (password.trim().length == 0) {
		document.getElementById("mission2").innerHTML = "<font color='red'>密码不可为空</font>";
		return false;
	} else {
		document.getElementById("mission2").innerHTML = "<font color='red'></font>"
		return true;
	}
};

function checksubmit() {
	if (checkusername()==false || checkpassword() == false) {
		document.getElementById("submit").disabled = true;
	} else {
		document.getElementById("submit").disabled = false;
	}
};

</script>
</head>
<body>
	<div class="login">
		<h2>欢迎使用订票系统</h2>
		<div class="login-top">
			<h1>请先登录</h1>
			<form action="<%=basePath%>signIn" method = "post">
			账号(电话）：<input type="text" name="user_phone" id="user_phone" onblur="checkusername()" onkeyup="checksubmit()">
			<span id="mission1"></span> <br>
			密码：<input type="password" name="user_password" id="user_password" onblur="checkpassword()" onkeyup="checksubmit()">
			<span id="mission2"></span> <br>
			<div class="forgot">
				 <input type="submit" id="submit" value="登录">
			</div>
			</form>
		</div>
		<div class="login-bottom">
			<h3>
				新用户&nbsp;<a href="<%=basePath%>signUp">注册</a>
			</h3>
		</div>
	</div>
</body>
</html>

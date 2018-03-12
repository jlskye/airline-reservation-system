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
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
	</script>
<link href="<%=basePath%>css/sty.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="<%=basePath%>css/buttons.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script>

	function validate() {
		var pw1 = document.getElementById("pw1").value;
		var pw2 = document.getElementById("pw2").value;
		if (pw1 == pw2) {
			document.getElementById("tishi").innerHTML = "<font color='green'>两次密码相同</font>";
			return true;
		} else {
			document.getElementById("tishi").innerHTML = "<font color='red'>两次密码不同</font>";
			return false;
		}

	};

	function checkemail() {
		var email = document.getElementById("email").value;
		if (email.trim().length == 0) {
			document.getElementById("mission2").innerHTML = "<font color='red'>邮箱不可为空</font>";
			return false;
		} else {
			document.getElementById("mission2").innerHTML = "<font color='green'>邮箱可以使用</font>";
			return true;
		}
	};
	
	function checkpassword() {
		var email = document.getElementById("pw1").value;
		if (email.trim().length == 0) {
			document.getElementById("mission5").innerHTML = "<font color='red'>密码不可为空</font>";
			return false;
		} else {
			document.getElementById("mission5").innerHTML = "<font color='green'>密码可以使用</font>";
			return true;
		}
	};

	function checkname() {
		var username = document.getElementById("username").value;
		if (username.trim().length == 0) {
			document.getElementById("mission").innerHTML = "<font color='red'>姓名不可为空</font>";
			return false;
		} else {
			document.getElementById("mission").innerHTML = "<font color='green'>姓名可以使用</font>";
			return true;
		}
	};

	function checkcard() {
		var card = document.getElementById("card").value;
		if (card.trim().length == 0) {
			document.getElementById("mission3").innerHTML = "<font color='red'>身份证号不可为空</font>";
			return false;
		} else if (card.trim().length != 18) {
			document.getElementById("mission3").innerHTML = "<font color='red'>身份证号长度不符</font>";
			return false;
		} else {
			document.getElementById("mission3").innerHTML = "<font color='green'>身份证可以使用</font>";
			return true;
		}
	};

	function checkphone() {
		var phone = document.getElementById("phone").value;
		$.ajax({
            url:'signUp/checkExist',
            data:{'user_phone':phone},
            success:function (resp) {
                console.log(resp)
                var resultname=resp['user_phone']
                if(resultname!=null){

                    document.getElementById("mission4").innerHTML = "<font color='red'>电话已被注册</font>";
                    console.log(resp);
                    // return false;
				}else{
                    if (phone.trim().length == 0) {
                        document.getElementById("mission4").innerHTML = "<font color='red'>电话不可为空</font>";
                        // return false;
                    } else if (phone.trim().length != 11){
                        document.getElementById("mission4").innerHTML = "<font color='red'>电话长度不符</font>";
                        // return false;
                    }
                    else {
                        document.getElementById("mission4").innerHTML = "<font color='green'>电话可以使用</font>";
                        // return true;
                    }

				}
            }
		})
	};
	
    function myCheck()
    {
    	var card = document.getElementById("card").value;
    	var phone = document.getElementById("phone").value;
       if(document.form1.elements[0].value=="")
       {
         alert("用户名不能为空");
         document.form1.elements[0].focus();
         return false;
       }else if (document.form1.elements[1].value==""){
    	   alert("密码不能为空");
           document.form1.elements[1].focus();
           return false;
       }else if (document.form1.elements[1].value != document.form1.elements[2].value){
    	   alert("两次密码不同");
           document.form1.elements[2].focus();
           return false;
       }else if (document.form1.elements[3].value==""){
    	   alert("邮箱不能为空");
           document.form1.elements[3].focus();
           return false;
       }else if (document.form1.elements[4].value==""){
    	   alert("身份证号不能为空");
           document.form1.elements[4].focus();
           return false;
       }else if (card.trim().length != 18){
    	   alert("身份证号长度不符");
           document.form1.elements[4].focus();
           return false;
       }else if (document.form1.elements[5].value==""){
        	   alert("电话不能为空");
               document.form1.elements[5].focus();
               return false;
       }else if (phone.trim().length != 11){
    	   alert("电话长度不符");
           document.form1.elements[5].focus();
           return false;
       }else{
    	   return true;
       }


    }

</script>
</head>
<body>
	<div class="login">
		<h2>欢迎使用</h2>
		<div class="login-top">
			<h1>用户注册</h1>
			<form action="<%=basePath%>signUp/save" method="post" name="form1" onSubmit="return myCheck()">
				电话：<input type="text" name="user_phone" onblur="checkphone()" id="phone">
				<span id="mission4"></span><br>
				用户名：<input type="text" name="user_name" onblur="checkname()" id="username">
				<span id="mission"></span> <br>
				密码：<input type="password" name="user_password" id="pw1" onblur="checkpassword()">
					<span id="mission5"></span> <br>
					再次输入密码：<input type="password" onkeyup="validate()" id="pw2"> 
					<span id="tishi"></span> <br> 
					邮箱：<input type="text" name="user_email" onblur="checkemail()" id="email"> 
					<span id="mission2"></span><br> 
					身份证号<input type="text" name="user_id" onblur="checkcard()" id="id">
					<span id="mission3"></span><br>
				<div class="forgot">
					<button type="submit" id="submit"
						class="button button-3d button-primary button-rounded">提交
					</button>
				</div>
			</form>
		</div>
		<div class="login-bottom">
			<h3>
				<a href="<%=basePath%>index.jsp">取消</a>
			</h3>
		</div>
	</div>
</body>

</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.register-form-div {
			position: fixed;
			top: 40%;
			left: auto;
		}

		input {
			width: 50%;
			height: 100px;
			font-size: 80px;
			background-color: ghostwhite;
		}
	</style>
</head>
<body>
<div align="center" class="register-form-div">

	<form action="register" method="post">
		<input name="username" placeholder="用户名"><br>
		<input name="password" placeholder="密码"><br>${msg}<br>
		<input type="submit" value="注册">
		<br>
		<a href="login.jsp"><h1>有账号，去登录</h1></a>
	</form>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style type="text/css">
		input {
			width: 50%;
			height: 100px;
			font-size: 80px;
			background-color: ghostwhite;
		}
	</style>

</head>
<body>
<div align="center" style="background-color: #dff3ff">
	<form action="login" method="post" style="font-size: 50px">
		账号：<input name="username" placeholder="Address"><br/>
		密码：<input name="password" placeholder="Password"><br/>
		${msg}<br>
			<input type="submit" value="游客|登录"><br/>
		<a href="register.jsp">没有账号，去注册</a>
	</form>

</div>

</body>
</html>
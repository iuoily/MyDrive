<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<input name="username"><br>
		<input name="password"><br>${msg}<br>
		<input type="submit" value="注册"><a href="login.jsp">有账号，去登录</a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <p>默认账号：test<br/> 密码：123</p>
	<form action="login" method="post">
		账号：<input name="username"><p>
		密码：<input name="password"><p>
		${msg}<br>
		<input type="submit" value="登录">
		<a href="register.jsp">没有账号，去注册</a>
	</form>
</body>
</html>
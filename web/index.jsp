<%@ page import="java.io.File" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <%
		String user = (String) session.getAttribute("user");
		File[] files = (File[]) session.getAttribute("files");
		System.out.println();
	%>
    <h1>登录成功，欢迎<%=user%>&nbsp;&nbsp;<a href="login.jsp">退出登录</a></h1>
	<hr>
	<h2>上传文件</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="开始上传">
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>文件名称</th>
			<th>文件大小</th>
            <th>上传时间</th>
			<th>操作</th>
		</tr>
		<%
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            int len = 0;
			for (File file : files) {
				out.println("<tr>");
				out.println("<td>" + file.getName() + "</td>");
				out.println("<td>" + ((len = (int) file.length())/1024 < 1024 ? len/1024+ "KB" : len/1024/1024 + "MB") + "</td>");
                out.println("<td>" + sdf.format(new Date(file.lastModified())) + "</td>");
				out.println("<td><a href='download?fname=" + file.getName() + "'>下载</a></td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>
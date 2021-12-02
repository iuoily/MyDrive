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
	<style type="text/css">
		#header {
			padding: 15px;
			background-color: rgb(48,54,67);
			width: 100%;
			text-align: end;
			color: white;
			font-size: 30px;
		}

		#main-view {
			margin-left: 100px;
			margin-right: 100px;
		}

		#table-files {
			width: 100%;
			table-layout: fixed;
			font-size: x-large;
		}

		td {
			border-top: 1px solid grey;

			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
		}
		
		.input-upload {
			width: 100%;
			height: auto;
			font-size: 50px
		}

		.input-submint {
			width: 200px;
			height: 200px;
			font-size: 40px;
			background-color: green;
			color: white;
			border: none;
			border-radius: 50%;
			margin-left: 38%;
		}

		.head-img {
			width: 100px;
			border-radius: 50%;
		}
	</style>
</head>
<body style="margin: 0">
    <%
		String user = (String) session.getAttribute("user");
		File[] files = (File[]) session.getAttribute("files");
		Integer msg = (Integer) session.getAttribute("msg");
		System.out.println();
	%>

<div id="header"><a href="#"><img src="static/image/head.jpg" alt="" class="head-img"></a><a href="login.jsp">退出登录</a></div>

	<div id="main-view">
		<hr style="height:5px;border:none;border-top:5px groove #84b3a4;">
			<form action="upload" method="post" enctype="multipart/form-data">
				<input type="file" name="file" class="input-upload" multiple="50"><br>
	<hr style="height:5px;border:none;border-top:5px groove #165b5d;">
				<input type="submit" value="开始上传" class="input-submint">
			</form>
	<hr style="height:5px;border:none;border-top:5px groove #145d30;">
			<table align="center" id="table-files">
				<caption style="font-size: xx-large"><%=user%>用户的文件列表(<%=(files.length)%>)</caption>
				<%
					if ("1" == session.getAttribute("DelStatus")) {
						out.println(("删除成功！"));
						session.removeAttribute("msg");
					}
					else if ("0" == session.getAttribute("DelStatus")) {
						out.println(("文件不存在！"));
						session.removeAttribute("msg");
					} else if ("-1" == session.getAttribute("DelStatus")) {
						out.println(("删除失败！"));
						session.removeAttribute("msg");
					} else if (null == session.getAttribute("DelStatus")) {
						out.println("111");
					}

				%>
				<tbody align="center">
				<tr style="font-size: x-large;">
					<th width="40%">文件名称</th>
            		<th width="170px">上传时间</th>
					<th width="70px">大小</th>
					<th width="110px">操作</th>

				</tr>
				<%
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
						int len = 0;
						for (File file : files) {
							out.println("<tr>");
							out.println("<td>" + file.getName() + "</td>");
							out.println("<td>" + sdf.format(new Date(file.lastModified())) + "</td>");
							out.println("<td>" + ((len = (int) file.length()) < 1024 ? len + "b" : (len/1024 < 1024 ? len/1024 + "KB" : len/1024/1024 + "MB")) + "</td>");
							out.println("<td><a href='download?fname=" + file.getName() + "'><img src=\"static/image/download_icon.png\"></a>");
							out.println("&nbsp;<a href='delete?fname=" + file.getName() + "'><img src=\"static/image/delete_icon.png\"></a></td>");
							out.println("</tr>");
						}

					} catch (Exception e) {
						System.out.println(e);
					}
				%>
				</tbody>
			</table>
	</div>
</body>
</html>

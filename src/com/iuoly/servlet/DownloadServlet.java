package com.iuoly.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
	
	String path = "E:\\FileCenter\\";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String fname = req.getParameter("fname");
		String user = (String) session.getAttribute("user");
		
		ServletOutputStream os = res.getOutputStream();
		FileInputStream in = new FileInputStream(path + user + "\\" + fname);
		
		res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fname,"UTF-8"));
		byte[] data = new byte[1024];
		int length = 0;
		while ( (length = in.read(data))!=-1 ) {
			os.write(data, 0, length);
		}
		os.close();
		in.close();
	}
}

package com.iuoly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.iuoly.dao.UserDao;
import com.iuoly.entity.User;
import com.iuoly.utils.MybatisUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();

		if ("".equals(username) && "".equals(password)) {
			System.out.println("用户名户密码为空");
//			req.setAttribute("msg", "请输入用户名和密码！");
//			req.getRequestDispatcher("login.jsp").forward(req, res);
//			return;
			username = "test";
			password = "123";
		}


		SqlSession session = MybatisUtils.getSession();
		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.getUserByName(username);
		
		//如果根据用户名查询用户，如果用户对象为null，表示用户不存在
		if (user==null) {
			System.out.println("用户名不存在");
			req.setAttribute("msg", "用户名不存在");
			//转发到登录页面
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}
		if (!user.getPassword().equals(password)){
			System.out.println("密码错误");
			req.setAttribute("msg", "密码错误");
			//转发到登录页面
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}
		System.out.println("登录成功");
        HttpSession session1 = req.getSession();
        session1.setAttribute("user",username);
		// 转发给FileList加载数据
//		req.getRequestDispatcher("FileList").forward(req,res);
		res.sendRedirect("FileList");

	}
}

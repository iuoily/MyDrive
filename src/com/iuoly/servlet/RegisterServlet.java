package com.iuoly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.iuoly.dao.UserDao;
import com.iuoly.entity.User;
import com.iuoly.utils.MybatisUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();

		if ("".equals(username) || "".equals(password)) {
			System.out.println("用户名户密码为空，不能注册");
			req.setAttribute("msg", "用户名户密码为空，不能注册");
			req.getRequestDispatcher("register.jsp").forward(req, res);
			return;
		}
		
		
		SqlSession session = MybatisUtils.getSession();
		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.getUserByName(username);
		
		//如果数据中查到了这个账号，说明已经存在，不能重复注册
		if (user!=null) {
			System.out.println("账号已存在，不能注册");
			req.setAttribute("msg", "账号已存在，不能注册");
			req.getRequestDispatcher("register.jsp").forward(req, res);
			return;
		}
		
		//插入数据库
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDao.save(user);
		session.commit();
		
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
}

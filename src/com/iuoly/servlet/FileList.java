package com.iuoly.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author iuoly
 */
@WebServlet(value = "/FileList")
public class FileList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

        String path = "E:/FileCenter/";
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("user");
        File f = new File(path + username);
        System.out.println(f);
        File[] files = f.listFiles();

        session.setAttribute("files", files);

        //转发到首页
        resp.sendRedirect("index.jsp");

        System.out.println("getfilelist...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

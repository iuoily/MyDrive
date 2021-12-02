package com.iuoly.servlet;

import java.io.File;
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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

    String path = "E:\\FileCenter\\";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String fname = req.getParameter("fname");
        String user = (String) session.getAttribute("user");

        Integer msg = null;
//        if ("test" == user) {
//            msg = "权限不足";
//        }

        try {

        File dfile = new File(path + user + "\\" + fname);
        boolean isOK = dfile.exists();
        if (isOK) {
            dfile.delete();
            msg = 1;
            System.out.println("删除成功");
        } else {
            msg = 0;
            System.out.println("文件不存在");
        }
        } catch (Exception e) {
            e.printStackTrace();
            msg = -1;
        }
        session.setAttribute("DelStatus",msg);
        res.sendRedirect("FileList");
    }
}

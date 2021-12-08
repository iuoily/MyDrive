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

    private String path = "E:\\FileCenter\\";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String fname = req.getParameter("fname");
        System.out.println(fname);
        String user = (String) session.getAttribute("user");

        String msg = null;
//        if ("test" == user) {
//            msg = "权限不足";
//        }

        try {
            File dfile = new File(path + user + "\\" + fname);
            if (forceDelete(dfile)) {
                req.setAttribute("DelSatuts","删除成功！");
                msg = "删除成功！";
                System.out.println("删除成功");
            } else {
                msg = "删除失败！";
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "操作异常！";
        }
//        req.setAttribute("DelStatus",msg);

        res.sendRedirect("FileList");
//        req.getRequestDispatcher("FileList").forward(req,res);
    }

    private static boolean forceDelete(File f) {
        boolean result = false;
        int tryCount = 0;
        while (!result && tryCount++ < 10) {
            System.gc();
            System.out.println(f);
            result = f.delete();
        }
        return result;
    }
}

package com.iuoly.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author iuoly
 */
@WebFilter(value = "/*")
public class myFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest)request;

        System.out.println(((HttpServletRequest) request).getRequestURI());
        if (req.getRequestURI().contains("login") ||
                req.getRequestURI().contains("login.jsp") ||
                req.getRequestURI().contains("register") ||
                req.getRequestURI().contains("register.jsp")
            ) {
            chain.doFilter(request, response);
            System.out.println("1");
        } else {
            if (req.getSession().getAttribute("user") != null) {
                chain.doFilter(request, response);
                System.out.println("2");
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect("login.jsp");
                System.out.println("3");
            }
        }
    }
}

package com.mildlamb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码：
        resp.setContentType("text/html;charset=utf-8");

        //获取前端参数
        String method = req.getParameter("method");
        if ("add".equals(method)){
            req.getSession().setAttribute("msg","调用了Add方法");
        }
        if ("delete".equals(method)){
            req.getSession().setAttribute("msg","调用了Delete方法");
        }
        //调用业务层

        //视图转发或重定向
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

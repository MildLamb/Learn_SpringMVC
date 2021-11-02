package com.mildlamb.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //放行判断
        //登录页面本身要放行
        if(request.getRequestURI().contains("Login")){
            return true;
        }

        //用户登录了要放行
        if (request.getSession().getAttribute("userInfo") != null){
            return true;
        }

        //判断什么情况下是没有登录的
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}

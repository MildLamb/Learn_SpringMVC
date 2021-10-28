package com.mildlamb.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放到ModelAndView中
        mv.addObject("msg","Hello,SpringMVC");

        //封装要跳转的视图
        mv.setViewName("hello");  //: /WEB-INF/jsp/hello.jsp
        return mv;
    }
}

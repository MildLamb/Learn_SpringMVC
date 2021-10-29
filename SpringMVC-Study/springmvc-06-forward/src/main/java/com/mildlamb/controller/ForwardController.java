package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ForwardController {
    //加了forward或者redirect就不走视图解析器了
    @GetMapping("/test")
    public String test(HttpServletRequest req, HttpServletResponse resp){
        //转发
        return "forward:/WEB-INF/jsp/forward.jsp";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest req, HttpServletResponse resp){
        //重定向
        //WEB-INF目录对客户端隐藏，是服务器级别，所以重定向不到，要想访问得到需要写controller处理
        //有视图解析器直接写地址
        return "redirect:/index.jsp";
    }
}

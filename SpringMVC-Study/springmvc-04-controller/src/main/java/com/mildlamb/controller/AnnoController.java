package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnoController {
    @RequestMapping("/test2")
    public String test(Model model){
        model.addAttribute("msg","注解实现控制器");
        return "test";
    }
}

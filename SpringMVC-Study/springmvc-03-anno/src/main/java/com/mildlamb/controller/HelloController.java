package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("msg","Never One,Without the other");
        return "kindred";
    }
}

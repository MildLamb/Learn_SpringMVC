package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class EncodingController {
    @PostMapping("/coding")
    public String test(String name, Model model) throws UnsupportedEncodingException {

        //过滤器解决乱码

        System.out.println("name:" + name);
        model.addAttribute("msg","Name" + name);
        return "test";
    }
}

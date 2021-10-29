package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingDemo {
    @RequestMapping
    public String test(){
        return "test";
    }
}

package com.mildlamb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    //原生方式：http://localhost:8080/add?a=1&b=2
    //RSETful：http://localhost:8080/add/1/2

//    @RequestMapping(value = "/add/{a}/{b}", method = {RequestMethod.GET})
    //@PathVariable: 路径变量 从url中获取对应的参数
    @GetMapping("/add/{a}/{b}")
    public String restFulTest(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为:" + (a+b));
        return "rest";
    }

    @PostMapping("/add/{a}/{b}")
    public String restFulTest2(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为:" + a+b);
        return "rest";
    }
}

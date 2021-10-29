package com.mildlamb.controller;

import com.mildlamb.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    //前端提交属性
    /*
        接收前端用户传递的参数，判断字段的名字，如果相同可以直接使用
        http://localhost:8080/user/info?username=kindred
     */
    @GetMapping("/info")
    public String test(@RequestParam("username") String name, Model model){
        //接收前端参数
        System.out.println("接收到的前端参数为:" + name);
        //设置响应信息
        model.addAttribute("msg","Name:" + name);
        //跳转视图
        return "test";
    }

    //前端传递的是对象
    /*
        接收前端用户传递的参数，判断参数是否与对象的属性字段相同，如果相同可以直接封装进对象
        http://localhost:8080/user/user?id=1&name=kindred&age=1500
     */
    @GetMapping("/user")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap modelMap){
        modelMap.addAttribute("msg","massage");
        return "test";
    }
}

package com.mildlamb.controller;

import com.mildlamb.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @GetMapping("/ajax")
    public String test(){
        return "Hello,Ajax";
    }

    @RequestMapping("/a")
    public void a1(String dataName, HttpServletResponse response) throws IOException {
        System.out.println("a1:param => " + dataName);
        if ("kindred".equals(dataName)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/userList")
    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();

        //添加数据
        users.add(new User("纳尔",9,"雄"));
        users.add(new User("千珏",1500,"女"));
        users.add(new User("妮蔻",16,"女"));

        return users;
    }


    @RequestMapping("/checkU")
    public String checkUserName(String username,String password){
        System.err.println("username:" + username + ",password:" + password);
        if ("".equals(username)){
            username = null;
        }
        if ("".equals(password)){
            password = null;
        }
        String msg = "";
        if (username != null){
            if ("admin".equals(username)){
                msg = "OK";
            }else {
                msg = "ERROR";
            }
        }
        if (password != null){
            if ("123456".equals(password)){
                msg = "OK";
            }else {
                msg = "ERROR";
            }
        }
        return msg;
    }


}

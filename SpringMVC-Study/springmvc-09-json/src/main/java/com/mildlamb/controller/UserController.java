package com.mildlamb.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mildlamb.pojo.User;
import com.mildlamb.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @GetMapping(value = "/j1"/*,produces = "application/json;charset=utf-8"*/)
//    @ResponseBody   //不会走视图解析器,会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson 中有一个对象叫 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1,"千珏",1500);

        //将对象变为字符串
        String s = mapper.writeValueAsString(user);

        return s;
    }

    @GetMapping("/j2")
    public String json2() throws JsonProcessingException {

        //jackson 中有一个对象叫 ObjectMapper
//        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1,"千珏",1500);
        User user2 = new User(2,"纳尔",9);
        User user3 = new User(3,"妮蔻",16);

        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        //将对象数组变为字符串
//        String s = mapper.writeValueAsString(users);

        return new ObjectMapper().writeValueAsString(users);
    }

    @GetMapping("/j3")
    public String json3() throws JsonProcessingException {

        //传统方式解决日期格式问题 sdf.format
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        //使用ObjectMapper 来格式化日期  setDateFormat
        ObjectMapper mapper = new ObjectMapper();
        //设置不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(sdf);


        Date date = new Date();
        //将时间类型转换为字符串  默认格式为 Timestamp，时间戳
        return mapper.writeValueAsString(date);
    }

    @GetMapping("/j4")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @GetMapping("/j5")
    public String json5() throws JsonProcessingException {
        User user = new User(1,"千珏",1500);
        return JsonUtils.getJson(user);
    }

    @GetMapping("/fast")
    public String fastjson(){
        List<User> users = new ArrayList<User>();

        User user = new User(1,"千珏",1500);
        User user2 = new User(2,"纳尔",9);
        User user3 = new User(3,"妮蔻",16);

        users.add(user);
        users.add(user2);
        users.add(user3);

        String s = JSON.toJSONString(users);

        return s;
    }
}

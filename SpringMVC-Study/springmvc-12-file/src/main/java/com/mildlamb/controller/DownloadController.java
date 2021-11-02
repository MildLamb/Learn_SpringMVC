package com.mildlamb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class DownloadController {
    @RequestMapping("/download")
    public String download(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //要下载的图片地址
        String path = request.getServletContext().getRealPath("/WEB-INF/images");
        String fileName = "kindred.jpg";

        //设置response响应头
        response.reset();  //设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");  //设置字符编码
        response.setContentType("multipart/form-data"); //设置传输格式

        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName,"UTF-8"));

        File file = new File(path,fileName);
        // 读取文件 -- 输入流
        InputStream inputStream = new FileInputStream(file);
        // 写出文件 -- 输出流
        OutputStream outputStream = response.getOutputStream();

        byte[] buff = new byte[1024];
        int index = 0;
        //执行写出操作
        while ((index = inputStream.read(buff)) != -1){
            outputStream.write(buff,0,index);
            outputStream.flush();
        }

        inputStream.close();
        outputStream.close();

        return null;

    }
}

package com.mildlamb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class FileController {
    //第一种方式
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("MyFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //获取文件名 : file.getOriginalFileName();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接返回首页
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传的文件名为:" + uploadFileName);

        //上传保存的路径
        String path = request.getServletContext().getRealPath("/upload");
        //如果不存在就创建一个
        File realFile = new File(path);
        if (!realFile.exists()){
            realFile.mkdir();
        }
        System.out.println("上传文件的保存地址为:" + realFile);

        InputStream in = file.getInputStream();  //文件输入流
        OutputStream out = new FileOutputStream(new File(realFile,uploadFileName));  //文件输出流

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
            out.flush();
        }

        in.close();
        out.close();

        return "redirect:/index.jsp";
    }


    //第二种方式
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("MyFile") CommonsMultipartFile file,HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realFile = new File(path);
        if (!realFile.exists()){
            realFile.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件的地址为:" + realFile);

        //通过CommonsMultipartFile的transferTo方法直接写文件
        file.transferTo(new File(realFile + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }
}

package com.example.sysdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Override
    /**
     * 只为功能实现做测试
     * 没有更严格判断是否为图片
     */
    public String fileUrl(MultipartFile file) {
        String pathurl="";
        if(file==null)
            throw new IllegalArgumentException("没有上传图片");
       try{
            //获取文件名
        String fileName=file.getOriginalFilename().toLowerCase();
        System.out.println("上传文件名：：："+fileName);
        //获取后缀名
        String sufixName=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀为：："+sufixName);
        //判断文件是否为图片
        if(!sufixName.equals(".jpg"))
            throw new IllegalArgumentException("图片不合法");
        String upLoadPath="D:/upload/";
        File f=new File(upLoadPath);
        if(!f.exists()){
            f.mkdirs();
        }
        //随机生成的文件名
        String upLoadName= UUID.randomUUID().toString();
        //全路径名拼接
        String fileN=upLoadName+sufixName;
        System.out.println("生成文件名为：："+fileN);
        //文件所在全路径
         pathurl=upLoadPath+fileN;
        File fp=new File(pathurl);
        System.out.println(pathurl);
        //文件上传
            file.transferTo(fp);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("图片异常");
        }
        //返回全路径
        return pathurl;
    }
}

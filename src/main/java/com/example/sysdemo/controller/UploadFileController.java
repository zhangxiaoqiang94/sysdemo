package com.example.sysdemo.controller;

import com.example.sysdemo.service.UploadFileService;
import com.example.sysdemo.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

  //  @RequestMapping(value = "/upload")
    @PostMapping("/upload")
    public SysResult uploadfile(@RequestParam(value = "file",required = false)
                                              MultipartFile myfile){
             System.out.println("file::"+myfile);
        try {
            String url=uploadFileService.fileUrl(myfile);
            if(url!=""||url!=null)
            return new SysResult(200,"上传成功",url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SysResult(201,"上传失败");
    }



}

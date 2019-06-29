package com.example.sysdemo.controller;

import com.example.sysdemo.pojo.User;
import com.example.sysdemo.service.UserService;
import com.example.sysdemo.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //查找所用用户数据进行返回生成 列表
    @RequestMapping("/findAll")
    public SysResult findAllUser(){
        List<User> users=userService.findAllUser();
      System.out.println("users的总记录数  ："+users.size());
        return new SysResult(200,"查询user成功",users);
    }
}

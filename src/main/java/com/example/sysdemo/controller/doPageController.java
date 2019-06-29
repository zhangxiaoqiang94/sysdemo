package com.example.sysdemo.controller;

import com.example.sysdemo.pojo.User;
import com.example.sysdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class doPageController {
    @Autowired
    private UserService userService;

    //登录页面
    @RequestMapping("/login")
    public String doLogin(){
        return "login";
    }
    //跳转到注册页面
    @RequestMapping("/register")
    public  String doRegister(){
        return "register";
    }


    //判断登录是否成功  跳转的页面
    @RequestMapping("/loginuser")
    public String doIndex(User user){
        int count=userService.findUser(user);

        return count>0?"index":"erro";
    }
    //注册成功以及登录
    @RequestMapping("/doregister")
    public String register(User user){
        try {
            int count=userService.register(user);
            System.out.println("注册行数为  ："+count);
            if(count!=0){
                return "registerok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "erro";
    }

    //添加商品界面
    @RequestMapping("/additem")
    public String addItemUI(){
        return "additem";
    }

    //直接进入首页
    @RequestMapping("/index")
    public String doIndex(){
        return "index1";
    }

    //加载  更新或添加  页面
    @RequestMapping("/updateUI")
    public String updateUI(){
        return "addAndedit";
    }







}





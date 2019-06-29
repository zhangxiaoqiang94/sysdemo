package com.example.sysdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sysdemo.mapper.UserMapper;
import com.example.sysdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;


    @Override
    public int findUser(User user) {
        //参数验证
        String username=user.getUsername();
        String password=user.getPassword();
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return  0;
        }
        QueryWrapper queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        return userMapper.selectCount(queryWrapper);
    }

    @Override
    //账号注册
    public int register(User user) {
        int count=0;
        //如果username或password不为空 执行以下……
        if(!StringUtils.isEmpty(user.getUsername())&&!StringUtils.isEmpty(user.getPassword())){
           //根据username查询数据库  if ==0  用户名可用  否则用户名已注册
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("username",user.getUsername());
            //返回查询行数 判断
            int row=userMapper.selectCount(queryWrapper);
            if(row!=0){
               return count;
            }else {
                count = userMapper.insert(user);
                if (count == 0) throw new RuntimeException("注册失败");
                System.out.println("注册行数   ：" + count);
            }
        }
        return count;
    }

    @Override
    //查找用户用于显示页面中
    public List<User> findAllUser() {
        return userMapper.selectList(null);
    }
}

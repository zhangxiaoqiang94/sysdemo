package com.example.sysdemo.service;

import com.example.sysdemo.pojo.User;

import java.util.List;

public interface UserService {
    int findUser(User user);

    int register(User user);

    List<User> findAllUser();
}

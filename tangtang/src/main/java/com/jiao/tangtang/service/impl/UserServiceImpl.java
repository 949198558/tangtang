package com.jiao.tangtang.service.impl;


import com.jiao.tangtang.entity.SysUser;
import com.jiao.tangtang.mapper.UserMapper;
import com.jiao.tangtang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public SysUser selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }



}
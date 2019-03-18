package com.jiao.tangtang.service;

import com.jiao.tangtang.entity.SysUser;


public interface UserService {


    SysUser  selectByUserName(String username);

}
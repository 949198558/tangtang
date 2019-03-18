package com.jiao.tangtang.mapper;

import com.jiao.tangtang.entity.SysUser;

import java.util.List;

public interface UserMapper {

    SysUser selectByUserName(String username);

}
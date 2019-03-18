package com.jiao.tangtang.mapper;


import java.util.List;

public interface SysMenuMapper {

    public List<String> selectPermsByUserId(String userId);
}

package com.jiao.tangtang.mapper;

import com.jiao.tangtang.entity.SysRole;

import java.util.List;

public interface SysRoleMapper {

    List<SysRole> selectRolesByUserId(String userId);

}

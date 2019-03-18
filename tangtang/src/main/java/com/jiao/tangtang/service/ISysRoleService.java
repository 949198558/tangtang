package com.jiao.tangtang.service;

import java.util.Set;

public interface ISysRoleService {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRolesByUserId(String userId);

}

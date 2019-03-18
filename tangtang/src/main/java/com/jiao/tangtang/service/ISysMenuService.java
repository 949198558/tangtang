package com.jiao.tangtang.service;

import java.util.Set;

public interface ISysMenuService {

    /**
     * 权限查询
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(String userId);
}

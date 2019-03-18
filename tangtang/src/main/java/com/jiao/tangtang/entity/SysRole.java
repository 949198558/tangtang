package com.jiao.tangtang.entity;

import com.jiao.tangtang.common.Base.BaseEntity;

public class SysRole extends BaseEntity {
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限关键字
     */
    private String roleKey;
    /**
     * 显示顺序
     */
    private String roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限）
     */
    private String dataScope;
    /**
     * 角色状态（0正常 1停用）
     */
    private String status;
    /**
     * 是否删除（0：已删除  1：未删除）
     */
    private String delFlag;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}

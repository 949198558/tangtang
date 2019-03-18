package com.jiao.tangtang.entity;

import com.jiao.tangtang.common.Base.BaseEntity;

public class SysUser extends BaseEntity {
    /**
     *  用户ID
     */
    private String userId;
    /**
     *  部门ID
     */
    private String deptId;
    /**
     *  用户名
     */
    private String userName;
    /**
     *  密码
     */
    private String password;
    /**
     *  昵称
     */
    private String nickName;
    /**
     *  手机号
     */
    private String phone;
    /**
     *  性别（0：女 1：男 2：保密）
     */
    private String sex;
    /**
     *  是否删除（0：删除 1：保存）
     */
    private String delFlag;


//    private List<SysRole> roles;
//
//    /** 角色数组 */
//    private Long[] roleIds;






    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
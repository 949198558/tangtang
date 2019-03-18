package com.jiao.tangtang.entity;

import com.jiao.tangtang.common.Base.BaseEntity;

public class SysMenu extends BaseEntity {
    /**
     *  菜单ID
     */
    private String menuId;
    /**
     *  菜单名称
     */
    private String menuName;
    /**
     *  父菜单ID
     */
    private String parentId;
    /**
     *  显示顺序
     */
    private String orderNum;
    /**
     *  请求地址
     */
    private String url;
    /**
     *  菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     *  菜单状态（0显示 1隐藏）
     */
    private String visible;
    /**
     *  权限标识
     */
    private String perms;
    /**
     *  菜单图标
     */
    private String icon;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

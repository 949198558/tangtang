package com.jiao.tangtang.common.shiro;

import com.jiao.tangtang.entity.SysUser;
import com.jiao.tangtang.service.ISysMenuService;
import com.jiao.tangtang.service.ISysRoleService;
import com.jiao.tangtang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 执行授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser)subject.getPrincipal();
        Set<String> sysRoles = sysRoleService.selectRolesByUserId(sysUser.getUserId());
        Set<String> sysMenus = sysMenuService.selectPermsByUserId(sysUser.getUserId());
        info.setRoles(sysRoles);
        info.setStringPermissions(sysMenus);
        return info;
    }
    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

       //判断用户名、密码
        UsernamePasswordToken Token = (UsernamePasswordToken) authenticationToken;
        String username = Token.getUsername();
        SysUser user = userService.selectByUserName(username);
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}

package com.jiao.tangtang.common.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {
/**
 * 创建ShiroFilterFactoryBean
 */
@Bean
public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    //设置安全管理器
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    //添加shiro内置过滤器
    /**
     * 常用过滤器
     * anon：无需认证（登录）就可以访问
     * authc：必须认证
     * user：如果使用rememberMe的功能可以直接访问
     * perms：该资源必须得到资源权限才可以访问
     * role：该资源必须得到角色权限才可以访问
     */
    Map<String,String> filterMap = new LinkedHashMap<String, String>();
    filterMap.put("/login","anon");
    filterMap.put("/tologin","anon");
    filterMap.put("/unAuth","anon");
    filterMap.put("/logout","logout");

    /*不拦截静态文件*/
    filterMap.put("/favicon.ico**", "anon");
    filterMap.put("/css/**", "anon");
    filterMap.put("/js/**", "anon");
    filterMap.put("/img/**", "anon");
    filterMap.put("/static/**", "anon");


    filterMap.put("/**","user");

    //修改拦截跳转页面
    shiroFilterFactoryBean.setLoginUrl("/tologin");
    shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);



    return shiroFilterFactoryBean;
}

/**
 * 创建DefaultWebSecurityManager
 */
@Bean(name = "securityManager")
public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
   //关联realm
    securityManager.setRealm(userRealm);
    return securityManager;
}


/**
 * 创建Realm
 */
@Bean(name = "userRealm")
public UserRealm getRealm(){
    return new UserRealm();
}
/**
 * 整合thymeleaf与shiro
 * @return
 */
@Bean
public ShiroDialect getShiroDialect(){
    return new ShiroDialect();
}

/**
 *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
 * @return
 */
@Bean
public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
    DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    advisorAutoProxyCreator.setProxyTargetClass(true);
    return advisorAutoProxyCreator;
}
/**
 * 开启aop注解支持
 * @param securityManager
 * @return
 */
@Bean
public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
}
}

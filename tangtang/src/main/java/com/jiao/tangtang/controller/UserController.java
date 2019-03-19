package com.jiao.tangtang.controller;

import com.jiao.tangtang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String testThymeleaf(Model model){
        model.addAttribute("name","我是张三");
        return "index";
    }
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String add(){
        return "/user/add";
    }
    @RequiresPermissions("user:update")
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"})
    public String update(){
        return "/user/update";
    }
    @RequestMapping(value = "/tologin", produces = {"application/json;charset=UTF-8"})
    public String tologin(){
        return "login";
    }
    @RequestMapping(value = "/unAuth", produces = {"application/json;charset=UTF-8"})
    public String unAuth(){
        return "unAuth";
    }
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public String login(String name ,String password,Model model){
        /**
         * 使用Shiro认证登录
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3.执行登录方法
        try{
            subject.login(token);

            return "redirect:/test";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}


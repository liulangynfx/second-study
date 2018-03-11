package com.rainea.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: UserAuthen.java</p>
 * <p>Description: 权限验证</p>
 * @author liulang
 * @date   Apr 16, 2017
 * @version 
 */
@Controller
public class UserAuthen {
    
    /**
     * 登录
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpSession session, String userName, String password) throws Exception {
        //service查询数据库
        
        
        session.setAttribute("userName", userName);
        return "itemsList";
    }
    
    /**
     * 退出
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "login";
    }
}

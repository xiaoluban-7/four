package com.xiaozhang.apple.module.sys;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author : zhanggang
 * @version : v1.0
 * @description 登录控制器
 * @date : 2021/2/26 15:20
 */
@Controller
@RequestMapping(value = "/sys")
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class);

    /**
     * @return ignore
     * @Description: 跳转到登录页面
     * @author zhanggang
     */
    @GetMapping(value = "/toLogin")
    public String toLogin() {
        return "/login.html";
    }

    /**
     * @param account  账号
     * @param password 密码
     * @return ignore
     * @Description: 登录
     * @author zhanggang
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam(value = "account") String account,
                        @RequestParam(value = "password") String password,
                        ModelAndView modelAndView) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        try {
            SecurityUtils.getSubject().login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                logger.info("账号错误:" + account);
            } else if (e instanceof LockedAccountException) {
                logger.info("账号禁用:" + account);
            } else if (e instanceof IncorrectCredentialsException) {
                logger.info("密码错误:" + password);
            } else {
                logger.info("用户认证失败...");
            }
        }

        return "/test.html";
    }

}

package com.xiaozhang.apple.module;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhanggang
 * @version : v1.0
 * @description 样例
 * @date : 2021/2/26 14:01
 */
@RestController
@RequestMapping(value = "/admin")
public class DemoController {
    @GetMapping(value = "/demo")
    public String demo() {

        return "demo";
    }
}

package com.emi2c.mybatis.controller;

import com.emi2c.mybatis.command.LoginCommand;
import com.emi2c.mybatis.config.security.JwtAuthenticatioToken;
import com.emi2c.mybatis.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody LoginCommand command, HttpServletRequest request) throws IOException {
        String username = command.getUsername();
        String password = command.getPassword();

        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return null;
    }

}

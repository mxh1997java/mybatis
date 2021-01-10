package com.emi2c.mybatis.controller;

import com.emi2c.mybatis.config.annotation.Operating;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Operating(type = "SELECT")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {

    }

}

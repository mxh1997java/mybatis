package com.emi2c.mybatis.controller;

import com.emi2c.mybatis.config.annotation.Operating;
import com.emi2c.mybatis.config.annotation.TakeTime;
import com.emi2c.mybatis.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @TakeTime
    @Operating(type = "SELECT")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setPassword("password" + i);
            userList.add(user);
        }
        return userList;
    }


    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "getUserInfo/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return null;
    }


    @PostMapping(value = "addUser")
    public User addUser(@RequestBody User user) {
        return null;
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @PostMapping(value = "update")
    public User updateUserById(@RequestBody User user) {
        return null;
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @DeleteMapping(value = "delete")
    public boolean deleteUserById(@RequestBody User user) {
        return true;
    }

}

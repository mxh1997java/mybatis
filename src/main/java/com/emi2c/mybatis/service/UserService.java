package com.emi2c.mybatis.service;

import com.emi2c.mybatis.entity.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    Set<String> findPermissions(String username);

}

package com.emi2c.mybatis.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticationManager {

    Authentication authenticate(Authentication authentication) throws AuthenticationException;

}

package com.emi2c.mybatis.config;

import com.emi2c.mybatis.config.interceptor.OperatingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//注册拦截器
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(getOperatingInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 解决拦截器内对象注入失败问题
     * @return
     */
    @Bean
    public OperatingInterceptor getOperatingInterceptor() {
        return new OperatingInterceptor();
    }

}

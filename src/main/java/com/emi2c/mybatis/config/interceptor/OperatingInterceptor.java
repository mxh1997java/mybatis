package com.emi2c.mybatis.config.interceptor;

import com.emi2c.mybatis.config.annotation.Operating;
import com.emi2c.mybatis.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 获取执行方法操作类型
 */
public class OperatingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // 拦截处理代码
        HandlerMethod method = (HandlerMethod) handler;
        Operating operating = method.getMethodAnnotation(Operating.class);
        if(!Objects.isNull(operating)) {
            String type = operating.type();
            logger.info("操作类型: {}", type);

            // 将操作记录放入redis队列
            redisUtil.lSet("operating", type);
        }
        return super.preHandle(request, response, handler);
    }

}

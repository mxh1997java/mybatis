package com.emi2c.mybatis.config;

import com.emi2c.mybatis.config.exception.GlobalExceptionHandler;
import com.emi2c.mybatis.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 返回统一结果
 */
@RestControllerAdvice(basePackages = "com.emi2c.mybatis.controller")
public class ResponseAdvice implements ResponseBodyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ResponseAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }


    /**
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        String methodName = methodParameter.getMethod().getName();
        String parameterName = methodParameter.getParameterName();
        logger.info("method: {}, param: {}", methodName, parameterName);
        Result result = new Result();
        if (Objects.isNull(o)) {
            result.setMessage("success");
            return result;
        }

        if (o instanceof Result) {
            return o;
        }

        result.setMessage("success");
        result.setData(o);
        return result;
    }

}

package com.emi2c.mybatis.config.exception;

import com.emi2c.mybatis.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;
import java.util.Map;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理Exception
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exceptionHandler(Exception e) {
        logger.info("未知异常！原因是: {}", e.getMessage());
        return ResultUtil.getFailure(500, e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Map<String, Object> runtimeExceptionHandler(Exception e) {
        logger.info("未知运行时异常！原因是: {}", e.getMessage());
        return ResultUtil.getFailure(500, e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Map<String, Object> nullPointerExceptionHandler(Exception e) {
        logger.info("空指针异常！原因是: {}", e.getMessage());
        return ResultUtil.getFailure(500, e.getMessage());
    }

    @ExceptionHandler(value = ClassNotFoundException.class)
    public Map<String, Object> classNotFoundExceptionHandler(Exception e) {
        logger.info("找不到类异常！原因是: {}", e.getMessage());
        return ResultUtil.getFailure(500, e.getMessage());
    }

    @ExceptionHandler(value = ConnectException.class)
    public Map<String, Object> connectExceptionExceptionHandler(Exception e) {
        logger.info("连接服务异常！原因是: {}", e.getMessage());
        return ResultUtil.getFailure(500, e.getMessage());
    }

}

package com.emi2c.mybatis.util;

/**
 * 断言工具类
 */
public class AssertUtil {

    private AssertUtil() {}

    /**
     * 条件成立抛异常
     * @param flag
     * @param message
     */
    public static void AssertTrue(boolean flag, String message) {
        if(flag) {
            throw new RuntimeException(message);
        }
    }

    /**
     * 条件不成立抛异常
     * @param flag
     * @param message
     */
    public static void AssertFalse(boolean flag, String message) {
        if(!flag) {
            throw new RuntimeException(message);
        }
    }

}

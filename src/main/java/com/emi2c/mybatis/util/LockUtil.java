package com.emi2c.mybatis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
public class LockUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static Lock lock = rwl.writeLock();

    /**
     * 获得锁
     * @param lockId
     * @param millisecond
     * @return
     */
    public boolean getLock(String lockId, long millisecond) {
        lock.lock();
        try {
            Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock");
            redisTemplate.expire(lockId, millisecond, TimeUnit.MILLISECONDS);
            return success != null && success;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 释放锁
     * @param lockId
     */
    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }

}

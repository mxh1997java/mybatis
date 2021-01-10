package com.emi2c.mybatis;

import com.emi2c.mybatis.entity.User;
import com.emi2c.mybatis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void strTest() {
        redisUtil.set("name", "马鑫海");
        redisUtil.set("age", 24);
        redisUtil.set("sex", "男");
        redisUtil.set("phone", "15735400536");
        redisUtil.set("address", "山西省晋城市阳城县北留镇小沟村");

        Object address = redisUtil.get("address");
        System.out.println(address);

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "马鑫海");
        map.put("age", 24);
        map.put("sex", "男");
        map.put("phone", "15735400536");
        map.put("address", "山西省晋城市阳城县北留镇小沟村");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        map.put("createTime", dtf.format(LocalDateTime.now()));
        redisUtil.set("info", map);
    }

    @Test
    public void mapTest() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "马鑫海");
        map.put("age", 24);
        map.put("sex", "男");
        map.put("phone", "15735400536");
        map.put("address", "山西省晋城市阳城县北留镇小沟村");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        map.put("createTime", dtf.format(LocalDateTime.now()));
        redisUtil.hmset("user_info", map);

        Map<Object, Object> user_info = redisUtil.hmget("user_info");
        user_info.forEach((k,v) -> {
            System.out.println(k + "=>" + v);
        });
    }

    @Test
    public void setTest() {
        System.out.println("========== set ==========");
        redisUtil.del("set");

        Set<String> set = new HashSet<>();
        set.add("马鑫海");
        set.add("马雅丽");
        set.add("马晶晶");
        set.add("马德森");
        set.add("马晨");
        set.add("梁甜甜");
        set.add("李晶");
        redisUtil.sSet("set", set);

        long size = redisUtil.sGetSetSize("set");
        System.out.println("set size: " + size);

        Set<Object> friends = redisUtil.sGet("set");
        friends.forEach(item -> {
            System.out.println(item);
        });

        boolean flag = redisUtil.sHasKey("set", "梁甜甜");
        System.out.println("包含: " + flag);

        System.out.println("========== set ==========");
    }

    @Test
    public void listTest() {
        System.out.println("========== list ==========");
        List<String> list = new ArrayList<>();
        list.add("马鑫海");
        list.add("马雅丽");
        list.add("马晶晶");
        list.add("马德森");
        list.add("马晨");
        list.add("梁甜甜");
        list.add("李晶");
        redisUtil.lSet("friends", list);
        long size = redisUtil.lGetListSize("friends");
        System.out.println("friends size: " + size);

        for(int i=0; i<10; i++) {
            Object value = redisUtil.lGetIndex("list", i);
            System.out.println(value);
        }


        for(int i=0; i<10; i++) {
            User user = new User();
            user.setId(0L);
            user.setIsActive(0);
            user.setIsDelete(0);
            user.setUsername("username" + i);
            user.setPassword("password" + i);
            user.setCreator("system");
            user.setDescription("这个人很懒什么也没有留下");

            redisUtil.lSet("user_list", user);
            redisUtil.lSet("array", i);
        }
        List<Object> array = redisUtil.lGet("array", 0, -1);
        array.forEach(item -> {
            System.out.println(item);
        });

        List<Object> user_list = redisUtil.lGet("user_list", 0, -1);
        user_list.forEach(item -> {
            System.out.println(item.toString());
        });

        System.out.println("========== list ==========");
    }

}

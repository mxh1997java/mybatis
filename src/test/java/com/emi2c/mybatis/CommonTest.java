package com.emi2c.mybatis;

import com.emi2c.mybatis.common.BaseServiceImpl;
import com.emi2c.mybatis.common.entity.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired
    private BaseServiceImpl baseService;

    @Test
    public void test() {
        Document document = new Document();
        document.setCode("404");
        document.setName("测试数据");
        document.setDescription("这个人很懒什么也没有留下");
        document.setCreator("system");
        document.setCreateTime(LocalDateTime.now());
        baseService.insert(document);
    }

}

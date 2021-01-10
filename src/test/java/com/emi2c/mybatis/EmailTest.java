package com.emi2c.mybatis;

import com.emi2c.mybatis.email.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void test() {
        String from = "2485460305@qq.com";
        String to = "18334698204@163.com";
        String subject = "2021年测试邮件";
        String content = "祝妈妈长命百岁！";
        emailUtil.sendSimpleMail(from, to, subject, content);
    }

}

package com.emi2c.mybatis;

import com.emi2c.mybatis.mongodb.OperatingRecord;
import com.emi2c.mybatis.mongodb.OperatingRecordDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private OperatingRecordDao operatingRecordDao;

    @Test
    public void queryTest() {
        Map<String, Object> query = new HashMap<>();
        List<OperatingRecord> recordList = operatingRecordDao.query(query);
        recordList.forEach(item -> {
            System.out.println(item);
        });
    }

}

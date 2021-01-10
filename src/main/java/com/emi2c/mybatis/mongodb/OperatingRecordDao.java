package com.emi2c.mybatis.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class OperatingRecordDao {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 保存
     * @param record
     */
    public void save(OperatingRecord record) {
        mongoTemplate.save(record);
    }

    /**
     * 删除
     * @param id
     */
    public void remove(ObjectId id) {
        mongoTemplate.remove(id);
    }

    /**
     * 修改
     * @param record
     */
    public void update(OperatingRecord record) {
        Query query = new Query(Criteria.where("id").is(record.getId()));
        Update update = new Update();
        update.set("type", record.getType());
        update.set("editor", record.getEditor());
        update.set("editTime", record.getEditTime());
        update.set("description", record.getDescription());
        mongoTemplate.updateFirst(query, update, OperatingRecord.class);
    }

    /**
     * 查询
     * @param condition
     * @return
     */
    public List<OperatingRecord> query(Map<String, Object> condition) {
        Query query = new Query(Criteria.where("type").is(condition.get("type")));
        if(!Objects.isNull(condition.get("beginTime"))) {
            query.addCriteria(Criteria.where("createTime").gte(condition.get("beginTime")));
        }
        if(!Objects.isNull(condition.get("endTime"))) {
            query.addCriteria(Criteria.where("createTime").lte(condition.get("endTime")));
        }
        List<OperatingRecord> recordList = mongoTemplate.find(query, OperatingRecord.class);
        return recordList;
    }

}

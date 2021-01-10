package com.emi2c.mybatis.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operating_record_collection")
public class OperatingRecord extends BaseEntity {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OperatingRecord{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", editor='" + editor + '\'' +
                ", editTime=" + editTime +
                '}';
    }
}

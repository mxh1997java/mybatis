package com.emi2c.mybatis.common;


import java.util.List;
import java.util.Map;

public interface BaseService {

    int insert(Object object);

    int batchInsert(List<Object> objectList);

    int update(Object obj);

    int batchUpdate(List<Object> objectList);

    int delete(Object obj);

    int batchDelete(List<Object> objectList);

    Map<String, Object> selectOneById(Object obj);

    List<Map<String, Object>> selectAll(Object obj);

}

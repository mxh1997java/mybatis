package com.emi2c.mybatis.common;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BaseMapper {

    int insert(Map<String, Object> params);

    int batchInsert(Map<String, Object> params);

    int update(Map<String, Object> params);

    int batchUpdate(Map<String, Object> params);

    int delete(Map<String, Object> params);

    int batchDelete(Map<String, Object> params);

    Map<String, Object> findOneById(Long id);

    List<Map<String, Object>> findAllByCondition(Map<String, Object> params);

}

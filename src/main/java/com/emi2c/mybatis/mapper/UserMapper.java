package com.emi2c.mybatis.mapper;

import com.emi2c.mybatis.command.Condition;
import com.emi2c.mybatis.entity.Diary;
import com.emi2c.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 插入单条数据
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 批量插入
     * @param userList
     * @return
     */
    int batchInsert(List<User> userList);

    /**
     * 删除单条数据
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteByIds(Set<Long> ids);

    /**
     * 修改单条数据
     * @param user
     * @return
     */
    int updateOneById(User user);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    Diary findOneById(Long id);

    /**
     * 根据条件查询多条
     * @param condition
     * @return
     */
    List<Diary> findAllByCondition(Condition condition);

}

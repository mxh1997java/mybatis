package com.emi2c.mybatis.common;

import com.emi2c.mybatis.common.annotation.Column;
import com.emi2c.mybatis.common.annotation.Id;
import com.emi2c.mybatis.common.annotation.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 通用增删改查
 */
@Service
public class BaseServiceImpl implements BaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseMapper baseMapper;

    private Map<String, Object> transformObj(Object t) {
        //获取表名
        if (null == t.getClass().getAnnotation(Table.class)) {
            throw new RuntimeException("Error Input Object! Error @Table Annotation.");
        }
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("TABLE_NAME", t.getClass().getAnnotation(Table.class).value());

        Method[] m = t.getClass().getMethods();
        if (null == m || m.length <= 0) {
            throw new RuntimeException("Error Input Object! No Method.");
        }

        List k = new ArrayList();//存放列名
        List v = new ArrayList();//存放列值
        for (Method i : m) {
            //获取列名和值
            try {
                if (null != i.getAnnotation(Column.class)) {
                    k.add(i.getAnnotation(Column.class).value());
                    v.add(i.invoke(t, null));
                    continue;
                }
                //获取主键
                if (null != i.getAnnotation(Id.class)) {
                    re.put("KEY_ID", i.getAnnotation(Id.class).value());
                    re.put("KEY_VALUE", i.invoke(t, null));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            }
        }
        re.put("COLUMNS", k);
        re.put("VALUES", v);
        if (k.size() != v.size()) {
            throw new RuntimeException("Error Input Object! Internal Error.");
        }
        return re;
    }


    @Override
    public int insert(Object obj) {
        Map<String, Object> params = transformObj(obj);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.insert(params);
    }

    @Override
    public int batchInsert(List<Object> objectList) {
        Map<String, Object> params = transformObj(null);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.batchInsert(null);
    }

    @Override
    public int update(Object obj) {
        Map<String, Object> params = transformObj(obj);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.update(params);
    }

    @Override
    public int batchUpdate(List<Object> objectList) {
        Map<String, Object> params = transformObj(null);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.batchUpdate(null);
    }

    @Override
    public int delete(Object obj) {
        Map<String, Object> params = transformObj(obj);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.delete(params);
    }

    @Override
    public int batchDelete(List<Object> objectList) {
        Map<String, Object> params = transformObj(null);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.batchDelete(null);
    }

    @Override
    public Map<String, Object>  selectOneById(Object obj) {
        Map<String, Object> params = transformObj(obj);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.findOneById(null);
    }

    @Override
    public List<Map<String, Object> > selectAll(Object obj) {
        Map<String, Object> params = transformObj(obj);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.findAllByCondition(params);
    }

}

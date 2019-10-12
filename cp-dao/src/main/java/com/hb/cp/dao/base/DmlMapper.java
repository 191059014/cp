package com.hb.cp.dao.base;

import com.hb.cp.dao.mapper.BaseMapper;
import com.hb.cp.dao.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ========== dml操作数据库类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.DmlMapper.java, v1.0
 * @date 2019年10月12日 14时09分
 */
@Component
public class DmlMapper {

    @Autowired
    private BaseMapper baseMapper;

    public <T> T selectOne(String tableName, Class<T> entityClass, Map<String, Object> conditions) {
        String sqlStatement = SqlHelper.buildSelectiveSql(tableName, conditions);
        Map<String, Object> result = baseMapper.selectOne(sqlStatement, conditions);
        return BeanUtils.mapToBean(result, entityClass);
    }

}

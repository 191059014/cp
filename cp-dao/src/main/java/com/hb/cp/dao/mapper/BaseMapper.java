package com.hb.cp.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * ========== mapper基类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.mapper.BaseMapper.java, v1.0
 * @date 2019年10月12日 11时30分
 */
public interface BaseMapper {

    Map<String, Object> selectOne(@Param("sqlStatement") String sqlStatement, @Param("params") Map<String, Object> params);

}

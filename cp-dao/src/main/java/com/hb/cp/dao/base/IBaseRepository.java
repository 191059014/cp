package com.hb.cp.dao.base;

import com.hb.cp.dao.constant.enums.QueryType;

import javax.persistence.Query;
import java.util.List;

/**
 * ========== 操作数据库Repository祖先 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.IBaseRepository.java, v1.0
 * @date 2019年09月02日 21时22分
 */
public interface IBaseRepository {

    <T> T save(T t);

    <T> T saveOrUpdate(T t);

    void delete(Object delObj);

    <T> T findByPrimaryKey(Class<T> aClass, Object id);

    boolean contains(Object obj);

    List findByCondition(String dml, QueryType queryType, Object... params);

    List findByCondition(String dml, String sort, QueryType queryType, Object... params);

    Long findCount(String dml, QueryType queryType, Object... params);

    List findPageList(String dml, String sort, QueryType queryType, Integer startRow, Integer pageSize, Object... params);

    Query createQuery(String hql);

    Query createQuery(String hql, String sort);

    Query createNativeQuery(String sql);

    Query createNativeQuery(String sql, String sort);

    Integer executeUpdate(String dml, QueryType queryType, Object... params);

    void flush();

    void refresh(Object obj);

    void clear();
}

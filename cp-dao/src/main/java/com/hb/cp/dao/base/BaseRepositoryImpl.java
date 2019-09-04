package com.hb.cp.dao.base;

import com.hb.cp.dao.constant.enums.QueryType;
import com.hb.cp.model.base.IBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * ========== 操作数据库Repository祖先实现类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.BaseRepositoryImpl.java, v1.0
 * @date 2019年09月02日 21时22分
 */
public class BaseRepositoryImpl<ID extends Serializable, T extends IBaseEntity> implements IBaseRepository<ID, T> {

    @PersistenceContext
    private EntityManager em;
    /**
     * order by statement
     */
    private static final String ORDER_BY = " order by ";
    /**
     * limit statement
     */
    private static final String PAGE_MYSQL = " limit ?,? ";

    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T saveOrUpdate(T t) {
        return em.merge(t);
    }

    @Override
    public void delete(T t) {
        em.remove(em.merge(t));
    }

    @Override
    public T findByPrimaryKey(Class<T> aClass, ID id) {
        return em.find(aClass, id);
    }

    @Override
    public boolean contains(T t) {
        return em.contains(t);
    }

    @Override
    public List findByCondition(String dml, QueryType queryType, Object... params) {
        return findByCondition(dml, null, queryType, params);
    }

    @Override
    public List findByCondition(String dml, String sort, QueryType queryType, Object... params) {
        Query query = getQueryByType(dml, sort, queryType);
        fillParameter(query, params);
        return query.getResultList();
    }

    @Override
    public Long findCount(String dml, QueryType queryType, Object... params) {
        Query query = getQueryByType(dml, null, queryType);
        fillParameter(query, params);
        Object result = query.getSingleResult();
        return result == null ? 0L : (Long) result;
    }

    @Override
    public List findPageList(String dml, String sort, QueryType queryType, Integer startRow, Integer pageSize, Object... params) {
        dml += PAGE_MYSQL;
        Object[] newParams = Arrays.asList(params, startRow, pageSize).toArray();
        Query query = getQueryByType(dml, sort, queryType);
        fillParameter(query, newParams);
        return query.getResultList();
    }

    @Override
    public Query createQuery(String hql) {
        return em.createQuery(hql);
    }

    @Override
    public Query createQuery(String hql, String sort) {
        if (sort != null && sort != "") {
            hql += ORDER_BY + sort;
        }
        return createQuery(hql);
    }

    @Override
    public Query createNativeQuery(String sql) {
        return em.createNativeQuery(sql);
    }

    @Override
    public Query createNativeQuery(String sql, String sort) {
        if (sort != null && sort != "") {
            sql += ORDER_BY + sort;
        }
        return createNativeQuery(sql);
    }

    /**
     * 获取Query对象
     *
     * @param dml       dml脚本
     * @param sort      排序
     * @param queryType 脚本类型
     * @return Query
     */
    private Query getQueryByType(String dml, String sort, QueryType queryType) {
        Query query = null;
        if (QueryType.hql == queryType) {
            query = createQuery(dml, sort);
        } else if (QueryType.sql == queryType) {
            query = createNativeQuery(dml, sort);
        }
        return query;
    }

    /**
     * 填充参数
     *
     * @param query  Query对象
     * @param params 参数
     */
    private void fillParameter(Query query, Object[] params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
    }

}

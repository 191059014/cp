package com.hb.cp.dao.base;

import com.hb.cp.model.base.IBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;

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

    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T addOrUpdate(T t) {
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
    public Query createQuery(String hql) {
        return em.createQuery(hql);
    }

    @Override
    public Query createNativeQuery(String sql) {
        return em.createNativeQuery(sql);
    }

}

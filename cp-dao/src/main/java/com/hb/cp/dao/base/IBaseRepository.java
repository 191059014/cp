package com.hb.cp.dao.base;

import javax.persistence.Query;

/**
 * ========== 操作数据库Repository祖先 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.IBaseRepository.java, v1.0
 * @date 2019年09月02日 21时22分
 */
public interface IBaseRepository<ID, T> {

    /**
     * 保存实体
     *
     * @param t 对象
     * @return Object
     */
    T save(T t);

    T update(T t);

    void delete(T t);

    T findByPrimaryKey(Class<T> aClass, ID id);

    boolean contains(T t);

    Query createQuery(String hql);

    Query createNativeQuery(String sql);

}

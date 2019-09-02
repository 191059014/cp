package com.hb.cp.dao.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * ========== 操作数据库Repository祖先实现类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.BaseRepositoryImpl.java, v1.0
 * @date 2019年09月02日 21时22分
 */
@Primary
@Repository("baseRepository")
public class BaseRepositoryImpl implements IBaseRepository, InitializingBean {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(em);
    }

    @Override
    public Object save(Object o) {
        em.persist(o);
        return o;
    }

}

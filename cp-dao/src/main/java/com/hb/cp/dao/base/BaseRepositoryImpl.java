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
 * <p>
 * Ø 临时状态:
 *  实际上就是new了一个普通的JavaBean对象。
 * <p>
 * Ø  托管状态
 *  临时状态在调用persist()后，即可将一般的JavaBean做为了托管状态的Bean，该Bean的任何属性改动都会牵涉到数据库记录的改动。
 *  一旦该记录flush到数据库之后，并且事务提交了，那么此对象不在持久化上下文中，即：变为了游离（没人管的孩子）状态了。
 * 在游离状态的时候调用更新、刷新方法后，游离状态对象就变为了在持久化上下文的托管状态了。
 *   通过管理器的find方法，将实体从数据库查询出来后，该实体也就变为了托管形态。
 * <p>
 * Ø  持久化状态
 *  当处在托管状态的实体Bean被管理器flush了，那么就在极短暂的时间进入了持久化状态，事务提交之后，立刻变为了游离状态。
 *  您可以把持久化状态当做实实在在的数据库记录。
 * <p>
 * Ø  游离状态
 *   游离状态就是提交到数据库后，事务commit后实体的状态，因为事务已经提交了，此时实体的属性任你如何改变，也不会同步到数据库，因为游离是没人管的孩子，不在持久化上下文中。
 * <p>
 * Ø  销毁对象
 *   一般要删除一个持久化对象的时候都是先find出来，之后调用remove方法删之，此时这个对象就是销毁对象，实际上就是瞬时对象的另一种形态罢了。
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.BaseRepositoryImpl.java, v1.0
 * @date 2019年09月02日 21时22分
 */
public class BaseRepositoryImpl<ID extends Serializable, T extends IBaseEntity> implements IBaseRepository<ID, T> {

    /**
     * entityManager
     */
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

    /**
     * 将临时态（即新new的对象，主键id为null）转化为托管态
     *
     * @param t 对象
     * @return 保存后的对象
     */
    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    /**
     * 通过entityManager将一个存在的实体“同步到”persistenceContext中
     * 实体的状态将从其单独的状态转换为受persistenceContext管理的状态
     * 如果Entity是新创建的，则执行insert操作
     * 如果Entity已经存在的，则执行update操作
     * 对不同状态下的实例 A ， merge 会产生以下操作 :
     * 1)如果 A 是一个 detached 状态的实体，该方法会将 A 的修改提交到数据库，并返回一个新的 managed 状态的实例 A2;
     * 2)如果 A 是一个 new 状态的实体，该方法会产生一个根据 A 产生的 managed 状态实体 A2;
     * 3)如果 A 是一个 managed 状态的实体，它的状态不会发生任何改变。但是系统仍会在数据库执行 UPDATE 操作；
     * 4)如果 A 是一个 removed 状态的实体，该方法会抛出 IllegalArgumentException 异常;
     *
     * @param t 对象
     * @return 修改后的对象
     */
    @Override
    public T saveOrUpdate(T t) {
        return em.merge(t);
    }

    /**
     * remove 方法可以将实体转换为 removed 状态，并且在调用 flush() 方法或提交事物后删除数据库中的数据。
     * 对不同状态下的实例 A ， remove 会产生以下操作 :
     * 1）如果 A 是一个 new 状态的实例， A 的状态不会发生任何改变，但系统仍会在数据库中执行 DELETE语句；
     * 2）如果 A 是一个 managed 状态的实例，它的状态会转换为 removed ；
     * 3）如果 A 是一个 removed 状态的实例，不会发生任何操作 ;
     * 4）如果 A 是一个 detached 状态的实体，该方法将会抛出异常。
     *
     * @param t 删除的对象
     */
    @Override
    public void delete(T t) {
        em.remove(em.merge(t));
    }

    /**
     * 通过主键查询
     *
     * @param aClass class
     * @param id     id属性
     * @return 唯一结果
     */
    @Override
    public T findByPrimaryKey(Class<T> aClass, ID id) {
        return em.find(aClass, id);
    }

    /**
     * 是否包含某个对象
     *
     * @param t 对象
     * @return true为包含，false为不包含
     */
    @Override
    public boolean contains(T t) {
        return em.contains(t);
    }

    /**
     * 条件查询
     *
     * @param dml       查询语句
     * @param queryType 查询语句的类型
     * @param params    参数
     * @return 查询结果集
     */
    @Override
    public List findByCondition(String dml, QueryType queryType, Object... params) {
        return findByCondition(dml, null, queryType, params);
    }

    /**
     * 条件查询
     *
     * @param dml       查询语句
     * @param sort      排序
     * @param queryType 查询语句的类型
     * @param params    参数
     * @return 查询结果集
     */
    @Override
    public List findByCondition(String dml, String sort, QueryType queryType, Object... params) {
        Query query = getQueryByType(dml, sort, queryType);
        fillParameter(query, params);
        return query.getResultList();
    }

    /**
     * 查询总条数
     *
     * @param dml       查询语句
     * @param queryType 查询语句的类型
     * @param params    参数
     * @return 总条数
     */
    @Override
    public Long findCount(String dml, QueryType queryType, Object... params) {
        Query query = getQueryByType(dml, null, queryType);
        fillParameter(query, params);
        Object result = query.getSingleResult();
        return result == null ? 0L : (Long) result;
    }

    /**
     * 分页查询
     *
     * @param dml       查询语句
     * @param sort      排序
     * @param queryType 查询语句的类型
     * @param startRow  开始行
     * @param pageSize  每页条数
     * @param params    参数
     * @return 分页结果集
     */
    @Override
    public List findPageList(String dml, String sort, QueryType queryType, Integer startRow, Integer pageSize, Object... params) {
        dml += PAGE_MYSQL;
        Object[] newParams = Arrays.asList(params, startRow, pageSize).toArray();
        Query query = getQueryByType(dml, sort, queryType);
        fillParameter(query, newParams);
        return query.getResultList();
    }

    /**
     * 更新
     *
     * @param dml       更新语句
     * @param queryType 更新语句的类型
     * @param params    参数
     * @return 影响的行数
     */
    @Override
    public Integer executeUpdate(String dml, QueryType queryType, Object... params) {
        Query query = getQueryByType(dml, null, queryType);
        fillParameter(query, params);
        return query.executeUpdate();
    }

    /**
     * 将PersistenceContext的信息同步到数据库中
     * 实体都将会被insert/update/remove到数据库中
     * 数据库不会触发Commit的操作
     * ORM框架执行的一些更新数据库的方法,其实质是在更新缓存,只有调用了flush()后才会将缓存同步到数据库,
     * 即真正执行SQL语句,但是这时并没有真正将数据保存进数据库,需要事务commit后才能全部保存。
     * 一般flush后立刻就会进行事务的提交。
     */
    @Override
    public void flush() {
        em.flush();
    }

    /**
     * Refresh的作用是从数据库中将Entity的状态进行更新操作。如果Entity和数据库中的数据不一致，将更新数据库中的数据到Entity中。
     * 即refresh操作只针对受托管状态（在persistencecontext中的对象）有效
     * 1) 如果 A 是一个 new 状态的实例，不会发生任何操作，但有可能会抛出异常，具体情况根据不同 JPA实现有关；
     * 2）如果 A 是一个 managed 状态的实例，它的属性将会和数据库中的数据同步；
     * 3）如果 A 是一个 removed 状态的实例，不会发生任何操作 ;
     * 4）如果 A 是一个 detached 状态的实体，该方法将会抛出异常
     *
     * @param t 需要刷新的对象
     */
    @Override
    public void refresh(T t) {
        em.refresh(t);
    }

    /**
     * 调用EntityManager 的clear()方法后，所有正在被管理的实体将会从持久化内容中分离出来
     */
    @Override
    public void clear() {
        em.clear();
    }

    /**
     * 创建jpql查询对象
     *
     * @param jpql jpql语句
     * @return Query对象
     */
    @Override
    public Query createQuery(String jpql) {
        return em.createQuery(jpql);
    }

    /**
     * 创建jpql查询对象
     *
     * @param jpql jpql语句
     * @param sort 排序
     * @return Query对象
     */
    @Override
    public Query createQuery(String jpql, String sort) {
        if (sort != null && sort != "") {
            jpql += ORDER_BY + sort;
        }
        return createQuery(jpql);
    }

    /**
     * 创建本地查询对象
     *
     * @param sql sql语句
     * @return Query对象
     */
    @Override
    public Query createNativeQuery(String sql) {
        return em.createNativeQuery(sql);
    }

    /**
     * 创建本地查询对象
     *
     * @param sql  sql语句
     * @param sort 排序
     * @return Query对象
     */
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
